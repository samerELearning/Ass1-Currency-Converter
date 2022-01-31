package com.samersbr1.spring2022.currencyconverter;
/*****************************************************************************
 * MainActivity.java
 * @author Samer Saber
 * Implementing a currency converter from lbp to Dollars and vice versa
 * Last modified on Monday, 31 of January 2022
 *****************************************************************************/

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected EditText lbp;
    protected EditText usd;
    protected final double RATE = 22000.00;//Updated on Monday 31 of January

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lbp = (EditText) findViewById(R.id.lbp);
        usd = (EditText) findViewById(R.id.usd);
    }

    public void eraseLbp(View view) {
    //Erases the text in lbp section
        lbp.setText(null);
    }

    public void eraseUsd(View view) {
    //Erases the text in usd section
        usd.setText(null);
    }

    public void lbpToUsd(View view)
    {
     //Converts lbp to usd and outputs the value in usd section.
        Double result;

        result = 0.0;
        if (!lbp.getText().toString().equals(""))
        {
         //If lbp input from the user exists
            try {
                result = Double.parseDouble(lbp.getText().toString()) / RATE;
            }catch(NumberFormatException e)
            {
                Toast.makeText(getApplicationContext(), "Number format error", Toast.LENGTH_LONG).show();
            }
            usd.setText("" + result);
        }
        else
            Toast.makeText(getApplicationContext(), "Please input lbp value", Toast.LENGTH_LONG).show();
    }

    public void usdToLbp(View view)
    {
     //Converts usd to lbp and outputs the value in lbp section
        Double result;

        result = 0.0;

        if (!usd.getText().toString().equals(""))
        {
         //if usd input from the user exists
            try {
                result = Double.parseDouble(usd.getText().toString()) * RATE;
            }catch(NumberFormatException e)
            {
                Toast.makeText(getApplicationContext(), "Number format error", Toast.LENGTH_LONG).show();
            }

            lbp.setText("" + result);
        }
        else
            Toast.makeText(getApplicationContext(), "Please input usd value", Toast.LENGTH_LONG).show();

    }

    public void convert(View view)
    {
     //Converts the lbp value to usd value and vice versa
        if (lbp.getText().toString().equals("") && usd.getText().toString().equals(""))
        {
         //If both usd and lbp have no input from user
            Toast.makeText(getApplicationContext(), "Please input usd or lbp value", Toast.LENGTH_LONG).show();
        }
        else if (!lbp.getText().toString().equals("") && !usd.getText().toString().equals(""))
        {
         //If both usd and lbp have input from user
            Toast.makeText(getApplicationContext(), "Please input either usd or lbp value, but not both", Toast.LENGTH_LONG).show();
        }
        else if (!lbp.getText().toString().equals(""))
        {
         //If lbp has input from user, then convert to usd
            lbpToUsd(null);
        }
        else
        //If usd has input from user, then convert to lbp
            usdToLbp(null);
    }

}