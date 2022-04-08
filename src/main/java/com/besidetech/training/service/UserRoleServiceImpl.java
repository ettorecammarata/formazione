package com.besidetech.training.service;

import com.besidetech.training.model.Role;
import com.besidetech.training.model.User;
import com.besidetech.training.model.UserRole;
import com.besidetech.training.repository.RoleRepository;
import com.besidetech.training.repository.UserRepository;
import com.besidetech.training.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    private UserRoleRepository userRoleRepository ;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleService roleService ;

    @Override
    public String getRoleOfAnUser(Integer idUser) { // prendo l'id dell'user
        Optional<User> currentUser = userRepository.findById(idUser) ;
        if(currentUser.isPresent() ){
            Optional<UserRole> tmp = userRoleRepository.findByUserId(idUser) ;
            return roleService.getRoleName(tmp.get().getRole().getId()) ;
        }
        return "NaN";
    }


}
