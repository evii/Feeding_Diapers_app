package com.example.android.feeding_diapers_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.id.message;

public class MainActivity extends AppCompatActivity {
    int numberOfFeeds = 0;
    int numberOfDiapers = 0;
    int numberOfPoos = 0;
    int numberOfPees = 0;
    static final String FEEDS = "number-of-feeds";
    static final String DIAPERS = "number-of-diapers";
    static final String POOS = "number-of-poos";
    static final String PEES = "number-of-pees";
    TextView breastTextView;
    TextView diapersView;
    TextView feedsView;
    TextView poosTextView;
    TextView peesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        breastTextView = (TextView) findViewById(R.id.LeftRightBreast);
        diapersView = (TextView) findViewById(R.id.NumberOfDiapers);
        feedsView = (TextView) findViewById(R.id.NumberOfFeeds);
        poosTextView = (TextView) findViewById(R.id.NumberOfPoos);
        peesTextView = (TextView) findViewById(R.id.NumberOfPees);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(FEEDS, numberOfFeeds);
        savedInstanceState.putInt(DIAPERS, numberOfDiapers);
        savedInstanceState.putInt(POOS, numberOfPoos);
        savedInstanceState.putInt(PEES, numberOfPees);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numberOfFeeds = savedInstanceState.getInt(FEEDS);
        numberOfDiapers = savedInstanceState.getInt(DIAPERS);
        numberOfPoos = savedInstanceState.getInt(POOS);
        numberOfPees = savedInstanceState.getInt(PEES);
        displayNumberOfFeeds(numberOfFeeds);
        displayNumberOfDiapers(numberOfDiapers);
        String Poos = "Poos: " + numberOfPoos;
        displayNumberOfPoos(Poos);
        String Pees = "Pees: " + numberOfPees;
        displayNumberOfPees(Pees);
    }

    public void displayNumberOfFeeds(int feeds) {
        feedsView.setText(String.valueOf(feeds));
    }

    public void displayNumberOfDiapers(int diapers) {
        diapersView.setText(String.valueOf(diapers));
    }

    private void displayRightOrLeft(String message) {
        breastTextView.setText(message);
    }

    private void displayNumberOfPoos(String poos) {
        poosTextView.setText(poos);
    }

    private void displayNumberOfPees(String pees) {
        peesTextView.setText(pees);
    }

    public void feedFromLeftBreast(View view) {
        String messageFeedFromRight = "Next feeding from RIGHT breast.";
        numberOfFeeds = numberOfFeeds + 1;
        displayNumberOfFeeds(numberOfFeeds);
        displayRightOrLeft(messageFeedFromRight);
    }

    public void feedFromRightBreast(View view) {
        String messageFeedFromLeft = "Next feeding from LEFT breast.";
        numberOfFeeds = numberOfFeeds + 1;
        displayNumberOfFeeds(numberOfFeeds);
        displayRightOrLeft(messageFeedFromLeft);
    }

    public void feedFromFormula(View view) {
        numberOfFeeds = numberOfFeeds + 1;
        displayNumberOfFeeds(numberOfFeeds);
    }

    public void pooInDiaper(View view) {
        numberOfDiapers = numberOfDiapers + 1;
        displayNumberOfDiapers(numberOfDiapers);
        numberOfPoos = numberOfPoos + 1;
        String Poos = "Poos: " + numberOfPoos;
        displayNumberOfPoos(Poos);
    }

    public void peeInDiaper(View view) {
        numberOfDiapers = numberOfDiapers + 1;
        displayNumberOfDiapers(numberOfDiapers);
        numberOfPees = numberOfPees + 1;
        String Pees = "Pees: " + numberOfPees;
        displayNumberOfPees(Pees);
    }

    public void pooPeeInDiaper(View view) {
        numberOfDiapers = numberOfDiapers + 1;
        displayNumberOfDiapers(numberOfDiapers);
        numberOfPoos = numberOfPoos + 1;
        numberOfPees = numberOfPees + 1;
        String Pees = "Pees: " + numberOfPees;
        displayNumberOfPees(Pees);
        String Poos = "Poos: " + numberOfPoos;
        displayNumberOfPoos(Poos);

    }

    public void newDay(View view) {
        numberOfFeeds = 0;
        numberOfDiapers = 0;
        numberOfPoos = 0;
        numberOfPees = 0;
        String Pees = "Pees: " + numberOfPees;
        String Poos = "Poos: " + numberOfPoos;
        displayNumberOfDiapers(numberOfDiapers);
        displayNumberOfPees(Pees);
        displayNumberOfPoos(Poos);
        displayNumberOfFeeds(numberOfFeeds);

    }
}

