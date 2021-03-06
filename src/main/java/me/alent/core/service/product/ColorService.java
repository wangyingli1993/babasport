package me.alent.core.service.product;


import me.alent.common.page.Pagination;
import me.alent.core.query.product.ColorQuery;
import me.alent.core.po.product.Color;

import java.util.List;

/**
 * 
 * @author lixu
 * @Date [2014-3-28 下午01:50:28]
 */
public interface ColorService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addColor(Color color);

	/**
	 * 根据主键查询
	 */
	public Color getColorByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Color> getColorsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateColorByKey(Color color);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param colorQuery
	 *            查询条件
	 * @return
	 */
	public Pagination getColorListWithPage(ColorQuery colorQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param colorQuery
	 *            查询条件
	 * @return
	 */
	public List<Color> getColorList(ColorQuery colorQuery);
}
