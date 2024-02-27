package com.hbtheme.customerservice.controllers;

import com.hbtheme.customerservice.config.GlobalConfig;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {
    private final GlobalConfig globalConfig;

    public ConfigTestController(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
    }

    @GetMapping("/test-config")
    public Map<String, Integer> configTest() {
        return Map.of("X", globalConfig.getX(), "Y", globalConfig.getY());
    }

    @GetMapping("/test-config-x")
    public int configTestX() {
        return globalConfig.getX();
    }
}
