package com.dao.impl;

import com.bean.Chapter;
import com.bean.Paragraph;
import com.dao.ChapterDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjy on 16-10-26.
 */

@Repository
public class ChapterDapImp implements ChapterDao {


    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public List<List<Paragraph>> find_paragraph_of_chapter(Integer chapter_id) {
        Session session = sessionFactory.openSession();
        List<List<Paragraph>> res = new ArrayList<List<Paragraph>>();

        String hql = "select max(sequence) from Paragraph paragraph where chapter_id = " + chapter_id;
        Query query = session.createQuery(hql);
        Integer max_sequence = (Integer)query.uniqueResult();
        if (max_sequence == null) {
            session.close();
            return null;
        }

        //得到res[所有段落][该段落排名前3+随机2]
        for (int i = 0; i <= max_sequence; ++i) {
            //在众多版本的段落i中获得大众评分最高分的前三个，纳入最终结果
            hql = "from Paragraph paragraph where chapter_id = :chapter_id and sequence = :sequence order by paragraph.score desc";
            query = session.createQuery(hql);
            query.setInteger("chapter_id", chapter_id);
            query.setInteger("sequence", i);
            query.setFirstResult(0);
            query.setMaxResults(3);
            List<Paragraph> high_score_paragraphs = query.list();

            //在众多版本的段落i中获得随机5个
            hql = "from Paragraph paragraph where chapter_id = :chapter_id and sequence = :sequence order by rand()";
            //hql = "from Paragraph paragraph where chapter_id = :chapter_id and sequence = :sequence order by id * dbms_random.value";
            query = session.createQuery(hql);
            query.setInteger("chapter_id", chapter_id);
            query.setInteger("sequence", i);
            query.setFirstResult(0);
            query.setMaxResults(5);

            List<Paragraph> random_score_paragraphs = query.list();

            //从随机到的5个中取出2个加入到最终结果中
            int count = 0;
            for (int j = 0; count < 2 && j < random_score_paragraphs.size(); ++j) {
                boolean isDuplicate = false;
                for (int k = 0; k < high_score_paragraphs.size(); ++k) {
                    if(random_score_paragraphs.get(j).getParagraph_id() == high_score_paragraphs.get(k).getParagraph_id()) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    high_score_paragraphs.add(random_score_paragraphs.get(j));
                    ++count;
                }
            }
            res.add(high_score_paragraphs);
        }

        session.close();
        return res;
    }

    @Override
    public void add_chapter(Chapter chapter) {
        Session session = sessionFactory.openSession();
        session.save(chapter);
        session.close();
    }
}
