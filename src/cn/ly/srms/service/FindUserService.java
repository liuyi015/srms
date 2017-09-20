package cn.ly.srms.service;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.ly.srms.common.util.StringUtil;
import cn.ly.srms.dao.FindUserInfoDao;
import cn.ly.srms.dao.UserDao;
import cn.ly.srms.entity.FindUserInfo;




@Service
public class FindUserService {
	/**
	 * Log4J Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FindUserService.class);
	
	@Resource FindUserInfoDao findUserDao;
	@Resource UserDao userDao;

	public List getFindUserList(FindUserInfo findUserInfo) {
		List<FindUserInfo> findUserInfoList;
        StringBuffer sql = new StringBuffer(); // 查询的HQL语句
		this.cookQueryCondiction(findUserInfo,sql);
		String userName=findUserInfo.getUserName();
		if(StringUtil.isNullOrWhiteSpace(userName)){
			findUserInfoList=findUserDao.find(sql.toString());
		}else{
			findUserInfoList=findUserDao.find(sql.toString(),findUserInfo.getUserName());
		}
		/*for(int i=0;i<findUserInfoList.size();i++){
			FindUserInfo fu=findUserInfoList.get(i);
			Integer userId=fu.getPublisher();
			// 将已知的发布人id转化为名字，用于界面显示名字
			if(!StringUtil.isNullOrWhiteSpace(userId)){
				fu.setPublisherName(userDao.findByUserid(userId).getUsername());
				System.out.println(fu.getPublisherName());
			}
			findUserInfoList.set(i, fu);
		}*/
		return findUserInfoList;
	}

	public void cookQueryCondiction(FindUserInfo findUserInfo,
			StringBuffer sql) {
		// TODO Auto-generated method stub
		sql=sql.append(" from FindUserInfo where 1=1");
		String userName=findUserInfo.getUserName();
		if(!StringUtil.isNullOrWhiteSpace(userName)){
			sql.append( " and userName = ?");
		}
		sql.append(" order by publishTime desc");
		
	}

	public FindUserInfo getFindUserByKey(Integer id) {
		return (FindUserInfo) findUserDao.get(id);
	}
}
