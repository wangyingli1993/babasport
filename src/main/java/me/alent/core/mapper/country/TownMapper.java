package me.alent.core.mapper.country;

import me.alent.core.Query.country.TownQuery;
import me.alent.core.po.country.Town;

import java.util.List;

public interface TownMapper {

	/**
	 * 添加
	 * @param town
	 */
	public Integer addTown(Town town);

	/**
	 * 根据主键查找
	 * @param
	 */
	public Town getTownByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param
	 */
	public List<Town> getTownsByKeys(List<Integer> idList);

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
	public Integer updateTownByKey(Town town);

	/**
	 * 分页查询
	 * @param townQuery
	 */
	public List<Town> getTownListWithPage(TownQuery townQuery);

	/**
	 * 集合查询
	 * @param townQuery
	 */
	public List<Town> getTownList(TownQuery townQuery);
	
	/**
	 * 总条数
	 * @param townQuery
	 */
	public int getTownListCount(TownQuery townQuery);
}
