package me.alent.core.mapper;

import me.alent.core.po.TestBean;

/**
 * Created by Alent on 2017/2/19.
 */
public interface TestBeanMapper {

    void addTestBean(TestBean testBean) throws Exception;
    TestBean findTestBeanById(int id) throws Exception;
}

