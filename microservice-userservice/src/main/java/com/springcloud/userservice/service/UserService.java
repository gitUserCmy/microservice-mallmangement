package com.springcloud.userservice.service;

import com.springcloud.userservice.pojo.User;

public interface UserService {

    User selectUser(String username);

}
