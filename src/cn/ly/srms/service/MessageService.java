package cn.ly.srms.service;


import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.ly.srms.common.util.StringUtil;
import cn.ly.srms.dao.FindUserInfoDao;
import cn.ly.srms.dao.MessageInfoDao;
import cn.ly.srms.dao.UserDao;
import cn.ly.srms.entity.FindUserInfo;
import cn.ly.srms.entity.MessageInfo;


@Service
public class MessageService {
	/**
	 * Log4J Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MessageService.class);
	
	@Resource MessageInfoDao messageInfoDao;
	@Resource UserDao userDao;

	public List getMailList(Integer userId) {
		List list;
        String sql = "from MessageInfo where receiveId=? order by sendTime desc"; // 查询的HQL语句
        list= messageInfoDao.find(sql,userId);
        if(list!=null){
			for(int i=0;i<list.size();i++){
				MessageInfo mi=(MessageInfo) list.get(i);
				Integer sendId=mi.getSendId();
				// 将已知的发送人id转化为名字，用于界面显示名字
				mi.setSendName(userDao.findByUserid(userId).getUsername());
				list.set(i, mi);
			}
        }
		return list;
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

}
