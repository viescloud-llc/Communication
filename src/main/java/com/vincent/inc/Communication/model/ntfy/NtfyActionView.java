package com.vincent.inc.Communication.model.ntfy;

import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NtfyActionView extends NtfyAction {

    /** Action type */
    @Builder.Default
    private NtfyActionEnum action = NtfyActionEnum.VIEW;

    /** Label of the action button in the notification */
    private String label;

    /** URL to open when action is tapped */
    private String url;

    /** Clear notification after action button is tapped */
    private boolean clear;
}
