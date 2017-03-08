package me.alent.core.service.order;

import me.alent.common.page.Pagination;
import me.alent.core.query.order.OrderQuery;
import me.alent.core.mapper.order.OrderMapper;
import me.alent.core.po.order.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单主
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Resource
    OrderMapper orderMapper;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addOrder(Order order) {
		return orderMapper.addOrder(order);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Order getOrderByKey(Integer id) {
		return orderMapper.getOrderByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Order> getOrdersByKeys(List<Integer> idList) {
		return orderMapper.getOrdersByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return orderMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return orderMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateOrderByKey(Order order) {
		return orderMapper.updateOrderByKey(order);
	}
	
	@Transactional(readOnly = true)
	public Pagination getOrderListWithPage(OrderQuery orderQuery) {
		Pagination p = new Pagination(orderQuery.getPageNo(),orderQuery.getPageSize(), orderMapper.getOrderListCount(orderQuery));
		p.setList(orderMapper.getOrderListWithPage(orderQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Order> getOrderList(OrderQuery orderQuery) {
		return orderMapper.getOrderList(orderQuery);
	}
}
