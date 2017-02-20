package me.alent.core.service;

import me.alent.common.junit.SpringJunit;
import me.alent.core.po.TestBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Alent on 2017/2/20.
 */
public class TestBeanServiceTest extends SpringJunit {
    @Autowired
    private TestBeanService testBeanService;

    @Test
    public void addTestBean() throws Exception {
        TestBean testBean = new TestBean();
        testBean.setName("巴烈军");
        testBeanService.addTestBean(testBean);
    }

    @Test
    public void findTestBeanById() throws Exception {
        TestBean testBean = testBeanService.findTestBeanById(1);
        System.out.println(testBean);
    }
}