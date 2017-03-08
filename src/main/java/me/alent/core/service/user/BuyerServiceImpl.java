package me.alent.core.service.user;

import me.alent.common.page.Pagination;
import me.alent.core.query.user.BuyerQuery;
import me.alent.core.mapper.user.BuyerMapper;
import me.alent.core.po.user.Buyer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 购买者
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

	@Resource
	BuyerMapper buyerMapper;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addBuyer(Buyer buyer) {
		return buyerMapper.addBuyer(buyer);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Buyer getBuyerByKey(String id) {
		return buyerMapper.getBuyerByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Buyer> getBuyersByKeys(List<String> idList) {
		return buyerMapper.getBuyersByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id) {
		return buyerMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<String> idList) {
		return buyerMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateBuyerByKey(Buyer buyer) {
		return buyerMapper.updateBuyerByKey(buyer);
	}
	
	@Transactional(readOnly = true)
	public Pagination getBuyerListWithPage(BuyerQuery buyerQuery) {
		Pagination p = new Pagination(buyerQuery.getPageNo(),buyerQuery.getPageSize(), buyerMapper.getBuyerListCount(buyerQuery));
		p.setList(buyerMapper.getBuyerListWithPage(buyerQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Buyer> getBuyerList(BuyerQuery buyerQuery) {
		return buyerMapper.getBuyerList(buyerQuery);
	}
}
