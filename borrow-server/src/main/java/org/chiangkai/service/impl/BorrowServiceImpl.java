package org.chiangkai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import org.chiangkai.client.BookClient;
import org.chiangkai.client.UserClient;
import org.chiangkai.domain.User;
import org.chiangkai.dto.UserBorrowInfoDTO;
import org.chiangkai.proxy.BookProxy;
import org.chiangkai.proxy.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.chiangkai.mapper.BorrowMapper;
import org.chiangkai.domain.Borrow;
import org.chiangkai.service.BorrowService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BorrowServiceImpl extends ServiceImpl<BorrowMapper, Borrow> implements BorrowService {

    @Override
    public int insertSelective(Borrow record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Borrow record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    final BookProxy bookProxy;

    final UserProxy userProxy;

    @Override
    public UserBorrowInfoDTO getByUserId(Integer uid) {
        QueryWrapper<Borrow> wrapper = new QueryWrapper<>();
        User user = userProxy.getUserByUid(uid);
        if (null == user) {
            return null;
        }
        wrapper.lambda().eq(Borrow::getUid, uid);
        List<Borrow> list = list(wrapper);
        UserBorrowInfoDTO info = new UserBorrowInfoDTO();
        info.setUser(user);
        info.setBookList(new ArrayList<>());
        for (Borrow borrow : list) {
            info.getBookList().add(bookProxy.getBookByBid(borrow.getBid()));
        }
        return info;
    }
}
