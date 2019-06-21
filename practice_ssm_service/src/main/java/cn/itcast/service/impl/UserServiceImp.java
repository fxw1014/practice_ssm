package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo ui = userDao.findUserByUsername(s);
        User user = new User(ui.getUsername(),
                "{noop}"+ui.getPassword(),
                 ui.getStatus() == 0 ? false : true,
                true,
                true,
                true,
                 getAuthorities(ui.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthorities(List<Role> roleList) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roleList) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getRoleName());
            authorities.add(simpleGrantedAuthority);
        }
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }
}
