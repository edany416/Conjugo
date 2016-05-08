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

import org.w3c.dom.Text;

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

        View verbNameTextField = findViewById(R.id.current_verb_label);
        View root = verbNameTextField.getRootView();
        root.setBackgroundColor(0xFFFFFFFF);
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
        TextView responseButtonText = (TextView) findViewById(R.id.response_button_text);
        //populate editTextArray with user input
        if (responseButtonText.getText().toString() != "CONTINUE") {
            editTextArray = new EditText[]{(EditText) findViewById(R.id.definition_edit_text), (EditText) findViewById(R.id.yo_edit_text),
                    (EditText) findViewById(R.id.tu_edit_text), (EditText) findViewById(R.id.el_edit_text),
                    (EditText) findViewById(R.id.nos_edit_text), (EditText) findViewById(R.id.vos_edit_text),
                    (EditText) findViewById(R.id.ellos_edit_text)};
            UserInput userInput = new UserInput(editTextArray);

            if (userInput.equalsCurrentVerb(currentVerb)) {
                responseButtonText.setText("CONTINUE");
            }

        } else {
            displayNextVerb();
            clearEditTextFields();

            //Reset next button back to check
            responseButtonText.setText("CHECK");
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
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
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
