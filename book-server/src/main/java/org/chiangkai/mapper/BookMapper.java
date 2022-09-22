package org.chiangkai.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.chiangkai.domain.Book;

public interface BookMapper extends BaseMapper<Book> {

    Book selectByBid(@Param("bid")Integer bid);




}