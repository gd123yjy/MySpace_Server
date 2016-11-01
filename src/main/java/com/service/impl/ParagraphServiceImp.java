package com.service.impl;

import com.bean.Chapter;
import com.bean.Paragraph;
import com.bean.User;
import com.dao.ParagraphDao;
import com.service.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yjy on 16-10-24.
 */

@Service
@Transactional
public class ParagraphServiceImp implements ParagraphService {

    @Autowired
    private ParagraphDao paragraphDao;

    public void setParagraphDao(ParagraphDao paragraphDao) {
        this.paragraphDao = paragraphDao;
    }

    @Override
    public void add_paragraph(Integer userid, Integer chapter_id, Integer sequence,
                              String content, Double score, Integer score_num) {
        Chapter chapter = new Chapter();
        chapter.setChapter_id(chapter_id);
        User user = new User();
        user.setUserid(userid);
        Paragraph paragraph = new Paragraph();
        paragraph.setChapter(chapter);
        paragraph.setUser(user);
        paragraph.setSequence(sequence);
        paragraph.setContent(content);
        paragraph.setScore(score);
        paragraph.setScore_num(score_num);
        paragraphDao.add_paragraph(paragraph);
    }

    @Override
    public Paragraph find_paragraph_by_paragraph_id(Integer paragraph_id) {
        return this.paragraphDao.find_paragraph_by_paragraph_id(paragraph_id);
    }


    @Override
    public void update_paragraph(Paragraph paragraph) {
        this.paragraphDao.update_paragraph(paragraph);

    }

    @Override
    public void delete_paragraph(Paragraph paragraph) {
        this.paragraphDao.delete_paragraph(paragraph);
    }

    @Override
    public List find_paragraphs_of_user(Integer user_id) {
        return paragraphDao.find_paragraphs_of_user(user_id);
    }

}
