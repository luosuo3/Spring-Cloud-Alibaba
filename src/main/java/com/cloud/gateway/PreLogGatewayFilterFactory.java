package com.cloud.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * @author 王峥
 * @date 2020/7/2 3:49 下午
 */
@Slf4j
@Component
public class PreLogGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return  (exchange, chain) -> {
            log.info("请求进来了,name:{},value:{}", config.getName(), config.getValue());

            ServerHttpRequest modemyRequest = exchange.getRequest()
                    .mutate()
                    .build();
            ServerWebExchange modefyExchange = exchange.mutate()
                    .request(modemyRequest)
                    .build();
            return chain.filter(modefyExchange);
        };
    }
}
