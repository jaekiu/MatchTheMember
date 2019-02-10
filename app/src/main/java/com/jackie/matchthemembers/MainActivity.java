/**  Executes all of the activity shown when the game has started.
 * @author: Jacqueline Zhang
 * */
package com.jackie.matchthemembers;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button nameButton1, nameButton2, nameButton3, nameButton4, quitButton;
    private Button[] nameButtons;
    private TextView description;
    private TextView scoreText;
    private CountDownTimer cdt;
    private int score = 0;
    private Animation a;
    private Members deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing content
        description = (TextView) findViewById(R.id.description);
        scoreText = (TextView) findViewById(R.id.scoreText);
        imageView = (ImageView) findViewById(R.id.imageView);
        nameButton1 = (Button) findViewById(R.id.memberName1);
        nameButton2 = (Button) findViewById(R.id.memberName2);
        nameButton3 = (Button) findViewById(R.id.memberName3);
        nameButton4 = (Button) findViewById(R.id.memberName4);
        quitButton = (Button) findViewById(R.id.quitButton);
        nameButtons = new Button[4];
        nameButtons[0] = nameButton1;
        nameButtons[1] = nameButton2;
        nameButtons[2] = nameButton3;
        nameButtons[3] = nameButton4;
        a = AnimationUtils.loadAnimation(this, R.anim.scale);
        deck = new Members();

        // Setting up game
        setupDisplay();
        cdt = new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                description.setText("Seconds Remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                displayTimesUp(description, a);
                displayAnswer();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setupDisplay();
                        resetText(description, a);
                        resetButtons();
                        start();
                    }
                }, 1000);

            }
        }.start();

        // Button activities
        nameButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cdt.cancel();
                if (deck.getCorrectChoice() == 0) {
                    displayCorrect(nameButton1);
                    displayCorrectText(description, a);
                    score++;
                } else {
                    displayIncorrect(nameButton1);
                    displayAnswer();
                    displayIncorrectText(description, a);
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cdt.start();
                        setupDisplay();
                        resetText(description, a);
                        resetButtons();
                    }
                }, 1000);
            }
        });

        nameButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cdt.cancel();
                if (deck.getCorrectChoice() == 1) {
                    displayCorrect(nameButton2);
                    displayCorrectText(description, a);
                    score++;
                } else {
                    displayIncorrect(nameButton2);
                    displayAnswer();
                    displayIncorrectText(description, a);
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cdt.start();
                        setupDisplay();
                        resetText(description, a);
                        resetButtons();
                    }
                }, 1000);
            }
        });

        nameButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cdt.cancel();
                if (deck.getCorrectChoice() == 2) {
                    displayCorrect(nameButton3);
                    displayCorrectText(description, a);
                    score++;
                } else {
                    displayIncorrect(nameButton3);
                    displayAnswer();
                    displayIncorrectText(description, a);
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cdt.start();
                        setupDisplay();
                        resetText(description, a);
                        resetButtons();
                    }
                }, 1000);
            }
        });

        nameButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cdt.cancel();
                if (deck.getCorrectChoice() == 3) {
                    displayCorrect(nameButton4);
                    displayCorrectText(description, a);
                    score++;
                } else {
                    displayIncorrect(nameButton4);
                    displayAnswer();
                    displayIncorrectText(description, a);
                }
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cdt.start();
                        setupDisplay();
                        resetText(description, a);
                        resetButtons();
                    }
                }, 1000);
            }
        });

        // Alerting for ending the game
        AlertDialog.Builder endGame = new AlertDialog.Builder(this);
        endGame.setMessage("Are you sure you want to quit?");
        endGame.setCancelable(false);
        endGame.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent quit = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(quit);
            }
        });
        endGame.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AlertDialog end = endGame.create();

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end.show();
            }
        });

        // Press image and open up Contacts app
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openContacts = new Intent(Intent.ACTION_INSERT);
                openContacts.setType(ContactsContract.Contacts.CONTENT_TYPE);
                openContacts.putExtra(ContactsContract.Intents.Insert.NAME, deck.getCorrectName());
                getApplicationContext().startActivity(openContacts);
            }
        });

    }

    /** <------- RESETTING THE SCREEN -------> */

    /** Resets all the buttons on the screen to the original button style. */
    void resetButtons() {
        for (Button button : nameButtons) {
            button.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.white_color));
            button.setTextColor(Color.parseColor("#224a6d"));
        }

    }

    /** Resets the DESCRIPTION text on the screen to the original text style. */
    void resetText(TextView tv, Animation animation) {
        tv.setTypeface(null, Typeface.NORMAL);
        tv.setTextColor(Color.parseColor("#224a6d"));
        tv.setTextSize(16);
        animation.reset();
        tv.clearAnimation();
    }

    /** <------- DISPLAYING ANSWERS/CORRECTNESS/TIME'S UP -------> */

    /** Displays the word "CORRECT!" while modifying text style.
     * Uses TV and ANIMATION to modify the DESCRIPTION variable and animate it. */
    void displayCorrectText(TextView tv, Animation animation) {
        tv.setTypeface(null, Typeface.BOLD);
        tv.setTextColor(Color.parseColor("#00b32c"));
        tv.setText("CORRECT!");
        runAnimation(animation);
    }

    /** Displays the word "INCORRECT!" while modifying text style.
     * Uses TV and ANIMATION to modify the DESCRIPTION variable and animate it. */
    void displayIncorrectText(TextView tv, Animation animation) {
        tv.setTypeface(null, Typeface.BOLD);
        tv.setTextColor(Color.parseColor("#e15249"));
        tv.setText("INCORRECT!");
        runAnimation(animation);
        final Toast toast = Toast.makeText(getApplicationContext(), "Wrong answer!",
                Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 750);
    }

    /** Displays the phrase "TIME'S UP!" while modifying text style.
     * Uses TV and ANIMATION to modify the DESCRIPTION variable and animate it. */
    void displayTimesUp(TextView tv, Animation animation) {
        tv.setTypeface(null, Typeface.BOLD);
        tv.setTextColor(Color.parseColor("#42a1ee"));
        tv.setText("TIME'S UP!");
        runAnimation(animation);
    }

    /** Changes BUTTON style to reflect that the right answer has been chosen. */
    void displayCorrect(Button button) {
        button.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.correct_button));
        button.setTextColor(Color.WHITE);
    }

    /** Changes BUTTON style to reflect that the wrong answer has been chosen. */
    void displayIncorrect(Button button) {
        button.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.color.incorrect_button));
        button.setTextColor(Color.WHITE);
    }

    /** Changes BUTTON style to show the correct answer.
     * Should be paired together with DISPLAYINCORRECT. */
    void displayAnswer() {
        int answer = deck.getCorrectChoice();
        switch (answer) {
            case 0:
                displayCorrect(nameButton1);
                break;
            case 1:
                displayCorrect(nameButton2);
                break;
            case 2:
                displayCorrect(nameButton3);
                break;
            case 3:
                displayCorrect(nameButton4);
                break;
        }
    }

    /** Scales the text with ANIMATION. */
    private void runAnimation(Animation animation)
    {
        animation.reset();
        description.clearAnimation();
        description.startAnimation(animation);
        animation.setFillEnabled(true);
        animation.setFillAfter(true);
    }

    /** <------- RANDOMIZING NAMES -------> */

    /** Sets up the game and rounds. */
    void setupDisplay() {
        scoreText.setText("Score: " + score);
        String name = deck.shuffleMembers();
        displayPicture(name);
        deck.generateChoices(name);
        setOptions(deck.getChoices());
    }

    /** Displays the picture of a member. */
    void displayPicture(String name) {
        String sourceName = name.toLowerCase().replaceAll("\\s","");
        final int id = getResources().getIdentifier(sourceName, "drawable", getPackageName());
        imageView.setImageResource(id);
    }

    /** Sets buttons' text to the answer choices. */
    void setOptions(ArrayList<String> choices) {
        int i = 0;
        for (String name : choices) {
            nameButtons[i].setText(name);
            i++;
        }
    }

}
