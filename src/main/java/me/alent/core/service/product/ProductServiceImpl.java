package me.alent.core.service.product;

import me.alent.common.page.Pagination;
import me.alent.core.po.product.Img;
import me.alent.core.po.product.Sku;
import me.alent.core.query.product.ProductQuery;
import me.alent.core.mapper.product.ProductMapper;
import me.alent.core.po.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 商品事务层
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Resource
	ProductMapper productMapper;
	@Autowired
	private ImgService imgService;
	@Autowired
	private SkuService skuService;
	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addProduct(Product product) {
		// 商品编号生成
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String no = df.format(new Date());
		product.setNo(no);
		// 添加时间
		product.setCreateTime(new Date());
		// 保存商品，返回影响行数
		Integer row = productMapper.addProduct(product);

		Img img = product.getImg();
		img.setProductId(product.getId());
		img.setIsDef(1);
		// 保存图片
		imgService.addImg(img);
		Sku sku = new Sku();
		sku.setProductId(product.getId());
		sku.setDeliveFee(10.00);
		sku.setSkuPrice(0.00);
		sku.setMarketPrice(0.00);
		sku.setStockInventory(0);
		sku.setSkuUpperLimit(0);
		sku.setCreateTime(new Date());
		for(String color: product.getColor().split(",")) {
			sku.setColorId(Integer.parseInt(color));
			for (String size : product.getSize().split(",")) {
				sku.setSize(size);
				skuService.addSku(sku);
			}
		}
		return row;
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Product getProductByKey(Integer id) {
		return productMapper.getProductByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProductsByKeys(List<Integer> idList) {
		return productMapper.getProductsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return productMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return productMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateProductByKey(Product product) {
		return productMapper.updateProductByKey(product);
	}
	
	@Transactional(readOnly = true)
	public Pagination getProductListWithPage(ProductQuery productQuery) {
		Pagination p = new Pagination(productQuery.getPageNo(),productQuery.getPageSize(), productMapper.getProductListCount(productQuery));
		List<Product> products = productMapper.getProductListWithPage(productQuery);
		p.setList(products);
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProductList(ProductQuery productQuery) {
		return productMapper.getProductList(productQuery);
	}
}
