package com.nutcracker.dubbo.entity;

import java.io.Serializable;


/**
 * 消息实体对象
 *
 * @author 胡桃夹子
 * @date 2022/1/24 10:00
 */
public class MessageBody implements Serializable {

    private static final long serialVersionUID = 4732186081041434484L;

    /**
     * 消息主体
     */
    private String body;

    /**
     * 差
     */
    private Integer diff;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getDiff() {
        return diff;
    }

    public void setDiff(Integer diff) {
        this.diff = diff;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" {");
        sb.append("\"body\":\"")
                .append(body).append('\"');
        sb.append(",\"diff\":")
                .append(diff);
        sb.append('}');
        return sb.toString();
    }
}
