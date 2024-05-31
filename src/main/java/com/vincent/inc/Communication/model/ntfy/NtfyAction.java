package com.vincent.inc.Communication.model.ntfy;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class NtfyAction {
    /** Action type */
    private NtfyActionEnum action;

    /** Label of the action button in the notification */
    private String label;

    /** Clear notification after action button is tapped */
    private boolean clear;
}
