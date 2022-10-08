package org.chiangkai.proxy.impl;

import lombok.extern.slf4j.Slf4j;
import org.chiangkai.domain.result.ApiCode;
import org.chiangkai.domain.result.ApiResult;
import org.chiangkai.exception.BusinessException;
import org.chiangkai.exception.GlobalException;

/**
 * @author ChiangKai
 * @date 2022/9/27
 */
@Slf4j
public class BaseProxy {

    public <T> T getData(ApiResult<T> result) {
        if (result.getCode() != ApiCode.SUCCESS.getCode()) {
            throw new BusinessException(result.getMessage());
        }
        return result.getData();
    }

    public boolean isSuccessState(ApiResult<?> result) {
        if (result.getCode() != ApiCode.SUCCESS.getCode()) {
            if (result.getCode() == ApiCode.FAIL.getCode()) {
                log.info("fail message:{}", result.getMessage());
                return false;
            }
            throw new GlobalException(result.getMessage());
        }
        return true;
    }
}
