package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.moneyOfStatistical;

public interface moneyOfStatisticalDao {
				
	
	//��ѯ�շ���Ϣ
	public List<moneyOfStatistical> getmoneyOfStatistical (String startTime,String endTime,int page,int pageSize);			
	
	public int getMoneyCount(String startTime,String endTime);
	
}
