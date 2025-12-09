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
//     WeatherData data = Converter.fromJsonString(jsonString);

package com.apiverve.weatherforecast.data;

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

    public static WeatherData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(WeatherData obj) throws JsonProcessingException {
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
        reader = mapper.readerFor(WeatherData.class);
        writer = mapper.writerFor(WeatherData.class);
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

// WeatherData.java

package com.apiverve.weatherforecast.data;

import com.fasterxml.jackson.annotation.*;

public class WeatherData {
    private double tempC;
    private double tempF;
    private double windMph;
    private double windKph;
    private long windDegree;
    private String windDir;
    private long pressureMB;
    private double pressureIn;
    private long precipMm;
    private long precipIn;
    private double feelslikeC;
    private double feelslikeF;
    private long visKM;
    private long visMiles;
    private double gustMph;
    private double gustKph;

    @JsonProperty("tempC")
    public double getTempC() { return tempC; }
    @JsonProperty("tempC")
    public void setTempC(double value) { this.tempC = value; }

    @JsonProperty("tempF")
    public double getTempF() { return tempF; }
    @JsonProperty("tempF")
    public void setTempF(double value) { this.tempF = value; }

    @JsonProperty("windMph")
    public double getWindMph() { return windMph; }
    @JsonProperty("windMph")
    public void setWindMph(double value) { this.windMph = value; }

    @JsonProperty("windKph")
    public double getWindKph() { return windKph; }
    @JsonProperty("windKph")
    public void setWindKph(double value) { this.windKph = value; }

    @JsonProperty("windDegree")
    public long getWindDegree() { return windDegree; }
    @JsonProperty("windDegree")
    public void setWindDegree(long value) { this.windDegree = value; }

    @JsonProperty("windDir")
    public String getWindDir() { return windDir; }
    @JsonProperty("windDir")
    public void setWindDir(String value) { this.windDir = value; }

    @JsonProperty("pressureMb")
    public long getPressureMB() { return pressureMB; }
    @JsonProperty("pressureMb")
    public void setPressureMB(long value) { this.pressureMB = value; }

    @JsonProperty("pressureIn")
    public double getPressureIn() { return pressureIn; }
    @JsonProperty("pressureIn")
    public void setPressureIn(double value) { this.pressureIn = value; }

    @JsonProperty("precipMm")
    public long getPrecipMm() { return precipMm; }
    @JsonProperty("precipMm")
    public void setPrecipMm(long value) { this.precipMm = value; }

    @JsonProperty("precipIn")
    public long getPrecipIn() { return precipIn; }
    @JsonProperty("precipIn")
    public void setPrecipIn(long value) { this.precipIn = value; }

    @JsonProperty("feelslikeC")
    public double getFeelslikeC() { return feelslikeC; }
    @JsonProperty("feelslikeC")
    public void setFeelslikeC(double value) { this.feelslikeC = value; }

    @JsonProperty("feelslikeF")
    public double getFeelslikeF() { return feelslikeF; }
    @JsonProperty("feelslikeF")
    public void setFeelslikeF(double value) { this.feelslikeF = value; }

    @JsonProperty("visKm")
    public long getVisKM() { return visKM; }
    @JsonProperty("visKm")
    public void setVisKM(long value) { this.visKM = value; }

    @JsonProperty("visMiles")
    public long getVisMiles() { return visMiles; }
    @JsonProperty("visMiles")
    public void setVisMiles(long value) { this.visMiles = value; }

    @JsonProperty("gustMph")
    public double getGustMph() { return gustMph; }
    @JsonProperty("gustMph")
    public void setGustMph(double value) { this.gustMph = value; }

    @JsonProperty("gustKph")
    public double getGustKph() { return gustKph; }
    @JsonProperty("gustKph")
    public void setGustKph(double value) { this.gustKph = value; }
}