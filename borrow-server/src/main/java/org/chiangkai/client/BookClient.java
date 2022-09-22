package org.chiangkai.client;

import org.chiangkai.domain.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ChiangKai
 * @date 2022/9/22
 */
@FeignClient(value ="bookServer",path = "/book")
public interface BookClient {


    /**
     * 得到书
     *
     * @param id id
     * @return {@link Book}
     */
    @GetMapping( "/{id}")
   Book getBook(@PathVariable("id") Integer id);
}
