package org.chiangkai.dto;

import lombok.Data;
import org.chiangkai.domain.Book;
import org.chiangkai.domain.User;

import java.util.List;

/**
 * @author ChiangKai
 * @date 2022/9/22
 */
@Data
public class UserBorrowInfoDTO {
    private User user;
    private List<Book> bookList;

}
