package com.example.recycleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Game extends AppCompatActivity {

    TextView Question, OptionA, OptionB;
    CardView Card1Option,Card2Option;
    ArrayList<QuestionModel> models;
    QuestionModel singleModel;
    int index=0;

    int level=0;
    TextView LevelCounter;
    Button Next;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        MatchingTage();
        models = provider.getQuestion();
        Collections.shuffle(models);
        singleModel = models.get(index);
        Next = findViewById(R.id.next);
        LevelCounter = findViewById(R.id.LevelCounter);
        description = findViewById(R.id.textView5);



        SetAllData();
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index < models.size()-1)
                {
                    description.setVisibility(View.GONE);
                    index++;
                    level=index+1;
                    LevelCounter.setText("Question "+level+"");
                    singleModel = models.get(index);
                    SetAllData();
                    Card1Option.setBackgroundColor(Color.parseColor("#C18B8B"));
                    Card1Option.setRadius(10);

                    Card2Option.setBackgroundColor(Color.parseColor("#C18B8B"));
                    Card2Option.setRadius(10);
                    Next.setVisibility(View.GONE);

                }
                else
                {

                    GameWon();
                }

            }
        });
    }


    public void MatchingTage()
    {
        Question = findViewById(R.id.Qtext);
        OptionA = findViewById(R.id.option1);
        OptionB = findViewById(R.id.option2);
        Card1Option = findViewById(R.id.option1Card);
        Card2Option = findViewById(R.id.option2Card);

    }
    private void SetAllData(){

        Question.setText(singleModel.getQuestion());
        OptionA.setText(singleModel.getoA());
        OptionB.setText(singleModel.getoB());

    }
    public void Correct(CardView cardView){





        description.setVisibility(View.VISIBLE);
        description.setText(models.get(index).getDescription());
        Next.setVisibility(View.VISIBLE);
        cardView.setBackgroundColor(Color.parseColor("#00ff00"));

        // index++;
        // singleModel = models.get(index);
        // SetAllData();



    }


    public void Wrong(CardView card1Option){

        description.setVisibility(View.VISIBLE);
        description.setText(models.get(index).getDescription());

        card1Option.setBackgroundColor(Color.parseColor("#ff0000"));

        Next.setVisibility(View.VISIBLE);
        if(index < models.size()-1)
        {
            //  index++;
            //singleModel = models.get(index);
            //SetAllData();


        }
        else
        {

            GameWon();
        }

    }

    public void GameWon()
    {
        Toast.makeText(Game.this,"Game Completed",Toast.LENGTH_LONG).show();
    }
    public void OptionA(View view) {

        if(singleModel.getoA().equals(singleModel.getRightanswer()))
        {

            if(index < models.size()-1)
            {
                Correct(Card1Option);

            }
            else{
                GameWon();

            }
        }

        else
        {
            Wrong(Card1Option);

        }
    }

    public void OptionB(View view) {


        if(singleModel.getoB().equals(singleModel.getRightanswer()))
        {
            //   Card2Option.setBackgroundColor(getResources().getColor(R.color.teal_700));
            if(index < models.size()-1)
            {
                Correct(Card2Option);

            }
            else{
                GameWon();
            }
        }

        else
        {
            Wrong(Card2Option);

        }
    }
}