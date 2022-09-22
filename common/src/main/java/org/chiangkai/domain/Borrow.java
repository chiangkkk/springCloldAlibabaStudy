package org.chiangkai.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "db_borrow")
public class Borrow {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "`uid`")
    private Integer uid;

    @TableField(value = "bid")
    private Integer bid;

    public static final String COL_ID = "id";

    public static final String COL_UID = "uid";

    public static final String COL_BID = "bid";
}