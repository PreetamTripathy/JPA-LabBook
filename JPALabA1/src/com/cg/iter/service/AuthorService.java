package com.cg.iter.service;

import com.cg.iter.entity.Author;

public interface AuthorService {
	
	boolean create(Author auth);

	boolean update(Author auth);

	boolean delete(Author auth);

	Author getAuth(int authorId); 

}
