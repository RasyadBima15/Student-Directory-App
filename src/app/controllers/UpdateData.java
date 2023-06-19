package app.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import app.config.Config;

public class UpdateData {
    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultset;
    
    public static void edit(){
        System.out.println();
        System.out.println("UPDATE DATA");

        String nama;
        String NIM;

        String newNama;
        String newNIM;
        String newProdi;

        Scanner input = new Scanner(System.in);

        System.out.print("Input Nama yang akan diubah : ");
        nama = input.nextLine();

        System.out.print("Input NIM yang akan diubah : ");
        NIM = input.nextLine();

        connect = Config.connection();

        try {
            int ID;
            boolean isActive = false;
            statement = connect.createStatement();
            resultset = statement.executeQuery("SELECT ID FROM tb_mahasiswa WHERE `nama` = '"+nama+"' AND `NIM` = '"+NIM+"';");

            while(resultset.next()){
                ID = resultset.getInt("ID");
                System.out.println();
                System.out.println("Edit Data");
                System.out.print("Nama  : ");
                newNama = input.nextLine();

                System.out.print("NIM : ");
                newNIM = input.nextLine();

                System.out.print("Prodi : ");
                newProdi = input.nextLine();

                Config.connection();
                try {
                    statement = connect.createStatement();
                    statement.executeUpdate("UPDATE `tb_mahasiswa` SET `Nama` = '"+newNama+"', `NIM` = '"+newNIM+"', `Prodi` = '"+newProdi+"' WHERE `ID` = '"+ID+"';");
                    System.out.println("Data berhasil diupdate");
                    System.out.println("=".repeat(40));
                    statement.close();
                    isActive = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }  
            if (!isActive){
                while(!resultset.next()){
                    System.out.println("Gagal mengupdate data! Data yang anda input tidak ada");
                    break;
                }
                System.out.println("=".repeat(40));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
