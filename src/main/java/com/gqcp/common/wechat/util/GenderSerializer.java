package com.gqcp.common.wechat.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.gqcp.common.wechat.user.Gender;

/**
 * Created by exizhai on 10/4/2015.
 */
public class GenderSerializer extends JsonSerializer<Gender> {

    @Override
    public void serialize(Gender gender, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(gender.getCode());
    }
}
