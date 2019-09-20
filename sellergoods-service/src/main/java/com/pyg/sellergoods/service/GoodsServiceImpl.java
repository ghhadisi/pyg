package com.pyg.sellergoods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hss.pyg.entity.PageResult;
import com.hss.pyg.mapper.TbGoodsMapper;
import com.hss.pyg.pojo.TbGoods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl<TbGoodsMapper, TbGoods>  implements GoodsService {
    public List<TbGoods> findAll() {
        return baseMapper.selectList(null);
    }

    public PageResult findPage(int pageNum, int pageSize) {
        Page<TbGoods> page = new Page<TbGoods>(pageNum,pageSize);
        QueryWrapper<TbGoods> query = new QueryWrapper<TbGoods>();
        IPage<TbGoods> pageResult = baseMapper.selectPage(page,query);
        PageResult result = new PageResult(pageResult.getTotal(),pageResult.getRecords());
        return result;
    }

    public void add(TbGoods goods) {
        baseMapper.insert(goods);
    }

    public void update(TbGoods goods) {
        baseMapper.updateById(goods);
    }

    public TbGoods findOne(Long id) {
        return baseMapper.selectById(id);
    }

    public void delete(Long[] ids) {
        for (Long id :ids){
            baseMapper.deleteById(id);
        }
    }

    public PageResult findPage(TbGoods goods, int pageNum, int pageSize) {
        Page<TbGoods> page = new Page<TbGoods>(pageNum,pageSize);
        QueryWrapper<TbGoods> query = new QueryWrapper<TbGoods>();
        if (goods !=null){
            if(goods.getSellerId()!=null && goods.getSellerId().length()>0){
                query.lambda().like(TbGoods::getId, goods.getId());
            }
            if (goods.getGoodsName() != null && goods.getGoodsName().length() >0 ){
                query.lambda().like(TbGoods::getGoodsName, goods.getGoodsName());
            }

            if(goods.getIsMarketable()!=null && goods.getIsMarketable().length()>0){
                query.lambda().like(TbGoods::getIsMarketable,goods.getIsMarketable());
            }
            if(goods.getCaption()!=null && goods.getCaption().length()>0){
                query.lambda().like(TbGoods::getCaption,goods.getCaption());
            }
            if(goods.getSmallPic()!=null && goods.getSmallPic().length()>0){
                query.lambda().like(TbGoods::getSmallPic,goods.getSmallPic());
            }
            if(goods.getIsEnableSpec()!=null && goods.getIsEnableSpec().length()>0){
                query.lambda().like(TbGoods::getIsEnableSpec,goods.getIsEnableSpec());
            }
            if(goods.getIsDelete()!=null && goods.getIsDelete().length()>0){
                query.lambda().like( TbGoods::getIsDelete,goods.getIsDelete());
            }
        }
        IPage<TbGoods> pageResult = baseMapper.selectPage(page,query);
        PageResult result = new PageResult(pageResult.getTotal(),pageResult.getRecords());
        return result;
    }
}
