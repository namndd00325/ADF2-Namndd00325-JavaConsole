/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.controller;

import java.util.Scanner;

/**
 *
 * @author Nam Nguyen
 */
public class MenuConsole {

    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        menu.creatMenu();
    }

    public void creatMenu() {
        while (true) {
            System.out.println("==============Student Manager============");
            System.out.println("1. Student list");
            System.out.println("2. Add student");
            System.out.println("3. Edit student");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.println("=========================================");
            System.out.println("Please enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            String strchoice = scanner.nextLine();
            System.out.println(strchoice);
            int choice = 0;
            try {
                choice = Integer.parseInt(strchoice); // Ép kiểu.
                System.out.println("Choice: " + choice);
            } catch (Exception e) {
                // Cần có phần lưu log lỗi ở đây
                System.err.println("Please enter a number: ");
                continue;

            }

            if (choice == 5) {
                break;
            } else {
                switch (choice) {
                    case 1: // Do something.
                        System.out.println("1. Student list");
                        break;
                    case 2: // Do somthing.
                        System.out.println("2. Add student");
                        break;
                    case 3: // Do something.
                        System.out.println("3. Edit student");
                        break;
                    case 4: // Do something.
                        System.out.println("4. Delete student");
                        break;
                    default: // Do something.

                }

            }

        }

    }

}
