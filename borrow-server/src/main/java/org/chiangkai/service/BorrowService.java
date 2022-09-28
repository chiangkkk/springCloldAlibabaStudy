package org.chiangkai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.chiangkai.domain.Borrow;
import org.chiangkai.dto.UserBorrowInfoDTO;

/**
 * 用户借书服务
 *
 * @author ChiangKai
 * @date 2022/09/28
 */
public interface BorrowService extends IService<Borrow> {


    int insertSelective(Borrow record);

    int updateByPrimaryKeySelective(Borrow record);


    UserBorrowInfoDTO getByUserId(Integer uid);

    /**
     * 借书服务
     *
     * @param uid 用户ID
     * @param bid 书籍ID
     */
    void borrow(Integer uid, Integer bid);
}
