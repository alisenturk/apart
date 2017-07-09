package com.apart.service.users;

import java.io.Serializable;
import java.util.List;

import com.apart.model.base.User;

public interface UserService extends Serializable{
	public List<User> 	listAllUsers();
	public User			findUserById(Long id);
	public void 		save(User user);
	public User			findUserByIdAndUsername(Long id,String username);
	public User			findUserByUsernameAndPassword(String username,String password);
}
