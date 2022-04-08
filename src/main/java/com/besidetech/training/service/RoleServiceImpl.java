package com.besidetech.training.service;

import com.besidetech.training.model.Role;
import com.besidetech.training.repository.RoleRepository;
import com.besidetech.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository ;

    @Override
    public String getRoleName(Integer id) { // riceve id del role
        Optional<Role> role = roleRepository.findById(id) ;
        if (role.isPresent())
            return role.get().getName() ;
        else return "NaN" ;
    }

    @Override
    public Integer getIdRole(Integer idUser) {
        Optional<Role>current = roleRepository.findById(idUser) ;
        if(current != null)
            return current.get().getId() ;
        else return 0 ;
    }


}
