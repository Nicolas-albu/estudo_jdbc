package com.databaseConnection;

import com.utils.ConfigData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


class connectionFactory {
    public static Connection create() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    ConfigData.getUrlDatabase(),
                    ConfigData.getDB_USER(),
                    ConfigData.getDB_PASSWORD());

        } catch (SQLException error) {
            error.printStackTrace();
        }

        return connection;
    }
}

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private static Connection connection;

    private DatabaseConnection() {
        connection = connectionFactory.create();
    }

    public static DatabaseConnection getInstance() {
        if (instance == null)
            instance = new DatabaseConnection();
        return instance;
    }

    public static String getNameEmployee(int codeRegistration) {
        String commandQuery = "SELECT \"NOM_FUNC\" FROM public.\"TBL_FUNCIONARIO\" WHERE \"COD_MAT\" = " + codeRegistration;
        String columnName = "NOM_FUNC";
        String nameEmployee = null;

        try (PreparedStatement instructionSql = connection.prepareStatement(commandQuery);
             ResultSet resultQuery = instructionSql.executeQuery()) {

            while (resultQuery.next()) {
                nameEmployee = resultQuery.getString(columnName);
            }

        } catch (SQLException error) {
            error.printStackTrace();
        }

        return nameEmployee;
    }
}
