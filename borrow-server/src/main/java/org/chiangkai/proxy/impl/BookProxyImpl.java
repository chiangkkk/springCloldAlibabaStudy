package org.chiangkai.proxy.impl;

import lombok.AllArgsConstructor;
import org.chiangkai.client.BookClient;
import org.chiangkai.domain.Book;
import org.chiangkai.proxy.BookProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ChiangKai
 * @date 2022/9/27
 */
@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookProxyImpl extends BaseProxy implements BookProxy {

    BookClient bookClient;

    @Override
    public Book getBookByBid(Integer id) {
        return getData(bookClient.getBook(id));
    }
}
