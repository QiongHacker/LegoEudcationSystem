package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.moneyOfStatistical;

public interface moneyOfStatisticalDao {
				
	
	//查询收费信息
	public List<moneyOfStatistical> getmoneyOfStatistical (String startTime,String endTime,int page,int pageSize);			
	
	public int getMoneyCount(String startTime,String endTime);
	
}
