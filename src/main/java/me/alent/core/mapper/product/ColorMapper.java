package me.alent.core.mapper.product;

import me.alent.core.Query.product.ColorQuery;
import me.alent.core.po.product.Color;

import java.util.List;

public interface ColorMapper {

	/**
	 * 添加
	 * @param color
	 */
	public Integer addColor(Color color);

	/**
	 * 根据主键查找
	 * @param
	 */
	public Color getColorByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param
	 */
	public List<Color> getColorsByKeys(List<Integer> idList);

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
	public Integer updateColorByKey(Color color);

	/**
	 * 分页查询
	 * @param colorQuery
	 */
	public List<Color> getColorListWithPage(ColorQuery colorQuery);

	/**
	 * 集合查询
	 * @param colorQuery
	 */
	public List<Color> getColorList(ColorQuery colorQuery);
	
	/**
	 * 总条数
	 * @param colorQuery
	 */
	public int getColorListCount(ColorQuery colorQuery);
}
