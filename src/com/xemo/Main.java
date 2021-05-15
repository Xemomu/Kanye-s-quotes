package com.xemo;

import com.xemo.service.KanyeService;
import org.json.JSONException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws JSONException {

        Scanner sc = new Scanner(System.in);
        int userNumber;
        do {
            System.out.println("Please enter a number between 5-20: ");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next();
            }
            userNumber = sc.nextInt();
        } while (userNumber < 5 || userNumber > 20);
        System.out.println("Thank you! You chose to get '" + userNumber + "' quotes form Kanye!");
        KanyeService kanyeService = new KanyeService(userNumber);

        for(int i = 0; i < userNumber; i++){
            kanyeService.getKanyeQuote();
        }

        System.out.println(kanyeService);
    }
}
