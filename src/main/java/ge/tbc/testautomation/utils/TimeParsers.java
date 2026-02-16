package ge.tbc.testautomation.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class TimeParsers extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String iso = p.getText();
        if (iso == null || iso.isBlank()) return null;

        var formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd'T'HH:mm:ss")
                .optionalStart()
                .appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true)
                .optionalEnd()
                .optionalStart()
                .appendOffsetId()
                .optionalEnd()
                .toFormatter();

        try {
            return OffsetDateTime.parse(iso, formatter).toLocalDateTime();
        } catch (Exception e) {
            return LocalDateTime.parse(iso, formatter);
        }
    }
}
