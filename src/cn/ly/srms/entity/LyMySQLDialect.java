/*
 * 文件名：LyMySQLDialect.java
 * 版权：Copyright 2012-2016 YLINK Tech. Co. Ltd. All Rights Reserved. 
 * 描述： LyMySQLDialect.java
 * 修改人：liuyi 1610140
 * 修改时间：2017年9月13日
 * 修改内容：新增
 */
package cn.ly.srms.entity;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.StandardSQLFunction;

/**
 * TODO重写MySQL数据库方言MySQLDialect
 * @author     liuyi 1610140
 * @version    CCAS 2017年9月13日
 * @since      CCAS
 */
public class LyMySQLDialect extends MySQLDialect {
	
	public LyMySQLDialect() {
		super();
	    registerFunction("group_concat", new StandardSQLFunction("group_concat",Hibernate.STRING));
	 }

}

