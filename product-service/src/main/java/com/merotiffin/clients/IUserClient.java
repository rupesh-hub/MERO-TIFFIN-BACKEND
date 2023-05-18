package com.merotiffin.clients;

import com.merotiffin.shared.model.UserPojo;
import com.merotiffin.shared.model.UserResponsePojo;
import com.merotiffin.shared.util.GlobalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "USER-MANAGEMENT", path = "/users", url = "${USER-MANAGEMENT.base-url}")
public interface IUserClient {

    @GetMapping("/userId/{userId}")
    GlobalResponse<UserPojo> getUserByUserId(@PathVariable final String userId);

}
