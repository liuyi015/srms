/*
 * 文件名：UserDao.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： UserDao.java
 * 修改人：liuyi 1610140
 * 修改时间：2017年2月14日
 * 修改内容：新增
 */
package cn.ly.srms.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ly.srms.entity.User;

/**
 * TODO用户模块持久层代码:
 * @author     liuyi 1610140
 * @version   CRMS 2017年2月14日
 * @since      CRMS
 */
@Repository 
public class UserDao extends _dao {
	// 按名次查询是否有该用户:
	public User findByUsername(String username){
		String hql="from User u where u.username = ?";
		List<User> list=this.find(hql,username);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	// 注册用户存入数据库代码实现
	public void doSave(User user){
		this.save(user);
	}

	public User findByUser(User user) {
		String sql="from User where username=? and password=?";
		//List<User> list=this.getHibernateTemplate().find(sql, user.getUsername(),user.getPassword());
		List<User> list=this.find(sql, user.getUsername(),user.getPassword());
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}


	public User findByUserid(Integer userid) {
		String sql="from User where userId=?";
		List<User> list=this.find(sql,userid);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public void doUpdate(User user) {
		this.update(user);		
	}
}

