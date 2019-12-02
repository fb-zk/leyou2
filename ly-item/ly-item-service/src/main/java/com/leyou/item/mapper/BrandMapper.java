package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


public interface BrandMapper extends Mapper<Brand> {
    @Insert("insert  tb_category_brand (category_id, brand_id) values (#(bid),#(cid))")
    int insertCategoryBrand(@Param("bid") Long bid , @Param("cid") Long cid);
}
