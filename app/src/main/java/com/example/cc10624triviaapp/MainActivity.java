package com.example.cc10624triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



        private Button tButton, fButton, nButton, pButton;

        private TextView tQuestion, tScore;

        private  int currentIdx = 0, score =0 ;


        private TrueFalse[] questionBank = new TrueFalse[] {
                new TrueFalse(R.string.q1,true, false),
                new TrueFalse(R.string.q2,false, false),
                new TrueFalse(R.string.q3,true, false),
                new TrueFalse(R.string.q4,true, false),
                new TrueFalse(R.string.q5,true, false),
                new TrueFalse(R.string.q6,true, false),
                new TrueFalse(R.string.q7,false, false),
                new TrueFalse(R.string.q8,true, false),
                new TrueFalse(R.string.q9,false, false),
                new TrueFalse(R.string.q10,true, false),
                new TrueFalse(R.string.q11,true, false)






        };







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tButton = findViewById(R.id.btnTrue);
        fButton = findViewById(R.id.btnFalse);
        nButton = findViewById(R.id.btnNext);
        pButton = findViewById(R.id.btnPrevious);

        tQuestion = findViewById(R.id.txtQuestion);
        tScore = findViewById(R.id.txtScore);

        int idxQuestion = questionBank[currentIdx].getIdxQuestion();
        tQuestion.setText(idxQuestion);

        //next button
        nButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetQuiz();
            }
        });
////
//        pButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showPreviousQuestion();
//            }
//        });

        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
    }

    private void showNextQuestion() {
        if (currentIdx == 9) {
            // Disable buttons
            tButton.setEnabled(false);
            fButton.setEnabled(false);
            nButton.setEnabled(true);

        }
        currentIdx = (currentIdx + 1) % questionBank.length;
        int idxQuestion = questionBank[currentIdx].getIdxQuestion();
        tQuestion.setText(idxQuestion);


    }

    private void showPreviousQuestion() {
        currentIdx = (currentIdx - 1 + questionBank.length) % questionBank.length;
        int idxQuestion = questionBank[currentIdx].getIdxQuestion();
        tQuestion.setText(idxQuestion);
    }

    private void checkAnswer(boolean selectedAnswer) {
        boolean keyAnswer = questionBank[currentIdx].isKeyAnswer();
        if (selectedAnswer == keyAnswer) {
            score++;
            Toast.makeText(MainActivity.this, R.string.msgcorrect, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.msgincorrect, Toast.LENGTH_SHORT).show();
        }

        tScore.setText("Score" +score);

        if (currentIdx == questionBank.length) {

            Toast.makeText(MainActivity.this, R.string.congratulations_message, Toast.LENGTH_LONG).show();
        } else {
            showNextQuestion();
        }
    }

    private void resetQuiz() {
        // Reset currentIdx and score
        currentIdx = 0;
        score = 0;

        // Reset isAnswered flag for each question in questionBank
        for (TrueFalse question : questionBank) {
            question.setAnswered(false);
        }

        // Update UI to show the first question
        int idxQuestion = questionBank[currentIdx].getIdxQuestion();
        tQuestion.setText(idxQuestion);
        tScore.setText("Score: " + score);

        // Enable buttons
        tButton.setEnabled(true);
        fButton.setEnabled(true);
        nButton.setEnabled(false);

    }




}





























