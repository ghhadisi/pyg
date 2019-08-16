package com.pyg.sellergoods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hss.pyg.mapper.TbBrandMapper;
import com.hss.pyg.pojo.TbBrand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl extends ServiceImpl<TbBrandMapper, TbBrand> implements BrandService {//


    public List<TbBrand> findAll() {
        return baseMapper.selectList(new QueryWrapper<TbBrand>());
    }
}
