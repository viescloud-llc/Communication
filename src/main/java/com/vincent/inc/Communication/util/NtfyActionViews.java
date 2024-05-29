package com.vincent.inc.Communication.util;

public class NtfyActionViews {
    private NtfyActionViews() {}

    public static String openHttpUrl(String url) {
        return String.format("http://%s", url);
    }

    public static String openHttpsUrl(String url) {
        return String.format("https://%s", url);
    }

    public static String mailTo(String email) {
        return String.format("mailto:%s", email);
    }

    public static String openGoogleMap(String cordinate) {
        return String.format("geo:%s", cordinate);
    }

    public static String openGoogleMap(String latitude, String longitude, String extras) {
        return String.format("geo:%s,%s?q=%s", latitude, longitude, extras);
    }

    public static String ntfyLinks(String url) {
        return String.format("ntfy://%s", url);
    }

    public static String twitterLinks(String url) {
        return String.format("twitter://%s", url);
    }

    public static String facebookLinks(String url) {
        return String.format("facebook://%s", url);
    }

    public static String telegramLinks(String url) {
        return String.format("telegram://%s", url);
    }

    public static String discordLinks(String url) {
        return String.format("discord://%s", url);
    }

    public static String slackLinks(String url) {
        return String.format("slack://%s", url);
    }

    public static String lineLinks(String url) {
        return String.format("line://%s", url);
    }

    public static String wechatLinks(String url) {
        return String.format("wechat://%s", url);
    }

    public static String viberLinks(String url) {
        return String.format("viber://%s", url);
    }

    public static String whatsappLinks(String url) {
        return String.format("whatsapp://%s", url);
    }

    public static String qqLinks(String url) {
        return String.format("qq://%s", url);
    }

    public static String weiboLinks(String url) {
        return String.format("weibo://%s", url);
    }

    public static String baiduLinks(String url) {
        return String.format("baidu://%s", url);
    }

    public static String bingLinks(String url) {
        return String.format("bing://%s", url);
    }

    public static String redditLinks(String url) {
        return String.format("reddit://%s", url);
    }

    public static String linkedinLinks(String url) {
        return String.format("linkedin://%s", url);
    }

    public static String youtubeLinks(String url) {
        return String.format("youtube://%s", url);
    }

    public static String githubLinks(String url) {
        return String.format("github://%s", url);
    }

    public static String tiktokLinks(String url) {
        return String.format("tiktok://%s", url);
    }

    public static String instagramLinks(String url) {
        return String.format("instagram://%s", url);
    }

    public static String spotifyLinks(String url) {
        return String.format("spotify://%s", url);
    }

    public static String vkLinks(String url) {
        return String.format("vk://%s", url);
    }

    public static String okLinks(String url) {
        return String.format("ok://%s", url);
    }
}
