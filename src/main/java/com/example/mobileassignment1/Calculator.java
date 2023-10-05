package com.example.mobileassignment1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Calculator extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        //Retrieve the edit fields
        EditText principal = findViewById(R.id.inputPrincipal);
        EditText rate = findViewById(R.id.inputRate);
        EditText term = findViewById(R.id.inputTerm);
        //
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        //OnChange functions for edit text fields, Call calculate function when edit text fields are changed
        principal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
               //
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                calculateOnChange();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // This method is called after the text changes.
              //  calculateOnChange();
            }
        });

        rate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                calculateOnChange();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // This method is called after the text changes.
                //calculateOnChange();
            }
        });

        term.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                calculateOnChange();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // This method is called after the text changes.
               // calculateOnChange();
            }
        });
    }
    public void calculateOnChange() {
        EditText principal = findViewById(R.id.inputPrincipal);
        EditText rate = findViewById(R.id.inputRate);
        EditText term = findViewById(R.id.inputTerm);
        // Check if the input fields all have been filled in
        if (principal.getText().length() > 0 && rate.getText().length() > 0 && term.getText().length() > 0) {
            double principalAmount = Double.parseDouble(principal.getText().toString());
            double annualRate = Double.parseDouble(rate.getText().toString()) / 12 / 100;
            int termAmount = Integer.parseInt(term.getText().toString()) * 12;
            double monthlyMortgage = 0;

            // Make the calculation
            monthlyMortgage = principalAmount * (annualRate * Math.pow(1 + annualRate, termAmount)) /
                    (Math.pow(1 + annualRate, termAmount) - 1);

            TextView monthlyMortgageText = findViewById(R.id.displayMonthlyPayment);
            //Change textview to monthly amount
            monthlyMortgageText.setText("$" + String.format("%.2f", monthlyMortgage) + " per month");
        } else {
            //Display toast for user to be notified
            Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity
        }
        return super.onOptionsItemSelected(item);
    }
}
