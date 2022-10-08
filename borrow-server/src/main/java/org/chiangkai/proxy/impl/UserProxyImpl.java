package org.chiangkai.proxy.impl;

import lombok.AllArgsConstructor;
import org.chiangkai.client.UserClient;
import org.chiangkai.domain.User;
import org.chiangkai.proxy.UserProxy;
import org.springframework.stereotype.Component;

/**
 * @author ChiangKai
 * @date 2022/9/27
 */
@Component
@AllArgsConstructor
public class UserProxyImpl extends BaseProxy implements UserProxy {

    final UserClient userClient;

    @Override
    public User getUserByUid(Integer uid) {
        return getData(userClient.getUserById(uid));
    }

    @Override
    public boolean decreaseUserBookCount(Integer uid) {
        return isSuccessState(userClient.setRemain(uid));
    }

    @Override
    public Integer getUserBookRemain(Integer uid) {
        return getData(userClient.getUserNumberOfBooksCanBorrowed(uid));
    }
}
