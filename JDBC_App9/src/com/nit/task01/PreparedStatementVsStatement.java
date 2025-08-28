package com.nit.task01;

import java.sql.*;

import com.nit.DBHandler.DBConnection;

public class PreparedStatementVsStatement {
   

    public static void main(String[] args) {
        int recordCount = 1000; // Number of records to insert
        long statementTime = 0;
        long preparedStatementTime = 0;

        try (Connection connection=DBConnection.connect()) {
            System.out.println("Database connected successfully.");

            // Using Statement
            String sqlStatement = "INSERT INTO users (id, name, email) VALUES (users_seq.NEXTVAL, 'User%d', 'user%d@example.com')";
            try (Statement statement = connection.createStatement()) {
                long start = System.currentTimeMillis();
                for (int i = 1; i <= recordCount; i++) {
                    statement.executeUpdate(String.format(sqlStatement, i, i));
                }
                long end = System.currentTimeMillis();
                statementTime = end - start;
            }

            // Using PreparedStatement
            String sqlPreparedStatement = "INSERT INTO users (id, name, email) VALUES (users_seq.NEXTVAL, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlPreparedStatement)) {
                long start = System.currentTimeMillis();
                for (int i = 1; i <= recordCount; i++) {
                    preparedStatement.setString(1, "User" + i);
                    preparedStatement.setString(2, "user" + i + "@example.com");
                    preparedStatement.executeUpdate();
                }
                long end = System.currentTimeMillis();
                preparedStatementTime = end - start;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Output results
        System.out.println("Time taken using Statement: " + statementTime + " ms");
        System.out.println("Time taken using PreparedStatement: " + preparedStatementTime + " ms");
    }
}
