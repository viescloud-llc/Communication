package com.vincent.inc.Communication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NtfyActionView extends NtfyAction {

    @Builder.Default
    private NtfyActionEnum action = NtfyActionEnum.VIEW;
    private String label;
    private String url;
    private boolean clear;
}
