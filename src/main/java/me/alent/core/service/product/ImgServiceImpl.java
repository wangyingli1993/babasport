package me.alent.core.service.product;

import me.alent.common.page.Pagination;
import me.alent.core.Query.product.ImgQuery;
import me.alent.core.mapper.product.ImgMapper;
import me.alent.core.po.product.Img;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class ImgServiceImpl implements ImgService {

	@Resource
	ImgMapper imgMapper;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addImg(Img img) {
		return imgMapper.addImg(img);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Img getImgByKey(Integer id) {
		return imgMapper.getImgByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Img> getImgsByKeys(List<Integer> idList) {
		return imgMapper.getImgsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return imgMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return imgMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateImgByKey(Img img) {
		return imgMapper.updateImgByKey(img);
	}
	
	@Transactional(readOnly = true)
	public Pagination getImgListWithPage(ImgQuery imgQuery) {
		Pagination p = new Pagination(imgQuery.getPageNo(),imgQuery.getPageSize(), imgMapper.getImgListCount(imgQuery));
		p.setList(imgMapper.getImgListWithPage(imgQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Img> getImgList(ImgQuery imgQuery) {
		return imgMapper.getImgList(imgQuery);
	}
}
