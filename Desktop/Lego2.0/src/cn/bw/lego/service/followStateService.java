package cn.bw.lego.service;

import java.util.List;

import cn.bw.lego.dao.followStateDao;
import cn.bw.lego.dao.followStateDaoImpl;
import cn.bw.lego.domain.followState;

public class followStateService {
				
				private followStateDao state = new followStateDaoImpl();
	
				public List<followState> getfollowStatesById (int id){
					return state.getFollowStatesById(id);
		
				}
				public boolean addFollowState(followState t){
					return state.insert(t);
	
					
				}
				public boolean updateFollowState(followState t){
					return state.update(t);
					
				}
				public followState getFollows(int id){
					return state.getFollows(id);
				}
				
}
