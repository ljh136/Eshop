package com.shop.service;

import java.util.List;

import org.hibernate.Query;

import com.shop.dao.BaseDao;
import com.shop.dto.Pager;


public class BaseService<T> {

	private BaseDao<T> baseDao;

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	
	public void save(Object entity) {
		baseDao.save(entity);
	}
	
	
	public void saveOrUpdate(Object entity) {
		baseDao.saveOrUpdate(entity);
	}
	
	
	public void delete(Object entity) {
		baseDao.delete(entity);
	}

	public void update(Object entity) {
		baseDao.update(entity);
	}
	
	
	@SuppressWarnings("rawtypes")
	public Object findById(Class c, int id) {
		return baseDao.findById(c, id);
	}
	
	
	public Pager<T> find(String hql) {
		return baseDao.find(hql);
	}
	
	
	public Pager<T> find(String hql, int pageSize) {
		return baseDao.find(hql, pageSize);
	}
	
	public List<?> findList(String sql) {
		Query q = baseDao.getSession().createQuery(sql);
		return q.list();
	}
	
	
	public Object findFirst(String sql) {
		List<?> list = findList(sql);
		if (list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	
	public Object findLast(String sql) {
		List<?> list = findList(sql);
		if (list != null && list.size() > 0){
			return list.get(list.size() - 1);
		}
		return null;
	}
	
	
	public Object random(String sql) {
		return baseDao.random(sql);
	}
	
	
	public long findCount(String sql) {
		return baseDao.findCount(sql);
	}
}
