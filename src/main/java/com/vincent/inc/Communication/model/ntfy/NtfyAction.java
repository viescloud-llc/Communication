package com.vincent.inc.Communication.model.ntfy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "action")   // field on which we differentiate objects
@JsonSubTypes({
        @JsonSubTypes.Type(value = NtfyActionView.class, name = "VIEW"), 
        @JsonSubTypes.Type(value = NtfyActionBroadcast.class, name = "BROADCAST"),
        @JsonSubTypes.Type(value = NtfyActionHttp.class, name = "HTTP")
})
public abstract class NtfyAction {
    /** Action type */
    private NtfyActionEnum action;

    /** Label of the action button in the notification */
    private String label;

    /** Clear notification after action button is tapped */
    private boolean clear;
}
