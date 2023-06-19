package app.controllers;

import java.sql.Connection;
import java.sql.Statement;

import app.config.Config;

public class DeleteData {
    private static Connection connect;
    private static Statement statement;

    public static void deleteAll() {
        connect = Config.connection();
        try {
            statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM `tb_mahasiswa`;");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
