package org.chiangkai.domain.result;

/**
 * api
 *
 * @author ChiangKai
 * @date 2022/9/27
 */
public interface Api {
    /**
     * 获取代码
     *
     * @return int
     */
    int getCode();

    /**
     * 得到消息
     *
     * @return {@link String}
     */
    String getMessage();
}
