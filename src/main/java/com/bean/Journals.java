package com.bean;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjy on 16-10-24.
 */

@XmlRootElement
public class Journals {
    private List journals = new ArrayList<Journal>();

    public Journals(List journals) {
        this.journals = journals;
    }

    public List getJournals() {
        return journals;
    }

    public void setJournals(List journals) {
        this.journals = journals;
    }
}
