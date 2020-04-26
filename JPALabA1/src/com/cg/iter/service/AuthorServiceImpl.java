package com.cg.iter.service;

import com.cg.iter.entity.Author;
import com.cg.iter.dao.AuthorDao;
import com.cg.iter.dao.AuthorDaoImpl;

public class AuthorServiceImpl implements AuthorService  {
private AuthorDao aDao = new AuthorDaoImpl();
	@Override
	public boolean create(Author auth) {
		
		return aDao.create(auth);
	}
   
	@Override
	public boolean update(Author auth) {
		
		return aDao.update(auth);
	}
	
	@Override
	public boolean delete(Author auth) {
		
		return aDao.delete(auth);
		
	}
	@Override
	public Author getAuth(int authorId) {
		
		return aDao.getAuth(authorId);
	}
	
}
