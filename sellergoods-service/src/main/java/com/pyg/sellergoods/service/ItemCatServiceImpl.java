package com.pyg.sellergoods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hss.pyg.entity.PageResult;
import com.hss.pyg.mapper.TbItemCatMapper;
import com.hss.pyg.pojo.TbItemCat;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ItemCatServiceImpl  extends ServiceImpl<TbItemCatMapper, TbItemCat> implements ItemCatService {


	/**
	 * 查询全部
	 */
	public List<TbItemCat> findAll() {
		return baseMapper.selectList(null);
	}

	/**
	 * 按分页查询
	 */
	public PageResult findPage(int pageNum, int pageSize) {
		Page<TbItemCat> page = new Page<TbItemCat>(pageNum,pageSize);
		QueryWrapper<TbItemCat> query = new QueryWrapper<TbItemCat>();
		IPage<TbItemCat> pageResult = baseMapper.selectPage(page,query);
		PageResult result = new PageResult(pageResult.getTotal(),pageResult.getRecords());
		return result;
	}

	/**
	 * 增加
	 */
	public void add(TbItemCat itemCat) {
		baseMapper.insert(itemCat);
	}

	
	/**
	 * 修改
	 */
	public void update(TbItemCat itemCat){
		baseMapper.updateById(itemCat);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbItemCat findOne(Long id){
		return baseMapper.selectById(id);
	}

	/**
	 * 批量删除
	 */
	public void delete(Long[] ids) {
		for(Long id:ids){
			baseMapper.deleteById(id);
		}		
	}
	
	
	public PageResult findPage(TbItemCat itemCat, int pageNum, int pageSize) {

		Page<TbItemCat> page = new Page<TbItemCat>(pageNum,pageSize);
		QueryWrapper<TbItemCat> query = new QueryWrapper<TbItemCat>();

		if(itemCat!=null){
			if(itemCat.getName()!=null && itemCat.getName().length()>0){
				query.lambda().like(TbItemCat::getName, itemCat.getName());
			}

		}
		IPage<TbItemCat> pageResult = baseMapper.selectPage(page,query);
		PageResult result = new PageResult(pageResult.getTotal(),pageResult.getRecords());
		return result;



	}
	
}
