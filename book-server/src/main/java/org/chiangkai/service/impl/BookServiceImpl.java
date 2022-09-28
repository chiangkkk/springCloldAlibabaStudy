package org.chiangkai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {


    @Override
    public Book getBook(Integer bid) {
        return baseMapper.selectByBid(bid);
    }

    @Override
    public void setRemain(int bid) {
        Book book = getBook(bid);
        Integer bookCount = book.getCount();
        book.setCount(bookCount - 1);
        baseMapper.updateById(book);
    }

    @Override
    public Integer getRemain(int bid) {
        return getBook(bid).getCount();
    }
}
