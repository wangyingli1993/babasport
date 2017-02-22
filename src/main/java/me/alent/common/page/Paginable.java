package me.alent.common.page;

/**
 * Created by Alent on 2017/2/21.
 */
public interface Paginable {
    int getTotalCount();

    int getTotalPage();

    int getPageSize();

    int getPageNo();

    boolean isFirstPage();

    boolean isLastPage();

    int getNextPage();

    int getPrePage();
}