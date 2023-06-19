package src.com.rasyad.projectpbo.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import src.com.rasyad.projectpbo.config.MyConfig;

public class DeleteData {
    private static Connection connect;
    private static Statement statement;
    
    public static void delete(){
        System.out.println();
        System.out.println("DELETE DATA");

        String nama;
        String NIM;

        Scanner input = new Scanner(System.in);

        System.out.println("Input Data yang akan dihapus");

        System.out.print("Nama : ");
        nama = input.nextLine();

        System.out.print("NIM  : ");
        NIM = input.nextLine();

        connect = MyConfig.connection();
        try {
            statement = connect.createStatement();
            int isSuccess = statement.executeUpdate("DELETE FROM `tb_mahasiswa` WHERE `Nama` = '"+nama+"' AND `NIM` = '"+NIM+"';");

            if (isSuccess != 0) {
                System.out.println("Data berhasil dihapus");
                System.out.println("=".repeat(40));
            } else if (isSuccess == 0){
                System.out.println("Data gagal dihapus, karena data tidak ditemukan");
                System.out.println("=".repeat(40));
            }

            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
