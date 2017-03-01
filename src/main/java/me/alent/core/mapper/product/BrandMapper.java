package me.alent.core.mapper.product;

import me.alent.core.po.product.Brand;
import me.alent.core.po.product.BrandPagination;

import java.util.List;

/**
 * Created by Alent on 2017/2/21.
 */
public interface BrandMapper {

    List<Brand> getBrandListWithPage(BrandPagination brandPagination) throws Exception;

    //查询总记录数
    int getBrandCount(BrandPagination brandPagination) throws Exception;

    void addBrand(Brand brand) throws Exception;
}
