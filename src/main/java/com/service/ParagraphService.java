package com.service;

import com.bean.Paragraph;

/**
 * Created by yjy on 16-10-24.
 */
public interface ParagraphService {

    public Paragraph find_paragraph_by_paragraph_id(Integer paragraph_id);

    public void add_paragraph(Integer userid, Integer chapter_id, Integer sequence, String content,
                              Double score , Integer score_num);

    public void update_paragraph(Paragraph paragraph);

    public void delete_paragraph(Paragraph paragraph);
}
