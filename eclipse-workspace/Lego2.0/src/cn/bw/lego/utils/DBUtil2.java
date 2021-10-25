package cn.bw.lego.utils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil2 {
	private Connection con = null;
	private Statement statement = null;
	private ResultSet resultSet =null;
	public DBUtil2() {
		con=getConnection();
		if (null!=con) {
			System.out.println("连接成功");
		}
	}
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/lego";
			String user="root";
			String password="";
			
			try {
				con=DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	/**
	 * 执行查询操作
	 * sql 查询语句
	 * 
	 * @param sql
	 * @return 结果集对象
	 * @throws SQLException
	 */
	public ResultSet query(String sql) throws SQLException{
		statement=con.createStatement();
		resultSet=statement.executeQuery(sql);
		return resultSet;
	}
	
	/*
	 * 执行更行操作
	 */
	public boolean update(String sql) throws SQLException{
		int r=0;
		statement=con.createStatement();
		r=statement.executeUpdate(sql);
		if (r>0) {
			return true;
		}
		return false;
		
	}
	
	public boolean close(){
		boolean t=true;
		if (resultSet!=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultSet=null; 
				t=false;
			}
			resultSet=null;
		}
		if (statement!=null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				statement=null; 
				t=false;
			}
			statement=null;
		}
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				con=null;
				t=false;
			}
			con=null;
		}
		return t;
	}
	public static void main(String[] args) {
		DBUtil2 dbUtil=new DBUtil2();
		
	}
}
