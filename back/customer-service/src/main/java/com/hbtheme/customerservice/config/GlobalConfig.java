package com.hbtheme.customerservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "application.params")
@RefreshScope
@Getter @Setter
public class GlobalConfig {
    private int x;
    private int y;
}
