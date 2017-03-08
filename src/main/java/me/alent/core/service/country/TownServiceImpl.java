package me.alent.core.service.country;

import me.alent.common.page.Pagination;
import me.alent.core.query.country.TownQuery;
import me.alent.core.mapper.country.TownMapper;
import me.alent.core.po.country.Town;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 县/区
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class TownServiceImpl implements TownService {

	@Resource
    TownMapper townMapper;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addTown(Town town) {
		return townMapper.addTown(town);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Town getTownByKey(Integer id) {
		return townMapper.getTownByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Town> getTownsByKeys(List<Integer> idList) {
		return townMapper.getTownsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return townMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return townMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateTownByKey(Town town) {
		return townMapper.updateTownByKey(town);
	}
	
	@Transactional(readOnly = true)
	public Pagination getTownListWithPage(TownQuery townQuery) {
		Pagination p = new Pagination(townQuery.getPageNo(),townQuery.getPageSize(), townMapper.getTownListCount(townQuery));
		p.setList(townMapper.getTownListWithPage(townQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Town> getTownList(TownQuery townQuery) {
		return townMapper.getTownList(townQuery);
	}
}
