package me.alent.core.service.user;

import me.alent.common.page.Pagination;
import me.alent.core.query.user.AddrQuery;
import me.alent.core.mapper.user.AddrMapper;
import me.alent.core.po.user.Addr;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 地址
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class AddrServiceImpl implements AddrService {

	@Resource
	AddrMapper addrMapper;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addAddr(Addr addr) {
		return addrMapper.addAddr(addr);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Addr getAddrByKey(Integer id) {
		return addrMapper.getAddrByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Addr> getAddrsByKeys(List<Integer> idList) {
		return addrMapper.getAddrsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return addrMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return addrMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateAddrByKey(Addr addr) {
		return addrMapper.updateAddrByKey(addr);
	}
	
	@Transactional(readOnly = true)
	public Pagination getAddrListWithPage(AddrQuery addrQuery) {
		Pagination p = new Pagination(addrQuery.getPageNo(),addrQuery.getPageSize(), addrMapper.getAddrListCount(addrQuery));
		p.setList(addrMapper.getAddrListWithPage(addrQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Addr> getAddrList(AddrQuery addrQuery) {
		return addrMapper.getAddrList(addrQuery);
	}
}
