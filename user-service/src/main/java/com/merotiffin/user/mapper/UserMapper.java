package com.merotiffin.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.merotiffin.shared.model.UserResponsePojo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    Page<UserResponsePojo> allUser(final Page<UserResponsePojo> userResponsePage);

}
