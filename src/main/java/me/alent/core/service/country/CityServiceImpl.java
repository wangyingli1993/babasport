package me.alent.core.service.country;

import me.alent.common.page.Pagination;
import me.alent.core.query.country.CityQuery;
import me.alent.core.mapper.country.CityMapper;
import me.alent.core.po.country.City;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 市
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Resource
    CityMapper cityMapper;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addCity(City city) {
		return cityMapper.addCity(city);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public City getCityByKey(Integer id) {
		return cityMapper.getCityByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<City> getCitysByKeys(List<Integer> idList) {
		return cityMapper.getCitysByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return cityMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return cityMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateCityByKey(City city) {
		return cityMapper.updateCityByKey(city);
	}
	
	@Transactional(readOnly = true)
	public Pagination getCityListWithPage(CityQuery cityQuery) {
		Pagination p = new Pagination(cityQuery.getPageNo(),cityQuery.getPageSize(), cityMapper.getCityListCount(cityQuery));
		p.setList(cityMapper.getCityListWithPage(cityQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<City> getCityList(CityQuery cityQuery) {
		return cityMapper.getCityList(cityQuery);
	}
}
