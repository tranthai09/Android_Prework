package com.example.hw1_burgercalculator;

import java.util.ArrayList;

/**
 * Separate class for the burgers storing the calories and cost of each type of bun, patty, and calories.
 * Also uses the calculator class to sum up the calories of the buns, patties, and toppings as well
 * as their costs.
 */
class Burger {

    private double bunCost; // total bun cost
    private double pattyCost; // total patties cost
    private double toppingsCost; // total toppings cost

    private double bunCalories; // total bun calories
    private double pattyCalories; // total patties calories
    private double toppingCalories; // total toppings calories

    private String bunType;     //stores what kind of bun was chosen
    private String pattyType; //stores what kind of patty was chosen
    private ArrayList<String> toppingsList; // Stores the list of strings of toppings used

    private Calculator calc; // Create a calculator to perform calculations for cost and calories

    /**
     * Constructor for bun taking in the type of bun, type of patty, and the string array list of
     * toppings used.
     * @param bunType   type of bun
     * @param pattyType type of patty
     * @param toppingsList list of toppings used in the form of strings
     */
    public Burger(String bunType, String pattyType, ArrayList<String> toppingsList){
        this.bunType = bunType;
        this.pattyType = pattyType;
        this.toppingsList = toppingsList;
    }

    public Burger(String bunType){
        this.bunType = bunType;
    }

    /**
     * Adds up all the buns used by first iterating through the array to match how much money
     * each bun is and sum them up based on the bun.
     * @param bun_type  Type of bun
     * @return  total cost of buns
     */
    public double addBuns(String bun_type){
        /**
         * If the user does not choose a bun then the bun total cost is 0.
         */
        if (bun_type == null){
            bunCost = 0.0;
        }
        else if (bun_type.equals("White")){
            bunCost = 1.0;


        }
        else if (bun_type.equals("Wheat")){
            bunCost = 1.0;
        }


        return bunCost;
    }

    /**
     * Adds up all the buns used by first iterating through the array to match how much calories
     * each bun is and sum them up based on the bun.
     * @param bun_type  Type of bun
     * @return  total calories for buns
     */
    public double addBunsCalories(String bun_type){

        if (bun_type == null){
            bunCalories = 0.0;
        }
        else if (bun_type.equals("White")){
            bunCalories = 140;


        }
        else if (bun_type.equals("Wheat")){
            bunCalories = 100;
        }

        return bunCalories;
    }

    /**
     * Adds up all the patties used by first iterating through the array to match how much moeny
     * each patty is and sum them up based on the patty.
     * @param patty_type    The type of patty used.
     * @return  double value for the total cost for patties.
     */
    public double addPatties(String patty_type){
        if (patty_type == null){
            pattyCost = 0.0;
        }
        else if (patty_type.equals("Beef")){
            pattyCost = 5.5;

        }
        else if (patty_type.equals("Chicken")){
            pattyCost = 5.0;
        }
        else if (patty_type.equals("Turkey")){
            pattyCost = 5.0;
        }
        else if (patty_type.equals("Salmon")){
            pattyCost = 7.5;
        }
        else if (patty_type.equals("Veggies")){
            pattyCost = 4.5;
        }

        return pattyCost;
    }

    /**
     *  Adds up all the patties used by first iterating through the array to match how much calories
     *  each patty is and sum them up based on the patty.
     * @param patty_type    The type of patty ordered
     * @return  double value for the total calories consumed for patties.
     */
    public double addPattiesCalories(String patty_type){
        if (patty_type == null){
            pattyCalories = 0;
        }
        else if (patty_type.equals("Beef")){
            pattyCalories = 240;
        }
        else if (patty_type.equals("Chicken")){
            pattyCalories = 180;
        }
        else if (patty_type.equals("Turkey")){
            pattyCalories = 190;
        }
        else if (patty_type.equals("Salmon")){
            pattyCalories = 95;
        }
        else if (patty_type.equals("Veggies")){
            pattyCalories = 80;
        }

        return pattyCalories;
    }

    /**
     * Adds up all the toppings used by first iterating through the array to match how much money
     * each topping is and sum them up based on the topping.
     * @param toppingsList  ArrayList of all the toppings used
     * @return  double of the total toppings cost
     */
    public double addToppings(ArrayList<String> toppingsList){
        toppingsCost = 0;
        for (int i = 0; i < toppingsList.size(); i++){

            if (toppingsList.get(i).equals("Mushroom")){
                toppingsCost += 1.0;
            }
            else if (toppingsList.get(i).equals("Lettuce")){
                toppingsCost += 0.3;
            }
            else if (toppingsList.get(i).equals("Tomato")){
                toppingsCost += 0.3;
            }
            else if (toppingsList.get(i).equals("Pickles")){
                toppingsCost += 0.5;
            }
            else if (toppingsList.get(i).equals("Mayo")){
                toppingsCost += 0.0;
            }
            else if (toppingsList.get(i).equals("Mustard")){
                toppingsCost += 0.0;
            }
        }

        return toppingsCost;
    }

    /**
     *  Adds up all the toppings used by first iterating through the array to match how much calories
     *  each topping is and sum them up based on the topping.
     * @param toppingsList Array list of toppings
     * @return  total amount of calories consumed as a double
     */
    public double addToppingsCalories(ArrayList<String> toppingsList){
        for (int i = 0; i < toppingsList.size(); i++){

            if (toppingsList.get(i).equals("Mushroom")){
                toppingCalories += 60;
            }
            else if (toppingsList.get(i).equals("Lettuce")){
                toppingCalories += 20;
            }
            else if (toppingsList.get(i).equals("Tomato")){
                toppingCalories += 20;
            }
            else if (toppingsList.get(i).equals("Pickles")){
                toppingCalories += 30;
            }
            else if (toppingsList.get(i).equals("Mayo")){
                toppingCalories += 100;
            }
            else if (toppingsList.get(i).equals("Mustard")){
                toppingCalories += 60;
            }
        }

        return toppingCalories;
    }

    /**
     * Calculates the total amount of cost using the calculator class.
     * @param bunCost   total bun cost
     * @param pattyCost total patty cost
     * @param toppingsCost  total toppings cost
     * @return  total cost of the order
     */
    public double calculateCost(double bunCost, double pattyCost, double toppingsCost){
        calc = new Calculator(bunCost, pattyCost, toppingsCost);
        return calc.calculateCost(bunCost, pattyCost, toppingsCost);
    }

    /**
     * Calculates the total amount of calories using the calculator class.
     * @param bunCalories   total bun calories
     * @param pattyCalories total patty calories
     * @param toppingCalories total toppings calories
     * @return  total calories to be consumed in the order
     */
    public double calculateCalories(double bunCalories, double pattyCalories, double toppingCalories){
        calc = new Calculator(bunCalories, pattyCalories, toppingCalories);
        return calc.calculateCalories(bunCalories, pattyCalories, toppingCalories);
    }


    public double calculateBunCost(double bunCost) {
        calc = new Calculator(bunCost);
        return calc.calculateBunCost(bunCost);
    }

    public double calculateCalories(double bunCalories) {
        calc = new Calculator(bunCalories);
        return calc.calculateBunCalories(bunCalories);
    }
}
