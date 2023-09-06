package org.example.orm2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        try (Orm orm = Orm.getInstance()) {
            showAllData(orm);

            //Имитация ввода
            Map<String, String> insert = new HashMap<>();
            insert.put("title", "молоко");
            insert.put("price", "60");
            insert.put("info", "информация о молоке");

            if (orm.insert("items", insert) > 0) {
                System.out.println("Товар добавлен");
                showAllData(orm);
            } else {
                System.out.println("Товар не добавлен");
            }

            System.out.println("-----------------------------------------------------------");
            Map<String, String> update = new HashMap<>();
            update.put("price", "80");
            update.put("info", "информация о молоке upd");

            if (orm.update("items", update, "`title` = 'молоко'") > 0) {
                System.out.println("Товар обновлён");
                showAllData(orm);
            } else {
                System.out.println("Товар не обновлен");
            }

            System.out.println("-----------------------------------------------------------");
            if (orm.delete("items","`title` = 'молоко'") > 0) {
                System.out.println("Товар удален");
                showAllData(orm);
            } else {
                System.out.println("Товар не удален");
            }

            System.out.println("-----------------------------------------------------------");
            if (orm.addCart("Audi") > 0) {
                System.out.println("Товар добавлен в корзину");
                showAllDataCart(orm);
            } else {
                System.out.println("Товара нет");
            }

            System.out.println("-----------------------------------------------------------");
            if (orm.addCart("Audi") > 0) {
                System.out.println("Товар добавлен в корзину");
                showAllDataCart(orm);
            } else {
                System.out.println("Товара нет");
            }

            System.out.println("-----------------------------------------------------------");
            if (orm.addCart("Audi") > 0) {
                System.out.println("Товар добавлен в корзину");
                showAllDataCart(orm);
            } else {
                System.out.println("Товара нет");
            }

            System.out.println("-----------------------------------------------------------");
            if (orm.addCart("BMW") > 0) {
                System.out.println("Товар добавлен в корзину");
                showAllDataCart(orm);
            } else {
                System.out.println("Товара нет");
            }
        }
    }

    private static void showAllDataCart(Orm orm) throws SQLException {
        try (ResultSet resultSet = orm.select("cart", new String[0], "")) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("item_id") + " " + resultSet.getInt("count"));
            }
        }
    }

    private static void showAllData(Orm orm) throws SQLException {
        try (ResultSet resultSet = orm.select("items", new String[0], "")) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("item_id") + " " + resultSet.getString("title") + " " + resultSet.getString("info") + " " + resultSet.getDate("date_create") + " " + resultSet.getInt("price"));
            }
        }
    }
}
