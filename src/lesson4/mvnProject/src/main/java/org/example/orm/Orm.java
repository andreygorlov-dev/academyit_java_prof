package org.example.orm;

import org.example.Config;

import java.sql.*;

public class Orm {

    private static Connection connection;

    private Orm() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(org.example.Config.URL_DB, org.example.Config.LOGIN, Config.PASSWORD);
        }
        return connection;
    }

    public static ResultSet select(String sql) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

    public static long execute(String sql) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            return preparedStatement.executeUpdate();
        }
    }

}
