package com.hss.pyg.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "tb_type_template")
public class TbTypeTemplate implements Serializable{
    private Long id;

    private String name;

    @TableField(value = "spec_ids")
    private String specIds;

    @TableField(value = "brand_ids")
    private String brandIds;

    @TableField(value = "custom_attribute_items")
    private String customAttributeItems;

}