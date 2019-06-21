package cn.itcast.dao;

import cn.itcast.domain.UserInfo;

public interface UserDao {
    public UserInfo findUserByUsername(String username);
}
