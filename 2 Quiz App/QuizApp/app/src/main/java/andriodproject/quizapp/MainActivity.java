package andriodproject.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean correctAnswer_QuestionA1 = true;
    boolean correctAnswer_QuestionA2 = false;
    boolean correctAnswer_QuestionA3 = true;
    boolean correctAnswer_QuestionA4 = true;
    boolean correctAnswer_QuestionA5 = false;
    boolean correctAnswer_QuestionA6 = false;
    String correctAnswer_QuestionB = "FEMALE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SubmitResult(View v) {

        String name = ((EditText) findViewById(R.id.nameText)).getText().toString();
        Boolean IsMale_gender = ((RadioButton) findViewById(R.id.male)).isChecked();
        Boolean IsFemale_gender = ((RadioButton) findViewById(R.id.female)).isChecked();
        Boolean answerQA1 = ((CheckBox) findViewById(R.id.CheckBoxQ1)).isChecked();
        Boolean answerQA2 = ((CheckBox) findViewById(R.id.CheckBoxQ2)).isChecked();
        Boolean answerQA3 = ((CheckBox) findViewById(R.id.CheckBoxQ3)).isChecked();
        Boolean answerQA4 = ((CheckBox) findViewById(R.id.CheckBoxQ4)).isChecked();
        Boolean answerQA5 = ((CheckBox) findViewById(R.id.CheckBoxQ5)).isChecked();
        Boolean answerQA6 = ((CheckBox) findViewById(R.id.CheckBoxQ6)).isChecked();
        String answerQB = ((EditText) findViewById(R.id.txt_questionB)).getText().toString();
        Boolean answerQC = ((RadioButton) findViewById(R.id.Belgium)).isChecked(); //correct answer Question -C

        int score = getScore(answerQA1, answerQA2, answerQA3, answerQA4, answerQA5, answerQA6, answerQB, answerQC);
        String result, helloMsg;
        if (score == 8)
            result = "Congrats.. You answered all of them correctly :)";
        else if (score == 0)
            result = "Please answer the questions to view your results. ";
        else
            result = "You answered " + score + " out of 8 correctly.";

        if (IsMale_gender)
            helloMsg = "Hello, Mr." + name;
        else if (IsFemale_gender)
            helloMsg = "Hello, Ms." + name;
        else
            helloMsg = "Hello there";

        Toast.makeText(MainActivity.this, helloMsg, Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
    }

    private int getScore(Boolean answerQ1, Boolean answerQ2, Boolean answerQ3, Boolean answerQ4, Boolean answerQ5, Boolean answerQ6, String answerQB, Boolean answerQC) {

        int score = 0;

        if (answerQ1 == correctAnswer_QuestionA1)
            score++;
        if (answerQ2 == correctAnswer_QuestionA2)
            score++;
        if (answerQ3 == correctAnswer_QuestionA3)
            score++;
        if (answerQ4 == correctAnswer_QuestionA4)
            score++;
        if (answerQ5 == correctAnswer_QuestionA5)
            score++;
        if (answerQ6 == correctAnswer_QuestionA6)
            score++;

        if (answerQB.toUpperCase().equals(correctAnswer_QuestionB))
            score++;

        if (answerQC)
            score++;

        return score;
    }

}
