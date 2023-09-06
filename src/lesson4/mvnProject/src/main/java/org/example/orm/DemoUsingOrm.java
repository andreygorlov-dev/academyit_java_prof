package org.example.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoUsingOrm {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try(ResultSet resultSet = Orm.select("SELECT * FROM items")) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("title"));
            }
        }
    }

}
