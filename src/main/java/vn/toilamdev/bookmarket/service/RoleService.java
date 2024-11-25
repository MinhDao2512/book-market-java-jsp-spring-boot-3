package vn.toilamdev.bookmarket.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.Role;
import vn.toilamdev.bookmarket.repository.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }

    public List<Role> getAllRoles(Pageable pageable) {
        Page<Role> page = this.roleRepository.findAll(pageable);
        return page.getContent();
    }

    public Role getRoleById(long id) {
        return this.roleRepository.findById(id);
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }
}
