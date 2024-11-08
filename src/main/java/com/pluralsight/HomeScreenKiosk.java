package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class HomeScreenKiosk {
    public static void main(String[] args) {
        //This Home Screen should allow the user to create a "New Order" or "Exit App"
        ArrayList<FoodOrder> food = getFoodOrder();
        ArrayList<FoodOrder> orders = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.nextLine();

        while(true){

        System.out.println("What would you like to do today?\n(1)New Order\n(2)Exit");
        System.out.println("Select option 1 or 2: ");

        switch (userInput){
            case("1"):{

            }
            case("2"):{
                System.out.println("Thank you goodbye!");
                System.exit(0);

            } default:
                System.out.println("Invalid option...");
                break;
        }
        }
    }
    public static ArrayList<FoodOrder> getFoodOrder() {
        ArrayList<FoodOrder> foodOrder = new ArrayList<FoodOrder>();
        try {
            FileReader fileReader = new FileReader("src/main/resources/CrockettDeli.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input ;
            bufferedReader.readLine();
            //Skipping the first line with the column headings
            while ((input = bufferedReader.readLine()) != null) {
                if (input.startsWith("Crockett Deli Shop")){
                    String[] description = input.split("|");
                    FoodOrder newFoodOrder = new FoodOrder((description[0]),
                            (description[1]),
                            (description[2]),
                    foodOrder.add(newFoodOrder);
                }
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
        return foodOrder;
    }
}
