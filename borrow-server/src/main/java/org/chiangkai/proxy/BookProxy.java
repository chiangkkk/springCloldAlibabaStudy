package org.chiangkai.proxy;

import org.chiangkai.domain.Book;

/**
 * @author ChiangKai
 * @date 2022/9/27
 */
public interface BookProxy {
    /**
     * 根据书籍id获取书籍信息
     *
     * @param id id
     * @return {@link Book}
     */
    Book getBookByBid(Integer id);

    /**
     * 书籍数量减少一
     *
     * @param bid 报价
     * @return boolean
     */
    boolean decreaseBookCount(Integer bid);

    /**
     * 得到剩余书籍数量
     *
     * @param bid 书籍ID
     * @return {@link Integer}
     */
    Integer getRemainBookCount(Integer bid);
}
