package me.alent.core.service.user;

import me.alent.common.page.Pagination;
import me.alent.core.query.user.EmployeeQuery;
import me.alent.core.mapper.user.EmployeeMapper;
import me.alent.core.po.user.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工
 * @author lixu
 * @Date [2014-3-27 下午03:31:57]
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	EmployeeMapper employeeMapper;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addEmployee(Employee employee) {
		return employeeMapper.addEmployee(employee);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Employee getEmployeeByKey(String id) {
		return employeeMapper.getEmployeeByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Employee> getEmployeesByKeys(List<String> idList) {
		return employeeMapper.getEmployeesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id) {
		return employeeMapper.deleteByKey(id);
	}

	public Integer deleteByKeys(List<String> idList) {
		return employeeMapper.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateEmployeeByKey(Employee employee) {
		return employeeMapper.updateEmployeeByKey(employee);
	}
	
	@Transactional(readOnly = true)
	public Pagination getEmployeeListWithPage(EmployeeQuery employeeQuery) {
		Pagination p = new Pagination(employeeQuery.getPageNo(),employeeQuery.getPageSize(), employeeMapper.getEmployeeListCount(employeeQuery));
		p.setList(employeeMapper.getEmployeeListWithPage(employeeQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Employee> getEmployeeList(EmployeeQuery employeeQuery) {
		return employeeMapper.getEmployeeList(employeeQuery);
	}
}
