package me.alent.core.service.order;

import me.alent.common.page.Pagination;
import me.alent.core.Query.order.DetailQuery;
import me.alent.core.mapper.order.DetaiMapper;
import me.alent.core.po.order.Detail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单子项(订单详情)
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class DetailServiceImpl implements DetailService {

	@Resource
    DetaiMapper detaiMapper;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addDetail(Detail detail) {
		return detaiMapper.addDetail(detail);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Detail getDetailByKey(Integer id) {
		return detaiMapper.getDetailByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Detail> getDetailsByKeys(List<Integer> idList) {
		return detaiMapper.getDetailsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return detaiMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return detaiMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateDetailByKey(Detail detail) {
		return detaiMapper.updateDetailByKey(detail);
	}
	
	@Transactional(readOnly = true)
	public Pagination getDetailListWithPage(DetailQuery detailQuery) {
		Pagination p = new Pagination(detailQuery.getPageNo(),detailQuery.getPageSize(), detaiMapper.getDetailListCount(detailQuery));
		p.setList(detaiMapper.getDetailListWithPage(detailQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Detail> getDetailList(DetailQuery detailQuery) {
		return detaiMapper.getDetailList(detailQuery);
	}
}
