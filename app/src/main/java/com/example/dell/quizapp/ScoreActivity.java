package com.example.dell.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.dell.quizapp.SelectedAnswers.ans1;
import static com.example.dell.quizapp.SelectedAnswers.ans2;

public class ScoreActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvName;
    TextView tvScore;
    TextView tvResult;
    Button btnCalculateScore;
    Button btnShareScore;
    Button btnCheck;
    int totalScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tvName = (TextView)findViewById(R.id.tvName);
        tvScore = (TextView)findViewById(R.id.tvScore);
        tvResult = (TextView)findViewById(R.id.tvResult);
        btnCalculateScore = (Button)findViewById(R.id.btnCalculateScore);
        btnShareScore = (Button)findViewById(R.id.btnShareScore);
        btnCheck = (Button)findViewById(R.id.btnCheck);
        tvName.append(SelectedAnswers.name);

        btnCalculateScore.setOnClickListener(this);
        btnShareScore.setOnClickListener(this);
        btnCheck.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(btnCalculateScore)) {
            tvScore.setText("");
            tvResult.setText("");
            tvScore.setText(calculateScore());
            Toast.makeText(ScoreActivity.this,calculateScore()+"",Toast.LENGTH_LONG).show();
            int score = Integer.parseInt(calculateScore());
            if(score == 10){
                tvResult.append("Excellent!");
            }else if(score>5 && score<=9){
                tvResult.append("Nice Work!");
            }else{
                tvResult.append("Not Bad!");
            }
        }else if(view.equals(btnShareScore)){
            String finalString = "Hi, "+SelectedAnswers.name+"\n"+
                    "You Scored "+calculateScore()+"\n"+
                    "Thank you for taking our quiz!!";
            sendEmail(finalString);
        }else{
            Intent intent = new Intent(ScoreActivity.this,AnswersActivity.class);
            startActivity(intent);
        }
    }

    public String calculateScore(){
        totalScore = 0;
        if (SelectedAnswers.ans1.equals("accommodate")) {
            totalScore++;
        }
        if(SelectedAnswers.ans2.equals("acknowledgement")){
            totalScore++;
        }
        if(SelectedAnswers.ans3.equals("deductible")){
            totalScore++;
        }
        if(SelectedAnswers.ans4.equals("perseverance")){
            totalScore++;
        }
        if(SelectedAnswers.ans5.equals("prerogative")){
            totalScore++;
        }
        if(SelectedAnswers.ans6 == true){
            totalScore++;
        }
        if(SelectedAnswers.ans7 == true){
            totalScore++;
        }
        if(SelectedAnswers.ans8 == true){
            totalScore++;
        }
        if(SelectedAnswers.ans9.equalsIgnoreCase("D")){
            totalScore++;
        }
        if(SelectedAnswers.ans10.equals("9")){
            totalScore++;
        }
        return totalScore+"";
    }

    public void sendEmail(String summary) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this

        intent.putExtra(Intent.EXTRA_SUBJECT,"QuizApp Score");
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
