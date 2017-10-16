package cn.broccoligo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBcon {
	//创建连接
	public Connection getCon()
	{
		String url="jdbc:mysql://localhost:3306/BookDB?useSSL=false&useUnicode=true&characterEncoding=gbk";
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection(url,"root","123456");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	//查找
	public List<String> getSelect(String sql,String col) throws SQLException{
		
		Connection conn=getCon();
		List<String> list=new ArrayList<String>();
		Statement st=null;
		try {
			st=(Statement) conn.createStatement();
			ResultSet res=st.executeQuery(sql);
			while(res.next())
			{
				
				list.add(res.getString(col));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		st.close();
		return list;
	}
	//关闭连接
	public void closeCon(Connection con)throws Exception
	{
		if(con!=null)
		{
			con.close();
		}
		else
		{
			System.out.println("con is null!");
		}
	}
	//更新
	
	//删除
	
}
