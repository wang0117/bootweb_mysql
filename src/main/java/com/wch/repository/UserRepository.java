package com.wch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wch.model.User;

/**
 * Description:   
 * @author wangchenghong 
 * @since: 2019年4月29日: 上午10:54:09
 */

public interface UserRepository extends JpaRepository<User, String>{
    User findUserByuserName(String userName);
}
