package andriodproject.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Tracks the score for Team A
    int scoreTeamA = 0;
    // Tracks the score for Team B
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Increase the goal for Team A by 1 point.
    public void addGoalForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA, "Goal");
    }

    //Increase the foul for Team A by 1 point.
    public void addFoulForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA, "Foul");
    }

    //Increase the goal for Team B by 1 point.
    public void addGoalForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB, "Goal");
    }

    //Increase the foul for Team A by 1 point.
    public void addFoulForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB, "Foul");
    }

    //Resets the score for both teams back to 0.
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA, "All");
        displayForTeamB(scoreTeamB, "All");
    }

    // Displays the given score for Team A.
    public void displayForTeamA(int score, String type) {
        TextView scoreView;
        if (type.equals("Goal")) {
            scoreView = (TextView) findViewById(R.id.team_a_goal);
            scoreView.setText(String.valueOf(score));
        } else if (type.equals("Foul")) {
            scoreView = (TextView) findViewById(R.id.team_a_foul);
            scoreView.setText(String.valueOf(score));
        } else //All
        {
            scoreView = (TextView) findViewById(R.id.team_a_goal);
            scoreView.setText(String.valueOf(score));
            scoreView = (TextView) findViewById(R.id.team_a_foul);
            scoreView.setText(String.valueOf(score));
        }

    }

    // Displays the given score for Team B.
    public void displayForTeamB(int score, String type) {
        TextView scoreView;
        if (type.equals("Goal")) {
            scoreView = (TextView) findViewById(R.id.team_b_goal);
            scoreView.setText(String.valueOf(score));
        } else if (type.equals("Foul")) {
            scoreView = (TextView) findViewById(R.id.team_b_foul);
            scoreView.setText(String.valueOf(score));
        } else //All
        {
            scoreView = (TextView) findViewById(R.id.team_b_goal);
            scoreView.setText(String.valueOf(score));
            scoreView = (TextView) findViewById(R.id.team_b_foul);
            scoreView.setText(String.valueOf(score));
        }
    }

}
