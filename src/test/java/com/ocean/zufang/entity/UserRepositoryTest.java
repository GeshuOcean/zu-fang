package com.ocean.zufang.entity;

import com.ocean.entity.User;
import com.ocean.repository.UserRepository;
import com.ocean.zufang.ApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ocean .
 */

public class UserRepositoryTest extends ApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testFindOne(){
        User user = userRepository.findOne(1L);
        Assert.assertEquals("wali",user.getName());
    }
}
