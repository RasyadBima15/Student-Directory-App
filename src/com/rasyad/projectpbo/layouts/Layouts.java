package src.com.rasyad.projectpbo.layouts;

import java.util.InputMismatchException;
import java.util.Scanner;

import src.com.rasyad.projectpbo.controllers.DeleteData;
import src.com.rasyad.projectpbo.controllers.GetData;
import src.com.rasyad.projectpbo.controllers.InsertData;
import src.com.rasyad.projectpbo.controllers.UpdateData;

public class Layouts {
    public static void run() {
        System.out.println("1. Read Data");
        System.out.println("2. Insert Data");
        System.out.println("3. Update Data");
        System.out.println("4. Delete Data");
        System.out.println("5. Exit");
        System.out.println("=".repeat(40));

        showChoice();
    }

    public static void showChoice() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Pilih : ");
            int pilih = input.nextInt();
            switch (pilih) {
                case 1:
                    GetData.get();
                    run();
                    break;
                case 2:
                    InsertData.insert();
                    run();
                    break;
                case 3:
                    UpdateData.edit();
                    run();
                    break;
                case 4:
                    DeleteData.delete();
                    run();
                    break;
                case 5:
                    System.out.println("Sampai Jumpa Kembali");
                    System.out.println("=".repeat(40));
                    break;
                default:
                    System.out.println("Inputan hanya berupa angka 1 sampai 5");
                    System.out.println("=".repeat(40));
                    run();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Inputan hanya berupa angka");
            System.out.println("=".repeat(40));
            run();
        }
    }
}
