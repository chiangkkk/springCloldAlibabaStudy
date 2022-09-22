package org.chiangkai.controller;

import lombok.AllArgsConstructor;
import org.chiangkai.domain.Book;
import org.chiangkai.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChiangKai
 * @date 2022/9/22 20:42
 */
@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    final BookService bookService;

    @GetMapping("/{id}")
    public Book book(@PathVariable Integer id){
        return bookService.getBook(id);
    }
}
