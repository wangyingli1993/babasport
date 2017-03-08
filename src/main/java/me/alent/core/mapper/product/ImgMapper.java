package me.alent.core.mapper.product;


import me.alent.core.query.product.ImgQuery;
import me.alent.core.po.product.Img;

import java.util.List;

public interface ImgMapper {

	/**
	 * 添加
	 * @param img
	 */
	public Integer addImg(Img img);

	Img getImgByProductId(Integer id);

	/**
	 * 根据主键查找
	 * @param
	 */
	public Img getImgByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param
	 */
	public List<Img> getImgsByKeys(List<Integer> idList);

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
	public Integer updateImgByKey(Img img);

	/**
	 * 分页查询
	 * @param imgQuery
	 */
	public List<Img> getImgListWithPage(ImgQuery imgQuery);

	/**
	 * 集合查询
	 * @param imgQuery
	 */
	public List<Img> getImgList(ImgQuery imgQuery);
	
	/**
	 * 总条数
	 * @param imgQuery
	 */
	public int getImgListCount(ImgQuery imgQuery);
}
