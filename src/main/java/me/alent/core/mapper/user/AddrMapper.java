package me.alent.core.mapper.user;


import me.alent.core.query.user.AddrQuery;
import me.alent.core.po.user.Addr;

import java.util.List;

public interface AddrMapper {

	/**
	 * 添加
	 * @param addr
	 */
	public Integer addAddr(Addr addr);

	/**
	 * 根据主键查找
	 * @param addrQuery
	 */
	public Addr getAddrByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param addrQuery
	 */
	public List<Addr> getAddrsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param addrQuery
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param addrQuery
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param addrQuery
	 */
	public Integer updateAddrByKey(Addr addr);

	/**
	 * 分页查询
	 * @param addrQuery
	 */
	public List<Addr> getAddrListWithPage(AddrQuery addrQuery);

	/**
	 * 集合查询
	 * @param addrQuery
	 */
	public List<Addr> getAddrList(AddrQuery addrQuery);
	
	/**
	 * 总条数
	 * @param addrQuery
	 */
	public int getAddrListCount(AddrQuery addrQuery);
}
