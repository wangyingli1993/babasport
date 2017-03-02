package me.alent.core.service.product;

import me.alent.common.page.Pagination;
import me.alent.core.po.product.Brand;
import me.alent.core.po.product.BrandPagination;

/**
 * Created by Alent on 2017/2/21.
 */
public interface BrandService {
    Pagination getBrandListWithPage(BrandPagination brandPagination) throws Exception;

    void addBrand(Brand brand) throws Exception;

    void deleteBrandByKey(Integer id) throws Exception;

    //批量删除
    void deleteBrandByKeys(Integer[] ids) throws Exception;

    void updateBrandByKey(Brand brand, Integer id) throws Exception;

    Brand getBrandByKey(Integer id) throws Exception;
}
