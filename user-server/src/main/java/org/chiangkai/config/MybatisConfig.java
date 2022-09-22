package org.chiangkai.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ChiangKai
 * @date 2022/9/22
 */
@Configuration
@MapperScan("org.chiangkai.mapper")
public class MybatisConfig {
}
