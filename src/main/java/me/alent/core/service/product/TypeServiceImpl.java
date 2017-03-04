package me.alent.core.service.product;

import me.alent.common.page.Pagination;
import me.alent.core.Query.product.TypeQuery;
import me.alent.core.mapper.product.TypeMapper;
import me.alent.core.po.product.Type;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品类型
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	@Resource
	TypeMapper typeMapper;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addType(Type type) {
		return typeMapper.addType(type);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Type getTypeByKey(Integer id) {
		return typeMapper.getTypeByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Type> getTypesByKeys(List<Integer> idList) {
		return typeMapper.getTypesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return typeMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return typeMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateTypeByKey(Type type) {
		return typeMapper.updateTypeByKey(type);
	}
	
	@Transactional(readOnly = true)
	public Pagination getTypeListWithPage(TypeQuery typeQuery) {
		Pagination p = new Pagination(typeQuery.getPageNo(),typeQuery.getPageSize(), typeMapper.getTypeListCount(typeQuery));
		p.setList(typeMapper.getTypeListWithPage(typeQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Type> getTypeList(TypeQuery typeQuery) {
		return typeMapper.getTypeList(typeQuery);
	}
}
