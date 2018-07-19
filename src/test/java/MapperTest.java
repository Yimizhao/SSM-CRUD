import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zym.crud.bean.Employee;
import com.zym.crud.dao.DepartmentMapper;
import com.zym.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MapperTest {

	@Autowired
	DepartmentMapper departmentMapper;

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	SqlSession sqlSession;

	@Test
	public void testCRUD() {
		// System.out.println(departmentMapper);

		// departmentMapper.insertSelective(new Department(null, "开发部"));
		// departmentMapper.insertSelective(new Department(null, "测试部"));

		// employeeMapper.insertSelective(new Employee(null, "何东", "M",
		// "hedong@yds.com", 1));
		// employeeMapper.insertSelective(new Employee(null, "丽丽", "F", "lili@yds.com",
		// 2));

		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		for (int i = 0; i < 100; i++) {
			String empName = UUID.randomUUID().toString().substring(0, 5);
			employeeMapper.insertSelective(new Employee(null, empName, "F", empName + "@yds.com", 1));
		}
		System.out.println("======执行完了======");
	}

}
