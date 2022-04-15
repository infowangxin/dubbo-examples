package com.nutcracker.dubbo.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.nutcracker.dubbo.entity.MessageBody;
import com.nutcracker.dubbo.exception.BusinessException;
import com.nutcracker.dubbo.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胡桃夹子
 * @date 2022-01-21 18:17
 */
@RestController
public class DemoController {

    private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);

    @DubboReference(interfaceClass = DemoService.class)
    private DemoService demoService;

    @GetMapping("diff/{input}")
    public String diff(@PathVariable Integer input) {
        LOG.info("# diff input={}", input);
        String result;
        try {
            MessageBody messageBody = demoService.getDiff(input);
            result = JSON.toJSONString(messageBody, true);
        } catch (BusinessException e) {
            result = e.getMessage();
            LOG.error("# BusinessException {}", result);
        } catch (Throwable e) {
            result = e.getMessage();
            LOG.error("# Exception {}", result);
        }
        return result;
    }

    @GetMapping("msg/{input}")
    public String msg(@PathVariable Integer input) {
        LOG.info("# msg input={}", input);
        String result;
        try {
            MessageBody messageBody = demoService.getMessage(input);
            result = JSON.toJSONString(messageBody, true);
        } catch (BusinessException e) {
            result = e.getMessage();
            LOG.error("# BusinessException {}", result);
        } catch (Throwable e) {
            result = e.getMessage();
            LOG.error("# Exception {}", result);
        }
        return result;
    }

}
