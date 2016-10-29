package com.controller;

import com.bean.Paragraph;

/**
 * Created by yjy on 16-10-24.
 */
public interface IParagraphController {

    //paragraph
    public void addParagraph(Integer userid,Integer chapter_id,Integer sequence,String content );

    public Paragraph findParagraph(Integer paragraph_id);

    public void updateParagraph(Integer paragraph_id,String content);

    public void deleteParagraph(Integer paragraph_id);
}
