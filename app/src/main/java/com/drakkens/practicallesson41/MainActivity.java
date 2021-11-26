package com.drakkens.practicallesson41;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    private int[] inputTypes = {InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS, InputType.TYPE_CLASS_NUMBER, InputType.TYPE_TEXT_FLAG_AUTO_CORRECT};
    int current = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_activity);

        Button changeKbButton = findViewById(R.id.changeKbButton);
        Button sumbitButton = findViewById(R.id.submitButton);

        EditText editText = findViewById(R.id.editText);

        changeKbButton.setOnClickListener(v -> {
            if (editText.getInputType() == (inputTypes[inputTypes.length-1])) {
                current = 0;
            } else {
                current += 1;

            }

            editText.setInputType(inputTypes[current]);

        });

        sumbitButton.setOnClickListener(v -> {
            Toast.makeText(this.getApplicationContext(), editText.getText(), Toast.LENGTH_SHORT).show();            editText.setText(null);
            editText.setText(null);
        });

        editText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                startActivity(new Intent(this.getApplicationContext(), PhoneDialingActivity.class));
            }
            return false;
        });

    }
}
