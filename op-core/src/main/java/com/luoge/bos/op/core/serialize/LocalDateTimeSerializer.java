package com.luoge.bos.op.core.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.luoge.bos.op.core.utils.DateUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (Objects.nonNull(value)) {
            gen.writeNumber(DateUtil.toTimeMills(value));
        }
    }
}
