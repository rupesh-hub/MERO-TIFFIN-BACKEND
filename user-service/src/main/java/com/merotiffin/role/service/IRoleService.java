package com.merotiffin.role.service;

import com.merotiffin.role.entity.Role;

import java.util.List;

public interface IRoleService {

    List<Role> createRoles(final List<Role> roles);
    Role getByName(final String name);
    List<Role> allRole();

}
