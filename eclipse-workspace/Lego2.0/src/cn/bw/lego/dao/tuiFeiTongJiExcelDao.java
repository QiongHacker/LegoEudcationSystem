package cn.bw.lego.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bw.lego.utils.DBUtil2;

public class tuiFeiTongJiExcelDao {
	public static List<HashMap<String, Object>> returnMoney(){
		List<HashMap<String, Object>> list=null;
		ResultSet rSet=null;
		DBUtil2 dbUtil=new DBUtil2();
		String sql="select * from v_tuifei_tongji";
		try {
			list= new ArrayList<HashMap<String, Object>>();
			rSet=dbUtil.query(sql);
			HashMap<String, Object> map=null;
			while(rSet.next()){
				map=new HashMap<String, Object>();
				
				String name=rSet.getString("name");
				String sex=rSet.getString("sex");
				String birth=rSet.getString("birth");
				String tele=rSet.getString("tele");
				String school=rSet.getString("school");
				String state_name=rSet.getString("state_name");
				String refundPrice=rSet.getString("refundprice");
				String refunddate=rSet.getString("refunddate");
				
				map.put("name", name);
				map.put("sex", sex);
				map.put("birth", birth);
				map.put("tele", tele);
				map.put("school", school);
				map.put("state_name", state_name);
				map.put("refundprice", refundPrice);
				map.put("refunddate", refunddate);
				
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbUtil.close();
		}
		return list;
	}
}
