package com.vincent.inc.Communication.model.ntfy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import static com.vincent.inc.viesspringutils.util.Enums.mapBy;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NtfyPriorityEnum {
    MIN_PRIORITY(1),
    LOW_PRIORITY(2),
    DEFAULT_PRIORITY(3),
    HIGH_PRIORITY(4),
    MAX_PRIORITY(5);

    private final int priority;

    private static final Map<String, NtfyPriorityEnum> matcherMap = mapBy(values(), it -> it.getPriority() + "");
    private static final Map<String, NtfyPriorityEnum> nameMap = mapBy(values(), it -> it.name().toUpperCase());

    @JsonCreator
    public static NtfyPriorityEnum fromPriority(String priority) {
        var matcher = matcherMap.get(priority.toLowerCase());
        var name = nameMap.get(priority.toLowerCase());
        return matcher != null ? matcher : name != null ? name : null;
    }

    public static NtfyPriorityEnum fromPriority(int priority) {
        var matcher = matcherMap.get(priority + "");
        var name = nameMap.get(priority + "");
        return matcher != null ? matcher : name != null ? name : null;
    }

    @JsonValue
    public int getValue() {
        return this.priority;
    }
}
