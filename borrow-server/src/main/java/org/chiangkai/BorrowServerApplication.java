package org.chiangkai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ChiangKai
 * @date 2022/9/22
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class BorrowServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BorrowServerApplication.class, args);
    }
}
