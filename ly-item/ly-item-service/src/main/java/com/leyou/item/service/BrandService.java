package com.leyou.item.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandService {
    @Resource
    private BrandMapper brandMapper;


    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        //开始分页
        PageHelper.startPage(page,rows);
        Example example = new Example(Brand.class);
        Example.Criteria  criteria= example.createCriteria();
        //关键词过滤
        if (StringUtils.isNotBlank(key)){
            criteria.orLike("name", "%" + key + "%").
                    orEqualTo("letter", key.toUpperCase());
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)){
            String orderByClause = sortBy + (desc ? " DESC": " ASC" );
            example.setOrderByClause(orderByClause);
        }
        //查询
        List<Brand> brands = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(brands)){
            throw  new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }
        //解析结果
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getList());
    }

    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        int i = brandMapper.insertSelective(brand);
        if (i<1){
            throw new LyException(ExceptionEnum.BRAND_SAVE_ERROR);
        }
//        for (Long cid : cids) {
//            brandMapper.insertCategoryBrand(brand.getId(),cid);
//        }
        cids.forEach(cid->{
            brandMapper.insertCategoryBrand(brand.getId(), cid);
        });
    }
}
