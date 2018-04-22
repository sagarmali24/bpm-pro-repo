package com.cch.processrecipes.process;

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
public class ProcessDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Process getById(int id)
	{
		return (Process) sessionFactory.getCurrentSession().get(Process.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Process> searchProcess(String name)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Process.class);
		criteria.add(Restrictions.ilike("process_name", name+"%"));
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Process> getAllProcess()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Process.class);
		Session sess=sessionFactory.getCurrentSession();
		
		return criteria.list();
		
		
	}
	
	public int save(Process proces)
	{
		return (Integer) sessionFactory.getCurrentSession().save(proces);
	}
	
	public void update(Process proces)
	{
		sessionFactory.getCurrentSession().merge(proces);
	}
	
	public void delete(int id)
	{
		Process c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}

}
