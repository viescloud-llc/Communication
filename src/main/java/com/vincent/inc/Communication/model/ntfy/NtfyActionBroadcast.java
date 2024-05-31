package com.vincent.inc.Communication.model.ntfy;

import java.util.Map;

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
public class NtfyActionBroadcast extends NtfyAction {
    /** Action type */
    @Builder.Default
    private NtfyActionEnum action = NtfyActionEnum.BROADCAST;

    /** Label of the action button in the notification */
    private String label;

    /** Android intent name, default is io.heckel.ntfy.USER_ACTION 
     * @example com.example.AN_INTENT
     * @default io.heckel.ntfy.USER_ACTION
    */
    private String intent;

    /**
     * Android intent extras. Currently, only string extras are supported. When publishing as JSON, extras are passed as a map. When the simple format is used, use extras.<param>=<value>.
     */
    private Map<String, String> extras;
}
