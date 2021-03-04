package com.example.hw1_burgercalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Main activity with the UI for the user. Using MVC model where the this class or activity is the
 * front end and the back end is the calculator and burger class.
 */
public class MainActivity extends AppCompatActivity {

    RadioButton white_bun, wheat_bun;
    RadioButton beef_patty, chicken_patty, turkey_patty, salmon_patty, veggie_patty;
    CheckBox checkBox_mushroom, checkBox_tomato, checkBox_mayo, checkBox_lettuce, checkBox_pickles, checkBox_mustard;
    EditText et_burgerCount; // User input for the number of burgers wanted

    TextView calories_res, cost_res;

    Button btn_calculate;

    double total_white_bun = 0;
    double total_wheat_bun = 0;

    double total_beef_patty = 0;
    double total_chicken_patty = 0;
    double total_turkey_patty = 0;
    double total_salmon_patty = 0;
    double total_veggie_patty = 0;

    int total_mushrooms = 0;
    int total_lettuce = 0;
    int total_tomato = 0;
    int total_pickles = 0;
    int total_mayo = 0;
    int total_mustard = 0;

    int toppings_counter = 0;


    private ArrayList<String> toppingsList;

    private static final String LOG_NAME = MainActivity.class.getSimpleName(); // For debugging

    String bunType;

    String pattyType;

    Burger burger;

    double numBurger;
    double finalCost;
    double finalCalories;

    Calculator calc;

    private static DecimalFormat df = new DecimalFormat("0.00"); //formatting for 2 decimal places

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize and identify the views used in the xml files
        et_burgerCount = findViewById(R.id.et_burgerCount);
        calories_res= findViewById(R.id.calories_res);
        cost_res= findViewById(R.id.cost_res);


        btn_calculate = findViewById(R.id.btn_calculate);

        // Set on click listener to allow the user to decide when to calculate the costs
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Specify the type of bun
                if(total_white_bun == 1){
                    bunType = "White";
                }
                else if(total_wheat_bun == 1){
                    bunType = "Wheat";
                }
                else { // If no bun was selected, force them to select a bun
                    Toast.makeText(getApplicationContext(), "Select a bun! ", Toast.LENGTH_SHORT).show();
                }

                // Choose a type of patty
                if(total_beef_patty == 1){
                    pattyType = "Beef";
                }
                else if(total_chicken_patty == 1){
                    pattyType = "Chicken";
                }
                else if(total_turkey_patty == 1){
                    pattyType = "Turkey";
                }
                else if(total_salmon_patty == 1){
                    pattyType = "Salmon";
                }
                else if(total_veggie_patty == 1){
                    pattyType = "Veggies";
                }
                else { // If no patty selected, force them to choose a patty
                    Toast.makeText(getApplicationContext(), "Select a patty! ", Toast.LENGTH_SHORT).show();
                }

                // Initialize an array list to store each topping used.
                toppingsList = new ArrayList<>();

                // Specify which toppings were chosen and add them to the array list
                if (total_mushrooms == 1){
                    toppingsList.add("Mushroom");
                }
                if (total_lettuce == 1){
                    toppingsList.add("Lettuce");
                }
                if (total_mayo == 1){
                    toppingsList.add("Mayo");
                }
                if (total_mustard == 1){
                    toppingsList.add("Mayo");
                }
                if (total_pickles == 1){
                    toppingsList.add("Mayo");
                }
                if (total_tomato == 1){
                    toppingsList.add("Mayo");
                }

                // Iterate through the array list to know what was chosen
                for (int i = 0; i < toppingsList.size(); i++){

                    Log.d(LOG_NAME, "Topping: " + toppingsList.get(i));
                }

                // Initialize a burger class with a specified bun type, patty type, and an array list
                // of toppings used.
                burger = new Burger(bunType, pattyType, toppingsList);

                // Calculate the cost of buns, patties, and toppings before mutliplying by how many
                // burgers the user wants.
                double baseCost = burger.calculateCost(burger.addBuns(bunType), burger.addPatties(pattyType), burger.addToppings(toppingsList));

