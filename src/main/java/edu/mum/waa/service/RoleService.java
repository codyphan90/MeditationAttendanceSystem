package edu.mum.waa.service;


import edu.mum.waa.entity.RoleEntity;
import edu.mum.waa.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<RoleEntity> findAll() {

        return roleRepository.findAll();
    }

    public RoleEntity get(Long id) {

        return roleRepository.findById(id).get();
    }
}
