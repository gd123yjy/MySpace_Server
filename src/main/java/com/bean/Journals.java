package com.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by yjy on 16-10-24.
 */

@XmlRootElement(name = "journalList")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Journals {

   /* @XmlElementWrapper(name = "journals")
    @XmlElement(name = "journal")
    @XmlList*/
    private List<Journal> journalList;

    public Journals(){};

    public Journals(List<Journal> journals) {
        this.journalList = journals;
    }

    @XmlElementWrapper(name = "journals")
    @XmlElement(name = "journal")
    public List<Journal> getJournalList() {
        return journalList;
    }

    /*@XmlElementWrapper(name = "journals")
    @XmlElement(name = "journal")
    public void setJournalList(List<Journal> journalList) {
        this.journalList = journalList;
    }*/
}
