package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.listening;

public interface ListeningDao {
			//添加
			public boolean insert (listening listen);
			//修改
			public boolean update (listening listen);
			//按条件查询
			public List<listening> getListenings (String name,String classType,String teacher,int page,int pageSize);
			//根据编号查询
			public listening getListeningsById (int id);
			public int getListeningCount(String name, String classType,
					String teacher);
			public boolean checkUser(String tele,String name);
}
