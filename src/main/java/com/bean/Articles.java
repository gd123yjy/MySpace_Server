package com.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by yjy on 16-10-26.
 */

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonRootName("articles")
public class Articles {

    @XmlElementWrapper(name = "article")
    //@XmlElement(name = "article")
    private List articles;

    public Articles(){};

    public Articles(List articles) {
        this.articles = articles;
    }

    public List getArticles() {
        return articles;
    }

    public void setArticles(List articles) {
        this.articles = articles;
    }
}
