package com.devcolibri.database;


import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;

public class Main2 {

    public static void main(String[] args) {
        String query = "SELECT* FROM users ";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/mydbtest?useUnicode=" +
                        "true&useJDBCCompliantTimezoneShift=" +
                        "true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root",
                "mysql")) {
            try (Statement statement = conn.createStatement()) {


                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    User user=new User();
                    user.setId(resultSet.getInt(1));
                    user.setName(resultSet.getString(2));
                    user.setAge(resultSet.getInt(3));
                    user.setEmail(resultSet.getString(4));
                    System.out.println(user);
                }
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

