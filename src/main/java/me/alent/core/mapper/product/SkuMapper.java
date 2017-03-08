package me.alent.core.mapper.product;


import me.alent.core.query.product.SkuQuery;
import me.alent.core.po.product.Sku;

import java.util.List;

public interface SkuMapper {

	/**
	 * 添加
	 * @param sku
	 */
	public Integer addSku(Sku sku);

	/**
	 * 根据主键查找
	 * @param
	 */
	public Sku getSkuByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param
	 */
	public List<Sku> getSkusByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param
	 */
	public Integer updateSkuByKey(Sku sku);

	/**
	 * 分页查询
	 * @param skuQuery
	 */
	public List<Sku> getSkuListWithPage(SkuQuery skuQuery);

	/**
	 * 集合查询
	 * @param skuQuery
	 */
	public List<Sku> getSkuList(SkuQuery skuQuery);
	
	/**
	 * 总条数
	 * @param skuQuery
	 */
	public int getSkuListCount(SkuQuery skuQuery);

}
