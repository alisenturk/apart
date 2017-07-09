package com.apart.service.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.apart.dao.user.UserDao;
import com.apart.model.base.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	@Cacheable("listAllUsers")
	public List<User> listAllUsers() {		
		return (List<User>)userDao.findAll(); 
	}


	@Override
	public void save(User user) {
		userDao.save(user);
		
	}

	@Override
	@Cacheable(cacheNames="userByID",key="#id")
	public User findUserById(Long id) {
		return userDao.findOne(id);
	}

	@Override
	@Cacheable(cacheNames="userByID",key="{#id,#username}")
	public User findUserByIdAndUsername(Long id, String username) {
		return userDao.findUserByIdAndUsername(id, username);
	}


	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		return userDao.findByUsernameAndPassword(username,password);
	}
	


}
