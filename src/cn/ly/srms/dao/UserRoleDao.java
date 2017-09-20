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

import cn.ly.srms.entity.User;
import cn.ly.srms.entity.UserRole;

/**
 * TODO用户模块持久层代码:
 * @author     liuyi 1610140
 * @version   CRMS 2017年2月14日
 * @since      CRMS
 */
@Repository
public class UserRoleDao extends _dao {
	
	public UserRole findRoleIdByUserId(Integer userId){
		String sql="from UserRole where userId=?";
		List<UserRole> list=this.find(sql,userId);
		if(list !=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
}

