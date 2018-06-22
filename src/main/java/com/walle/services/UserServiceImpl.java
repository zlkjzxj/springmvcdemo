package com.walle.services;

import com.walle.beans.Girl;
import com.walle.beans.SysUser;
import com.walle.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public SysUser getUser(int id) {
        return userDao.selectUserById(1);
    }

    @Override
    public List<Girl> getGirls() {
        return userDao.getGirls();
    }

}
