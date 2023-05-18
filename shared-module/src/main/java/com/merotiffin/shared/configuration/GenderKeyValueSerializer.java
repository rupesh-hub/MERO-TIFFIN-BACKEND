package com.merotiffin.shared.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.merotiffin.shared.enums.Gender;
import com.merotiffin.shared.model.KeyValuePojo;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GenderKeyValueSerializer extends StdSerializer<Enum> {

    public GenderKeyValueSerializer() {
        this(null);
    }

    protected GenderKeyValueSerializer(Class<Enum> t) {
        super(t);
    }

    @Override
    public void serialize(Enum s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(this._getSerializedData(s));
    }

    private KeyValuePojo _getSerializedData(Enum s) {
        return Gender.valueOf(s.toString()).getEnum();
    }

}
