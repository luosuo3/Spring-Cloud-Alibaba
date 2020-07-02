package com.cloud.gateway;

import lombok.Data;

import java.time.LocalTime;

/**
 * @author 王峥
 * @date 2020/7/2 10:06 上午
 */
@Data
public class TimeBeweenConfig {
    private LocalTime start;
    private LocalTime end;
}
