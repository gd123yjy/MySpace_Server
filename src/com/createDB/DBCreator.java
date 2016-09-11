package com.createDB;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Created by yjy on 16-9-11.
 */
public class DBCreator {
    public static void main(String[] arg){
        Configuration configuration = new Configuration().configure();
        SchemaExport schemaExport = new SchemaExport(configuration);
        schemaExport.create(true,true);
    }
}
