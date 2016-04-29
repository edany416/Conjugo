package com.z3dd.conjugo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    UserInput userInput;
    Verb currentVerb;
    EditText[] editTextArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //VerbSet vs = VerbSet.getInstance();
        setSupportActionBar(toolbar);


        if (editTextArray == null) {
            //TODO: same as code in on click check answer
            editTextArray = new EditText[]{(EditText) findViewById(R.id.definition_edit_text), (EditText) findViewById(R.id.yo_edit_text),
                    (EditText) findViewById(R.id.tu_edit_text), (EditText) findViewById(R.id.el_edit_text),
                    (EditText) findViewById(R.id.nos_edit_text), (EditText) findViewById(R.id.vos_edit_text),
                    (EditText) findViewById(R.id.ellos_edit_text)};
            if (currentVerb == null) {
                currentVerb = new Verb(editTextArray);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        //TODO: make function that returns if empty before doing this
        displayNextVerb();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //toolbar.setNavigationIcon(R.drawable.ic_toolbar);
    }

    @Override
    protected void onStop() {
        super.onStop();
        clearEditTextFields();
    }

    public void onClickCheckAnswer(View view) {
        Button checkAnswerButton = (Button) findViewById(R.id.check_answer_button);
        //populate editTextArray with user input
        if (checkAnswerButton.getText().toString() != "Next") {
            editTextArray = new EditText[]{(EditText) findViewById(R.id.definition_edit_text), (EditText) findViewById(R.id.yo_edit_text),
                    (EditText) findViewById(R.id.tu_edit_text), (EditText) findViewById(R.id.el_edit_text),
                    (EditText) findViewById(R.id.nos_edit_text), (EditText) findViewById(R.id.vos_edit_text),
                    (EditText) findViewById(R.id.ellos_edit_text)};
            UserInput userInput = new UserInput(editTextArray);

            if (userInput.equalsCurrentVerb(currentVerb)) {
                checkAnswerButton.setText("Next");
                checkAnswerButton.setBackgroundColor(Color.GREEN);
            }

        } else {
            displayNextVerb();
            clearEditTextFields();

            //Reset next button back to check answer
            Button temp = (Button) findViewById(R.id.check_answer_button);
            temp.setText("Check Answer");
            temp.setBackgroundColor(Color.LTGRAY);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.verb_list:
                Intent intent = new Intent(this, VerbListActivity.class);
                startActivity(intent);
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayNextVerb() {
        currentVerb = VerbSetManager.getRandomVerb();
        TextView verbNameTextView = (TextView) findViewById(R.id.current_verb_label);
        verbNameTextView.setText(currentVerb.getVerbName());
    }

    private void clearEditTextFields() {
        for (EditText et : editTextArray) {
            et.setText("");
        }
    }


}
