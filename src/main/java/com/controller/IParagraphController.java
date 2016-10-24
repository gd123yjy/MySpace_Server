package com.controller;

import com.bean.Paragraph;

/**
 * Created by yjy on 16-10-24.
 */
public interface IParagraphController {

    //paragraph
    public void addParagraph(int userid,int chapter_id,int sequence,String content );

    public Paragraph findParagraph(int paragraph_id);

    public void updateParagraph(int paragraph_id,String content);

    public void deleteParagraph(int paragraph_id);
}
