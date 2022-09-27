package edu.javacourse.city.dao;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnectionBuilder implements ConnectionBuilder {
    private final static Logger logger = Logger.getLogger(PoolConnectionBuilder.class);
    private DataSource dataSource;

    public PoolConnectionBuilder() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/cityRegister");
        } catch (NamingException e) {
            logger.error("", e);
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
