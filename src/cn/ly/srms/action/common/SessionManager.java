package cn.ly.srms.action.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.ly.srms.action.exception.ApplicationException;
import cn.ly.srms.entity.LimitInfo;
import cn.ly.srms.entity.User;
import cn.ly.srms.service.LimitService;
import cn.ly.srms.service.UserService;

@Controller @Scope("prototype")
public class SessionManager extends ActionSupport  implements ModelDriven{

	/**
	 * Log4J Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SessionManager.class);

	public static final String SESSION_USER = "user";

	private static final String SESSION_PRIV_LIST = "limitlist";

	public static final String SESSION_PRIV_MAP = "limitmap";

	public static final String SESSION_BAK_FIELD_MAP = "bakFieldMap";

	private static final String SESSION_ROLE_LIST = "rolelist";

	public static final String SESSION_LAST_QUERY_PAGE = "lastList"; // 最近一次查询List界面

	public static final String SESSION_LAST_MEMBER_QUERY_PARAMS = "lastMemberQueryParams"; // 最近一次会员查询参数

	public static final String SESSION_LAST_QUERY_PAGE_CHILD = "lastListOfChild"; // 最近一次子操作界面查询List界面

	public static final String SESSION_ALERT_INFO = "alertInfo"; // 需要弹出的操作提示

	public static final String SESSION_CURR_REPORT_LIST = "currReportList"; // 当前查询报表明细的缓存

	public static final String SESSION_CURR_REPORT_TOTAL = "currReportTotal"; // 当前查询报表汇总类信息的缓存

	public static final String BIZ_SPLIT = "|"; // 用户Session中保存的权限列表中使用，业务的分隔符，用法参见initSystemPriv方法

	public static final String NOT_BIZ_LIMIT = "NOT_BIZ"; // 用户Session中保存的权限列表中使用，非业务性权限的表示字符串，用法参见initSystemPriv方法

	public static final String ALL_BIZ = "ALL BIZ"; // 所有业务，用于admin用户

	public static final String BIZ_OTHER_SHARES = "OTHER_SHARES"; // 指除本组织机构以外通过共享获取的其它业务

	public static final String LASTLIST_PRINT_PARAM = "lastlistPrintParm"; // 最后一次查询结果的打印参数

	public static final String MAIN_TREE_CURRENT_NODE = "mainTreeCurrentNode"; // 主菜单树当前打开的内容节点

	public static final String MAIN_TREE_PARENT_NODES = "mainTreeParentNodes"; // 主菜单树当前展开的父节点

	public static final String LAST_ACCESS_URL = "lastAccessUrl"; // 上一次访问的页面地址

	public static final String CURR_ACCESS_URL = "CurrAccessUrl"; // 当前访问的页面地址


	public static Map sessionMap = new HashMap(); // 会话Map，用于保存当前所有登录用户的Session，key是“用户id|用户group_id”，value是session

	public static Map<String, String> errLoginTimeMap = new HashMap<String, String>();// 用於保存當天錯誤登陸次數
	public static int ERR_LOGIN_TIME = 3;
	
	@Resource
	public UserService userService;
	@Resource
	public LimitService limitService;
	
	 // 写入对象到session中
	public boolean setSession(HttpServletRequest request, Object so, String name) {
		boolean flag = true;
		try {
			HttpSession session = request.getSession();
			session.setAttribute(name, so);
		} catch (IllegalStateException ie) {
			flag = false;
		}
		return flag;
	}

	//初始化用户的权限配置到Session中 输入参数：用户标识
	public boolean initSystemPriv(HttpServletRequest request, Integer userId) throws ApplicationException {

		// 取有效备用字段信息到Session
		boolean flag = false;

		// 获取权限列表，此权限列表未考虑业务属性，只用于显示操作菜单。考虑业务属性的权限集在后面获取。
		List privList = limitService.getRealLimitByUserKey(userId);
		flag = setSession(request, privList, SESSION_PRIV_LIST);

		// 如果无权限，返回
		if (null == privList || 0 == privList.size()) {
			return true;
		}

		HashMap userBizOperPrivMap = new HashMap();
		for (Iterator bIter = privList.iterator(); bIter.hasNext();) {
			LimitInfo limit = (LimitInfo) bIter.next();
			userBizOperPrivMap.put(limit.getLimitId(), ALL_BIZ);
		}
		// mod by aps-gub 20070828 end
		flag = setSession(request, userBizOperPrivMap, SESSION_PRIV_MAP);

		return flag;
	}

	/*
	ServletActionContext.getRequest().getSession();

	*//**
	 * 写入用户对象到session中
	*//*	 
	public boolean setUserSession(User user) {
		Integer userId = user.getUserId();
		Integer userKey = userId;
		// if (!user.getUserType().equals(UserManager.IS_ADMIN)) // 不是默认管理员
		// {
		if (null != sessionMap.get(userKey) && tryKickUser(userKey)) {
			logger.warn("Warning: The session map has some sessions having not been cancelled. These sessions will be forced to cancel. The corresponding user is " + userKey + ". ");
		}
		sessionMap.put(userKey, request.getSession()); // 保存新session到map中
		// }
		return setSession(request, user, SESSION_USER);
	}


	
	 
	  * 判断session是否有效
	  
	 
	public boolean isSessionAvail() {
		boolean flag = true;
		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute(SESSION_USER);
			if (user == null) {
				flag = false;
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}*/
	
	
	/**
	 * 强行销毁某用户session，即强制离线
	 * 
	 * @param "userId|groupId"
	 */
	public boolean tryKickUser(Integer userKey) {
		// 修改状态为离线
		try {
			userService.forceOffline(userKey);
		} catch (Exception e) {
			logger.error("An exception occurred in forcing user to get offline! " + e);
		}

		// 清除map中记录
		try {
			HttpSession sessionInMap = (HttpSession) sessionMap.get(userKey);
			if (null != sessionInMap) {
				sessionMap.remove(userKey);
				logger.debug("The session map of the user [" + userKey + "] has been cancelled successfully. ");
				sessionInMap.invalidate();
				return true;
			}
		} catch (Exception e) {
			logger.error("An exception occurred in cancelling the session map [" + e + "]. The reason is that " + e.getCause());
		}
		return false;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 从session中读取当前用户key
	 
	public String getCurrentUserKey(HttpServletRequest request) {
		BankUserInfo user = (BankUserInfo) getSession(request, SESSION_USER);
		if (null == user)
			return null;
		return user.getUserLoginId();
	}

	
	 * 从session中读取当前用户ID
	 
	public String getCurrentUserID(HttpServletRequest request) {
		BankUserInfo user = (BankUserInfo) getSession(request, SESSION_USER);
		if (null == user)
			return null;
		return user.getUserId();
	}

	
	 * 从session中读取当前UserType
	 
	public String getCurrentUserType(HttpServletRequest request) {
		BankUserInfo user = (BankUserInfo) getSession(request, SESSION_USER);
		if (null == user)
			return null;
		return user.getUserType();
	}

	
	 * 从session中读取当前用户名称
	 
	public String getCurrentUserName(HttpServletRequest request) {
		BankUserInfo user = (BankUserInfo) getSession(request, SESSION_USER);
		if (null == user)
			return null;
		return user.getUserName();
	}

	
	 * 从session中读取当前用户groupId
	 
	public String getCurrentUserGroupId(HttpServletRequest request) {
		BankUserInfo user = (BankUserInfo) getSession(request, SESSION_USER);
		if (null == user)
			return null;
		return user.getGroupId();
	}

	
	 * 从session中读取当前用户groupName
	 
	public String getCurrentUserGroupName(HttpServletRequest request) throws ApplicationException {
		BankUserInfo user = (BankUserInfo) getSession(request, SESSION_USER);
		
		
		if (null == user){
			return null;
		}else {
			GroupInfo group=GroupInfoManager.getInstance().getGroupInfoByPk(user.getGroupId());
			if (null == group)
				return null;
			return group.getGroupName();
		}
	}
	
	
	 * 从session中读取当前用户名称
	 
	public String getCurrentUserLoginId(HttpServletRequest request) {
		BankUserInfo user = (BankUserInfo) getSession(request, SESSION_USER);
		if (null == user)
			return null;
		return user.getUserLoginId();
	}

	
	 * 从session中读取当前用户bankcode
	 
	public String getCurrentUserGroupAbbr(HttpServletRequest request) {
		BankUserInfo user = (BankUserInfo) getSession(request, SESSION_USER);
		if (null == user)
			return null;
		GroupInfo groupInfo = new GroupInfo();
		groupInfo = GroupInfoDAO.getInstance().get(user.getGroupId());
		return groupInfo.getGroupAbbr();
	}

	
	 * 从session中读取用户对象
	 
	public BankUserInfo getUserSession(HttpServletRequest request) {
		BankUserInfo user = (BankUserInfo) getSession(request, SESSION_USER);
		return user;
	}

	
	 * 从session中读取当前用户的组织机构ID
	 
	public String getCurrentGroupId(HttpServletRequest request) {
		BankUserInfo user = (BankUserInfo) getSession(request, SESSION_USER);
		if (user != null)
		{
		    return user.getGroupId();    
		}
		return null;
	}

	
	 * 使session无效
	 
	public void invalidate(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
	}

	
	
	
	 * 获取当前用户的某项权限具有哪些业务
	 
	public String getBusinessPriv(HttpServletRequest request, String limitId) {
		Map userBizOperPrivMap = (Map) getSession(request, SESSION_PRIV_MAP);
		if (null == userBizOperPrivMap) {
			logger.error("An exception occurred! The transaction limit tree has not been initialized yet. ");
			return "";
		}
		String priv = (String) userBizOperPrivMap.get(limitId);
		if (null == priv)
			return "";
		return priv;
	}

	
	 * 判断系统权限是否存在 输入参数：系统权限标识
	 
	public boolean existSystemPriv(HttpServletRequest request, String privId) {
		List privList = (List) getSession(request, SESSION_PRIV_LIST);
		for (Iterator bIter = privList.iterator(); bIter.hasNext();) {
			BankLimitInfo limit = (BankLimitInfo) bIter.next();
			if (privId.equals(limit.getLimitId())) {
				if (SystemConfigServlet.getInstance().isLoginOnBank() && limit.getLimitType().equals("2")) {
					return false;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	
	 * 获取当前用户的权限列表 输入参数：
	 
	public List getMyPrivList(HttpServletRequest request) {
		List privList = (List) getSession(request, SESSION_PRIV_LIST);
		return privList;
	}

	
	 * 获取当前用户的业务权限map 输入参数：
	 
	public Map getMyBizPrivMap(HttpServletRequest request) {
		Map privMap = (Map) getSession(request, SESSION_PRIV_MAP);
		return privMap;
	}

	
	 * 获取当前用户的角色列表 输入参数：
	 
	public List getMyRoleList(HttpServletRequest request) {
		List roleList = (List) getSession(request, SESSION_ROLE_LIST);
		return roleList;
	}

	
	 * 获取最近的会员查询参数
	 
	public Map getLastMemberQueryParams(HttpServletRequest request) {
		Map lastList = (Map) getSession(request, SESSION_LAST_MEMBER_QUERY_PARAMS);
		return lastList;
	}

	
	 * 设置最近的会员查询参数
	 
	public void setLastMemberQueryParams(HttpServletRequest request, Map params) {
		SessionManager.getInstance().setSession(request, params, SESSION_LAST_MEMBER_QUERY_PARAMS);
	}

	
	 * 获取最近的查询界面url
	 
	public String getLastQueryPage(HttpServletRequest request) {
		String lastList = (String) getSession(request, SESSION_LAST_QUERY_PAGE);
		if (lastList == null) {
			lastList = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
		}
		return lastList;
	}

	
	 * 设置最近的查询界面url
	 
	public void setLastQueryPage(HttpServletRequest request, String lastList) {
		SessionManager.getInstance().setSession(request, lastList, SESSION_LAST_QUERY_PAGE);
	}

	
	 * 获取子操作窗口上最近的查询界面url
	 
	public String getLastQueryPageOfChild(HttpServletRequest request) {
		String lastList = (String) getSession(request, SESSION_LAST_QUERY_PAGE_CHILD);
		return lastList;
	}

	
	 * 设置子操作窗口上最近的查询界面url
	 
	public void setLastQueryPageOfChild(HttpServletRequest request, String lastList) {
		SessionManager.getInstance().setSession(request, lastList, SESSION_LAST_QUERY_PAGE_CHILD);
	}

	
	 * 获取最近的报表查询明细结果缓存
	 
	public List getCurrReportList(HttpServletRequest request) {
		List lastList = (List) getSession(request, SESSION_CURR_REPORT_LIST);
		return lastList;
	}

	
	 * 设置最近的报表查询明细结果缓存
	 
	public void setCurrReportList(HttpServletRequest request, List lastList) {
		SessionManager.getInstance().setSession(request, lastList, SESSION_CURR_REPORT_LIST);
	}

	
	 * 获取最近的报表查询汇总结果缓存
	 
	public Map getCurrReportTotal(HttpServletRequest request) {
		Map map = (Map) getSession(request, SESSION_CURR_REPORT_TOTAL);
		return map;
	}

	
	 * 设置最近的报表查询汇总结果缓存
	 
	public void setCurrReportTotal(HttpServletRequest request, Map map) {
		SessionManager.getInstance().setSession(request, map, SESSION_CURR_REPORT_TOTAL);
	}

	
	 * 获取最新的需要提示用户的信息
	 
	public String getAlertInfo(HttpServletRequest request) {
		String lastList = (String) getSession(request, SESSION_ALERT_INFO);
		return lastList;
	}

	
	 * 设置最新的需要提示用户的信息
	 
	public void setAlertInfo(HttpServletRequest request, String alertInfo) {
		SessionManager.getInstance().setSession(request, alertInfo, SESSION_ALERT_INFO);
	}

	
	 * 获取最后一次查询结果的打印参数
	 
	public Map getLastListPrintPara(HttpServletRequest request) {
		Map printParaMap = (Map) getSession(request, SessionManager.LASTLIST_PRINT_PARAM);
		return printParaMap;
	}

	
	 * 设置最后一次查询结果的打印参数
	 
	public void setLastListPrintPara(HttpServletRequest request, Map printParaMap) {
		SessionManager.getInstance().setSession(request, printParaMap, SessionManager.LASTLIST_PRINT_PARAM);
	}

	
	 * 获取最后一次主菜单的点击状态
	 
	public Map getLastMainTreeState(HttpServletRequest request) {
		Map treeStateMap = new HashMap();
		String currentNodeId = null;
		String selectParentNodesId = null;
		if (null != SessionManager.getInstance().getSession(request, SessionManager.MAIN_TREE_CURRENT_NODE)) {
			if (null != SessionManager.getInstance().getSession(request, SessionManager.MAIN_TREE_CURRENT_NODE)) {
				currentNodeId = (String) SessionManager.getInstance().getSession(request, SessionManager.MAIN_TREE_CURRENT_NODE);
				treeStateMap.put("currentNodeId", currentNodeId);
			}
		}

		if (null != SessionManager.getInstance().getSession(request, SessionManager.MAIN_TREE_PARENT_NODES)) {
			if (null != SessionManager.getInstance().getSession(request, SessionManager.MAIN_TREE_PARENT_NODES)) {
				selectParentNodesId = (String) SessionManager.getInstance().getSession(request, SessionManager.MAIN_TREE_PARENT_NODES);
				treeStateMap.put("selectParentNodesId", selectParentNodesId);
			}
		}

		return treeStateMap;
	}

	
	 * 设置最后一次主菜单的点击状态
	 
	public void setLastMainTreeState(HttpServletRequest request) {
		String currentNodeId = request.getParameter("currentNodeId");
		String selectParentNodesId = request.getParameter("selectParentNodesId");
		// 当前节点
		if (null != currentNodeId) {
			SessionManager.getInstance().setSession(request, currentNodeId, SessionManager.MAIN_TREE_CURRENT_NODE);
		}
		// 当前展开的父节点
		if (null != selectParentNodesId) {
			SessionManager.getInstance().setSession(request, selectParentNodesId, SessionManager.MAIN_TREE_PARENT_NODES);
		}
	}

	
	 * 获取最后一次访问的页面地址
	 
	public String getLastAccessUrl(HttpServletRequest request) {
		// 最近一次访问的页面地址
		String lastAccessUrl = "";
		lastAccessUrl = (String) SessionManager.getInstance().getSession(request, SessionManager.LAST_ACCESS_URL);
		return lastAccessUrl;

	}

	
	 * 设置最后一次访问的页面地址
	 
	public void setLastAccessUrl(HttpServletRequest request) {
		// 当前访问的页面地址
		String lastAccessUrl = WebUtils.generateURL(request);
		SessionManager.getInstance().setSession(request, lastAccessUrl, SessionManager.LAST_ACCESS_URL);

	}

	
	 * 写入对象到session中
	 
	public boolean setSession(HttpServletRequest request, Object so, String name) {
		boolean flag = true;
		try {
			HttpSession session = request.getSession();
			session.setAttribute(name, so);
		} catch (IllegalStateException ie) {
			flag = false;
		}
		return flag;
	}

	
	 * 从session中读取对象
	 
	public Object getSession(HttpServletRequest request, String name) {
		Object so = null;
		try {
			HttpSession session = request.getSession();
			so = session.getAttribute(name);
		} catch (IllegalStateException ie) {
			logger.error("An exception occurred in reading object [" + name + "]. " + ie);
		}
		return so;
	}

	
	 * 删除存储的提示用户的信息
	 
	public void removeAlertInfo(HttpServletRequest request) {
		SessionManager.getInstance().removeSession(request, SESSION_ALERT_INFO);
	}

	
	 * 删除session中对象
	 
	private boolean removeSession(HttpServletRequest request, String name) {
		boolean flag = true;
		try {
			HttpSession session = request.getSession();
			session.removeAttribute(name);
		} catch (IllegalStateException ie) {
			flag = false;
		}
		return flag;
	}

	public synchronized boolean checkErrTime(String userId) {
		String errLoginTime = errLoginTimeMap.get(userId);
		if (errLoginTime == null || !errLoginTime.split("_")[0].equals(DateUtil.dateToStr(new Date()))) {
			errLoginTimeMap.put(userId, DateUtil.dateToStr(new Date()) + "_1");
		} else {
			int currTime = Integer.valueOf(errLoginTime.split("_")[1]);
			if (currTime >= ERR_LOGIN_TIME) {

				return true;
			}
			currTime++;
			errLoginTimeMap.put(userId, DateUtil.dateToStr(new Date()) + "_" + currTime);

		}
		return false;
	}

	public synchronized void unlockTime(String userLoginId) {
		if (errLoginTimeMap.get(userLoginId) != null) {
			errLoginTimeMap.remove(userLoginId);
		}

	}

	public String getInfo(HttpServletRequest request, String msg) {
		Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);
		ResourceBundle bundle = ResourceBundle.getBundle("ApplicationResources", locale);
		return bundle.getString(msg);

	}

	
	 * 从session中读取授權驗證信息
	 
	public List getVerifyMessage(HttpServletRequest request, String limitId) {
		List obj = (ArrayList<String>) getSession(request, "Verify" + limitId);
		return obj;
	}

	
	 * 从session中刪除授權驗證信息
	 
	public void removeVerifyMessage(HttpServletRequest request, String limitId) {
		removeSession(request, "Verify" + limitId);
	}

	public BankUserLogin editClearingAccountInfo(HttpServletRequest request) {
		String userId = getCurrentUserID(request);
		BankUserLogin result = null;

		try {
			BankUserLoginId id = new BankUserLoginId(SystemStatusControlManager.getInstance().getCurrentWorkDate(), userId);
			result = BankUserLoginManager.getInstance().getBankUserLoginByPk(id);

		} catch (Exception e) {
			logger.error("Failed to edit the clearing account. " + e.getMessage());
		}

		return result;

	}
	
    public BankUserInfo getCurrentUser(HttpServletRequest request) {
        BankUserInfo user = (BankUserInfo) getSession(request, SESSION_USER);
        if (user == null)
        {
            user = new BankUserInfo();
            user.setUserId("u01");
            user.setUserName("lxx");
            user.setGroupId("g01");
            user.setUserId("u02");
            user.setUserName("test");
            user.setGroupId("g02");
        }
        return user;
    }*/
}
