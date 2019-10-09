package com.springboot.bookinfo.details.service.impl;

import com.springboot.bookinfo.details.lib.greeter.GreeterGrpc;
import com.springboot.bookinfo.details.lib.greeter.GreeterProto.HelloReply;
import com.springboot.bookinfo.details.lib.greeter.GreeterProto.HelloRequest;
import com.springboot.bookinfo.details.service.GreeterService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * 类GrpcGreeterService的实现描述: GrpcGreeterService
 *
 * @author hongyang 2019-10-09 16:13
 */
@Service
public class GrpcGreeterService implements GreeterService {

    @GrpcClient("greeter")
    private GreeterGrpc.GreeterBlockingStub greeterStub;

    @Override
    public String sayHello(String name) {
        HelloReply response = greeterStub.sayHello(HelloRequest.newBuilder().setName(name).build());
        return response.getMessage();
    }
}
