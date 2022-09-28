package org.chiangkai.client;

import org.chiangkai.domain.User;
import org.chiangkai.domain.result.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ChiangKai
 * @date 2022/9/22
 */

@FeignClient(name = "userServer", path = "/user")
public interface UserClient {
    /**
     * 得到用户
     *
     * @param id id
     * @return {@link User}
     */
    @GetMapping(value = "/{id}")
    ApiResult<User> getUserById(@PathVariable(value = "id") Integer id);


    /**
     * 用户可借书籍数量减一
     *
     * @param uid 书籍id
     * @return {@link ApiResult}<{@link ?}>
     */
    @GetMapping("/borrow/{uid}")
    ApiResult<?> setRemain(@PathVariable("uid") Integer uid);

    /**
     * 获取用户数量书可以借了
     * 获取用户 书可以借的数量
     *
     * @param uid uid
     * @return {@link ApiResult}<{@link Integer}>
     */
    @GetMapping("/remain/{uid}")
    ApiResult<Integer> getUserNumberOfBooksCanBorrowed(@PathVariable("uid") Integer uid);
}
