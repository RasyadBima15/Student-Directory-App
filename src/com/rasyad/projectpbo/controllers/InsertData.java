package src.com.rasyad.projectpbo.controllers;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import src.com.rasyad.projectpbo.config.MyConfig;

public class InsertData {
    private static Connection connect;
    private static Statement statement;
    
    public static void insert(){
        System.out.println();
        System.out.println("CREATE DATA");

        String nama;
        String NIM;
        String prodi;

        Scanner input = new Scanner(System.in);

        System.out.print("Nama  : ");
        nama = input.nextLine();

        System.out.print("NIM : ");
        NIM = input.nextLine();

        System.out.print("Prodi : ");
        prodi = input.nextLine();

        connect = MyConfig.connection();

        try {
            statement = connect.createStatement();
            statement.executeUpdate("INSERT INTO `tb_mahasiswa` (`Nama`, `NIM`, `Prodi`) VALUES ('"+nama+"', '"+NIM+"', '"+prodi+"')");

            System.out.println("Data berhasil di simpan");
            System.out.println("=".repeat(40));

            statement.close();
            
        } catch (Exception e) {
            System.out.println();
            //NIM bersifat unique
            System.out.println("Gagal menambahkan data! NIM " + NIM + " sudah ada pada database");
            System.out.println("=".repeat(40));
        }
    }
}
