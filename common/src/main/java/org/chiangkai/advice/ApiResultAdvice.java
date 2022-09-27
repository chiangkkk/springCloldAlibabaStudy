package org.chiangkai.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.chiangkai.domain.result.ApiResult;
import org.chiangkai.exception.BusinessException;
import org.chiangkai.exception.GlobalException;
import org.chiangkai.util.ExcpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * api结果aop
 *
 * @author ChiangKai
 * @date 2022/9/27
 */
@RestControllerAdvice(basePackages = "org.chiangkai.controller")
@Slf4j
public class ApiResultAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper mapper;

    /**
     * 无效类型
     */
    private final String VOID_TYPE = "void";

    @ExceptionHandler(BusinessException.class)
    public ApiResult<Object> businessException(BusinessException e) {
        log.info(e.getMessage());
        return ApiResult.fail(e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public ApiResult<?> globalException(HttpServletRequest request, Throwable ex, HttpServletResponse response) {
        log.error("{}", ExcpUtil.buildErrorMessage(ex));
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ApiResult.error(new GlobalException("global Exception"));
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (VOID_TYPE.equals(returnType.getParameterType().getName())) {
            return ApiResult.success();
        }
        // 字符串类型 json 化返回message
        if (returnType.getParameterType().equals(String.class)) {
            response.getHeaders().setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_VALUE));
            try {
                return mapper.writeValueAsString(ApiResult.success((String) body));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        if (boolean.class.equals(returnType.getParameterType())
                || Boolean.class.equals(returnType.getParameterType())) {
            if (body != null || (Boolean) body) {
                return ApiResult.success();
            }
            return ApiResult.fail();
        }
        // ApiResult类型
        if (returnType.getParameterType().equals(ApiResult.class)
                // 资源类型
                || (body instanceof Resource)
                // 不是Json类型
                || (!selectedContentType.includes(MediaType.APPLICATION_JSON))) {
            return body;
        }
        return ApiResult.success(body);
    }
}
