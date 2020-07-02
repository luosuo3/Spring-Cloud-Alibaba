package com.cloud.gateway;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 王峥
 * @date 2020/7/2 10:03 上午
 */
@Component
public class TimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory <TimeBeweenConfig>{


    public TimeBetweenRoutePredicateFactory() {
        super(TimeBeweenConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(TimeBeweenConfig config) {
        LocalTime start = config.getStart();
        LocalTime end = config.getEnd();
        return exchange -> {
            LocalTime now = LocalTime.now();
            return now.isAfter(start) && now.isBefore(end);
        };
    }
//配置类的映射关系
    //
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("start","end");
    }
}
