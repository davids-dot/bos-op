package com.luoge.bos.core.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (Objects.nonNull(value)) {
            gen.writeString(value.stripTrailingZeros().toPlainString());
        }
    }

    public static class BigDecimalListSerializer extends JsonSerializer<List<BigDecimal>> {
        @Override
        public void serialize(List<BigDecimal> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartArray();
            if (CollectionUtils.isNotEmpty(value)) {
                for (BigDecimal decimal : value) {
                    gen.writeString(decimal.stripTrailingZeros().toPlainString());
                }
            }
            gen.writeEndArray();
        }
    }

}
