package com.nutcracker.dubbo.service;

import com.nutcracker.dubbo.entity.MessageBody;
import com.nutcracker.dubbo.exception.BusinessException;

/**
 * 示例接口
 *
 * @author 胡桃夹子
 * @date 2022/1/24 09:59
 */
public interface DemoService {

    public MessageBody getDiff(Integer value);

    public MessageBody getMessage(Integer value) throws BusinessException;

}
