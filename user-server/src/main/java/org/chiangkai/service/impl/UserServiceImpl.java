package org.chiangkai.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.chiangkai.domain.User;
import org.chiangkai.mapper.UserMapper;
import org.chiangkai.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public int insertSelective(User record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Integer getRemain(int uid) {
        return getById(uid).getBookCount();
    }

    @Override
    public boolean setRemain(int uid) {
        User user = getById(uid);
        user.setBookCount(user.getBookCount() - 1);
        updateByPrimaryKeySelective(user);
        return true;
    }
}



