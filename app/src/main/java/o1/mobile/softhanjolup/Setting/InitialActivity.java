package o1.mobile.softhanjolup.Setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import o1.mobile.softhanjolup.MainActivity;
import o1.mobile.softhanjolup.R;

public class InitialActivity extends AppCompatActivity {
    EditText name_input;
    Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_main_x);

        name_input = findViewById(R.id.initial_name_input);
        startBtn = findViewById(R.id.initial_startBtn);

        SharedPreferences pref = getSharedPreferences("initFlag", Context.MODE_PRIVATE);
        boolean first = pref.getBoolean("isFirst",false);

        if(first == false){
            startBtn.setText("시작하기");
        }
        else{
            startBtn.setText("저장하기");
        }

        startBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                SharedPreferences prefName = getSharedPreferences("prefName", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefName.edit();
                editor.putString("userName", name_input.getText().toString());
                editor.commit();

                Intent intent = new Intent(InitialActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
