package com.vincent.inc.Communication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NtfyActionEnum {
    VIEW("view"),
    BROADCAST("broadcast"),
    HTTP("http");

    private final String action;
}
