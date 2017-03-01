package me.alent.core.controller.admin;

import me.alent.common.page.Pagination;
import me.alent.core.po.product.Brand;
import me.alent.core.po.product.BrandPagination;
import me.alent.core.service.product.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/brand/add.do")
    public String add(Brand brand) throws Exception {
        brandService.addBrand(brand);
        return "redirect:/brand/list.do";
    }
}

