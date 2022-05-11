package com.globalin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.globalin.model.Employees;
import com.globalin.util.DBManager;

public class EmployeesDao {
	//싱글톤 패턴
	//1.기본생성자를  프라이베이트 접근제한자로 만들기
	private EmployeesDao() {
		
	}
	//2.자기자신 타입을 가진 정적 변수 만들기(static Employeesdao),접근제한private
	private static EmployeesDao instance=new EmployeesDao();
    //3.외부에서 내가 가지고 있는 변수를 사용할수 있도록 getter 메소드 만들어주기
     public static EmployeesDao getInstance() {
    	 return instance;
    	 //EmployeesDao.getInstance()를 외부에서 호출해야 사용가능
    	 //외부에선 new EmployeesDao()로객체생성이 불가능하다
     }
         //사원정보 1개 가져오기(id로)
         //리턴타입:Employees
     //파라미터:String id
     public Employees getMember(String id) {
    	 //리턴할 사원 정보
    	 Employees result = null;
    	 //연결객체
    	 Connection conn=null;
    	 //sql문 실행 객체
    	 PreparedStatement pstmt=null;
    	 //select문 처리를 위한 결과 객체
    	 ResultSet rs=null;
    	 //실행할 sql문
    	 String sql="select * from employees where id=?";
    	 //연결가져오기
    	 try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			//쿼리실행
			rs=pstmt.executeQuery();
			//결과처리
			if(rs.next()) {
				result = new Employees();
				result.setId(rs.getString("id"));
				result.setPass(rs.getString("pass"));
				result.setName(rs.getString("name"));
				result.setLev(rs.getString("lev"));
				result.setPhone(rs.getString("phone"));
				result.setGender(rs.getInt("gender"));
				result.setEnter(rs.getTimestamp("enter"));
				//rs.getDate("enter");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(rs, pstmt,conn);
		}
    	 return result;
     }
          public List<Employees>selectAllEmployees(){
    	 //리턴할 결과 정보
    	 List<Employees>result = new ArrayList <Employees>();
    	 //연결객체
    	 Connection conn = null;
    	 //sql실행 객체
    	 PreparedStatement pstmt = null;
    	 //실행할 sql문
    	 String sql="select * from employees order by enter desc";
    	 // sql실행결과
    	 ResultSet rs=null;
    			 try {
    					conn=DBManager.getConnection();
    					pstmt=conn.prepareStatement(sql);
    					
    					//쿼리실행
    					rs=pstmt.executeQuery();
    					//결과처리
    					while(rs.next()) {
    						Employees e = new Employees();
    						e.setId(rs.getString("id"));
    						e.setPass(rs.getString("pass"));
    						e.setName(rs.getString("name"));
    						e.setLev(rs.getString("lev"));
    						e.setPhone(rs.getString("phone"));
    						e.setGender(rs.getInt("gender"));
    						e.setEnter(rs.getTimestamp("enter"));
    						result.add(e);
    						//rs.getDate("enter");
    					}
    				} catch (ClassNotFoundException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}finally {
    					DBManager.close(rs, pstmt,conn);
    				}
    		    	 return result;
     }
    		     
//사원정보 삽입하기
//리턴타입:int(실패시 0,성공시 삽입한 갯수만큼)
//파라미터:사원정보 employees객체
public int insertMember(Employees member) {
	//삽입결과(성공or실패)
	int result=0;
	//연결객체
	Connection conn=null;
	//sql실행객체
	PreparedStatement pstmt=null;
	//실행할sql문
	String sql="insert into employees values(?,?,?,?,sysdate,?,?)";

	try {
		conn=DBManager.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPass());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getLev());
		pstmt.setInt(5, member.getGender());
		pstmt.setString(6, member.getPhone());
		
		result = pstmt.executeUpdate();
	
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally {
	DBManager.close(pstmt,conn);
}
 return result;
}
//사원정보수정
//리턴타입:INT(0이면 수정된 행이 없음,0이 아니면 수정된 행이 있음)
//파라미터:Employee
public int updateMember(Employees member) {
	//실행결과
	int result = -1;
	//msg/-1:에러가 생겨서 수정하지 못함/0:해당아이디가 존재하지 않아서 수정하지 못함/1이상:결과개수만큼의 행을 수정함
	//연결객체
	Connection conn=null;
	//sql실행객체
	PreparedStatement pstmt=null;
	//실행할 sql문
	String sql="update employees set name=?,gender=?,pass=?,lev=?,"
	+"phone=?where id=?";
	try {
		conn=DBManager.getConnection();
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, member.getName());
	pstmt.setInt(2, member.getGender());
	pstmt.setString(3, member.getPass());
	pstmt.setString(4, member.getLev());
	pstmt.setString(5, member.getPhone());
	pstmt.setString(6, member.getId());
	
	result=pstmt.executeUpdate();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBManager.close(pstmt, conn);
	}
	return result;
}
//사원정보 삭제기능
//리턴타입:int(0이면 삭제된 행 없음,0이 아니면 삭제된 행 있음)
//파라미터:String id
public int deleteMember(String id) {
	//실행결과
	int result=-1;
	//연결객체
	Connection conn=null;
	//sql실행객체
	PreparedStatement pstmt =null;
	//실행할 sql문
	String sql="delete from employees where id=?";
	try {
		conn=DBManager.getConnection();
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, id);
		result=pstmt.executeUpdate();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBManager.close(pstmt, conn);
	}
	return result;
}
	
}

