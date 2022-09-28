package org.chiangkai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.chiangkai.domain.Borrow;
import org.chiangkai.domain.User;
import org.chiangkai.dto.UserBorrowInfoDTO;
import org.chiangkai.mapper.BorrowMapper;
import org.chiangkai.proxy.BookProxy;
import org.chiangkai.proxy.UserProxy;
import org.chiangkai.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void borrow(Integer uid, Integer bid) {
        //1. 判断图书和用户是否都支持借阅
        if(bookProxy.getBookByBid(bid) < 1)
            throw new RuntimeException("图书数量不足");
        if(userClient.userRemain(uid) < 1)
            throw new RuntimeException("用户借阅量不足");
        //2. 首先将图书的数量-1
        if(!bookClient.bookBorrow(bid))
            throw new RuntimeException("在借阅图书时出现错误！");
        //3. 添加借阅信息
        if(mapper.getBorrow(uid, bid) != null)
            throw new RuntimeException("此书籍已经被此用户借阅了！");
        if(mapper.addBorrow(uid, bid) <= 0)
            throw new RuntimeException("在录入借阅信息时出现错误！");
        //4. 用户可借阅-1
        if(!userClient.userBorrow(uid))
            throw new RuntimeException("在借阅时出现错误！");
        //完成
        return true;
    }
}
