package com.pluralsight;

import com.pluralsight.Ingredients.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public  class HomeScreenKiosk {
    public static void main(String[] args) {
        //This Home Screen should allow the user to create a "New Order" or "Exit App"
        Scanner keyboard = new Scanner(System.in);


        while (true) {
            System.out.println("Please use the NumberPad to select options?");
            System.out.println("What would you like to do today?\n(1)New Order\n(2)Exit");
            System.out.println("Select option 1 or 2: ");
            String userInput = keyboard.nextLine();

            switch (userInput) {
                case ("1"):
                    customerOrder();
                    break;
                case ("2"):
                    System.out.println("Thank you goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option...");
                    break;
            }
        }
    }

    // All methods and functions
    public static void customerOrder() {
        while (true) {
            Scanner keyboard = new Scanner(System.in);
            CurrentOrder currentOrder = new CurrentOrder();
            System.out.println("Please use the NumberPad to select options?");
            System.out.println("What kind of Order do you want to place?\n" +
                    "(1)Customizable Sandwich\n" +
                    "(2)Popular Sandwiches\n" +
                    "(3)Drinks\n" +
                    "(4)Chips\n" +
                    "(5)Check-Out\n" +
                    "(6)Cancel Order\n");
            String userInput = keyboard.nextLine();

            switch (userInput) {
                case ("1"):
                    CustomizableSandwich(currentOrder);
                case ("2"):
                    //PopularSandwiches(currentOrder);
                case ("3"):
                    CustomizableDrink(currentOrder);
                case ("4"):
                    CustomizableChips(currentOrder);
                case ("5"):
                    checkOut(currentOrder);
                case ("6"):
                    System.out.println("Are you sure you want to Exit Order Menu?" +
                            "\n (1)Yes" +
                            "\n (2)NO");
                    String confirmExit = keyboard.nextLine();
                    switch (confirmExit) {
                        case ("1"):
                            System.out.println("Thank you goodbye!");
                            System.exit(0);
                            break;
                        case ("2"):
                            System.out.println("Returning....");
                            break;
                    }
                default:
                    System.out.println("Invalid option...");

            }

        }
    }
    //public static PopularSandwiches PopularSandwiches() {
    //   Scanner keyboard = new Scanner(System.in);

    //   System.out.println("Enter the type of sandwich: \n"+"(1)BLT\n(2)Turkey,Bacon & Avocado\n(3)Ham & Swiss\n(4)Chicken Club\n");
    //   String type = keyboard.nextLine();
    //   switch(type){
    //   case ("1"):
    //       return BLT;
    //   }

    //   System.out.println("Would you like it toasted? (yes/no)");
    //   boolean toasted = keyboard.nextLine().equalsIgnoreCase("yes");

    //   System.out.println("Choose size:\n(1) Small\n(2) Medium\n(3) Large");
    //   int sizeChoice = Integer.parseInt(keyboard.nextLine());
    //   double sizePrice;
    //   switch (sizeChoice) {
    //       case 1 -> sizePrice = 5.00;
    //       case 2 -> sizePrice = 7.00;
    //       case 3 -> sizePrice = 9.00;
    //       default -> {
    //           System.out.println("Invalid size. Defaulting to Small.");
    //           sizePrice = 5.00;
    //       }
    //   }

    //   return new PopularSandwiches(type, toasted, sizePrice);
    //
    public static void CustomizableSandwich(CurrentOrder currentOrder) {
        Scanner keyboard = new Scanner(System.in);

        // Select sandwich size
        System.out.println("""
            Select your sandwich size:
            (1) Small (4 inches)
            (2) Medium (8 inches)
            (3) Large (12 inches)
            """);
        String size;
        switch (keyboard.nextLine()) {
            case "1" -> size = "Small";
            case "2" -> size = "Medium";
            case "3" -> size = "Large";
            default -> {
                size = "Medium";
                System.out.println("Invalid choice. Defaulting to Medium size.");
            }
        }

        // Select bread type
        System.out.println("""
            Select your bread:
            1) White
            2) Wheat
            3) Rye
            4) Wrap
            """);
        String bread;
        switch (keyboard.nextLine()) {
            case "1" -> bread = "White";
            case "2" -> bread = "Wheat";
            case "3" -> bread = "Rye";
            case "4" -> bread = "Wrap";
            default -> {
                bread = "White";
                System.out.println("Invalid choice. Defaulting to White bread.");
            }
        }

        // Toasted option
        boolean toasted;
        System.out.println("Do you want your sandwich toasted?\n(1) Yes\n(2) No");
        toasted = keyboard.nextLine().equals("1");

        CustomSandwiches sandwich = new CustomSandwiches(size,toasted);

        int option;
        while (true) {
            System.out.println("""
                Toppings and sides:
                (1) Meat
                (2) Cheese
                (3) Other toppings
                (4) Sauces
                (5) Remove Selection
                (0) Done
                """);
            option = Integer.parseInt(keyboard.nextLine().trim());
            switch (option) {
                case 1 -> addMeatToppings(sandwich);
                case 2 -> addCheeseToppings(sandwich);
                case 3 -> addRegularToppings(sandwich);
                case 4 -> addSauces(sandwich);
                case 5 -> removeSandwichSelection(sandwich);
                case 0 -> {
                    currentOrder.addItem(sandwich);
                    currentOrder.listOrder();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static void CustomizableDrink(CurrentOrder currentOrder) {
        Scanner keyboard = new Scanner(System.in);

        // Select drink size
        System.out.println("""
                Select your sandwich size:
                (1) Small
                (2) Medium
                (3) Large
                """);
        String size;
        switch (keyboard.nextLine()) {
            case "1" -> size = "Small";
            case "2" -> size = "Medium";
            case "3" -> size = "Large";
            default -> {
                size = "Medium";
                System.out.println("Invalid choice. Defaulting to Medium size.");
            }
        }
        Drinks beverages = new Drinks(size);int option;
        while (true) {
            System.out.println("""
                Toppings and sides:
                (1) Add Drink
                (2) Remove Drink
                (0) Done
                """);
            option = Integer.parseInt(keyboard.nextLine().trim());
            switch (option) {
                case 1 -> addDrink(beverages);
                case 2 -> removeDrinks(beverages);
                case 0 -> {
                    currentOrder.addDrinkItem(beverages);
                    currentOrder.listOrder();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }


        // Select drink type
        System.out.println("""
                Select your bread:
                (1) Coke-Cola
                (2) Sprite
                (3) Dr.Pepper
                (4) Lemon-aid
                (5) Water
                (0) Done
                """);
        String drinks;
        switch (keyboard.nextLine()) {
            case "1" -> drinks = "Coke-Cola";
            case "2" -> drinks = "Sprite";
            case "3" -> drinks = "Dr.Pepper";
            case "4" -> drinks = "Lemon-aid";
            case "5" -> drinks = "Water";
            case "0" -> {
                currentOrder.addDrinkItem(beverages);
                currentOrder.listOrder();
                return;
            }
            default -> {
                drinks = "Water";
                System.out.println("Invalid choice. Defaulting to Water for drink.");
                currentOrder.listOrder();
            }
        }
    }
    }
    public static void CustomizableChips(CurrentOrder currentOrder){
        Scanner keyboard = new Scanner(System.in);

        // Select drink size
        System.out.println("""
                Select your Chips:
                (1) Bag Chips
              
                """);
        String size;
        switch (keyboard.nextLine()) {
            case "1" -> size = "Small";
            case "2" -> size = "Medium";
            case "3" -> size = "Large";
            default -> {
                size = "Medium";
                System.out.println("Invalid choice. Defaulting to Medium size.");
            }
        }
        Chips bagChips = new Chips(size);int option;
        while (true) {
            System.out.println("""
                    Toppings and sides:
                    (1) Add Chips
                    (2) Remove Chips
                    (0) Done
                    """);
            option = Integer.parseInt(keyboard.nextLine().trim());
            switch (option) {
                case 1 -> addChips(bagChips);
                case 2 -> removeChips(bagChips);
                case 0 -> {
                    currentOrder.addChipItem(bagChips);
                    currentOrder.listOrder();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");

            }
        }
    }

        //Added to Sandwich
    public static void addRegularToppings(CustomSandwiches sandwich) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("""
                Regular toppings:
                (1) Lettuce
                (2) Peppers
                (3) Onions
                (4) Tomatoes
                (5) Jalapenos
                (6) Cucumbers
                (7) Pickles
                (8) Banana Peppers
                (9) Mushrooms
                (0) Finish
                """);

            switch (keyboard.nextLine()) {
                case "1" -> sandwich.addRegularToppings(RegularToppings.Lettuce);
                case "2" -> sandwich.addRegularToppings(RegularToppings.Peppers);
                case "3" -> sandwich.addRegularToppings(RegularToppings.Onions);
                case "4" -> sandwich.addRegularToppings(RegularToppings.Tomatoes);
                case "5" -> sandwich.addRegularToppings(RegularToppings.Jalapenos);
                case "6" -> sandwich.addRegularToppings(RegularToppings.Cucumbers);
                case "7" -> sandwich.addRegularToppings(RegularToppings.Pickles);
                case "8" -> sandwich.addRegularToppings(RegularToppings.BananaPeppers);
                case "9" -> sandwich.addRegularToppings(RegularToppings.Mushrooms);
                case "0" -> { return; }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static void addMeatToppings(CustomSandwiches sandwich) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("""
                Meat toppings:
                (1) Steak
                (2) Ham
                (3) Salami
                (4) Roast Beef
                (5) Chicken
                (6) Bacon
                (7) Turkey
                (0) Finish
                """);

            switch (keyboard.nextLine()) {
                case "1" -> sandwich.addMeat(Meat.Steak);
                case "2" -> sandwich.addMeat(Meat.Ham);
                case "3" -> sandwich.addMeat(Meat.Salami);
                case "4" -> sandwich.addMeat(Meat.RoastBeef);
                case "5" -> sandwich.addMeat(Meat.Chicken);
                case "6" -> sandwich.addMeat(Meat.Bacon);
                case "7" -> sandwich.addMeat(Meat.Turkey);
                case "0" -> { return; }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static void addCheeseToppings(CustomSandwiches sandwich) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("""
                Cheese options:
                (1) American
                (2) Provolone
                (3) Cheddar
                (4) Swiss
                (0) Finish
                """);

            switch (keyboard.nextLine()) {
                case "1" -> sandwich.addCheese(Cheese.American);
                case "2" -> sandwich.addCheese(Cheese.Provolone);
                case "3" -> sandwich.addCheese(Cheese.Cheddar);
                case "4" -> sandwich.addCheese(Cheese.Swiss);
                case "0" -> { return; }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static void addSauces(CustomSandwiches sandwich) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("""
                Sauce options:
                (1) Mayo
                (2) Mustard
                (3) Ketchup
                (4) Ranch
                (5) BBQ
                (6) Honey Mustard
                (0) Done
                """);

            switch (keyboard.nextLine()) {
                case "1" -> sandwich.addSauce(Sauce.Mayo);
                case "2" -> sandwich.addSauce(Sauce.Mustard);
                case "3" -> sandwich.addSauce(Sauce.Ketchup);
                case "4" -> sandwich.addSauce(Sauce.Ranch);
                case "5" -> sandwich.addSauce(Sauce.BBQ);
                case "6" -> sandwich.addSauce(Sauce.HoneyMustard);
                case "0" -> { return; }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static void addDrink(Drinks beverages){
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("""
                What would you like to add?
                (1) Coca-Cola
                (2) Sprite
                (3) Dr.Pepper
                (4) Lemon-aid
                (5) Water
                (0) Done
               
                """);

            switch (keyboard.nextLine()) {
                case "1" -> beverages.addDrinks(Beverages.CocaCola);
                case "2" -> beverages.addDrinks(Beverages.Sprite);
                case "3" -> beverages.addDrinks(Beverages.DrPepper);
                case "4" -> beverages.addDrinks(Beverages.LemonAid);
                case "5" -> beverages.addDrinks(Beverages.Water);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }

        }

    }
    public static void addChips(Chips bagChips){
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("""
                What would you like to remove?
                (1) Sun Chips
                (2) Cheetos
                (3) Lays
                (4) Doritos
                (0) Done
               
                """);

            switch (keyboard.nextLine()) {
                case "1" -> bagChips.addChips(BagChips.SunChips);
                case "2" -> bagChips.addChips(BagChips.Cheetos);
                case "3" -> bagChips.addChips(BagChips.Lays);
                case "4" -> bagChips.addChips(BagChips.Doritos);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }

        }

    }
        //Remove from Sandwich
    public static void removeDrinks(Drinks beverages){
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("""
                What would you like to remove?
                (1) Coca-Cola
                (2) Sprite
                (3) Dr.Pepper
                (4) Lemon-aid
                (5) Water
                (0) Done
               
                """);

            switch (keyboard.nextLine()) {
                case "1" -> beverages.removeDrink(Beverages.CocaCola);
                case "2" -> beverages.removeDrink(Beverages.Sprite);
                case "3" -> beverages.removeDrink(Beverages.DrPepper);
                case "4" -> beverages.removeDrink(Beverages.LemonAid);
                case "5" -> beverages.removeDrink(Beverages.Water);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }

    }
    }
    public static void removeChips(Chips bagChips){
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("""
                What would you like to remove?
                (1) Sun Chips
                (2) Cheetos
                (3) Lays
                (4) Doritos
                (0) Done
               
                """);

            switch (keyboard.nextLine()) {
                case "1" -> bagChips.removeChips(BagChips.SunChips);
                case "2" -> bagChips.removeChips(BagChips.Cheetos);
                case "3" -> bagChips.removeChips(BagChips.Lays);
                case "4" -> bagChips.removeChips(BagChips.Doritos);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }

        }

    }
    public static void removeSandwichSelection(CustomSandwiches sandwich) {
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("""
                What would you like to remove?
                (1) Bread
                (2) Topping
                (3) Meat
                (4) Cheese
                (5) Sauce
                (0) Done
                """);

            switch (keyboard.nextLine()) {
                case "1" -> removeBread(sandwich);
                case "2" -> removeTopping(sandwich);
                case "3" -> removeMeat(sandwich);
                case "4" -> removeCheese(sandwich);
                case "5" -> removeSauces(sandwich);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static void removeBread (CustomSandwiches sandwich){
        }
    public static void removeTopping (CustomSandwiches sandwich){
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Regular toppings:
                    (1) Remove Lettuce
                    (2) Remove Peppers
                    (3) Remove Onions
                    (4) Remove Tomatoes
                    (5) Remove Jalapenos
                    (6) Remove Cucumbers
                    (7) Remove Pickles
                    (8) Remove Banana Peppers
                    (9) Remove Mushrooms
                    (0) Finish
                    """);

            switch (keyboard.nextLine()) {
                case "1" -> sandwich.removeTopping(RegularToppings.Lettuce);
                case "2" -> sandwich.removeTopping(RegularToppings.Peppers);
                case "3" -> sandwich.removeTopping(RegularToppings.Onions);
                case "4" -> sandwich.removeTopping(RegularToppings.Tomatoes);
                case "5" -> sandwich.removeTopping(RegularToppings.Jalapenos);
                case "6" -> sandwich.removeTopping(RegularToppings.Cucumbers);
                case "7" -> sandwich.removeTopping(RegularToppings.Pickles);
                case "8" -> sandwich.removeTopping(RegularToppings.BananaPeppers);
                case "9" -> sandwich.removeTopping(RegularToppings.Mushrooms);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static void removeMeat (CustomSandwiches sandwich){
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("""
            Meat toppings:
            (1) Steak
            (2) Ham
            (3) Salami
            (4) Roast Beef
            (5) Chicken
            (6) Bacon
            (7) Turkey
            (0) Finish
            """);

            switch (keyboard.nextLine()) {
                case "1" -> sandwich.removeMeat(Meat.Steak);
                case "2" -> sandwich.removeMeat(Meat.Ham);
                case "3" -> sandwich.removeMeat(Meat.Salami);
                case "4" -> sandwich.removeMeat(Meat.RoastBeef);
                case "5" -> sandwich.removeMeat(Meat.Chicken);
                case "6" -> sandwich.removeMeat(Meat.Bacon);
                case "7" -> sandwich.removeMeat(Meat.Turkey);
                case "0" -> { return; }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

    }
    public static void removeCheese (CustomSandwiches sandwich){
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Cheese options:
                    (1) Remove American
                    (2) Remove Provolone
                    (3) Remove Cheddar
                    (4) Remove Swiss
                    (0) Finish
                    """);

            switch (keyboard.nextLine()) {
                case "1" -> sandwich.removeCheese(Cheese.American);
                case "2" -> sandwich.removeCheese(Cheese.Provolone);
                case "3" -> sandwich.removeCheese(Cheese.Cheddar);
                case "4" -> sandwich.removeCheese(Cheese.Swiss);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

    }
    public static void removeSauces (CustomSandwiches sandwich){
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Sauce options:
                    (1) Remove Mayo
                    (2) Remove Mustard
                    (3) Remove Ketchup
                    (4) Remove Ranch
                    (5) Remove BBQ
                    (6) Remove Honey Mustard
                    (0) Done
                    """);

            switch (keyboard.nextLine()) {
                case "1" -> sandwich.removeSauce(Sauce.Mayo);
                case "2" -> sandwich.removeSauce(Sauce.Mustard);
                case "3" -> sandwich.removeSauce(Sauce.Ketchup);
                case "4" -> sandwich.removeSauce(Sauce.Ranch);
                case "5" -> sandwich.removeSauce(Sauce.BBQ);
                case "6" -> sandwich.removeSauce(Sauce.HoneyMustard);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }


    public static ArrayList<CustomSandwiches> getFoodOrder() {
        ArrayList<CustomSandwiches> foodOrder = new ArrayList<CustomSandwiches>();
        try {
            FileReader fileReader = new FileReader("src/main/resources/CrockettDeli.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input ;
            bufferedReader.readLine();
            //Skipping the first line with the column headings
            while ((input = bufferedReader.readLine()) != null) {
                if (input.startsWith("Crockett's Deli Shop")){
                    String[] description = input.split("|");
                    CustomSandwiches newCustomSandwich = new CustomSandwiches(description[0], true
                            );

                    foodOrder.add(newCustomSandwich);
                }
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
        return foodOrder;
    }
    public static void checkOut(CurrentOrder order ){
        Scanner option2 = new Scanner(System.in);
       ArrayList<CustomSandwiches> items = order.getItems();
       ArrayList<Drinks> beverages = order.getDrinkItems();
       ArrayList<Chips> bagChips = order.getChipItems();
        if (!items.isEmpty() || !beverages.isEmpty() ||!bagChips.isEmpty()) {
            System.out.println(ListOrder(items, beverages,bagChips));
            double orderPrice = 0;
            for (CustomSandwiches fO : items) {
                orderPrice += fO.getSandwichSizePrice();
            }
            System.out.printf("Total cost: $%.2f\n", orderPrice);
            System.out.print("Enter the payment: ");
            double payment = option2.nextDouble();
            if (payment >= orderPrice) {
                printReceipt(payment, orderPrice, items, beverages,bagChips);
                System.out.println("Order successfully!");
                order.cancelOrder();
                if (payment > orderPrice) {
                    System.out.printf("Change: %.2f\n", (payment - orderPrice));
                }
            } else {
                System.out.println("Unable to process order..");
            }
        }
        else
            System.out.println("No Order Available..");
    }
    public static void printReceipt(double payment, double cost, ArrayList<CustomSandwiches> purchases, ArrayList<Drinks> beverages,
    ArrayList<Chips> bagChips){
        System.out.println("Date: "+ LocalDate.now());
        System.out.println(ListOrder(purchases, beverages ,bagChips));
        System.out.printf("Sub-total: $%.2f\n",cost);
        System.out.printf("Paid: $%.2f\n",payment);
        System.out.printf("Change: $%.2f\n",payment-cost);
        try{
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter Datetime = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            FileWriter fileWriter = new FileWriter("CrockettDeliReceipts/"+now.format(Datetime)+".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Date: "+ LocalDate.now()+"\n");
            bufferedWriter.write(ListOrder(purchases,beverages,bagChips));
            bufferedWriter.write(String.format("Sub-total: $%.2f\n",cost));
            bufferedWriter.write(String.format("Paid: $%.2f\n",payment));
            bufferedWriter.write(String.format("Change: $%.2f\n",payment-cost));
            bufferedWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int ListOrder(ArrayList<CustomSandwiches> purchases, ArrayList<Drinks> beverages, ArrayList<Chips> bagChips) {
        return 0;
    }

}


