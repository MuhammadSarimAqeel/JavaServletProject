package com.dao;





import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;


import com.entities.student;

public class studentDao {
	
private HibernateTemplate 	hibernatetemplate;
	@Transactional
	public int insert(student student) {
		
	Integer i = (Integer)	this.hibernatetemplate.save(student);
		
		return i ;
	}
    public student getstudentbyid(int id) {
    	
    student student =	this.hibernatetemplate.get(student.class, id);
    	
    return student;
    }
    
    public List<student> getstudents() {
    	
    List<student> list	=this.hibernatetemplate.loadAll(student.class);
    	
    return list;
    }
    @Transactional
    public void delete(int id) {
 student student =   	this.hibernatetemplate.get(student.class, id);
 this.hibernatetemplate.delete(student);
    	
    }
    @Transactional
    public void update(student student) {
    	this.hibernatetemplate.update(student);
    	
    }
	public HibernateTemplate getHibernatetemplate() {
		return hibernatetemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
		this.hibernatetemplate = hibernatetemplate;
	}

}
