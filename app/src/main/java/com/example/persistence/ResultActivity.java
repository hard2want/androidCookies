package com.example.persistence;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // create an outlet from the text view label
        final TextView resultLabel = (TextView)findViewById(R.id.result);

        // connect the cookies to the controller
        final SharedPreferences sharedPreference = PreferenceManager.getDefaultSharedPreferences(this);


        // pull the value from your cookie via the key
        final String num1 = sharedPreference.getString("number01", null);
        final String num2 = sharedPreference.getString("number02", null);
        final String mathOperator = sharedPreference.getString("operation", null);


        Double n1 = Double.parseDouble(num1.toString());
        Double n2 = Double.parseDouble(num2.toString());

        // convert the operation to a string
        String op = mathOperator.toString();

        // convert the string to a character
        char[] operation = op.toCharArray();

        // assign the character from the array to a variable
        char operator = operation[0];

        Double result = 0.0;

        switch (operator) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                result = n1 / n2;
                break;
        } // end switch

        // post the value to the view
        resultLabel.setText("Result: " + result);

    } // end onCreate()

} // end ResultActivity {}
