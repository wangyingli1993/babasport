package me.alent.core.service.country;

import me.alent.common.page.Pagination;
import me.alent.core.Query.country.ProvinceQuery;
import me.alent.core.mapper.country.ProvinceMapper;
import me.alent.core.po.country.Province;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 省
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

	@Resource
    ProvinceMapper provinceMapper;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProvince(Province province) {
		return provinceMapper.addProvince(province);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Province getProvinceByKey(Integer id) {
		return provinceMapper.getProvinceByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Province> getProvincesByKeys(List<Integer> idList) {
		return provinceMapper.getProvincesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return provinceMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return provinceMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProvinceByKey(Province province) {
		return provinceMapper.updateProvinceByKey(province);
	}
	
	@Transactional(readOnly = true)
	public Pagination getProvinceListWithPage(ProvinceQuery provinceQuery) {
		Pagination p = new Pagination(provinceQuery.getPageNo(),provinceQuery.getPageSize(), provinceMapper.getProvinceListCount(provinceQuery));
		p.setList(provinceMapper.getProvinceListWithPage(provinceQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Province> getProvinceList(ProvinceQuery provinceQuery) {
		return provinceMapper.getProvinceList(provinceQuery);
	}
}
