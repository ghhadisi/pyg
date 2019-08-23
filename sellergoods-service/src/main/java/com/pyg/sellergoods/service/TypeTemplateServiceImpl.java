package com.pyg.sellergoods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hss.pyg.entity.PageResult;
import com.hss.pyg.mapper.TbTypeTemplateMapper;
import com.hss.pyg.pojo.TbTypeTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class TypeTemplateServiceImpl extends ServiceImpl<TbTypeTemplateMapper, TbTypeTemplate> implements TypeTemplateService {


	/**
	 * 查询全部
	 */
	@Override
	public List<TbTypeTemplate> findAll() {

		return baseMapper.selectList(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		Page<TbTypeTemplate> page = new Page<TbTypeTemplate>(pageNum,pageSize);
		IPage<TbTypeTemplate> pageResult = baseMapper.selectPage(page,null);
		PageResult result = new PageResult(pageResult.getTotal(),pageResult.getRecords());
		return result;
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbTypeTemplate typeTemplate) {
		baseMapper.insert(typeTemplate);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbTypeTemplate typeTemplate){
		baseMapper.updateById(typeTemplate);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbTypeTemplate findOne(Long id){
		return baseMapper.selectById(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			baseMapper.deleteById(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbTypeTemplate typeTemplate, int pageNum, int pageSize) {
			Page<TbTypeTemplate> page = new Page<TbTypeTemplate>(pageNum,pageSize);
			QueryWrapper<TbTypeTemplate >  query = new QueryWrapper<>();
			if (typeTemplate !=null) {
				if (typeTemplate.getName() !=null && typeTemplate.getName().length()>0){
					query.lambda().like(TbTypeTemplate::getName, typeTemplate.getName());
				}
			}
			IPage<TbTypeTemplate> pageResult = baseMapper.selectPage(page,query);
			PageResult result = new PageResult(pageResult.getTotal(),pageResult.getRecords());
			return result;
	}


}
