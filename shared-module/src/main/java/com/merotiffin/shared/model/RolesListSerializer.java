//package com.merotiffin.shared.model;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import com.merotiffin.shared.enums.Roles;
//import org.springframework.boot.jackson.JsonComponent;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@JsonComponent
//public class RolesListSerializer extends JsonSerializer<List<Roles>> {
//
//    @Override
//    public void serialize(List<Roles> roles, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        List<KeyValuePojo> serializedRoles = roles.stream()
//                .map(Roles::getEnum)
//                .collect(Collectors.toList());
//        jsonGenerator.writeObject(serializedRoles);
//    }
//}
