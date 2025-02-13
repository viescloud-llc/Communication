package com.vincent.inc.Communication.model.ntfy;

import java.util.Map;
import static com.viescloud.llc.viesspringutils.util.Enums.mapBy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NtfyActionMethodEnum {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    private final String method;

    private static final Map<String, NtfyActionMethodEnum> matcherMap = mapBy(values(), it -> it.getMethod().toUpperCase());
    private static final Map<String, NtfyActionMethodEnum> nameMap = mapBy(values(), it -> it.name().toUpperCase());

    @JsonCreator
    public static NtfyActionMethodEnum fromMethod(String method) {
        var matcher = matcherMap.get(method.toUpperCase());
        var name = nameMap.get(method.toUpperCase());
        return matcher != null ? matcher : name != null ? name : null;
    }

    @JsonValue
    public String getValue() {
        return this.method;
    }
}
