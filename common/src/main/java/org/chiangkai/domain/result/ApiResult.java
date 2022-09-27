package org.chiangkai.domain.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.objects.Global;
import lombok.Data;
import lombok.Getter;
import org.chiangkai.exception.BaseException;
import org.chiangkai.exception.GlobalException;

import java.util.Date;
import java.util.HashMap;

/**
 * api结果
 *
 * @author ChiangKai
 * @date 2022/9/27
 */
@Data
public class ApiResult<T> {

    /**
     * api结果
     */
    public ApiResult() {

    }

    /**
     * 代码
     */

    private int code;
    /**
     * 数据
     */
    private T data;

    /**
     * 消息
     */
    private String message;
    /**
     * 时间
     */
    private long timestamp;

    /**
     * api代码
     */
    @JsonIgnore
    private ApiCode apiCode;

    /**
     * api结果
     *
     * @param code    代码
     * @param message 消息
     * @param data    数据
     */
    public ApiResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * api结果
     *
     * @param code    代码
     * @param message 消息
     */
    public ApiResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * api结果
     *
     * @param data 数据
     * @param api  api
     */
    public ApiResult(Api api, T data) {
        this.code = api.getCode();
        this.message = api.getMessage();
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * api结果
     *
     * @param api     api
     * @param message 消息
     */
    public ApiResult(Api api, String message) {
        this.code = api.getCode();
        this.message = message;
        this.data = null;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * api结果
     *
     * @param api api
     */
    public ApiResult(Api api) {
        this.code = api.getCode();
        this.message = api.getMessage();
        this.data = null;
        this.timestamp = System.currentTimeMillis();
    }

    public ApiResult(T data) {
        ApiCode api = ApiCode.SUCCESS;
        this.code = api.getCode();
        this.message = api.getMessage();
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }


    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(ApiCode.SUCCESS, data);
    }

    /**
     * 成功
     *
     * @param message 消息
     * @return {@link ApiResult}<{@link Object}>
     */
    public static ApiResult<Object> success(String message) {
        return new ApiResult<Object>(ApiCode.SUCCESS.getCode(), message);
    }

    /**
     * 成功
     *
     * @return {@link ApiResult}<{@link Object}>
     */
    public static ApiResult<Object> success() {
        return new ApiResult<Object>(ApiCode.SUCCESS);
    }

    /**
     * 失败
     *
     * @return {@link ApiResult}<{@link Object}>
     */
    public static ApiResult<Object> fail() {
        return new ApiResult<Object>(ApiCode.FAIL);
    }

    public static ApiResult<Object> fail(String message) {
        return new ApiResult<Object>(ApiCode.FAIL, message);
    }


    public static ApiResult<Object> error(GlobalException globalException) {
        return new ApiResult<Object>(ApiCode.ERROR.getCode(), globalException.getMessage(), null);
    }
}
