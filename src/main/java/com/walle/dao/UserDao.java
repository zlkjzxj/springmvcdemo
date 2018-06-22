package com.walle.dao;

import com.walle.beans.Girl;
import com.walle.beans.SysUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    public SysUser selectUserById(int id);
    public List<Girl> getGirls();
}
