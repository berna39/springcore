package com.terminator.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.terminator.annotation"}) // Spring will scan the whole package to detect component and create beans for them
public class MyAppConfig {
}
