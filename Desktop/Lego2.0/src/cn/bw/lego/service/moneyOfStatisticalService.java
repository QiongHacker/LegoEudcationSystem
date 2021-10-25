package cn.bw.lego.service;

import java.util.List;

import cn.bw.lego.dao.moneyOfStatisitcalDaoImpl;
import cn.bw.lego.dao.moneyOfStatisticalDao;
import cn.bw.lego.domain.moneyOfStatistical;
import cn.bw.lego.domain.pageBean;


public class moneyOfStatisticalService {
		
	
			private moneyOfStatisticalDao moneDao = new moneyOfStatisitcalDaoImpl();
			
			public pageBean getMoneyForPageBean(String startTime, String endTime, int page,int pageSize) 
			{
				
				//在这里组织分页对象
				pageBean pagebean = new pageBean();
				pagebean.setCurPage(page);
				pagebean.setPageSize(pageSize);
				int totalCount = moneDao.getMoneyCount(startTime, endTime);
				pagebean.setTotalCount(totalCount);
				
				int totalPage = totalCount/pageSize;
				if (totalCount%pageSize>0) {
					totalPage++;
				}
				pagebean.setTotalPage(totalPage);
		List<moneyOfStatistical> list= moneDao.getmoneyOfStatistical(startTime,endTime, page, pageSize);
			pagebean.setData(list);	
				return pagebean;
			}
}
