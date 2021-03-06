package com.proshine.campus.config;

import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: DubboConfig
 * Description: Dubbo配置类
 * Author: zyl
 * Date: 2019/10/16 10:59
 */
@Configuration
@EnableDubbo
@DubboComponentScan(basePackages = "com.proshine.campus")
public class DubboConfig {

    /**
     * 解决因为服务启动顺序造成的消费端服务引用空指针问题
     */
    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setCheck(false);
        consumerConfig.setTimeout(40000);
        return consumerConfig;
    }

}
