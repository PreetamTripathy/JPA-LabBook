package com.cg.iter.dao;

import com.cg.iter.entity.Author;

public interface AuthorDao {
	
	boolean create(Author auth);

	Author getAuth(int AuthorId);

	boolean update(Author auth);

	boolean delete(Author auth);

}
