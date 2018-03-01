package com.example.dell.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.dell.quizapp.SelectedAnswers.ans1;
import static com.example.dell.quizapp.SelectedAnswers.ans10;
import static com.example.dell.quizapp.SelectedAnswers.ans2;
import static com.example.dell.quizapp.SelectedAnswers.ans3;
import static com.example.dell.quizapp.SelectedAnswers.ans4;
import static com.example.dell.quizapp.SelectedAnswers.ans5;


public class ScrollingActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName;
    EditText etEmail;
    RadioGroup radioGroupQuiz1;
    RadioGroup radioGroupQuiz2;
    RadioGroup radioGroupQuiz3;
    RadioGroup radioGroupQuiz4;
    RadioGroup radioGroupQuiz5;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    Button btnContinue;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    EditText etOddOneBox;
    RadioGroup radioGroupQuiz6;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        radioGroupQuiz1 = (RadioGroup) findViewById(R.id.radioGroupSpell1);
        radioGroupQuiz2 = (RadioGroup) findViewById(R.id.radioGroupSpell2);
        radioGroupQuiz3 = (RadioGroup) findViewById(R.id.radioGroupSpell3);
        radioGroupQuiz4 = (RadioGroup) findViewById(R.id.radioGroupSpell4);
        radioGroupQuiz5 = (RadioGroup) findViewById(R.id.radioGroupSpell5);
        btnContinue = (Button) findViewById(R.id.btnContinue);
        checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkbox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkbox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkbox6);
        etOddOneBox = (EditText) findViewById(R.id.etOddOneBox);
        radioGroupQuiz6 = (RadioGroup) findViewById(R.id.radioGroupQuiz6);

        btnContinue.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            startActivity(new Intent(ScrollingActivity.this, AboutActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        if (radioGroupQuiz1.getCheckedRadioButtonId() > 0) {
            int selectedAnswer1 = radioGroupQuiz1.getCheckedRadioButtonId();
            radioButton1 = (RadioButton) findViewById(selectedAnswer1);
            ans1 = (String) radioButton1.getText();
        } else {
            ans1 = "wrong";
        }
        if (radioGroupQuiz2.getCheckedRadioButtonId() > 0) {
            int selectedAnswer2 = radioGroupQuiz2.getCheckedRadioButtonId();
            radioButton2 = (RadioButton) findViewById(selectedAnswer2);
            ans2 = (String) radioButton2.getText();
        } else {
            ans2 = "wrong";
        }
        if (radioGroupQuiz3.getCheckedRadioButtonId() > 0) {
            int selectedAnswer3 = radioGroupQuiz3.getCheckedRadioButtonId();
            radioButton3 = (RadioButton) findViewById(selectedAnswer3);
            ans3 = (String) radioButton3.getText();
        } else {
            ans3 = "wrong";
        }
        if (radioGroupQuiz4.getCheckedRadioButtonId() > 0) {
            int selectedAnswer4 = radioGroupQuiz4.getCheckedRadioButtonId();
            radioButton4 = (RadioButton) findViewById(selectedAnswer4);
            ans4 = (String) radioButton4.getText();
        } else {
            ans4 = "wrong";
        }
        if (radioGroupQuiz5.getCheckedRadioButtonId() > 0) {
            int selectedAnswer5 = radioGroupQuiz5.getCheckedRadioButtonId();
            radioButton5 = (RadioButton) findViewById(selectedAnswer5);
            ans5 = (String) radioButton5.getText();
        } else {
            ans5 = "wrong";
        }
        if (isEmpty(etName) == true) {
            etName.setError("Empty fields not allowed.");
        } else {
            String name = etName.getText().toString().trim();
            SelectedAnswers.name = name;
        }
        if (isEmpty(etName) == true) {
            etEmail.setError("Empty fields not allowed.");
        } else {
            String email = etEmail.getText().toString().trim();
            SelectedAnswers.email = email;
        }
        if (!checkBox1.isChecked() && checkBox2.isChecked() && !checkBox3.isChecked() && checkBox4.isChecked() && !checkBox5.isChecked() && checkBox6.isChecked()) {
            SelectedAnswers.ans6 = true;
            SelectedAnswers.ans7 = true;
            SelectedAnswers.ans8 = true;
        }
        if (isEmpty(etOddOneBox) == true) {
            SelectedAnswers.ans9 = "wrong";
        } else {
            String textBoxValue = etOddOneBox.getText().toString();
            SelectedAnswers.ans9 = textBoxValue.trim();
        }
        if (radioGroupQuiz6.getCheckedRadioButtonId() > 0) {
            int selectedAnswer = radioGroupQuiz6.getCheckedRadioButtonId();
            radioButton = (RadioButton) findViewById(selectedAnswer);
            SelectedAnswers.ans10 = (String) radioButton.getText();
        } else {
            ans10 = "wrong";
        }
        Intent intent = new Intent(ScrollingActivity.this, ScoreActivity.class);
        startActivity(intent);
    }

    public boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
