package com.vincent.inc.Communication.model;

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
}
