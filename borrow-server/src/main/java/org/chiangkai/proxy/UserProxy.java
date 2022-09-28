package org.chiangkai.proxy;

import org.chiangkai.domain.User;

/**
 * @author ChiangKai
 * @date 2022/9/27
 */
public interface UserProxy {
    /**
     * 获取用户uid
     *
     * @param uid uid
     * @return {@link User}
     */
    User getUserByUid(Integer uid);


    /**
     * 减少用户书数
     *
     * @param uid uid
     * @return boolean
     */
    boolean decreaseUserBookCount(Integer uid);
}
