package com.example.hw1_burgercalculator;

/**
 * Creates a calculator class to perform mathematical functions inlcuding addition and multiplication.
 * Creates two functions to calculate the cost of the buns, toppings, and patties. Another function
 * also exists to calculate the total amount of calories for the buns, patties, and toppings.
 */
public class Calculator {

    private double bunCost; //stores the cost of the buns
    private double pattyCost; //stores the cost of the patties
    private double toppingsCost; //stores the cost of the toppings

    private double bunCalories; //stores the calories of the buns
    private double pattyCalories; //stores the calories of the patties
    private double toppingsCalories; //stores the calories of the toppings

    double num1, num2;

    /**
     * Constructor to set up the calculator class with the buns, patties, and toppings.
     * @param bunCost   the total bun cost for calculation
     * @param pattyCost the total patties cost for calculation
     * @param toppingsCost the total toppings cost for calculation
     */
    public Calculator(double bunCost, double pattyCost, double toppingsCost){
        this.bunCost = bunCost;
        this.pattyCost = pattyCost;
        this.toppingsCost = toppingsCost;

    }

    public Calculator(double bunCost){
        this.bunCost = bunCost;
    }

    public Calculator(double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;

    }

    public double multiply (double num1, double num2){
        return num1 * num2;
    }
    /**
     * Calculate the total cost given the total bun cost, the total patty cost, and the total
     * toppings cost.
     * @param bunCost      total bun cost
     * @param pattyCost     total patties cost
     * @param toppingsCost   total toppings cost
     * @return the total cost of all three steps
     */
    public double calculateCost(double bunCost, double pattyCost, double toppingsCost){
        return bunCost + pattyCost + toppingsCost;
    }

    /**
     * Calculate the total calories given the total bun calories, the total patty calories, and the total
     * toppings calories.
     * @param bunCalories       total bun calories
     * @param pattyCalories     total patty calories
     * @param toppingsCalories  total toppings calories
     * @return  total calories of all three steps
     */
    public double calculateCalories(double bunCalories, double pattyCalories, double toppingsCalories) {
        return bunCalories + pattyCalories + toppingsCalories;
    }

    public double calculateBunCost(double bunCost) {
        return bunCost;
    }

    public double calculateBunCalories(double bunCalories) {
        return bunCalories;
    }
}
