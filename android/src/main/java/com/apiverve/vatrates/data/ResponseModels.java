// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     VATRatesData data = Converter.fromJsonString(jsonString);

package com.apiverve.vatrates.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static VATRatesData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(VATRatesData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(VATRatesData.class);
        writer = mapper.writerFor(VATRatesData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// VATRatesData.java

package com.apiverve.vatrates.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class VATRatesData {
    private String country;
    private String countryName;
    private String currency;
    private LocalDate effectiveFrom;
    private Rates rates;
    private Object exception;

    @JsonProperty("country")
    public String getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(String value) { this.country = value; }

    @JsonProperty("countryName")
    public String getCountryName() { return countryName; }
    @JsonProperty("countryName")
    public void setCountryName(String value) { this.countryName = value; }

    @JsonProperty("currency")
    public String getCurrency() { return currency; }
    @JsonProperty("currency")
    public void setCurrency(String value) { this.currency = value; }

    @JsonProperty("effectiveFrom")
    public LocalDate getEffectiveFrom() { return effectiveFrom; }
    @JsonProperty("effectiveFrom")
    public void setEffectiveFrom(LocalDate value) { this.effectiveFrom = value; }

    @JsonProperty("rates")
    public Rates getRates() { return rates; }
    @JsonProperty("rates")
    public void setRates(Rates value) { this.rates = value; }

    @JsonProperty("exception")
    public Object getException() { return exception; }
    @JsonProperty("exception")
    public void setException(Object value) { this.exception = value; }
}

// Rates.java

package com.apiverve.vatrates.data;

import com.fasterxml.jackson.annotation.*;

public class Rates {
    private long standard;
    private long reduced;
    private Object reduced2;
    private Object superReduced;
    private Object parking;

    @JsonProperty("standard")
    public long getStandard() { return standard; }
    @JsonProperty("standard")
    public void setStandard(long value) { this.standard = value; }

    @JsonProperty("reduced")
    public long getReduced() { return reduced; }
    @JsonProperty("reduced")
    public void setReduced(long value) { this.reduced = value; }

    @JsonProperty("reduced2")
    public Object getReduced2() { return reduced2; }
    @JsonProperty("reduced2")
    public void setReduced2(Object value) { this.reduced2 = value; }

    @JsonProperty("superReduced")
    public Object getSuperReduced() { return superReduced; }
    @JsonProperty("superReduced")
    public void setSuperReduced(Object value) { this.superReduced = value; }

    @JsonProperty("parking")
    public Object getParking() { return parking; }
    @JsonProperty("parking")
    public void setParking(Object value) { this.parking = value; }
}