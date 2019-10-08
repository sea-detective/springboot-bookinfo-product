package com.springboot.bookinfo.product.infra.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * 类RestTemplateUtils的实现描述: HTTP请求的工具类
 *
 * @author hongyang 2019-10-08 21:04
 */
public class RestTemplateUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateUtils.class);

    private static final int HTTP_SUCCESS_CODE = 200;

    private static final SimpleClientHttpRequestFactory DEFAULT_REQUEST_FACTORY = new SimpleClientHttpRequestFactory() {
        {
            setConnectTimeout(5000);
            setReadTimeout(30000);
        }
    };
    private static final RestTemplate DEFAULT_REST_TEMPLATE = new RestTemplate(DEFAULT_REQUEST_FACTORY);

    public static <T> T postByForm(String url, Map<String, String> paraMap, TypeReference<T> typeReference, int retryCount) {

        String flatResult = postByForm(url, paraMap, String.class, retryCount);
        if (null == flatResult) {
            return null;
        }
        return JSON.parseObject(flatResult, typeReference);

    }

    public static <T> T postByForm(String url, Map<String, String> paraMap, Class<T> responseType, int retryCount) {

        LOGGER.info("||RestClient.postByForm||url={}||paraMap={}", url, logParaMap(paraMap));

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        if (MapUtils.isNotEmpty(paraMap)) {
            paraMap.forEach(formData::add);
        }

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> requestHttp = new HttpEntity<>(formData, header);

        for (int i = 0; i <= retryCount; i++) {
            try {
                ResponseEntity<T> responseEntity = DEFAULT_REST_TEMPLATE.exchange(url, HttpMethod.POST, requestHttp, responseType);
                if (HTTP_SUCCESS_CODE == responseEntity.getStatusCode().value()) {
                    return responseEntity.getBody();
                }
                LOGGER.error("||RestClient.postByForm||url=" + url + "||paraMap=" + logParaMap(paraMap) + "||statusCode="
                        + responseEntity.getStatusCode());
            } catch (Exception e) {
                LOGGER.error("||RestClient.postByForm||url=" + url + "||paraMap=" + logParaMap(paraMap), e);
            }
        }
        return null;
    }

    public static <T, R> R postEntity(String url, T entity, Class<R> responseType, int retryCount) {

        LOGGER.info("||RestClient.postEntity||url={}||entity={}", url, JSON.toJSONString(entity));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String entityJsonStr = JSON.toJSONString(entity);
        HttpEntity<T> httpEntity = new HttpEntity<>(entity, httpHeaders);

        for (int i = 0; i <= retryCount; i++) {
            try {
                ResponseEntity<R> responseEntity = DEFAULT_REST_TEMPLATE.exchange(url, HttpMethod.POST, httpEntity, responseType);
                if (HTTP_SUCCESS_CODE == responseEntity.getStatusCode().value()) {
                    return responseEntity.getBody();
                }
                LOGGER.error("||RestClient.postEntity||url=" + url + "||entity=" + entityJsonStr + "||statusCode="
                        + responseEntity.getStatusCode());
            } catch (RestClientException e) {
                LOGGER.error("||RestClient.postEntity||url=" + url + "||entity=" + entityJsonStr, e);
            }
        }
        return null;
    }

    private static String logParaMap(Map<String, String> paraMap) {

        StringBuilder logStringBuilder = new StringBuilder();
        if (MapUtils.isEmpty(paraMap)) {
            return logStringBuilder.toString();
        }

        paraMap.forEach((key, value) -> {
            if (null != value && value.length() > 50) {
                value = value.substring(0, 50);
            }
            logStringBuilder.append("{").append(key).append(":").append(value).append(", ");
        });
        logStringBuilder.deleteCharAt(logStringBuilder.length() - 1);
        logStringBuilder.append("}");
        return logStringBuilder.toString();
    }


}
