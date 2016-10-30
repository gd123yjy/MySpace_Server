package com.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by yjy on 16-10-26.
 */

@XmlRootElement(name = "articles")
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
