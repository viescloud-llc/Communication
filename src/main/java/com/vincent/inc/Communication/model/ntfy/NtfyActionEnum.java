package com.vincent.inc.Communication.model.ntfy;

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

    @JsonValue
    public String getValue() {
        return this.action;
    }
}
