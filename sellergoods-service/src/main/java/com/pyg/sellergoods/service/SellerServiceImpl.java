package com.pyg.sellergoods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hss.pyg.entity.PageResult;
import com.hss.pyg.mapper.TbSellerMapper;
import com.hss.pyg.pojo.TbSeller;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SellerServiceImpl extends ServiceImpl<TbSellerMapper, TbSeller> implements SellerService {

	/**
	 * 查询全部
	 */
	public List<TbSeller> findAll() {
		return baseMapper.selectList(null);
	}

	/**
	 * 按分页查询
	 */
	public PageResult findPage(int pageNum, int pageSize) {
		Page<TbSeller> page = new Page<TbSeller>(pageNum,pageSize);
		QueryWrapper<TbSeller> query = new QueryWrapper<TbSeller>();
		IPage<TbSeller> pageResult = baseMapper.selectPage(page,query);
		PageResult result = new PageResult(pageResult.getTotal(),pageResult.getRecords());
		return result;
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbSeller seller) {		
		seller.setStatus("0");//状态
		seller.setCreateTime(new Date());//申请日期
		baseMapper.insert(seller);
	}

	
	/**
	 * 修改
	 */
	public void update(TbSeller seller){
		baseMapper.updateById(seller);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbSeller findOne(String id){

		return baseMapper.selectById(id);
	}

	/**
	 * 批量删除
	 */
	public void delete(String[] ids) {
		for(String id:ids){
			baseMapper.deleteById(id);
		}		
	}
	
	
	public PageResult findPage(TbSeller seller, int pageNum, int pageSize) {

		Page<TbSeller> page = new Page<TbSeller>(pageNum,pageSize);
		QueryWrapper<TbSeller> query = new QueryWrapper<TbSeller>();

		if(seller!=null){
			if(seller.getSellerId()!=null && seller.getSellerId().length()>0){
				query.lambda().like(TbSeller::getSellerId,"%"+seller.getSellerId()+"%");
			}
			if(seller.getName()!=null && seller.getName().length()>0){
				query.lambda().like(TbSeller::getName,"%"+seller.getName()+"%");
			}
//			if(seller.getNickName()!=null && seller.getNickName().length()>0){
//				query.lambda().like("%"+seller.getNickName()+"%");
//			}
//			if(seller.getPassword()!=null && seller.getPassword().length()>0){
//				query.lambda().like("%"+seller.getPassword()+"%");
//			}
//			if(seller.getEmail()!=null && seller.getEmail().length()>0){
//				query.lambda().like("%"+seller.getEmail()+"%");
//			}
//			if(seller.getMobile()!=null && seller.getMobile().length()>0){
//				query.lambda().like("%"+seller.getMobile()+"%");
//			}
//			if(seller.getTelephone()!=null && seller.getTelephone().length()>0){
//				query.lambda().like("%"+seller.getTelephone()+"%");
//			}
//			if(seller.getStatus()!=null && seller.getStatus().length()>0){
//				query.lambda().like("%"+seller.getStatus()+"%");
//			}
//			if(seller.getAddressDetail()!=null && seller.getAddressDetail().length()>0){
//				query.lambda().like("%"+seller.getAddressDetail()+"%");
//			}
//			if(seller.getLinkmanName()!=null && seller.getLinkmanName().length()>0){
//				query.lambda().like("%"+seller.getLinkmanName()+"%");
//			}
//			if(seller.getLinkmanQq()!=null && seller.getLinkmanQq().length()>0){
//				query.lambda().like("%"+seller.getLinkmanQq()+"%");
//			}
//			if(seller.getLinkmanMobile()!=null && seller.getLinkmanMobile().length()>0){
//				query.lambda().like("%"+seller.getLinkmanMobile()+"%");
//			}
//			if(seller.getLinkmanEmail()!=null && seller.getLinkmanEmail().length()>0){
//				query.lambda().like("%"+seller.getLinkmanEmail()+"%");
//			}
//			if(seller.getLicenseNumber()!=null && seller.getLicenseNumber().length()>0){
//				query.lambda().like("%"+seller.getLicenseNumber()+"%");
//			}
//			if(seller.getTaxNumber()!=null && seller.getTaxNumber().length()>0){
//				query.lambda().like("%"+seller.getTaxNumber()+"%");
//			}
//			if(seller.getOrgNumber()!=null && seller.getOrgNumber().length()>0){
//				query.lambda().like("%"+seller.getOrgNumber()+"%");
//			}
//			if(seller.getLogoPic()!=null && seller.getLogoPic().length()>0){
//				query.lambda().like("%"+seller.getLogoPic()+"%");
//			}
//			if(seller.getBrief()!=null && seller.getBrief().length()>0){
//				query.lambda().like("%"+seller.getBrief()+"%");
//			}
//			if(seller.getLegalPerson()!=null && seller.getLegalPerson().length()>0){
//				query.lambda().like("%"+seller.getLegalPerson()+"%");
//			}
//			if(seller.getLegalPersonCardId()!=null && seller.getLegalPersonCardId().length()>0){
//				query.lambda().like("%"+seller.getLegalPersonCardId()+"%");
//			}
//			if(seller.getBankUser()!=null && seller.getBankUser().length()>0){
//				query.lambda().like("%"+seller.getBankUser()+"%");
//			}
//			if(seller.getBankName()!=null && seller.getBankName().length()>0){
//				query.lambda().like("%"+seller.getBankName()+"%");
//			}

		}

		IPage<TbSeller> pageResult = baseMapper.selectPage(page,query);
		PageResult result = new PageResult(pageResult.getTotal(),pageResult.getRecords());
		return result;
	}

	public void updateStatus(String sellerId, String status) {
		
		TbSeller seller = baseMapper.selectById(sellerId);
		seller.setStatus(status);
		baseMapper.updateById(seller);
	}
	
}
