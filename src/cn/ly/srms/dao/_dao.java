package cn.ly.srms.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.ly.srms.entity.User;

public class _dao extends HibernateDaoSupport{
	@Resource
	public void setSessionFactoryOverride(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	public Object get(Class entityClass, Serializable key){
		return this.getHibernateTemplate().get(entityClass, key);
	}
	public List find(String sql) {
		return this.getHibernateTemplate().find(sql);
	}
	
	public List find(String sql,Integer i) {
		return this.getHibernateTemplate().find(sql,i);
	}
	
	public List find(String sql,String s) {
		return this.getHibernateTemplate().find(sql,s);
	}

	public List find(String sql, String s1, String s2) {
		return this.getHibernateTemplate().find(sql,s1,s2);
	}
	/*protected List<User> find(String sql,Object value) {
		return this.getHibernateTemplate().find(sql,);
	}*/
	public void save(Object o) {
	   this.getHibernateTemplate().save(o);
	}
	
	public void update(Object o) {
		   this.getHibernateTemplate().update(o);
		}

}
