package com.nutcracker.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Start Application
 *
 * @author 胡桃夹子
 * @date 2022/1/24 09:57
 */
@EnableDubbo
@ServletComponentScan
@SpringBootApplication
public class NacosProviderApplication {
    private static final Logger LOG = LoggerFactory.getLogger(NacosProviderApplication.class);

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(NacosProviderApplication.class);
        springApplication.run(args);
        LOG.info(">>>>>>>>>>>>>>>>>>>> start successful <<<<<<<<<<<<<<<<<<<<");
    }

}
