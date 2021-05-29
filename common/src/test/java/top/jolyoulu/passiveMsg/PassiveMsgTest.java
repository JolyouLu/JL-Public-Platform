package top.jolyoulu.passiveMsg;

import org.junit.Test;
import top.jolyoulu.enums.PassiveMsgType;
import top.jolyoulu.passiveMsg.entity.articles.ArticlesCtx;
import top.jolyoulu.passiveMsg.entity.articles.ArticlesItem;
import top.jolyoulu.passiveMsg.entity.articles.ArticlesMessage;
import top.jolyoulu.passiveMsg.entity.image.ImageCtx;
import top.jolyoulu.passiveMsg.entity.image.ImageMessage;
import top.jolyoulu.passiveMsg.entity.music.MusicCtx;
import top.jolyoulu.passiveMsg.entity.music.MusicMessage;
import top.jolyoulu.passiveMsg.entity.text.TextMessage;
import top.jolyoulu.passiveMsg.entity.video.VideoCtx;
import top.jolyoulu.passiveMsg.entity.video.VideoMessage;
import top.jolyoulu.passiveMsg.entity.voice.VoiceCtx;
import top.jolyoulu.passiveMsg.entity.voice.VoiceMessage;
import top.jolyoulu.passiveMsg.utils.PassiveMsgUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: JolyouLu
 * @Date: 2021/5/25 15:52
 * @Version 1.0
 */
public class PassiveMsgTest {

    @Test
    public void textMessage(){
        System.out.println("================回复文本消息================");
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName("toUser");
        textMessage.setFromUserName("fromUser");
        textMessage.setMsgType(PassiveMsgType.TEXT_TYPE.getType());
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setContent("你好");
        String xml = PassiveMsgUtil.INSTANCE.getMsgXml(textMessage);
        System.out.println(xml);
    }

    @Test
    public void imageMessage(){
        System.out.println("================回复图片消息================");
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setToUserName("toUser");
        imageMessage.setFromUserName("fromUser");
        imageMessage.setMsgType(PassiveMsgType.IMAGE_TYPE.getType());
        imageMessage.setCreateTime(new Date().getTime());
        imageMessage.setImage(new ImageCtx("media_id"));
        String xml = PassiveMsgUtil.INSTANCE.getMsgXml(imageMessage);
        System.out.println(xml);
    }

    @Test
    public void videoMessage(){
        System.out.println("================回复语音消息================");
        VideoMessage videoMessage = new VideoMessage();
        videoMessage.setToUserName("toUser");
        videoMessage.setFromUserName("fromUser");
        videoMessage.setMsgType(PassiveMsgType.VIDEO_TYPE.getType());
        videoMessage.setCreateTime(new Date().getTime());
        videoMessage.setVideo(new VideoCtx("media_id","title","description"));
        String xml = PassiveMsgUtil.INSTANCE.getMsgXml(videoMessage);
        System.out.println(xml);
    }

    @Test
    public void voiceMessage(){
        System.out.println("================回复视频消息================");
        VoiceMessage voiceMessage = new VoiceMessage();
        voiceMessage.setToUserName("toUser");
        voiceMessage.setFromUserName("fromUser");
        voiceMessage.setMsgType(PassiveMsgType.VOICE_TYPE.getType());
        voiceMessage.setCreateTime(new Date().getTime());
        voiceMessage.setVoice(new VoiceCtx("media_id"));
        String xml = PassiveMsgUtil.INSTANCE.getMsgXml(voiceMessage);
        System.out.println(xml);
    }

    @Test
    public void musicMessage(){
        System.out.println("================回复音乐消息================");
        MusicMessage musicMessage = new MusicMessage();
        musicMessage.setToUserName("toUser");
        musicMessage.setFromUserName("fromUser");
        musicMessage.setMsgType(PassiveMsgType.MUSIC_TYPE.getType());
        musicMessage.setCreateTime(new Date().getTime());
        musicMessage.setMusic(new MusicCtx("TITLE","DESCRIPTION","MUSIC_Url","HQ_MUSIC_Url","media_id"));
        String xml = PassiveMsgUtil.INSTANCE.getMsgXml(musicMessage);
        System.out.println(xml);
    }

    @Test
    public void articlesMessage(){
        System.out.println("================回复图文消息================");
        ArticlesMessage articlesMessage = new ArticlesMessage();
        articlesMessage.setToUserName("toUser");
        articlesMessage.setFromUserName("fromUser");
        articlesMessage.setMsgType(PassiveMsgType.NEWS_TYPE.getType());
        articlesMessage.setCreateTime(new Date().getTime());
        articlesMessage.setArticleCount(1);

        List<ArticlesItem> list = new ArrayList<>();
        list.add(new ArticlesItem(new ArticlesCtx("title1","description1","picurl","url")));
        list.add(new ArticlesItem(new ArticlesCtx("title2","description2","picurl","url")));

        articlesMessage.setItem(list);
        String xml = PassiveMsgUtil.INSTANCE.getMsgXml(articlesMessage);
        System.out.println(xml);
    }

}
