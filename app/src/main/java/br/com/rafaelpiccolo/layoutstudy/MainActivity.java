package br.com.rafaelpiccolo.layoutstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView txtTitle;
    EditText editFullName;
    Button btnConfirm;
    ToggleButton tbOn;
    SwitchCompat swShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitle = findViewById(R.id.txtTitle);
        editFullName = findViewById(R.id.editFullName);
        btnConfirm = findViewById(R.id.btnConfirm);
        tbOn = findViewById(R.id.tbOn);
        swShow = findViewById(R.id.swShow);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean okData = true;

                if (TextUtils.isEmpty(editFullName.getText().toString())) {
                    editFullName.setError("This field cannot be empty");
                    okData = false;
                }

                if (okData) {
                    Toast.makeText(getBaseContext(), "You typed: " + editFullName.getText()
                            , Toast.LENGTH_LONG).show();
                }
            }
        });

        tbOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tbOn.isChecked()){
                    editFullName.setEnabled(false);
                    editFullName.setError("Field deactivated");
                }
                else editFullName.setEnabled(true);

            }
        });

        swShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(swShow.isChecked()){
                    txtTitle.setVisibility(View.GONE);
                } else{
                    txtTitle.setVisibility(View.VISIBLE);
                }

            }
        });

    }
}