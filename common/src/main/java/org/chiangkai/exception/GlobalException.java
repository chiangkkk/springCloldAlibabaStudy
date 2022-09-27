package org.chiangkai.exception;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author ChiangKai
 * @date 2022/9/27
 */
public class GlobalException extends BaseException {

    public GlobalException(String message) {
        super(message);
    }
}
