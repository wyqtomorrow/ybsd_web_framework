package com.gqcp.common.wechat.message.xml;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.gqcp.common.wechat.message.MsgType;
import com.gqcp.common.wechat.message.News;
import com.gqcp.common.wechat.message.XmlMessageHeader;

/**
 * Created by exizhai on 9/26/2015.
 */
@JacksonXmlRootElement(localName = "xml")
public class NewsXmlMessage extends XmlMessageHeader {

    @JsonProperty("ArticleCount")
    private int articleCount;
    @JsonProperty("Articles")
    private News news;

    public NewsXmlMessage() {
        this.msgType = MsgType.news;
        this.setCreateTime(new Date());
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public int getArticleCount() {
        return news.getArticles().size();
    }
}
