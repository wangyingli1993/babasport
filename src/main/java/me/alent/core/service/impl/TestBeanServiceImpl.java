package me.alent.core.service.impl;

import me.alent.core.mapper.TestBeanMapper;
import me.alent.core.po.TestBean;
import me.alent.core.service.TestBeanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Alent on 2017/2/19.
 */
@Service("testBeanService")
public class TestBeanServiceImpl implements TestBeanService {

    @Resource
    private TestBeanMapper testBeanMapper;

    public void addTestBean(TestBean testBean) throws Exception {
        testBeanMapper.addTestBean(testBean);
        throw new RuntimeException();
    }

    public TestBean findTestBeanById(int id) throws Exception {
        return testBeanMapper.findTestBeanById(id);
    }
}
