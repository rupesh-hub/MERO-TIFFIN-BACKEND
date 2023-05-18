package com.merotiffin.shared.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.merotiffin.shared.model.KeyValuePojo;

import java.util.Arrays;
import java.util.List;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Roles {

    ROLE_USER("ROLE_USER"),
    ROLE_CREATOR("ROLE_CREATOR"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_SUPER_ADMIN("ROLE_SUPER_ADMIN");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public static List<KeyValuePojo> getEnumList() {
        return Arrays.stream(com.merotiffin.shared.enums.Roles.values())
                .map(x -> KeyValuePojo.builder()
                        .key(x.toString())
                        .valueEnglish(x.role)
                        .build())
                .toList();
    }


    public KeyValuePojo getEnum() {
        return KeyValuePojo.builder()
                .key(this.toString())
                .valueEnglish(this.role)
                .build();
    }
}

