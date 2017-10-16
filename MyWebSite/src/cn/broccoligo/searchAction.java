package cn.broccoligo;

import java.sql.*;
import java.util.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import cn.broccoligo.www.DBcon;

public class searchAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String authorName;
   
    public ResultSet rs;
    public void setName(String name)
    {
    	this.authorName=name;
    	System.out.println("sixsixsix");
    }
    public String getName()
    {
    	return this.authorName;
    }
    public String execute()
    {
    	try
    	{
    		Class.forName("com.mysql.jdbc.Driver");
    		//this.res=new String("loading driver successfully!");
    		System.out.print("success!");
    	}catch(ClassNotFoundException e1)
    	{
    		System.out.println("can't find driver");
    		e1.printStackTrace();
    	}
    	
    	String url="jdbc:mysql://localhost:3306/BookDB?useSSL=false&useUnicode=true&characterEncoding=gbk";
    	Connection conn;
    	try {
    		conn=DriverManager.getConnection(url,"root","123456");
    		Statement st=conn.createStatement();
    		System.out.println(this.authorName);
    		String sql="select authorId from author where name="+"'"+this.authorName+"'";
    		rs=st.executeQuery(sql);
    		if(rs==null)return "error";
    		//ActionContext.getContext().getSession().put("allBook", rs);
    		ActionContext actionContext=ActionContext.getContext();
    		Map<String, Object> session=actionContext.getSession();
    		session.put("allBook", rs);
    		System.out.println("成功连接数据库！");
    		st.close();
    		conn.close();
    		return "success";
    	}catch(SQLException e) {
    		e.printStackTrace();
    		return "error";
    	}
    }
}
