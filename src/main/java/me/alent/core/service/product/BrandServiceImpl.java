package me.alent.core.service.product;


import me.alent.common.page.Pagination;
import me.alent.core.Query.product.BrandQuery;
import me.alent.core.mapper.product.BrandMapper;
import me.alent.core.po.product.Brand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 品牌事务
 * @author lx
 *
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService{
	
	@Resource
	private BrandMapper brandMapper;

	@Transactional(readOnly = true)
	public Pagination getBrandListWithPage(Brand brand){
		//1:起始页  startRow = (pageNo - 1)*pageSize
		//2:每页数
		//3:总记录数
		Pagination  pagination = new Pagination(brand.getPageNo(),brand.getPageSize(), brandMapper.getBrandCount(brand));
		//Brand集合
		pagination.setList(brandMapper.getBrandListWithPage(brand));
		
		return pagination;
	}

	@Override
	public void addBrand(Brand brand) {
		brandMapper.addBrand(brand);
	}

	@Override
	public void deleteBrandByKey(Integer id) {
		brandMapper.deleteBrandByKey(id);
		
	}

	@Override
	public void deleteBrandByKeys(Integer[] ids) {
		brandMapper.deleteBrandByKeys(ids);
		
	}

	@Override
	public void updateBrandByKey(Brand brand) {
		brandMapper.updateBrandByKey(brand);
		
	}

	public Brand getBrandByKey(Integer id) {
		// TODO Auto-generated method stub
		return brandMapper.getBrandByKey(id);
	}

	@Override
	public List<Brand> getBrandList(BrandQuery brandQuery) {
		// TODO Auto-generated method stub
		return brandMapper.getBrandList(brandQuery);
	}
}
