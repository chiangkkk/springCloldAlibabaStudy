package org.chiangkai.client;

import org.chiangkai.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ChiangKai
 * @date 2022/9/22
 */

@FeignClient(name = "userServer",path = "/user")
public interface UserClient {
    /**
     * 得到用户
     *
     * @param id id
     * @return {@link User}
     */
    @GetMapping(value = "/{id}")
    User getUserById(@PathVariable(value = "id") Integer id);
}
