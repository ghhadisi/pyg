package com.hss.pyg.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("tb_specification_option")
@Data
public class TbSpecificationOption implements Serializable{
    private Long id;

    @TableField(value = "option_name")
    private String optionName;

    @TableField(value = "spec_id")
    private Long specId;

    private Integer orders;


}