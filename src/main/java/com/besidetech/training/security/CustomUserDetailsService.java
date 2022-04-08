package com.besidetech.training.security;

import java.util.ArrayList;
import java.util.List;
import com.besidetech.training.repository.UserRepository;
import com.besidetech.training.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository ;
    @Autowired
    UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<SimpleGrantedAuthority> roles= new ArrayList<>();
        com.besidetech.training.model.User u = userRepository.findByUsername(username) ;
        String currentRole = userRoleService.getRoleOfAnUser(u.getId()) ;
        if (u!=null){
            System.out.println("role : " + currentRole +"\nUsername : " + u.getUsername() +"\nPassword : "+ u.getPassword());
            roles.add(new SimpleGrantedAuthority(currentRole));
            User myUser = new User(u.getUsername() , u.getPassword() , roles) ;
            return myUser ;
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

}