package org.chiangkai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.chiangkai.domain.Borrow;

public interface BorrowMapper extends BaseMapper<Borrow> {
    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Borrow record);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Borrow record);
}