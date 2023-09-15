package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseModel implements AutoCloseable {

    private static BaseModel baseModel;
    private final Connection connection;
    private final Statement statement;

    private BaseModel() throws ClassNotFoundException, SQLException {
        Class.forName(Config.DRIVER);
        String url = "jdbc:mysql://" + Config.SERVER + "/" + Config.DB;
        connection =  DriverManager.getConnection(url, Config.LOGIN, Config.PASSWORD);
        statement = connection.createStatement();
    }

    public static BaseModel newInstance() throws SQLException, ClassNotFoundException {
        if (baseModel == null) {
            baseModel = new BaseModel();
        }

        return baseModel;
    }

    //ORM method select
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

    //ORM method insert
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
                vals = vals.concat(isIntParam(item.getKey()) ? "" : "'")
                        .concat(item.getValue())
                        .concat(isIntParam(item.getKey()) ? "" : "'")
                        .concat(i < values.size() - 1 ? "," : "");
                i++;
            }
            sql = sql.concat("(").concat(columns).concat(") VALUES (").concat(vals).concat(")");
            System.out.println(sql);
            return statement.executeUpdate(sql);
        }
        throw new SQLException("Ошибка! Не указаны параметры");
    }

    private boolean isIntParam(String colName) {
        return "good_id|user_id|count".contains(colName);
    }

    //ORM method update
    public int update(String table, Map<String, String> values, String where) throws SQLException {
        String sql = "UPDATE ".concat(table).concat(" SET ");
        String update = "";
        if (!values.isEmpty()) {
            int i = 0;
            for (Map.Entry<String,String> item : values.entrySet()) {
                update = update.concat("`")
                        .concat(item.getKey())
                        .concat("` = ")
                        .concat(item.getValue())
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

    //ORM method delete
    public int delete(String table, String where) throws SQLException {
        String sql = "DELETE FROM ".concat(table);
        String whereSql = "";
        if (where.length() != 0) {
            whereSql = " WHERE ".concat(where);
        }
        sql = sql.concat(whereSql);
        return statement.executeUpdate(sql);
    }

    public List<Good> getItems() throws SQLException {
        List<Good> goods = new ArrayList<>();
        try (ResultSet resultSet = select("GOODS", new String[0], "")) {
            while (resultSet.next()) {
                goods.add(new Good(resultSet.getLong("good_id"),
                        resultSet.getString("title"),
                        resultSet.getDouble("price"),
                        resultSet.getString("info"),
                        resultSet.getString("img")));
            }
        }
        return goods;
    }

    public List<ItemCart> getCart(long user_id) throws SQLException {
        String sql = "SELECT g.good_id as id, title, price, count, user_id FROM goods g INNER JOIN cart c ON g.good_id=c.good_id where c.user_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, user_id);
            try (ResultSet data = ps.executeQuery()) {
                List<ItemCart> cart = new ArrayList<>();
                while (data.next()) {
                    cart.add(new ItemCart(data.getInt("id"),
                            data.getInt("user_id"),
                            data.getInt("count"),
                            data.getString("title"),
                            data.getInt("price")));
                }
                return cart;
            }
        }
    }

    public boolean isEmptyCart(long user_id) throws SQLException {
        try (ResultSet resultSet = select("CART", new String[0], "user_id = " + user_id)) {
            return !resultSet.next();
        }
    }

    private boolean isEmptyCart(int id, long user_id) throws SQLException {
        try (ResultSet resultSet = select("CART", new String[0], "good_id = " + id + " AND user_id = " + user_id)) {
            return !resultSet.next();
        }
    }

    public boolean addItem(int id, long user_id) throws SQLException {
        if (!isEmptyCart(id, user_id)) {
            Map<String, String> update = new HashMap<>();
            update.put("count", "count + 1");
            return update("cart", update, "good_id = " + id + " AND user_id = " + user_id) > 0;//preparedStatement.executeUpdate() > 0;
        } else {
            Map<String, String> insert = new HashMap<>();
            insert.put("good_id", String.valueOf(id));
            insert.put("user_id", String.valueOf(user_id));
            insert.put("count", "1");
            return insert("cart", insert) > 0;
        }
    }

    public User getUser(String login, String password) throws SQLException {
        try (ResultSet data = select("users", new String[] {"id", "login", "pass", "name"}, "login = '" + login + "' AND pass = '" + password + "'")) {
            if (data.next()) {
                return new User(data.getLong("id"), data.getString("login"), data.getString("pass"), data.getString("name"));
            }
            return null;
        }
    }

    @Override
    public void close() throws SQLException {
        connection.close();
        statement.close();
    }

    public User regUser(String login, String password, String name) throws SQLException {
        try (ResultSet data = select("users", new String[] {"id", "login", "pass", "name"}, "login = '" + login + "'")) {
            if (data.next()) {
                return null;
            } else {
                if (insertUser(login, password, name)) {
                    return getUser(login, password);
                } else {
                    return null;
                }
            }
        }
    }

    private boolean insertUser(String login, String password, String name) throws SQLException {
        Map<String, String> insert = new HashMap<>();
        insert.put("login", login);
        insert.put("pass", password);
        insert.put("name", name);
        return insert("users", insert) > 0;
    }

    public boolean checkout(long user_id) throws SQLException {
        String sql = "INSERT INTO `order`(`user_id`, `good_id`, `count`, `date_order`) " +
                "SELECT `user_id`, `good_id`, `count`,  NOW() FROM `cart` " +
                "WHERE `user_id` = " + user_id;
        if (statement.executeUpdate(sql) == 0) {
             return false;
        } else {
            return delete("cart", "`user_id` = " + user_id) > 0;
        }
    }

}
