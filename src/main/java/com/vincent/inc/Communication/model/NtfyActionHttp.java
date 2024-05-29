package com.vincent.inc.Communication.model;

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
public class NtfyActionHttp<T> extends NtfyAction {

    /** Action type */
    @Builder.Default
    private NtfyActionEnum action = NtfyActionEnum.HTTP;

    /** Label of the action button in the notification */
    private String label;

    /** URL to which the HTTP request will be sent */
    private String url;

    /** HTTP request method */
    private NtfyActionEnum method;

    /** HTTP headers to pass in request. When publishing as JSON, headers are passed as a map. When the simple format is used, use headers.<header1>=<value>. */
    private Map<String, String> headers;

    /** HTTP request body. When publishing as JSON, body is passed as a map. When the simple format is used, use body.<key>=<value>. */
    private T body;

    /** Clear notification after action button is tapped */
    private boolean clear;
}
