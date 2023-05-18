package com.merotiffin.shared.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.merotiffin.shared.configuration.GenderKeyValueSerializer;
import com.merotiffin.shared.configuration.RoleKeyValueSerializer;
import com.merotiffin.shared.enums.Gender;
import com.merotiffin.shared.enums.Roles;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponsePojo {

    private String userId;
    private String fullNameEn;
    private String fullNameNp;
    private String email;
    private String phone;
    private Date dateOfBirth;

    @JsonSerialize(using = GenderKeyValueSerializer.class, as = Enum.class)
    private Gender gender;

    private LocalDateTime lastLoginDate;
    private LocalDateTime lastLogoutDate;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private Boolean isActive;
    private Boolean enabled;
    private AddressPojo address;

//    @JsonSerialize(using = RoleKeyValueSerializer.class, as = Enum.class)
    private List<String> roles;

}