package cn.bw.lego.dao;

import java.util.List;

import cn.bw.lego.domain.followState;
import cn.bw.lego.domain.listening;



/**
 * 
 * @author Li dong cheng
 *
 */
public interface followStateDao {

	public List<followState> getFollowStatesById (int id);
	public boolean update (followState follow);
	//Ìí¼Ó
	public boolean insert (followState follow);
	public followState getFollows (int id);
}
