package com.dao;

import com.bean.User;

import java.util.List;

public interface UserDAO {
	public void saveUser(User user);
	
	public User findUserByUsername(String username);
	
	public User findUserByUserid(Integer userid);

	public void updateUser(User user);

	public String find_note_of_user(Integer userid);

	@SuppressWarnings("rawtypes")
	public List find_all_paragraph_of_user(Integer userid);
}
