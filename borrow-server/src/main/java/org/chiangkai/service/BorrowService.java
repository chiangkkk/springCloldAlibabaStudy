package org.chiangkai.service;

import org.chiangkai.domain.Borrow;
import com.baomidou.mybatisplus.extension.service.IService;
import org.chiangkai.dto.UserBorrowInfoDTO;

public interface BorrowService extends IService<Borrow>{


    int insertSelective(Borrow record);

    int updateByPrimaryKeySelective(Borrow record);


    UserBorrowInfoDTO getByUserId(Integer uid);

}
