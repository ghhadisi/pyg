package com.pyg.sellergoods.service;

import com.hss.pyg.pojo.TbBrand;

import java.util.List;


/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService{

	public List<TbBrand> findAll();
	
}
