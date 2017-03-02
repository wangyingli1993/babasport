package me.alent.core.po.product;

import me.alent.common.web.Constants;

/**
 * 品牌
 * Created by Alent on 2017/2/21.
 */
public class Brand {
    private Integer id;
    private String name;
    private String description;
    private String imgUrl;
    private Integer sort;
    private Integer isDisplay;

    public String getAllImgUrl() {
        return Constants.IMAGE_URL + this.getImgUrl();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", sort=" + sort +
                ", isDisplay=" + isDisplay +
                '}';
    }
}
