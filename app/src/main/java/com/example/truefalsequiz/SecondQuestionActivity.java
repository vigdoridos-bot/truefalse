package com.example.truefalsequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondQuestionActivity extends AppCompatActivity {
    boolean correctAnswer = false;
    boolean Q2 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_question);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button buttonT = findViewById(R.id.buttonT);
        buttonT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean userAnswer = true;

                boolean isCorrect2;
                if (userAnswer == correctAnswer) {
                    isCorrect2 = true;
                } else {
                    isCorrect2 = false;
                }

                Intent intent = new Intent(SecondQuestionActivity.this, ResultActivity.class);
                intent.putExtra("isCorrect2", isCorrect2);
                intent.putExtra("Q2", Q2);
                startActivity(intent);


            }
        });
        Button buttonF = findViewById(R.id.buttonF);
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = false;
                boolean isCorrect2;
                if(userAnswer == correctAnswer) {
                    isCorrect2 = true;
                } else {
                    isCorrect2 = false;
                }
                Intent intent = new Intent(SecondQuestionActivity.this, ResultActivity.class);
                intent.putExtra("isCorrect2", isCorrect2);
                intent.putExtra("Q2", Q2);
                startActivity(intent);


            }
        });
    }
}