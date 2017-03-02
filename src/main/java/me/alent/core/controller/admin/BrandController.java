package me.alent.core.controller.admin;

import me.alent.common.page.Pagination;
import me.alent.core.po.product.Brand;
import me.alent.core.po.product.BrandPagination;
import me.alent.core.service.product.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 品牌
 * Created by Alent on 2017/2/22.
 */
@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;

    // 品牌列表页面
    @RequestMapping(value = "/brand/list.do")
    public String list(BrandPagination brandPagination, Model model) throws Exception {
        //首次查询，确保pageNo不为空
        brandPagination.setPageNo(Pagination.cpn(brandPagination.getPageNo()));
        // 设置分页查询的开始行
        int startRow = (brandPagination.getPageNo() - 1) * brandPagination.getPageSize();
        brandPagination.setStartRow(startRow);

        Pagination pagination = brandService.getBrandListWithPage(brandPagination);
        String url = "/brand/list.do";
        StringBuilder sb = new StringBuilder();
        if (!StringUtils.isEmpty(brandPagination.getName())) {
            sb.append("name=").append(brandPagination.getName());
        }
        if (!StringUtils.isEmpty(brandPagination.getIsDisplay())) {
            sb.append("&").append("isDisplay=").append(brandPagination.getIsDisplay());
        }
        pagination.pageView(url, sb.toString());

        model.addAttribute("pagination", pagination);
        model.addAttribute("name", brandPagination.getName());
        model.addAttribute("isDisplay", brandPagination.getIsDisplay());
        return "brand/list";
    }

    @RequestMapping(value = "brand/toAdd.do")
    public String toAdd() {
        return "brand/add";
    }

    // 添加品牌
    @RequestMapping(value = "/brand/add.do")
    public String add(Brand brand) throws Exception {
        brandService.addBrand(brand);
        return "redirect:/brand/list.do";
    }

    //删除,重定向时传递数据到jsp页面
    @RequestMapping(value = "/brand/delete.do")
    public String delete(Integer id, String name, Integer isDisplay, ModelMap model) throws Exception {
//        重定向时使用拼接字符串的方式传递数据，将出现中文乱码问题
//        return "redirect:/brand/list.do?name=" + name + "&isDisplay=" + isDisplay;

        brandService.deleteBrandByKey(id);  //参数校验？？？
        if (!StringUtils.isEmpty(name)) {
            model.addAttribute("name", name); // 重定向时为什么能将attr传递到新的jsp页面？？？？
        }
        return "redirect:/brand/list.do";
    }

    //删除多个
    @RequestMapping(value = "/brand/deletes.do")
    public String deletess(Integer[] ids, String name, Integer isDisplay, ModelMap model) throws Exception {
        brandService.deleteBrandByKeys(ids);  //参数校验？？？
        if (!StringUtils.isEmpty(name)) {
            model.addAttribute("name", name); // 重定向时为什么能将attr传递到新的jsp页面？？？？
        }
        return "redirect:/brand/list.do";
    }

    // 去修改页面
    @RequestMapping(value = "/brand/toEdit.do")
    public String toEdit(Integer id, Model model) throws Exception {
        Brand brand = brandService.getBrandByKey(id);
        model.addAttribute("brand", brand);
        return "brand/edit";
    }

    //提交修改页面
    @RequestMapping(value = "/brand/edit.do")
    public String edit(Integer id, Brand brand) throws Exception {
        brandService.updateBrandByKey(brand, id);
        return "redirect:/brand/list.do";
    }
}

