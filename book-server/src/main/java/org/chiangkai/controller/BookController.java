package org.chiangkai.controller;

import org.chiangkai.domain.Book;
import org.chiangkai.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ChiangKai
 * @date 2022/9/22 20:42
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    BookService bookService;

    @GetMapping("/{id}")
    public Book book(@PathVariable Integer id) {
        return bookService.getBook(id);
    }


    @GetMapping("/borrow/{bid}")
    public void setRemain(@PathVariable("bid") int bid) {
        bookService.setRemain(bid);
    }

    ;

    @GetMapping("/remain/{bid}")
    public Integer getRemain(@PathVariable("bid") int bid) {
        return bookService.getRemain(bid);
    }

    ;


}
