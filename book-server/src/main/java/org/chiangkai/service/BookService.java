package org.chiangkai.service;

import org.chiangkai.domain.Book;

/**
 * 书服务
 *
 * @author ChiangKai
 * @date 2022/9/22 20:44
 */
public interface BookService {


    /**
     * 得到书
     *
     * @param bid 报价
     * @return {@link Book}
     */
    Book getBook(Integer bid);

    void setRemain(int bid);

    Integer getRemain(int bid);
}
