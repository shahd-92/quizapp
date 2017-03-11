package com.udacity.shahd.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.answer4) EditText answer4EditText;
    @BindView(R.id.answer1) EditText answer1EditText;
    @BindView(R.id.answer3) EditText answer3EditText;
    @BindView(R.id.trueAnswer2) RadioButton trueAnswer2RadioButton;
    @BindView(R.id.falseAnswer2) RadioButton falseAnswer2RadioButton;
    @BindView(R.id.choice1Answer5) CheckBox choice1Answer5CheckBox;
    @BindView(R.id.choice2Answer5) CheckBox choice2Answer5CheckBox;
    @BindView(R.id.choice3Answer5) CheckBox choice3Answer5CheckBox;
    @BindView(R.id.choice4Answer5) CheckBox choice4Answer5CheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submit(View view) {
        int totalscore=checkAnswer1()+checkAnswer2()+checkAnswer3()+checkAnswer4()+checkAnswer5();
        if (totalscore==6)
            Toast.makeText(this,"All your answers are correct. Your score is "+totalscore,Toast.LENGTH_LONG).show();
        else if (totalscore==0)
            Toast.makeText(this,"All your answers are wrong. Your score is "+totalscore,Toast.LENGTH_LONG).show();
        else {
            if (checkAnswer1() == 0)
                Toast.makeText(this, "answer 1 is wrong. ", Toast.LENGTH_LONG).show();
            if (checkAnswer2() == 0)
                Toast.makeText(this, "answer 2 is wrong.", Toast.LENGTH_LONG).show();
            if (checkAnswer3() == 0)
                Toast.makeText(this, "answer 3 is wrong.", Toast.LENGTH_LONG).show();
            if (checkAnswer4() == 0)
                Toast.makeText(this, "answer 4 is wrong.", Toast.LENGTH_LONG).show();
            if (checkAnswer5() == 1)
                Toast.makeText(this, "there is one more correct choice in Q5", Toast.LENGTH_LONG).show();
            if (checkAnswer5() == 0)
                Toast.makeText(this, "answer 5 is wrong.", Toast.LENGTH_LONG).show();

                Toast.makeText(this, "Your score is "+totalscore, Toast.LENGTH_LONG).show();
        }
    }

    public int checkAnswer1(){
        int answer1=0;
        try {
            String a1=answer1EditText.getText().toString();
            answer1 = Integer.parseInt(a1);
        }catch (Exception e){
                e.getStackTrace();
            }
        if (answer1==1)
            return 1;
        else return 0;
    }
    public int checkAnswer2(){
        boolean trueAnswer2= false;
        boolean falseAnswer2 = false;
        try {
        trueAnswer2= trueAnswer2RadioButton.isChecked();
        falseAnswer2= falseAnswer2RadioButton.isChecked();}
        catch (NullPointerException e){
            e.getStackTrace();
        }
        if (falseAnswer2)
        return 1;
        else return 0;

    }
    public int checkAnswer3(){
        int answer3 =0;
        try {
            answer3=Integer.parseInt(answer3EditText .getText().toString());
        }catch (Exception nfe){
            nfe.getStackTrace();
        }
        if (answer3==1)
            return 1;
        else return 0;
    }
    public int checkAnswer4(){
        int answer4 = 0;

        try{
            answer4=Integer.parseInt(answer4EditText.getText().toString());
        }catch (Exception nfe){
            nfe.getStackTrace();
        }
        if (answer4==1)
            return 1;
        else return 0;
    }
    public int checkAnswer5(){
        boolean choice1Answer5=false ;
        boolean choice2Answer5=false ;
        boolean choice3Answer5=false ;
        boolean choice4Answer5=false ;
        try {
             choice1Answer5 = choice1Answer5CheckBox.isChecked();
             choice2Answer5 = choice2Answer5CheckBox.isChecked();
             choice3Answer5 = choice3Answer5CheckBox.isChecked();
             choice4Answer5 = choice4Answer5CheckBox.isChecked();
        }catch (NullPointerException npe){
            npe.getStackTrace();
        }
        if (choice3Answer5&&choice2Answer5)
            return 2;
        else if(choice3Answer5||choice2Answer5)
            return 1;
        else return 0;
    }
}
