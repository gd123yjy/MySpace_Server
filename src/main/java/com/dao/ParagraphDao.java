package com.dao;

import com.bean.Paragraph;

import java.util.List;

/**
 * Created by yjy on 16-10-26.
 */
public interface ParagraphDao {

    public void add_paragraph(Paragraph paragraph);

    public Paragraph find_paragraph_by_paragraph_id(Integer paragraph_id);

    public void update_paragraph(Paragraph paragraph);

    public void delete_paragraph(Paragraph paragraph);

    public List find_paragraphs_of_user(Integer user_id);
}
