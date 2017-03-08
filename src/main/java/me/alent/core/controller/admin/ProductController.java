package me.alent.core.controller.admin;

import me.alent.common.page.Pagination;
import me.alent.core.po.product.*;
import me.alent.core.query.product.*;
import me.alent.core.service.product.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * 后台商品管理
 * 商品列表
 * 商品添加'
 * 商品上架
 *
 * @author lx
 */
@Controller
public class ProductController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private ColorService colorService;

    //商品列表
    @RequestMapping(value = "/product/list.do")
    public String list(Integer pageNo, String name, Integer brandId, Integer isShow, ModelMap model) {

        BrandQuery brandQuery = new BrandQuery();

        brandQuery.setFields("id,name");
        brandQuery.setIsDisplay(1);
        //加载品牌
        List<Brand> brands = brandService.getBrandList(brandQuery);
        model.addAttribute("brands", brands);

        //分页参数
        StringBuilder params = new StringBuilder();

        //商品条件对象
        ProductQuery productQuery = new ProductQuery();
        //1:判断条件是为Null
        if (StringUtils.isNotBlank(name)) {
            productQuery.setName(name);
            //要求模糊查询
            productQuery.setNameLike(true);

            params.append("&name=").append(name);

            //回显查询条件
            model.addAttribute("name", name);
        }
        //判断品牌ID
        if (null != brandId) {
            productQuery.setBrandId(brandId);
            params.append("&").append("brandId=").append(brandId);

            //回显查询条件
            model.addAttribute("brandId", brandId);
        }
        //判断上下架状态
        if (null != isShow) {
            productQuery.setIsShow(isShow);
            params.append("&").append("isShow=").append(isShow);

            //回显查询条件
            model.addAttribute("isShow", isShow);
        } else {
            productQuery.setIsShow(0);
            params.append("&").append("isShow=").append(0);
            //回显查询条件
            model.addAttribute("isShow", 0);
        }
        //设置页号
        productQuery.setPageNo(Pagination.cpn(pageNo));
        //设置每页数
        productQuery.setPageSize(5);
        productQuery.orderbyId(false); // 倒叙
        //加载带有分页的商品
        Pagination pagination = productService.getProductListWithPage(productQuery);

        //分页页面展示
        String url = "/product/list.do";
        pagination.pageView(url, params.toString());

        model.addAttribute("pagination", pagination);
        return "product/list";
    }

    // 去添加页面
    @RequestMapping(value = "/product/toAdd.do")
    public String toAdd(Model model) {
        TypeQuery typeQuery = new TypeQuery();
        // 指定查询内容
        typeQuery.setFields("id,name");
        typeQuery.setIsDisplay(1);
        List<Type> types = typeService.getTypeList(typeQuery);
        model.addAttribute("types", types);

        // 加载商品品牌
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setFields("id,name");
        brandQuery.setIsDisplay(1);
        List<Brand> brands = brandService.getBrandList(brandQuery);
        model.addAttribute("brands", brands);

        // 加载商品属性
        FeatureQuery featureQuery = new FeatureQuery();
        List<Feature> features = featureService.getFeatureList(featureQuery);
        model.addAttribute("features", features);

        ColorQuery colorQuery = new ColorQuery();
        colorQuery.setParentId(0);
        List<Color> colors = colorService.getColorList(colorQuery);
        model.addAttribute("colors", colors);
        return "product/add";
    }

    // 商品添加
    @RequestMapping(value = "/product/add.do")
    public String add(Product product, Img img) {
        // 商品表， 图片表， sku表
        product.setImg(img);
        productService.addProduct(product);
        return "redirect:/product/list.do";
    }

    @RequestMapping(value = "/product/isShow.do")
    public String isShow(Integer[] ids, Integer pageNo, String name, Integer brandId, Integer isShow, Model model) {
        Product product = new Product();
        product.setIsShow(1);
        if (ids != null && ids.length > 0) {
            for (Integer id : ids) {
                product.setId(id);
                productService.updateProductByKey(product);
            }
        }

        //静态化



        if (pageNo != null) {
            model.addAttribute("pageNo", pageNo);
        }
        if (StringUtils.isEmpty(name)) {
            model.addAttribute("name", name);
        }
        if (brandId != null) {
            model.addAttribute("brandId", brandId);
        }
        if (isShow != null) {
            model.addAttribute("isShow", brandId);
        }
        return "redirect:/product/list.do";
    }
}
