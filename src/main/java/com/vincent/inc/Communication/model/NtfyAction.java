package com.vincent.inc.Communication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class NtfyAction {
    protected NtfyActionEnum action;
    protected String label;
}
