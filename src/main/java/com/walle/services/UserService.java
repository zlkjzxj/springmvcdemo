package com.walle.services;

import com.walle.beans.Girl;
import com.walle.beans.SysUser;

import java.util.List;

public interface UserService {
    public SysUser getUser(int id);
    public List<Girl> getGirls();
}
