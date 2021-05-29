package top.jolyoulu.utils;

import java.util.Date;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/29 18:44
 * @Version 1.0
 * 被动消息返回工具类(不推荐使用，推荐使用注解方式)
 */
@Deprecated
public class PassiveMsgUtil {

    //私有构造方法
    private PassiveMsgUtil() {}

    //静态内部类实现单例模式
    private static class PassiveMsgUtilInstance{
        private static final PassiveMsgUtil INSTANCE = new PassiveMsgUtil();
    }

    public static PassiveMsgUtil getInstance(){
        return PassiveMsgUtilInstance.INSTANCE;
    }

    /**
     * 回复文本消息
     * @param toUserName 接收方帐号（收到的OpenID）
     * @param fromUserName 开发者微信号
     * @param content 消息类型，文本为text
     * @return
     */
    public String textMessage(String toUserName,String fromUserName,String content){
        return "<xml>\n" +
                "  <ToUserName><![CDATA["+toUserName+"]]></ToUserName>\n" +
                "  <FromUserName><![CDATA["+fromUserName+"]]></FromUserName>\n" +
                "  <CreateTime>"+new Date().getTime() +"</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA["+content+"]]></Content>\n" +
                "</xml>";
    }

    /**
     *回复图片消息
     * @param toUserName 接收方帐号（收到的OpenID）
     * @param fromUserName 开发者微信号
     * @param mediaId 通过素材管理中的接口上传多媒体文件，得到的id
     * @return
     */
    public String imageMessage(String toUserName,String fromUserName,String mediaId){
        return "<xml>\n" +
                "  <ToUserName><![CDATA["+toUserName+"]]></ToUserName>\n" +
                "  <FromUserName><![CDATA["+fromUserName+"]]></FromUserName>\n" +
                "  <CreateTime>"+new Date().getTime() +"</CreateTime>\n" +
                "  <MsgType><![CDATA[image]]></MsgType>\n" +
                "  <Image>\n" +
                "    <MediaId><![CDATA["+mediaId+"]]></MediaId>\n" +
                "  </Image>" +
                "</xml>";
    }

    /**
     * 回复语音消息
     * @param toUserName 接收方帐号（收到的OpenID）
     * @param fromUserName 开发者微信号
     * @param mediaId 通过素材管理中的接口上传多媒体文件，得到的id
     * @return
     */
    public String videoMessage(String toUserName,String fromUserName,String mediaId){
        return "<xml>\n" +
                "  <ToUserName><![CDATA["+toUserName+"]]></ToUserName>\n" +
                "  <FromUserName><![CDATA["+fromUserName+"]]></FromUserName>\n" +
                "  <CreateTime>"+new Date().getTime() +"</CreateTime>\n" +
                "  <MsgType><![CDATA[voice]]></MsgType>\n" +
                "  <Voice>\n" +
                "    <MediaId><![CDATA["+mediaId+"]]></MediaId>\n" +
                "  </Voice>" +
                "</xml>";
    }

    /**
     * 回复视频消息
     * @param toUserName 接收方帐号（收到的OpenID）
     * @param fromUserName 开发者微信号
     * @param mediaId 通过素材管理中的接口上传多媒体文件，得到的id
     * @param title 视频消息的标题
     * @param description 视频消息的描述
     * @return
     */
    public String voiceMessage(String toUserName,String fromUserName,String mediaId,String title,String description){
        return "<xml>\n" +
                "  <ToUserName><![CDATA["+toUserName+"]]></ToUserName>\n" +
                "  <FromUserName><![CDATA["+fromUserName+"]]></FromUserName>\n" +
                "  <CreateTime>"+new Date().getTime() +"</CreateTime>\n" +
                "  <MsgType><![CDATA[video]]></MsgType>\n" +
                "  <Video>\n" +
                "    <MediaId><![CDATA["+mediaId+"]]></MediaId>\n" +
                "    <Title><![CDATA["+title+"]]></Title>\n" +
                "    <Description><![CDATA["+description+"]]></Description>\n" +
                "  </Video>" +
                "</xml>";
    }

    /**
     * 回复音乐消息
     * @param toUserName 接收方帐号（收到的OpenID）
     * @param fromUserName 开发者微信号
     * @param title 音乐标题
     * @param description 音乐描述
     * @param musicUrl 音乐链接
     * @param hqMusicUrl 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     * @param mediaId 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     * @return
     */
    public String musicMessage(String toUserName,String fromUserName,String title,String description,String musicUrl,String hqMusicUrl,String mediaId){
        return "<xml>\n" +
                "  <ToUserName><![CDATA["+toUserName+"]]></ToUserName>\n" +
                "  <FromUserName><![CDATA["+fromUserName+"]]></FromUserName>\n" +
                "  <CreateTime>"+new Date().getTime() +"</CreateTime>\n" +
                "  <MsgType><![CDATA[music]]></MsgType>\n" +
                "  <Music>\n" +
                "    <Title><![CDATA["+title+"]]></Title>\n" +
                "    <Description><![CDATA["+description+"]]></Description>\n" +
                "    <MusicUrl><![CDATA["+musicUrl+"]]></MusicUrl>\n" +
                "    <HQMusicUrl><![CDATA["+hqMusicUrl+"]]></HQMusicUrl>\n" +
                "    <ThumbMediaId><![CDATA["+mediaId+"]]></ThumbMediaId>\n" +
                "  </Music>" +
                "</xml>";
    }
}
