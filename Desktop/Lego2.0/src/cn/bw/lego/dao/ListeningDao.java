package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.listening;

public interface ListeningDao {
			//���
			public boolean insert (listening listen);
			//�޸�
			public boolean update (listening listen);
			//��������ѯ
			public List<listening> getListenings (String name,String classType,String teacher,int page,int pageSize);
			//���ݱ�Ų�ѯ
			public listening getListeningsById (int id);
			public int getListeningCount(String name, String classType,
					String teacher);
			public boolean checkUser(String tele,String name);
}
