package com.bean;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by yjy on 16-10-24.
 */

@XmlRootElement
public class Paragraphs {
    private List<Paragraph> paragraphs;

    public Paragraphs(){};

    public Paragraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List paragraphs) {
        this.paragraphs = paragraphs;
    }
}
