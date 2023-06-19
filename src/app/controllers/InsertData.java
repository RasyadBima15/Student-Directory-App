package app.controllers;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import app.config.Config;
import app.models.Mahasiswa;


public class InsertData {
    private static Connection connect;
    private static Statement statement;

    public static void saveToDatabase(List<Mahasiswa> listMahasiswa) {
        connect = Config.connection();
        try {
            statement = connect.createStatement();
            for (int i = 0; i < listMahasiswa.size(); i++){
                statement.executeUpdate("INSERT INTO `tb_mahasiswa` (`ID`, `Nama`, `NIM`, `Prodi`) VALUES ('"+(i+1)+"','"+listMahasiswa.get(i).getNama()+"', '"+listMahasiswa.get(i).getNIM()+"', '"+listMahasiswa.get(i).getProdi()+"')");
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
