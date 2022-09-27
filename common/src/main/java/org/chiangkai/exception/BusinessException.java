package org.chiangkai.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * 业务异常
 *
 * @author ChiangKai
 * @date 2022/9/27
 */
public class BusinessException extends BaseException {

    public BusinessException(String message) {
        super(message);
    }
}
