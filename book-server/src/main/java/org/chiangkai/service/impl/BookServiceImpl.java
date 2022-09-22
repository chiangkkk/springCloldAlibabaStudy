package org.chiangkai.service.impl;

import lombok.AllArgsConstructor;
import org.chiangkai.domain.Book;
import org.chiangkai.mapper.BookMapper;
import org.chiangkai.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChiangKai
 * @date 2022/9/22 20:49
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookServiceImpl implements BookService {

    final BookMapper bookMapper;

    @Override
    public Book getBook(Integer bid) {
        return bookMapper.selectByBid(bid);
    }
}
