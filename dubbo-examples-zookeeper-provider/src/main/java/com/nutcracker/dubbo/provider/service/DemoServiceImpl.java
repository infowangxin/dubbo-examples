package com.nutcracker.dubbo.provider.service;

import com.nutcracker.dubbo.entity.MessageBody;
import com.nutcracker.dubbo.exception.BusinessException;
import com.nutcracker.dubbo.provider.exception.ProviderException;
import com.nutcracker.dubbo.service.DemoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 示例接口实现类
 *
 * @author 胡桃夹子
 * @date 2022/1/24 09:59
 */
@DubboService(interfaceClass = DemoService.class)
public class DemoServiceImpl implements DemoService {

    private static final Logger LOG = LoggerFactory.getLogger(DemoServiceImpl.class);

    private static final int TOTAL = 10;

    @Override
    public MessageBody getDiff(Integer value) {
        String body = "from provider service, value is " + value;
        if (null == value || value == 0) {
            //dubbo有一个专门处理异常的Filter，叫ExceptionFilter，针对provider端未被捕获的各种异常做了分别处理
            //(以下说的抛出是指异常会传递给consumer)：
            //1. 如果是checked异常，直接返回
            //2. 如果是方法签名声明的异常,直接返回
            //3. 异常类和接口类在同一个jar包,直接返回
            //4. 异常类的包名是都以 java. 或是 javax. 开头 的直接返回(是JDK自带的异常，直接抛出)
            //5. 如果是dubbo本身的异常RpcException,直接抛出
            //6. 否则,封装成一个新的RunTimeException抛出
            throw new ProviderException("1001", "value is empty or zero");
        }
        int diff = TOTAL / value;
        MessageBody messageBody = new MessageBody();
        messageBody.setBody(body);
        messageBody.setDiff(diff);

        LOG.info("# keyword={}", value);
        LOG.info("# body={}", body);
        LOG.info("# messageBody={}", messageBody);
        return messageBody;
    }

    @Override
    public MessageBody getMessage(Integer value) throws BusinessException {
        try {
            try {
                // 此处线程睡眠3秒为了方便做性能测试
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                LOG.error("# Thread.sleep fail");
                throw new ProviderException(e);
            }
            return getDiff(value);
        } catch (ProviderException e) {
            LOG.error("# BusinessException error msg {}", e.getMessage());
            throw new BusinessException(e.getErrorCode(), e.getMessage());
        } catch (Exception e) {
            LOG.error("# Exception error msg {}", e.getMessage());
            throw new BusinessException("value error");
        }
    }
}
