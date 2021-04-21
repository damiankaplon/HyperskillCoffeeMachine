package machine;

import java.util.Scanner;

public class CoffeeMachine {

   private int waterInMachine = 400, milkInMachine = 540, beansInMachine = 120, moneyInMachine = 550,
   disposableCups = 9;

   private void getParametersOfMachine(){
      System.out.println("Coffee machine has:");
      System.out.println(this.waterInMachine + " of water");
      System.out.println(this.milkInMachine + " of milk");
      System.out.println(this.beansInMachine + " of coffee beans");
      System.out.println(this.moneyInMachine + " of money");
      System.out.println(this.disposableCups + " of disposable cups");
      System.out.println();
   }

   private String chooseTheAction(){
      Scanner in = new Scanner(System.in);
      System.out.println();
      System.out.println("Write action (buy, fill, take, remaining, exit):");
      String chosenAction = in.nextLine();

      String checkedChosenAction;
      switch (chosenAction){
         case "buy":
            checkedChosenAction = "buy";
            break;

         case "fill":
            checkedChosenAction = "fill";
            break;

         case "take":
            checkedChosenAction = "take";
            break;

         case "remaining":
            checkedChosenAction = "remaining";
            break;

         case "exit":
            checkedChosenAction = "exit";
            break;

         default:
            checkedChosenAction = "Wrong action has been chosen";
      }
      return  checkedChosenAction;
   }

   private void performBuy(){
      System.out.println("");
      System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
      Scanner in = new Scanner(System.in);
      String chosenCoffee = in.nextLine();

      switch (chosenCoffee){
         case "1":
            makeEspresso();
            break;
         case "2":
            makeLatte();
            break;
         case "3":
            makeCappuccino();
            break;
         case "back":
            break;
         default:
            break;
      }
   }

   private void makeEspresso(){
      int a = this.waterInMachine - 250;
      int b = this.beansInMachine - 16;
      int c = this.disposableCups - 1;

      if (a<0){
         System.out.println("Sorry, not enough water!");
      }
      else if (b<0){
         System.out.println("Sorry, not enough coffee beans!");
      }
      else if (c<0){
         System.out.println("Sorry, not enough cups!");
      }
      else{
         System.out.println("I have enough resources, making you a coffee!");
         this.waterInMachine = a;
         this.beansInMachine = b;
         this.moneyInMachine += 4;
         this.disposableCups = c;
      }
   }

   private void makeLatte(){
      int a = this.waterInMachine - 350;
      int b = this.milkInMachine - 75;
      int c = this.beansInMachine - 20;
      int d = this.disposableCups - 1;

      if (a<0){
         System.out.println("Sorry, not enough water!");
      }
      else if (b<0){
         System.out.println("Sorry, not enough milk");
      }
      else if (c<0){
         System.out.println("Sorry, not enough coffee beans");
      }
      else if (d<0){
         System.out.println("Sorry, not enough cups");
      }
      else{
         System.out.println("I have enough resources, making you a coffee!");
         this.waterInMachine = a;
         this.milkInMachine = b;
         this.beansInMachine = c;
         this.moneyInMachine += 7;
         this.disposableCups = d;
      }
   }

   private void makeCappuccino(){
      int a =  this.waterInMachine - 200;
      int b = this.milkInMachine - 100;
      int c = this.beansInMachine - 12;
      int d = this.disposableCups - 1;

      if (a<0){
         System.out.println("Sorry, not enough water!");
      }
      else if (b<0){
         System.out.println("Sorry, not enough milk");
      }
      else if (c<0){
         System.out.println("Sorry, not enough coffee beans");
      }
      else if (d<0){
         System.out.println("Sorry, not enough cups");
      }
      else{
         System.out.println("I have enough resources, making you a coffee!");
         this.waterInMachine = a;
         this.milkInMachine = b;
         this.beansInMachine = c;
         this.moneyInMachine += 6;
         this.disposableCups = d;
      }

   }

   private void performFill(){
      System.out.println();

      Scanner in = new Scanner(System.in);
      System.out.println("Write how many ml of water do you want to add:");
      int waterAdded = in.nextInt();
      this.waterInMachine += waterAdded;

      System.out.println("Write how many ml of milk do you want to add:");
      int milkAdded = in.nextInt();
      this.milkInMachine += milkAdded;

      System.out.println("Write how many grams of coffee beans do you want to add:");
      int beansAdded = in.nextInt();
      this.beansInMachine += beansAdded;

      System.out.println("Write how many disposable cups of coffee do you want to add:");
      int cupsAdded = in.nextInt();
      this.disposableCups += cupsAdded;

 }

   private void performTake(){
      System.out.println();
     System.out.println("I gave you $" + this.moneyInMachine);
     this.moneyInMachine = 0;
   }


 /* private boolean runCoffeeMachine(){

      String chosenAction = chooseTheAction();

         switch (chosenAction) {
            case "buy":
               performBuy();
               break;
            case "fill":
               performFill();
               break;
            case "take":
               performTake();
               break;
            case "remaining":
               getParametersOfMachine();
               break;
         }

   }
   */





   public static void main(String[] args) {
      CoffeeMachine coffeeMachine = new CoffeeMachine();
      String chosenAction = "";

      while (chosenAction.equalsIgnoreCase("buy") || chosenAction.equalsIgnoreCase("fill") ||
              chosenAction.equalsIgnoreCase("take") || chosenAction.equalsIgnoreCase("remaining")
            || chosenAction.equalsIgnoreCase("")) {
         chosenAction = coffeeMachine.chooseTheAction();
         switch (chosenAction) {
            case "buy":
               coffeeMachine.performBuy();
               break;
            case "fill":
               coffeeMachine.performFill();
               break;
            case "take":
               coffeeMachine.performTake();
               break;
            case "remaining":
               coffeeMachine.getParametersOfMachine();
               break;
            default:
               break;
         }
      }
    }
}
