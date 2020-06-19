package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button submit;
    int correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }
    //method to check answer for question1  is correct or not

    private void checkQuestionOneAnswers(){
        CheckBox questionOneMario = (CheckBox) findViewById(R.id.checkboxQuest1AnswerMario);
        CheckBox questionOneDonkey = (CheckBox) findViewById(R.id.checkboxQuest1AnswerDonkey);
        CheckBox questionOnePortal = (CheckBox) findViewById(R.id.checkboxQuest1AnswerPortal);
        boolean isQuestionOneMarioChecked = questionOneMario.isChecked();
        boolean isQuestionOneDonkeyChecked = questionOneDonkey.isChecked();
        boolean isQuestionOnePortalChecked = questionOnePortal.isChecked();

        if (isQuestionOneMarioChecked && isQuestionOneDonkeyChecked && !isQuestionOnePortalChecked){
            correctAnswers += 1;
        }
        else
            correctAnswers += 0;
    }
    //method to check answer for question 2 is correct or not

    private void checkQuestionTwoAnswers(){
        RadioButton radioButton1989 = (RadioButton) findViewById(R.id.radio_1989);
        boolean isQuestionTwo1989Checked = radioButton1989.isChecked();
        if (isQuestionTwo1989Checked){
            correctAnswers += 1;
        }
        else
            correctAnswers += 0;
    }
    //method to check answer for question 3 is correct or not

    private String getQuestionThreeUserInput() {
        EditText userInputLastName = (EditText) findViewById(R.id.answerInputWebsite);
        String name = userInputLastName.getText().toString();
        return name;
    }

    private void checkQuestionThreeAnswer(){
        String name = getQuestionThreeUserInput();
        if (name.trim().equalsIgnoreCase("Udacity")){
            correctAnswers += 1;
        }
        else
            correctAnswers += 0;
    }
    //method to check answer for question 4 is correct or not

    private void checkQuestionFourAnswers(){
        RadioButton radioButtonPortal = (RadioButton) findViewById(R.id.radio_portal);
        boolean isQuestionTwoPortalChecked = radioButtonPortal.isChecked();
        if (isQuestionTwoPortalChecked){
            correctAnswers += 1;
        }
        else
            correctAnswers += 0;
    }

    //method to check answer for question 5 is correct or not

    private void checkQuestionFiveAnswers(){
        CheckBox questionFiveGameBoy = (CheckBox) findViewById(R.id.checkboxQuest5GameBoy);
        CheckBox questionFivePSP = (CheckBox) findViewById(R.id.checkboxQuestPSP);
        CheckBox questionFiveWii = (CheckBox) findViewById(R.id.checkboxQuest5Wii);
        boolean isQuestionFiveGameBoyChecked = questionFiveGameBoy.isChecked();
        boolean isQuestionFivePSPChecked = questionFivePSP.isChecked();
        boolean isQuestionFiveWiiChecked = questionFiveWii.isChecked();

        if (isQuestionFiveGameBoyChecked && !isQuestionFivePSPChecked && isQuestionFiveWiiChecked){
            correctAnswers += 1;
        }
        else
            correctAnswers += 0;
    }

    private void checkAllQuestions(){
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    private void resetCounterCorrectAnswers(){
        correctAnswers = 0;
    }
    // method to display result as a toast

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkAllQuestions();
            Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers + "/5",
                    Toast.LENGTH_LONG).show();
            resetCounterCorrectAnswers();
        }
    };
}