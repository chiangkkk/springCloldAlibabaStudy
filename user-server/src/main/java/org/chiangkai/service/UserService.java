package org.chiangkai.service;

import org.chiangkai.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {


    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);

    Integer getRemain(int uid);

    boolean setRemain(int uid);
}



