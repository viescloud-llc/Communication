package com.vincent.inc.Communication.util;

import java.util.Collections;

public class NtfyMarkdowns {
    private NtfyMarkdowns() {}

    public static String bold(String text) {
        return String.format("**%s**", text);
    }

    public static String italic(String text) {
        return String.format("*%s*", text);
    }

    public static String strikethrough(String text) {
        return String.format("~~%s~~", text);
    }

    public static String inlineCode(String text) {
        return String.format("`%s`", text);
    }

    public static String link(String text, String url) {
        return String.format("[%s](%s)", text, url);
    }

    public static String image(String text, String url) {
        return String.format("![](%s) %s", url, text);
    }

    public static String blockQuote(String text) {
        return String.format("> %s", text);
    }

    public static String codeBlock(String text) {
        return String.format("```\n%s\n```", text);
    }

    public static String header(String text, int level) {
        return String.format("%s %s", String.join("", Collections.nCopies(level, "#")), text);
    }

    public static String unorderedList(String text) {
        return String.format("- %s", text);
    }

    public static String orderedList(String text) {
        return String.format("1. %s", text);
    }

    public static String horizontalRule() {
        return "---";
    }
}
