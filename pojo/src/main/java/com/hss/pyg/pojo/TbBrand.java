package com.hss.pyg.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("tb_brand")
public class TbBrand implements Serializable{


    private int id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "firstChar")
    private String firstChar;

}