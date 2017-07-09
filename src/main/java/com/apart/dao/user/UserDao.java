package com.apart.dao.user;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apart.model.base.User;

@Transactional
public interface UserDao extends JpaRepository<User, Long> {

	
	@Query(value = "select u from User u where u.username=?1 and u.password=?2 ")
	User findByUsernameAndPassword(String username,String password);
	
	@Query(value = "select u from User u where u.id=?1 and u.username=?2 ")
	User findUserByIdAndUsername(long id,String username);
}
