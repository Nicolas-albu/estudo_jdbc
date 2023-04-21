package com.estudando;

import com.databaseConnection.DatabaseConnection;

/**
 * @author nicolasalbuquerque581@gmail.com
 */
public class App {
    public static void main(String[] args) {
//        try {
//            String employeeName = DatabaseConnection.getEmployeeName(1);
//            System.out.println(employeeName);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//

//        String name = DatabaseConnection.getEmployeeName(1);
//        System.out.println(name);

        DatabaseConnection db = DatabaseConnection.getInstance();

        System.out.println(DatabaseConnection.getNameEmployee(1));

    }
}
