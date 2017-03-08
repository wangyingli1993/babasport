package me.alent.core.service.product;

import me.alent.common.page.Pagination;
import me.alent.core.query.product.FeatureQuery;
import me.alent.core.mapper.product.FeatureMapper;
import me.alent.core.po.product.Feature;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品属性事务层
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class FeatureServiceImpl implements FeatureService {

	@Resource
	FeatureMapper featureMapper;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addFeature(Feature feature) {
		return featureMapper.addFeature(feature);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Feature getFeatureByKey(Integer id) {
		return featureMapper.getFeatureByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Feature> getFeaturesByKeys(List<Integer> idList) {
		return featureMapper.getFeaturesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return featureMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return featureMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateFeatureByKey(Feature feature) {
		return featureMapper.updateFeatureByKey(feature);
	}
	
	@Transactional(readOnly = true)
	public Pagination getFeatureListWithPage(FeatureQuery featureQuery) {
		Pagination p = new Pagination(featureQuery.getPageNo(),featureQuery.getPageSize(), featureMapper.getFeatureListCount(featureQuery));
		p.setList(featureMapper.getFeatureListWithPage(featureQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Feature> getFeatureList(FeatureQuery featureQuery) {
		return featureMapper.getFeatureList(featureQuery);
	}
}
