package org.chiangkai.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 书
 *
 * @author ChiangKai
 * @date 2022/09/22
 */
@Data
@TableName(value = "db_book")
public class Book {
    @TableId(value = "bid", type = IdType.INPUT)
    private Integer bid;

    @TableField(value = "title")
    private String title;

    @TableField(value = "`desc`")
    private String desc;

    @TableField(value = "count")
    private Integer count;

    public static final String COL_BID = "bid";

    public static final String COL_TITLE = "title";

    public static final String COL_DESC = "desc";

    public static final String COL_COUNT = "count";
}