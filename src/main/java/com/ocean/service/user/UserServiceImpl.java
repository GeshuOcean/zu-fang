package com.ocean.service.user;

import com.ocean.entity.Role;
import com.ocean.entity.User;
import com.ocean.repository.RoleRepository;
import com.ocean.repository.UserRepository;
import com.ocean.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ocean .
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findUserByName(String userName) {
        User user = userRepository.findByName(userName);
        if (user == null){
            return null;
        }
        List<Role> roles = roleRepository.findRolesByUserId(user.getId());
        if (roles ==null || roles.isEmpty()){
            throw new DisabledException("权限非发");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));
        user.setAuthorityList(authorities);
        return user;
    }

    @Override
    public User findUserByTelephone(String telephone) {
        return null;
    }

    @Override
    public User addUserByPhone(String telehone) {
        return null;
    }

}
