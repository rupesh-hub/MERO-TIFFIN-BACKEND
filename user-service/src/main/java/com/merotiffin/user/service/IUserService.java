package com.merotiffin.user.service;

import com.merotiffin.shared.model.UserPojo;
import com.merotiffin.shared.model.UserRequestPojo;
import com.merotiffin.shared.model.UserResponsePojo;
import com.merotiffin.shared.util.GlobalResponse;

import java.util.List;

public interface IUserService {

    GlobalResponse<String> createUser(final UserRequestPojo userRequestPojo);

    GlobalResponse<List<UserResponsePojo>> allUser(final int page, final int limit);

    GlobalResponse<String> assignRole(final String roleName, final String email);

    GlobalResponse<String> removeRole(final String roleName, final String email);

    GlobalResponse<UserPojo> getByUserId(final String userId);

    GlobalResponse<UserPojo> getByEmail(final String email);

    GlobalResponse<UserPojo> getByPhone(final String phone);

}