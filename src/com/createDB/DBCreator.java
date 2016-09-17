package com.createDB;

import com.bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.internal.SessionFactoryRegistry;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.metamodel.source.internal.MetadataBuilderImpl;
import org.hibernate.metamodel.source.internal.SessionFactoryBuilderImpl;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.util.List;

/**
 * Created by yjy on 16-9-11.
 */
public class DBCreator {
    public static void main(String[] arg){
        //创建关系
        Configuration configuration = new Configuration().configure();
        SchemaExport schemaExport = new SchemaExport(configuration);
        schemaExport.create(true,true);

        //创建管理员
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        User user = new User();
        user.setAdmin(true);
        user.setEmail("1234567@163.com");
        user.setPassword("111111");
        user.setUsername("root");
        session.save(user);
        transaction.commit();

        //关闭数据库连接
        if (session.isOpen()){
            session.close();
        }
    }
}
