package com.qian.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by qld on 2017/8/25.
 */
@Component
@Lazy
public class RedisConfig {

    @Value("${redis.cluster.hostandport}")
    private String hostandport;

    @Value("${redis.cluster.timeout}")
    private int timeout;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMaxRedirections() {
        return maxRedirections;
    }

    public void setMaxRedirections(int maxRedirections) {
        this.maxRedirections = maxRedirections;
    }

    @Value("${redis.cluster.maxRedirections}")
    private int maxRedirections;

    public String getHostandport() {
        return hostandport;
    }

    public void setHostandport(String hostandport) {
        this.hostandport = hostandport;
    }




}
