package com.vincent.inc.Communication.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vincent Bui
 * @since 2021-11-16
 * @version 1.0
 * @see https://docs.ntfy.sh/emojis/
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NtfyPackage {
    /** Description: Target topic name */
    private String topic;
    
    /** Description: Message body; set to triggered if empty or not passed */
    private String message;
    
    /** Description: Message title */
    private String title;
    
    /** Description: List of tags that may or not map to emojis */
    private List<NtfyTagEnum> tags;
    
    /** Description: Message priority with 1=min, 3=default and 5=max */
    private NtfyPriorityEnum priority;
    
    /** Description: Website opened when notification is clicked */
    private String click;
    
    /** Description: URL of an attachment, see attach via URL */
    private String attach;
    
    /** Description: Set to true if the message is Markdown-formatted */
    private Boolean markdown;
    
    /** Description: URL to use as notification icon */
    private String icon;
    
    /** Description: File name of the attachment */
    private String filename;
    
    /** Description: Timestamp or duration for delayed delivery */
    private String delay;
    
    /** Description: E-mail address for e-mail notifications */
    private String email;
}
