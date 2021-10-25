package cn.bw.lego.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * ���ݿ⹤����
 */
public class DBUtil {
	
	private static Properties dbconfig=new Properties();
    //��ȡ���ݿ�����
    public static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            InputStream in=DBUtil.class.getClassLoader().getResourceAsStream("db.properties"); 
			 try {
				dbconfig.load(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
            conn=DriverManager.getConnection(dbconfig.getProperty("url"), dbconfig.getProperty("username"), dbconfig.getProperty("password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //�ر�������Դ 
    public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
        try {
            if(rs!=null)
                rs.close();
            if(stmt!=null)
                stmt.close();
            if(conn!=null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


