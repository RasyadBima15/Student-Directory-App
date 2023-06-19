package app.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.config.Config;
import app.models.Mahasiswa;

public class GetData {
    
    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultset;

    public static List<Mahasiswa> get(){
        connect = Config.connection();
        List<Mahasiswa> listMahasiswa = new ArrayList<>();
        try {
            statement = connect.createStatement();
            resultset = statement.executeQuery("SELECT * FROM tb_mahasiswa ORDER BY NIM ASC");

            while(resultset.next()){
                String nama = resultset.getString("Nama");
                String NIM = resultset.getString("NIM");
                String prodi = resultset.getString("Prodi");
                listMahasiswa.add(new Mahasiswa(nama, NIM, prodi));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMahasiswa;
    }
}