                // Make sure the string is not empty, if it is, force them to enter in a number
                // for how many burgers the user wants.
                if (et_burgerCount.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "Enter in the number of burgers!", Toast.LENGTH_SHORT).show();
                }
                else if(Double.parseDouble(et_burgerCount.getText().toString()) > 4){ // the max number of burgers is 4
                    Toast.makeText(getApplicationContext(), "Eat more healthy! Too many burgers!", Toast.LENGTH_SHORT).show();
                }
                else { // parse the text or number the user chose for how many burgers they want.
                    numBurger = Double.parseDouble(et_burgerCount.getText().toString());
                }

                // Calculate the final cost of the burgers by multiplying by how many burgers the user
                //wants with the calculated cost for each burger created using the calculator class.
                calc = new Calculator(numBurger, baseCost);

                // Calculate the final cost of the burgers
                finalCost = calc.multiply(numBurger, baseCost);
                cost_res = findViewById(R.id.cost_res);
                cost_res.setText("$" + df.format(finalCost));

                // Calculate the final calories of the burgers
                double baseCalories = burger.calculateCalories(burger.addBunsCalories(bunType), burger.addPattiesCalories(pattyType), burger.addToppingsCalories(toppingsList));
                calc = new Calculator(numBurger, baseCost);
                finalCalories = calc.multiply(numBurger, baseCalories);;
                calories_res = findViewById(R.id.calories_res);
                calories_res.setText("" + finalCalories);

            }
        });

    }

    /**
     * OnClick listener for the bun action if the radio button chosen was the white bun
     * @param view  Radio button for white bun
     */
    public void whiteBunAction(View view) {
        white_bun = findViewById(R.id.white_bun);
        if(white_bun.isChecked()){
            total_white_bun = 1;
            total_wheat_bun = 0;

        }

    }

    /**
     * OnClick listener for the bun action if the radio button chosen was the wheat bun
     * @param view  Radio button for wheat bun
     */
    public void wheatBunAction(View view) {
        wheat_bun = findViewById(R.id.wheat_bun);
        if(wheat_bun.isChecked()){
            total_wheat_bun = 1;
            total_white_bun = 0;
        }
    }

    /**
     * OnClick listener for the patty action if the radio button chosen was the beef patty
     * @param view  Radio button for beef patty
     */
    public void beefPattyAction(View view) {
        beef_patty = findViewById(R.id.beef_patty);
        if(beef_patty.isChecked()){
            total_beef_patty = 1;
            total_chicken_patty = 0;
            total_turkey_patty = 0;
            total_salmon_patty = 0;
            total_veggie_patty = 0;
        }
    }

    /**
     * OnClick listener for the patty action if the radio button chosen was the chicken patty
     * @param view  Radio button for chicken patty
     */
    public void chickenPattyAction(View view) {
        chicken_patty = findViewById(R.id.chicken_patty);
        if(chicken_patty.isChecked()){
            total_beef_patty = 0;
            total_chicken_patty = 1;
            total_turkey_patty = 0;
            total_salmon_patty = 0;
            total_veggie_patty = 0;
        }
    }

    /**
     * OnClick listener for the patty action if the radio button chosen was the turkey patty
     * @param view  Radio button for turkey patty
     */
    public void turkeyPattyAction(View view) {
        turkey_patty = findViewById(R.id.turkey_patty);
        if(turkey_patty.isChecked()){
            total_beef_patty = 0;
            total_chicken_patty = 0;
            total_turkey_patty = 1;
            total_salmon_patty = 0;
            total_veggie_patty = 0;
        }

    }

    /**
     * OnClick listener for the patty action if the radio button chosen was the salmon patty
     * @param view  Radio button for salmon patty
     */
    public void salmonPattyAction(View view) {
        salmon_patty = findViewById(R.id.salmon_patty);
        if(salmon_patty.isChecked()){
            total_beef_patty = 0;
            total_chicken_patty = 0;
            total_turkey_patty = 0;
            total_salmon_patty = 1;
            total_veggie_patty = 0;
        }
    }

    /**
     * OnClick listener for the patty action if the radio button chosen was the veggie patty
     * @param view  Radio button for veggie patty
     */
    public void veggiePattyAction(View view) {
        veggie_patty = findViewById(R.id.veggie_patty);
        if(veggie_patty.isChecked()){
            total_beef_patty = 0;
            total_chicken_patty = 0;
            total_turkey_patty = 0;
            total_salmon_patty = 0;
            total_veggie_patty = 1;
        }
    }

    /**
     * OnClick listener for the topping action if the radio button chosen was the mushroom topping
     * @param view  Radio button for mushroom topping
     */
    public void cbMushroomAction(View view) {
        checkBox_mushroom= findViewById(R.id.checkBox_mushroom);
        // make sure there is not more than 3 toppings
        if (toppings_counter > 2){
            if (!checkBox_mushroom.isChecked()){
                toppings_counter--;
                checkBox_mushroom.toggle();

            }
            checkBox_mushroom.setChecked(false);
            Toast.makeText(this, "Can only choose up to 3 toppings! ", Toast.LENGTH_SHORT).show();

        }
        else {
            if (checkBox_mushroom.isChecked()) {
                total_mushrooms = 1;
                toppings_counter++;
            }
            if (!checkBox_mushroom.isChecked()){
                total_mushrooms = 0;
                toppings_counter--;
            }
        }

    }

    /**
     * OnClick listener for the topping action if the radio button chosen was the mustard topping
     * @param view  Radio button for mustard topping
     */
    public void cbMustardAction(View view) {
        checkBox_mustard= findViewById(R.id.checkBox_mustard);
        // make sure there is not more than 3 toppings
        if (toppings_counter > 2){
            if (!checkBox_mustard.isChecked()){
                toppings_counter--;
                checkBox_mustard.toggle();
            }
            checkBox_mustard.setChecked(false);
            Toast.makeText(this, "Can only choose up to 3 toppings! ", Toast.LENGTH_SHORT).show();
        }
        else {
            if (checkBox_mustard.isChecked()) {
                total_mustard = 1;
                toppings_counter++;
            }
            if (!checkBox_mustard.isChecked()){
                total_mustard = 0;
                toppings_counter--;
            }
        }

    }

    /**
     * OnClick listener for the topping action if the radio button chosen was the pickles topping
     * @param view  Radio button for pickles topping
     */
    public void cbPicklesAction(View view) {
        checkBox_pickles= findViewById(R.id.checkBox_pickles);
        // make sure there is not more than 3 toppings
        if (toppings_counter > 2){

            if (!checkBox_pickles.isChecked()){
                toppings_counter--;
                checkBox_pickles.toggle();
            }
            checkBox_pickles.setChecked(false);
            Toast.makeText(this, "Can only choose up to 3 toppings! ", Toast.LENGTH_SHORT).show();
        }
        else {
            if (checkBox_pickles.isChecked()) {
                total_pickles = 1;
                toppings_counter++;
            }
            if (!checkBox_pickles.isChecked()){
                total_pickles = 0;
                toppings_counter--;
            }
        }

    }

    /**
     * OnClick listener for the topping action if the radio button chosen was the mayo topping
     * @param view  Radio button for mayo topping
     */
    public void cbMayoAction(View view) {
        checkBox_mayo= findViewById(R.id.checkBox_mayo);
        // make sure there is not more than 3 toppings
        if (toppings_counter > 2){

            if (!checkBox_mayo.isChecked()){
                toppings_counter--;
                checkBox_mayo.toggle();
            }
            checkBox_mayo.setChecked(false);
            Toast.makeText(this, "Can only choose up to 3 toppings! ", Toast.LENGTH_SHORT).show();
        }
        else {
            if (checkBox_mayo.isChecked()) {
                total_mayo = 1;
                toppings_counter++;
            }
            if (!checkBox_mayo.isChecked()){
                total_mayo = 0;
                toppings_counter--;
            }
        }

    }

    /**
     * OnClick listener for the topping action if the radio button chosen was the tomato topping
     * @param view  Radio button for tomato topping
     */
    public void cbTomatoAction(View view) {
        checkBox_tomato= findViewById(R.id.checkBox_tomato);
        // make sure there is not more than 3 toppings
        if (toppings_counter > 2){
            if (!checkBox_tomato.isChecked()){
                toppings_counter--;
                checkBox_tomato.toggle();
            }
            checkBox_tomato.setChecked(false);
            Toast.makeText(this, "Can only choose up to 3 toppings! ", Toast.LENGTH_SHORT).show();
        }
        else {
            if (checkBox_tomato.isChecked()) {
                total_tomato = 1;
                toppings_counter++;
            }
            if (!checkBox_tomato.isChecked()){
                total_tomato = 0;
                toppings_counter--;
            }
        }

    }

    /**
     * OnClick listener for the topping action if the radio button chosen was the lettuce topping
     * @param view  Radio button for lettuce topping
     */
    public void cbLettuceAction(View view) {
        checkBox_lettuce= findViewById(R.id.checkBox_lettuce);
        // make sure there is not more than 3 toppings
        if (toppings_counter > 2){

            if (!checkBox_lettuce.isChecked()){
                toppings_counter--;
                checkBox_lettuce.toggle();
            }
            checkBox_lettuce.setChecked(false);
            Toast.makeText(this, "Can only choose up to 3 toppings! ", Toast.LENGTH_SHORT).show();

        }
        else {
            if (checkBox_lettuce.isChecked()) {
                total_lettuce = 1;
                toppings_counter++;

            }
            if (!checkBox_lettuce.isChecked()){
                total_lettuce = 0;
                toppings_counter--;
            }
        }

    }
}