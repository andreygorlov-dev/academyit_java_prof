package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class DemoDb implements AutoCloseable{

    private Connection connection;

    public DemoDb() throws SQLException, ClassNotFoundException {
        init();
    }

    private void init() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(Config.URL_DB, Config.LOGIN, Config.PASSWORD);
    }

    public Connection getConnection() {
        return connection;
    }

    public int update(String title, int price) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE items SET price = ? WHERE title = ?")
        ) {
            preparedStatement.setInt(1, price);
            preparedStatement.setString(2, title);
            return preparedStatement.executeUpdate();
        }
    }

    public void showItems() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `items`");
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                System.out.printf("Автомобиль %s стоит %d \n", resultSet.getString("title"), resultSet.getInt("price"));
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название авто и стоимость авто через дефис");
        String[] mas = reader.readLine().split("-");
        try (DemoDb demoDb = new DemoDb()) {
            System.out.println("До изменений");
            demoDb.showItems();
            demoDb.update(mas[0], Integer.parseInt(mas[1]));
            System.out.println("После изменений");
            demoDb.showItems();
        }


    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
//try with resources
}
