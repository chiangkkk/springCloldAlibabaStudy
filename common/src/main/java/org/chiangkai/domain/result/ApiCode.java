package org.chiangkai.domain.result;

import lombok.Getter;

/**
 * api代码
 *
 * @author ChiangKai
 * @date 2022/9/27
 */
public enum ApiCode implements Api {
    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),


    /**
     * 操作失败
     */
    FAIL(0, "操作失败"),

    /**
     * 服务错误
     */
    ERROR(500, "服务错误");

    /**
     * 代码
     */
    private final int code;
    /**
     * 消息
     */
    private final String message;

    /**
     * api代码
     *
     * @param code    代码
     * @param message 消息
     */
    ApiCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
