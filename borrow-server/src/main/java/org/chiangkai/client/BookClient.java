package org.chiangkai.client;

import org.chiangkai.domain.Book;
import org.chiangkai.domain.result.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ChiangKai
 * @date 2022/9/22
 */
@FeignClient(value = "bookServer", path = "/book")
public interface BookClient {


    /**
     * 根据书籍id获取书籍信息
     *
     * @param id id
     * @return {@link Book}
     */
    @GetMapping("/{id}")
    ApiResult<Book> getBook(@PathVariable("id") Integer id);

    /**
     * 设置 书籍库存减一
     *
     * @param bid 书籍id
     * @return {@link ApiResult}<{@link Object}>
     */
    @GetMapping("/borrow/{bid}")
    ApiResult<Object> setRemain(@PathVariable("bid") int bid);


    /**
     * 得到剩余书籍
     *
     * @param bid 报价
     * @return {@link ApiResult}<{@link Integer}>
     */
    @GetMapping("/remain/{bid}")
    ApiResult<Integer> getRemain(@PathVariable("bid") int bid);
}
