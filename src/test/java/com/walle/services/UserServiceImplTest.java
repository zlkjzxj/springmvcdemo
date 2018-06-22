package com.walle.services;

import com.walle.beans.Girl;
import com.walle.beans.SysUser;
import com.walle.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class UserServiceImplTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void getUser() {
        List<Girl> girls = userDao.getGirls();
        for(Girl girl:girls) {
            System.out.println(girl.getName());
        }
    }
}