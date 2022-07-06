package com.wang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("nocv_data")
//映射的表的名字
public class NocvData {
    // @TableId 标记id 递增
    @TableId(value = "id",type= IdType.AUTO)
    private  Integer id;
    private String name;
    private Integer value;

}