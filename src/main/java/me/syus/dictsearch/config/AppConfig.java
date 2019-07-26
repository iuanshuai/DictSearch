package me.syus.dictsearch.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "me.syus.dictsearch", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "me.syus.dictsearch.api.*"))

public class AppConfig {

}