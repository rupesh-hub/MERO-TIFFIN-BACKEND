package com.merotiffin.shared.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.merotiffin.shared.enums.Roles;
import com.merotiffin.shared.model.KeyValuePojo;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class RoleKeyValueSerializer extends StdSerializer<Enum> {

    public RoleKeyValueSerializer() {
        this(null);
    }

    protected RoleKeyValueSerializer(Class<Enum> t) {
        super(t);
    }

    @Override
    public void serialize(Enum s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(this._getSerializedData(s));
    }

    private KeyValuePojo _getSerializedData(Enum s) {
        return Roles.valueOf(s.toString()).getEnum();
    }

}
