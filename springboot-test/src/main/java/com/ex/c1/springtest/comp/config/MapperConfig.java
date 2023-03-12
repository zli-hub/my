package com.ex.c1.springtest.comp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ex.c1.springtest.mapper")
public class MapperConfig {
	
}
