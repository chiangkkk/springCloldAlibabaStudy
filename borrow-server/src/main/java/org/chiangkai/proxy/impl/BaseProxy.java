package org.chiangkai.proxy.impl;

import org.chiangkai.domain.result.ApiCode;
import org.chiangkai.domain.result.ApiResult;
import org.chiangkai.exception.BusinessException;

/**
 * @author ChiangKai
 * @date 2022/9/27
 */
public class BaseProxy {

    public <T> T getData(ApiResult<T> result) {
        if (result.getCode() != ApiCode.SUCCESS.getCode()) {
            throw new BusinessException(result.getMessage());
        }
        return result.getData();
    }

    public void isSuccessState(ApiResult<?> result) {
        if (result.getCode() != ApiCode.SUCCESS.getCode()) {
            throw new BusinessException(result.getMessage());
        }
    }
}
