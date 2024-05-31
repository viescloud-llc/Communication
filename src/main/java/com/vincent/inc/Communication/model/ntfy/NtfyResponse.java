package com.vincent.inc.Communication.model.ntfy;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NtfyResponse extends NtfyPackage {

    /** Description: Unique notification ID */
    private String id;

    /** Description: Time of creation */
    private Long time;

    /** Description: Time of expiration */
    private Long expires;

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

    /** Description: List of actions */
    private List<NtfyAction> actions;
    
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
