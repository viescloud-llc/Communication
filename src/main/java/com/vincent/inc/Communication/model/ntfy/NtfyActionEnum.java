package com.vincent.inc.Communication.model.ntfy;

import java.util.Map;
import static com.viescloud.llc.viesspringutils.util.Enums.mapBy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NtfyActionEnum {
    VIEW("view"),
    BROADCAST("broadcast"),
    HTTP("http");

    private final String action;

    private static final Map<String, NtfyActionEnum> matcherMap = mapBy(values(), it -> it.getAction().toUpperCase());
    private static final Map<String, NtfyActionEnum> nameMap = mapBy(values(), it -> it.name().toUpperCase());

    @JsonCreator
    public static NtfyActionEnum fromAction(String action) {
        var matcher = matcherMap.get(action.toUpperCase());
        var name = nameMap.get(action.toUpperCase());
        return matcher != null ? matcher : name != null ? name : null;
    }

    @JsonValue
    public String getValue() {
        return this.action;
    }
}
