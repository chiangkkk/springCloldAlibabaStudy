package org.chiangkai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ChiangKai
 * @date 2022/9/22 16:14
 */
@SpringBootApplication
public class BookServerApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BookServerApplication.class);
        springApplication.run(args);
    }
}
