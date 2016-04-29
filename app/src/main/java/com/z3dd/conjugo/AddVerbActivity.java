package com.z3dd.conjugo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//TODO: implement back button
public class AddVerbActivity extends AppCompatActivity {
    Verb verb;
    EditText[] editTextArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_verb);
        editTextArray = new EditText[8];
    }

    public void onClickDone(View view) {
        EditText verbName = (EditText) findViewById(R.id.verb_name_edit_text);
        EditText def = (EditText) findViewById(R.id.definition_edit_text);
        EditText yo = (EditText) findViewById(R.id.yo_edit_text);
        EditText tu = (EditText) findViewById(R.id.tu_edit_text);
        EditText el = (EditText) findViewById(R.id.el_edit_text);
        EditText nos = (EditText) findViewById(R.id.nos_edit_text);
        EditText vos = (EditText) findViewById(R.id.vos_edit_text);
        EditText ellos = (EditText) findViewById(R.id.ellos_edit_text);

        editTextArray[0] = verbName;
        editTextArray[1] = def;
        editTextArray[2] = yo;
        editTextArray[3] = tu;
        editTextArray[4] = el;
        editTextArray[5] = nos;
        editTextArray[6] = vos;
        editTextArray[7] = ellos;

        verb = new Verb(editTextArray);
        VerbSetManager.addVerb(verb);

        Intent intent = new Intent(this, VerbListActivity.class);
        startActivity(intent);
    }
}
