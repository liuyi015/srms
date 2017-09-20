package cn.ly.srms.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import cn.ly.srms.action.exception.ApplicationException;
import cn.ly.srms.dao.LimitInfoDao;
import cn.ly.srms.entity.LimitInfo;



/**
 * TODO 用户名模块业务层代码
 * @author     liuyi 1610140
 * @version    CCAS 2017年3月10日
 * @since      CCAS
 */
@Service
public class LimitService {
	/**
	 * Log4J Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserService.class);
	
	@Resource
	private LimitInfoDao limitInfoDao;
	private LimitInfo limitInfo;
	
	public void setLimitInfo(LimitInfo limitInfo) {
		this.limitInfo = limitInfo;
	}

	
	/*
	 * 获取用户拥有的系统权限列表id组(初始化Session时使用） 输入参数：用户标识
	 */
	public List getLimitIdByUserKey(Integer userId) throws ApplicationException {
		List<String[]> limitList;
		StringBuffer sql=new StringBuffer();
		sql.append("select group_concat(lt.limitId) from LimitInfo lt where lt.limitId in (select distinct li.limitId from LimitInfo li,RoleLimit rl,UserRole ur")
			.append(" where li.limitId=rl.limitId and rl.roleId=ur.roleId").append(" and ur.userId=").append(userId);
		sql.append(") group by lt.limitParent");
		
		limitList=limitInfoDao.find(sql.toString());
		return limitList;
	}
	
	/*
	 * 获取用户拥有的系统权限列表(初始化Session时使用） 输入参数：用户标识
	 */
	public List<LimitInfo> getRealLimitByUserKey(Integer userId) throws ApplicationException {
		List<LimitInfo> limitList;
		StringBuffer sql=new StringBuffer();
		sql.append("select lt from LimitInfo lt where lt.limitId in (select distinct li.limitId from LimitInfo li,RoleLimit rl,UserRole ur")
			.append(" where li.limitId=rl.limitId and rl.roleId=ur.roleId").append(" and ur.userId=").append(userId);
		sql.append(") group by lt.limitId");
		
		limitList=limitInfoDao.find(sql.toString());
		return limitList;
	}
	public LimitInfo getLimitInfoByLimitId(String limitId){
		
		return limitInfoDao.getByLimitId(limitId);
	}
}
