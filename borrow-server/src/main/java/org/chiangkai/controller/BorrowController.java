package org.chiangkai.controller;

import lombok.AllArgsConstructor;
import org.chiangkai.dto.UserBorrowInfoDTO;
import org.chiangkai.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChiangKai
 * @date 2022/9/22
 */
@RestController
@RequestMapping("/borrow")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BorrowController {

    final BorrowService borrowService;

    @GetMapping("/user/{uid}")
    public UserBorrowInfoDTO getByUserId(@PathVariable Integer uid) {
        return borrowService.getByUserId(uid);
    }
}
