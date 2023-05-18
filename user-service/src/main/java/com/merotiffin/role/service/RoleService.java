package com.merotiffin.role.service;

import com.merotiffin.role.entity.Role;
import com.merotiffin.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;
    private static final String NO_ROLE_FOUND_BY_NAME = "no role found by role name [%s]";

    @Override
    @Transactional
    public List<Role> createRoles(final List<Role> roles) {
        roles.forEach(role -> {
            role.setCreatedDate(LocalDateTime.now());
            role.setCreatedBy("");
        });
        return roleRepository.saveAll(roles);
    }

    @Override
    public Role getByName(final String name) {
        return roleRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(String.format(NO_ROLE_FOUND_BY_NAME, name)));
    }

    @Override
    public List<Role> allRole() {
        return Optional.ofNullable(roleRepository.findAll())
                .orElse(null);
    }
}