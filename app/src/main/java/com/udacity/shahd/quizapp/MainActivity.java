package com.udacity.shahd.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
        if (!checkAnswer1())
            Toast.makeText(this,"answer 1 is wrong.",Toast.LENGTH_LONG).show();
        if (!checkAnswer2())
            Toast.makeText(this,"answer 2 is wrong.",Toast.LENGTH_LONG).show();
        if (!checkAnswer3())
            Toast.makeText(this,"answer 3 is wrong.",Toast.LENGTH_LONG).show();
        if (!checkAnswer4())
            Toast.makeText(this,"answer 4 is wrong.",Toast.LENGTH_LONG).show();
        if (checkAnswer1()&&checkAnswer2()&&checkAnswer3()&&checkAnswer4())
            Toast.makeText(this,"All your answer are correct.",Toast.LENGTH_LONG).show();
        else if (!(checkAnswer1()&&checkAnswer2()&&checkAnswer3()&&checkAnswer4()))
            Toast.makeText(MainActivity.this,"All your answer are wrong.",Toast.LENGTH_LONG).show();
    }

    public boolean checkAnswer1(){
        int answer1 = Integer.parseInt(((EditText)findViewById(R.id.answer1)).getText().toString());
        if (answer1==0)
            return true;
        else return false;
    }
    public boolean checkAnswer2(){
        boolean answer2 = ((CheckBox)findViewById(R.id.answer2)).isChecked();
        return !answer2;
    }
    public boolean checkAnswer3(){
        int answer3 = Integer.parseInt(((EditText)findViewById(R.id.answer3)).getText().toString());
        if (answer3==1)
            return true;
        else return false;
    }
    public boolean checkAnswer4(){
        int answer4 = Integer.parseInt(((EditText)findViewById(R.id.answer4)).getText().toString());
        if (answer4==1)
            return true;
        else return false;
    }
}
