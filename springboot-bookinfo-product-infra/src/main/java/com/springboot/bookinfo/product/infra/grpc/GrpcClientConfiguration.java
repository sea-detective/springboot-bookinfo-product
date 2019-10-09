package com.springboot.bookinfo.product.infra.grpc;

import net.devh.boot.grpc.client.config.GrpcChannelsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 类GrpcClientConfiguration的实现描述: GrpcClientConfiguration
 *
 * @author hongyang 2019-10-09 17:17
 */
@Configuration
@PropertySource("classpath:grpc-client.properties")
public class GrpcClientConfiguration {

    @Bean
    public GrpcChannelsProperties grpcChannelsProperties() {
        return new GrpcChannelsProperties();
    }

}
