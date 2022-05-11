package com.globalin.test;



import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import com.globalin.dao.EmployeesDao;
import com.globalin.model.Employees;

public class DaoTest {
	
private static EmployeesDao dao =EmployeesDao.getInstance();	
	
	
	
	
	@Test
	public void testSelect() {
		Employees e =dao.getMember("admin");
		System.out.println(e);
		//"관리자":기대값
		//e.getName:실제값
		//assertEquals메소드:테스트실행 결과 두 값이같을 것이다라고예상
		//두값이 다르면 테스트 실패
		//두값이 같으면 테스트성공
		assertEquals("관리자",e.getName());
		        List <Employees >list=dao.selectAllEmployees();
		        System.out.println(list.get(0));
		        //1:기대값
		        //list.size():실제값
		        //assertEquals(1, list.size());
		        
		       int result=dao.deleteMember("hyewon");
		       Employees e1= dao.getMember("hyewon");
		       //e1객체가 null일것이다라고 예상
		       assertNull(e1);
				
	
	}

}
