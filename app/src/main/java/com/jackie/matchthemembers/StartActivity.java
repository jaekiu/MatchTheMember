/**  The first screen that pops up when the app is run.
 * @author: Jacqueline Zhang
 * Credits to Sarah Tang for the MDB Illustration shown on this screen!
 * */
package com.jackie.matchthemembers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });
    }

    public void startGame() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
