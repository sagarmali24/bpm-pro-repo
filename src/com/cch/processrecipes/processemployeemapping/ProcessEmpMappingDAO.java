package com.cch.processrecipes.processemployeemapping;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sagar Mali,Dada Gaikvad
 *
 */

@Repository
@Transactional
public class ProcessEmpMappingDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProcessEmpMapping getById(int id)
	{
		return (ProcessEmpMapping) sessionFactory.getCurrentSession().get(ProcessEmpMapping.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcessEmpMapping> searchProcessEmpMapping(int empID)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProcessEmpMapping.class);
		criteria.add(Restrictions.ilike("emp_id", empID+"%"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcessEmpMapping> getAllProcessEmpMapping()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProcessEmpMapping.class);
		Session sess=sessionFactory.getCurrentSession();
		
		return criteria.list();
		
		
	}
	
	public int save(ProcessEmpMapping proces)
	{
		return (Integer) sessionFactory.getCurrentSession().save(proces);
	}
	
	public void update(ProcessEmpMapping proces)
	{
		sessionFactory.getCurrentSession().merge(proces);
	}
	
	public void delete(int id)
	{
		ProcessEmpMapping c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}

}
