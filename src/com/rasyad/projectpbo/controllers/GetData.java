package src.com.rasyad.projectpbo.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import src.com.rasyad.projectpbo.config.MyConfig;
import src.com.rasyad.projectpbo.models.Mahasiswa;

public class GetData {
    
    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultset;

    public static void get(){
        connect = MyConfig.connection();
        try {
            boolean isActive = false;
            List<Mahasiswa> listMahasiswa = new ArrayList<>();
            statement = connect.createStatement();
            resultset = statement.executeQuery("SELECT * FROM tb_mahasiswa ORDER BY ID DESC");

            while(resultset.next()){
                String nama = resultset.getString("Nama");
                String NIM = resultset.getString("NIM");
                String prodi = resultset.getString("Prodi");
                listMahasiswa.add(new Mahasiswa(nama, NIM, prodi));
                isActive = true;
            }

            if(!isActive){
                System.out.println("DATA KOSONG");
            } else if (isActive){
                System.out.println();
                System.out.println("READ DATA");
            }

            for (int i = 0; i < listMahasiswa.size(); i++){
                System.out.println("Nama: " + listMahasiswa.get(i).getNama());
                System.out.println("NIM: " + listMahasiswa.get(i).getNIM());
                System.out.println("Prodi: " + listMahasiswa.get(i).getProdi());
                System.out.println();
            }
            System.out.println("=".repeat(40));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
