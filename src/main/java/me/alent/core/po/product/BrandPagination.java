package me.alent.core.po.product;

/**
 * Created by Alent on 2017/2/22.
 */
public class BrandPagination extends Brand {
    private static final int PAGE_SIZE = 5;

    private Integer pageNo;

    private Integer startRow;

    private final Integer pageSize = PAGE_SIZE;

    public int getPageSize() {
        return pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
}
