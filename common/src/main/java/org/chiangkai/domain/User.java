package org.chiangkai.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "db_user")
public class User {
    @TableId(value = "uid", type = IdType.INPUT)
    private Integer uid;

    @TableField(value = "`name`")
    private String name;

    @TableField(value = "age")
    private Integer age;

    @TableField(value = "sex")
    private Object sex;

    public static final String COL_UID = "uid";

    public static final String COL_NAME = "name";

    public static final String COL_AGE = "age";

    public static final String COL_SEX = "sex";
}