package org.chiangkai.proxy;

import org.chiangkai.domain.Book;

/**
 * @author ChiangKai
 * @date 2022/9/27
 */
public interface BookProxy {
    Book getBookByBid(Integer id);
}
