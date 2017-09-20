package cn.ly.srms.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import cn.ly.srms.action.exception.ApplicationException;
import cn.ly.srms.common.util.StringUtil;
import cn.ly.srms.dao.LimitInfoDao;
import cn.ly.srms.dao.UserRoleDao;
import cn.ly.srms.entity.LimitInfo;
import cn.ly.srms.entity.UserRole;



/**
 * TODO 用户名模块业务层代码
 * @author     liuyi 1610140
 * @version    CCAS 2017年3月10日
 * @since      CCAS
 */
@Service
public class UserRoleService {
	/**
	 * Log4J Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserService.class);
	
	@Resource
	private UserRoleDao userRoleDao;
	
	/**
	 * 获取角色id
	 */
	public String getRoleId(Integer userId) {
		String roleId;
		UserRole userRole=userRoleDao.findRoleIdByUserId(userId);
		if(StringUtil.isNullOrWhiteSpace(userRole)){
			return null;
		}
		return userRole.getRoleId();
	}
}
