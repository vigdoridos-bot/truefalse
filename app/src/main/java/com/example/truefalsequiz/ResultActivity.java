package com.example.truefalsequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tvResult = findViewById(R.id.tvResult);
        TextView tvExplanation = findViewById(R.id.tvExplanation);

        Intent intent = getIntent();
        boolean Q2 = intent.getBooleanExtra("Q2", false);
        boolean isCorrect = intent.getBooleanExtra("isCorrect", false);
        boolean isCorrect2 = intent.getBooleanExtra("isCorrect2", false);
        String tvExplanation2 = intent.getStringExtra("tvExplanation");
        tvExplanation.setText(tvExplanation2);

        Button nextQ = findViewById(R.id.nextQ);
        nextQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(ResultActivity.this, SecondQuestionActivity.class);
                startActivity(intent2);

            }
        });

        if(!Q2) {

            if (isCorrect) {
                LinearLayout main = findViewById(R.id.main);
                main.setBackgroundColor(getColor(R.color.green));
                tvResult.setText("צדקת הוא מאוד מושך");

            } else {
                LinearLayout main = findViewById(R.id.main);
                main.setBackgroundColor(getColor(R.color.red));
                tvResult.setText("טעית הוא לא מושך");

            }
        }
        else{
            nextQ.setVisibility(View.GONE);
            if(isCorrect2){
                LinearLayout main = findViewById(R.id.main);
                main.setBackgroundColor(getColor(R.color.green));
                tvResult.setText("צדקת לא רוצים אותם");
            }
            else{
                LinearLayout main = findViewById(R.id.main);
                main.setBackgroundColor(getColor(R.color.red));
                tvResult.setText("טעית לא רוצים אותם ");
            }
        }



        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }
}