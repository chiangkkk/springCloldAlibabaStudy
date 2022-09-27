package org.chiangkai.proxy;

import org.chiangkai.domain.User;

/**
 * @author ChiangKai
 * @date 2022/9/27
 */
public interface UserProxy {
    User getUserByUid(Integer uid);
}
