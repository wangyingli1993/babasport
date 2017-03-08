package me.alent.core.service.product;

import me.alent.common.page.Pagination;
import me.alent.core.query.product.ColorQuery;
import me.alent.core.mapper.product.ColorMapper;
import me.alent.core.po.product.Color;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 颜色
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class ColorServiceImpl implements ColorService {

	@Resource
    ColorMapper colorMapper;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addColor(Color color) {
		return colorMapper.addColor(color);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Color getColorByKey(Integer id) {
		return colorMapper.getColorByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Color> getColorsByKeys(List<Integer> idList) {
		return colorMapper.getColorsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return colorMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return colorMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateColorByKey(Color color) {
		return colorMapper.updateColorByKey(color);
	}
	
	@Transactional(readOnly = true)
	public Pagination getColorListWithPage(ColorQuery colorQuery) {
		Pagination p = new Pagination(colorQuery.getPageNo(),colorQuery.getPageSize(), colorMapper.getColorListCount(colorQuery));
		p.setList(colorMapper.getColorListWithPage(colorQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Color> getColorList(ColorQuery colorQuery) {
		return colorMapper.getColorList(colorQuery);
	}
}
