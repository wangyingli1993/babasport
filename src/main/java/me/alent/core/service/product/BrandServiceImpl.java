package me.alent.core.service.product;


import me.alent.common.page.Pagination;
import me.alent.core.mapper.product.BrandMapper;
import me.alent.core.po.product.Brand;
import me.alent.core.po.product.BrandPagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Alent on 2017/2/21.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    public Pagination getBrandListWithPage(BrandPagination brandPagination) throws Exception {
        int count = brandMapper.getBrandCount(brandPagination);
        Pagination pagination = new Pagination(brandPagination.getPageNo(), brandPagination.getPageSize(), count);
        pagination.setList(brandMapper.getBrandListWithPage(brandPagination));
        return pagination;
    }

    public void addBrand(Brand brand) throws Exception {
        brandMapper.addBrand(brand);
    }
}
