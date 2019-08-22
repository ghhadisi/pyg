package com.hss.pyg.pojogroup;

import com.hss.pyg.pojo.TbSpecification;
import com.hss.pyg.pojo.TbSpecificationOption;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
/**
 * 规格组合实体类
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor
public class Specification implements Serializable{

	private TbSpecification specification;
	
	private List<TbSpecificationOption> specificationOptionList;


	
	
	
}
