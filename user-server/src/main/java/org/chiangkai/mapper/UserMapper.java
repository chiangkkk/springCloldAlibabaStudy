package org.chiangkai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.chiangkai.domain.User;

public interface UserMapper extends BaseMapper<User> {
    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(User record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(User record);
}