package com.pyg.sellergoods.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hss.pyg.entity.PageResult;
import com.hss.pyg.mapper.TbSpecificationMapper;
import com.hss.pyg.mapper.TbSpecificationOptionMapper;
import com.hss.pyg.pojo.TbSpecification;
import com.hss.pyg.pojo.TbSpecificationOption;
import com.hss.pyg.pojogroup.Specification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class SpecificationServiceImpl extends ServiceImpl<TbSpecificationMapper, TbSpecification> implements SpecificationService {
    @Autowired
    TbSpecificationOptionMapper tbSpecificationOptionMapper;

    @Override
    public List<TbSpecification> findAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {

        Page<TbSpecification> page = new Page<TbSpecification>(pageNum,pageSize);
        IPage<TbSpecification> pageResult = baseMapper.selectPage(page,null);
        PageResult result = new PageResult(pageResult.getTotal(),pageResult.getRecords());
        return result;
    }

    @Override
    public void add(Specification specification) {
        baseMapper.insert(specification.getSpecification());

        for ( TbSpecificationOption option:specification.getSpecificationOptionList()){
            option.setSpecId(specification.getSpecification().getId());
            tbSpecificationOptionMapper.insert(option);
        }
    }

    @Override
    public void update(Specification specification) {
        //获取规格实体
        TbSpecification tbspecification = specification.getSpecification();
        baseMapper.updateById(tbspecification);
        //删除原来规格对应的规格选项
        tbSpecificationOptionMapper.delete(new QueryWrapper<TbSpecificationOption>().lambda().eq(TbSpecificationOption::getSpecId, tbspecification.getId()));
        for ( TbSpecificationOption option:specification.getSpecificationOptionList()){
            option.setSpecId(specification.getSpecification().getId());
            tbSpecificationOptionMapper.insert(option);
        }
    }

    @Override
    public Specification findOne(Long id) {
        Specification specification=new Specification();
        specification.setSpecification(baseMapper.selectById(id));
        specification.setSpecificationOptionList(tbSpecificationOptionMapper.selectList(new QueryWrapper<TbSpecificationOption>().lambda().eq(TbSpecificationOption::getSpecId, id)));
        return specification;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids){
            baseMapper.deleteById(id);
            tbSpecificationOptionMapper.delete(new QueryWrapper<TbSpecificationOption>().lambda().eq(TbSpecificationOption::getSpecId, id));
        }
    }

    @Override
    public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
        Page<TbSpecification> page = new Page<TbSpecification>(pageNum,pageSize);

        QueryWrapper<TbSpecification> query = new QueryWrapper<>();
        if (specification !=null && specification.getSpecName() !=null && specification.getSpecName().length() >0){
            query.lambda().like(TbSpecification::getSpecName, specification.getSpecName());
        }


        IPage<TbSpecification> pageResult = baseMapper.selectPage(page,query);
        PageResult result = new PageResult(pageResult.getTotal(),pageResult.getRecords());
        return result;
    }

    @Override
    public List<Map<String, Object>> selectOptionList() {
        return baseMapper.selectMaps(null);
    }
}
