package com.wch.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wch.model.User;
import com.wch.repository.UserRepository;
import com.wch.service.UserService;

/**
 * Description:
 * 
 * @author wangchenghong
 * @since: 2019年4月29日: 上午10:59:30
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findUserByuserName(String userName) {
        return userRepository.findUserByuserName(userName);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

}
