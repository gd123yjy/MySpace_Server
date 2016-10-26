package com.dao;

import com.bean.Paragraph;

/**
 * Created by yjy on 16-10-26.
 */
public interface ParagraphDao {

    public void add_paragraph(Paragraph paragraph);

    public Paragraph find_paragraph_by_paragraph_id(Integer paragraph_id);

    public void update_paragraph(Paragraph paragraph);

    public void delete_paragraph(Paragraph paragraph);
}
