package Persistance.DataMapper;


import Persistance.MySql;

import java.sql.Connection;

public abstract class DataMapper {

    // DataMapper Principal qui est extends

    protected Connection connection;

    public DataMapper() {
        try {
            connection = MySql.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
