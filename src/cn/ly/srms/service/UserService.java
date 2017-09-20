/*
 * 文件名：UserService.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserService.java
 * 修改人：liuyi 1610140
 * 修改时间：2017年2月14日
 * 修改内容：新增
 */
package cn.ly.srms.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


import cn.ly.srms.action.exception.ApplicationException;
import cn.ly.srms.dao.UserDao;
import cn.ly.srms.entity.User;

/**
 * TODO 用户名模块业务层代码
 * @author     liuyi 1610140
 * @version    CCAS 2017年2月14日
 * @since      CCAS
 */
@Service
public class UserService {
	/**
	 * Log4J Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserService.class);
	
	//注入UserDao
	@Resource
	private UserDao userDao;
	
	// 按用户名查询用户的方法:
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
	
	// 业务层完成用户注册代码:
	public void save(User user){
		userDao.doSave(user);
	}

	//通过用户查询
	public User findByUser(User user) {
		return userDao.findByUser(user);
	}

	 //按用户名id查询用户的方法:
	public User findByUserid(Integer userid) {
		return userDao.findByUserid(userid);
		
	}

	//修改个人资料
	public void update(User user) {
		userDao.doUpdate(user);
	}
	

	/*
	 * 强制离线用户 输入参数：用户标识
	 */
	public void forceOffline(Integer userId) throws ApplicationException {
		if (null == userId) {
			logger.error("The user to be forced to log out is null. ");
			throw new ApplicationException("The bank user to be forced to log out is null. ");
		}
		User user= userDao.findByUserid(userId);

		// 只有当用户是在线状态时才允许强制离线
		if (null != user && "1".equals(user.getOnlineState())) {
			updateOnlineState(userId, "0");
		}
	}
	
	/*
	 * 修改用户在线状态状态 输入参数：用户标识、用户状态
	 */
	public User updateOnlineState(Integer userId, String onlineState) throws ApplicationException {
		User user = userDao.findByUserid(userId);
		user.setOnlineState(onlineState);
		try {
			userDao.doUpdate(user);
		} catch (Exception e) {
			logger.error("An unknown exception occurred in updating the OnlineState of user. " + e);
			throw new ApplicationException(e.getCause().getMessage());
		}
		return user;
	}
	
}

