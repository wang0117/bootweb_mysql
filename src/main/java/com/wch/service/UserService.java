package com.wch.service;

import org.springframework.stereotype.Repository;

import com.wch.model.User;

/**
 * Description:
 * 
 * @author wangchenghong
 * @since: 2019年4月29日: 上午10:59:04
 */
@Repository
public interface UserService {

    /**
     * Description:
     * 
     * @param userName
     * @return User
     * @author wangchenghong
     * @since 2019年4月29日: 上午11:01:35
     */

    User findUserByuserName(String userName);

    void saveUser(User user);

}
