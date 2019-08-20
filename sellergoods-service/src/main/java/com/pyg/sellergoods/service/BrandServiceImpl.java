package com.pyg.sellergoods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hss.pyg.entity.PageResult;
import com.hss.pyg.mapper.TbBrandMapper;
import com.hss.pyg.pojo.TbBrand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl extends ServiceImpl<TbBrandMapper, TbBrand> implements BrandService {//


    public List<TbBrand> findAll() {
        return baseMapper.selectList(new QueryWrapper<TbBrand>());
    }

    public PageResult findPage(int pageNum, int pageSize) {
        Page<TbBrand> page = new Page<TbBrand>(pageNum,pageSize);
        IPage<TbBrand> pageResult = baseMapper.selectPage(page,null);
        PageResult result = new PageResult(pageResult.getTotal(),pageResult.getRecords());
        return result;
    }

    public void add(TbBrand brand) {
        baseMapper.insert(brand);
    }

    public TbBrand findOne(Long id) {
        return baseMapper.selectById(id);
    }

    public void update(TbBrand brand) {
        baseMapper.updateById(brand);
    }

    public void delete(Long[] ids) {
        for (long id : ids){
            baseMapper.deleteById(id);
        }
    }

    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
        Page<TbBrand> page = new Page<TbBrand>(pageNum,pageSize);
        QueryWrapper<TbBrand> query = new QueryWrapper<TbBrand>();
        if (brand != null){
            if (brand.getName() != null && brand.getName().length() >0){
                query.lambda().like(TbBrand::getName,brand.getName());
            }
            if (brand.getFirstChar() !=null && brand.getFirstChar().length()>0 ){
                query.lambda().like(TbBrand::getFirstChar,brand.getFirstChar());

            }
        }
        IPage<TbBrand> pageResult = baseMapper.selectPage(page,query);
        PageResult result = new PageResult(pageResult.getTotal(),pageResult.getRecords());
        return result;
    }
}
