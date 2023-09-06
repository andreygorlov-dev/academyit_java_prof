package org.example.orm2;

import org.example.Config;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Orm implements AutoCloseable {
    private static Orm object;
    private Connection connection;
    private Statement statement;

    private Orm() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(Config.URL_DB, Config.LOGIN, Config.PASSWORD);
        statement = connection.createStatement();
    }

    public static Orm getInstance() throws SQLException, ClassNotFoundException {
        if (object == null) {
            object = new Orm();
        }
        return object;
    }

    public ResultSet select(String table, String[] fields, String where) throws SQLException {

        String sqlFields = "*";
        if (fields.length != 0) {
            sqlFields = String.join(", ", fields);
        }
        String sqlWhere = "";
        if (where.length() != 0) {
            sqlWhere = " WHERE ".concat(where);
        }

        return statement.executeQuery("SELECT ".concat(sqlFields).concat(" FROM ").concat(table).concat(sqlWhere));
    }

    public int insert(String table, Map<String, String> values) throws SQLException {
        String sql = "INSERT INTO ".concat(table);
        String columns = "";
        String vals = "";
        if (!values.isEmpty()) {
            int i = 0;
            for (Map.Entry<String,String> item : values.entrySet()) {
                columns = columns.concat("`")
                        .concat(item.getKey())
                        .concat("`")
                        .concat(i < values.size() - 1 ? "," : "");
                vals = vals.concat(isPrice(item.getKey()) ? "" : "'")
                        .concat(item.getValue())
                        .concat(isPrice(item.getKey()) ? "" : "'")
                        .concat(i < values.size() - 1 ? "," : "");
                i++;
            }
            sql = sql.concat("(").concat(columns).concat(") VALUES (").concat(vals).concat(")");
            System.out.println(sql);
            return statement.executeUpdate(sql);
        }
        throw new SQLException("Ошибка! Не указаны параметры");
    }

    private boolean isPrice(Object colName) {
        return "price".equalsIgnoreCase((String) colName);
    }

    public int update(String table, Map<String, String> values, String where) throws SQLException {
        String sql = "UPDATE ".concat(table).concat(" SET ");
        String update = "";
        if (!values.isEmpty()) {
            int i = 0;
            for (Map.Entry<String,String> item : values.entrySet()) {
                update = update.concat("`")
                        .concat(item.getKey())
                        .concat("` = ")
                        .concat(" '")
                        .concat(item.getValue())
                        .concat("'")
                        .concat(i < values.size() - 1 ? "," : "");
                i++;
            }
            String whereSql = "";
            if (where.length() != 0) {
                whereSql = " WHERE ".concat(where);
            }
            sql = sql.concat(update).concat(whereSql);
            System.out.println(sql);
            return statement.executeUpdate(sql);
        }

        throw new SQLException("Ошибка! Не указаны параметры");
    }

    public int delete(String table, String where) throws SQLException {
        String sql = "DELETE FROM ".concat(table);
        String whereSql = "";
        if (where.length() != 0) {
            whereSql = " WHERE ".concat(where);
        }
        sql = sql.concat(whereSql);
        return statement.executeUpdate(sql);
    }

    public int addCart(String nameItem) throws SQLException {
        try (ResultSet resultSet = select("items", new String[]{"item_id"}, "title = '" + nameItem + "'")) {
            //Товар будет уникальный по имени
            if (resultSet.next()) {
                int id = resultSet.getInt("item_id");
                try (ResultSet resultSet2 = select("cart", new String[]{"count"}, "item_id = " +  id)) {
                    //Товар будет уникальный по имени
                    if (resultSet2.next()) {
                        int count = resultSet2.getInt("count");
                        count++;
                        Map<String, String> map = new HashMap<>();
                        map.put("count", String.valueOf(count));
                        return update("cart", map, "item_id = " +  id);
                    }

                    Map<String, String> map = new HashMap<>();
                    map.put("count", "1");
                    map.put("item_id", String.valueOf(id));
                    return insert("cart", map);
                }
            }
            return 0;
        }
    }


    @Override
    public void close() throws Exception {
        connection.close();
        statement.close();
    }
}
