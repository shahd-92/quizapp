package com.udacity.shahd.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            answer1 = Integer.parseInt(((EditText) findViewById(R.id.answer1)).getText().toString());
        }catch (NumberFormatException nfe){
                nfe.getStackTrace();
            }
        if (answer1==1)
            return 1;
        else return 0;
    }
    public int checkAnswer2(){
        boolean trueAnswer2 = ((RadioButton)findViewById(R.id.trueAnswer2)).isChecked();
        boolean falseAnswer2 = ((RadioButton)findViewById(R.id.falseAnswer2)).isChecked();
        if (falseAnswer2)
        return 1;
        else return 0;

    }
    public int checkAnswer3(){
        int answer3 =0;
        try {
            answer3=Integer.parseInt(((EditText)findViewById(R.id.answer3)).getText().toString());
        }catch (NumberFormatException nfe){
            nfe.getStackTrace();
        }
        if (answer3==1)
            return 1;
        else return 0;
    }
    public int checkAnswer4(){
        int answer4 = 0;
        try{
            answer4=Integer.parseInt(((EditText)findViewById(R.id.answer4)).getText().toString());
        }catch (NumberFormatException nfe){
            nfe.getStackTrace();
        }
        if (answer4==1)
            return 1;
        else return 0;
    }
    public int checkAnswer5(){
        boolean choice1Answer5 = ((CheckBox)findViewById(R.id.choice1Answer5)).isChecked();
        boolean choice2Answer5 = ((CheckBox)findViewById(R.id.choice2Answer5)).isChecked();
        boolean choice3Answer5 = ((CheckBox)findViewById(R.id.choice3Answer5)).isChecked();
        boolean choice4Answer5 = ((CheckBox)findViewById(R.id.choice4Answer5)).isChecked();
        if (choice3Answer5&&choice2Answer5)
            return 2;
        else if(choice3Answer5||choice2Answer5)
            return 1;
        else return 0;
    }
}
