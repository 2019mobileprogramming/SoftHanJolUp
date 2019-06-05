package o1.mobile.softhanjolup.Init;

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
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_main_x);

        name_input = findViewById(R.id.initial_name_input);
        startBtn = findViewById(R.id.initial_startBtn);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int isFirst = bundle.getInt("isFirst");

        if(isFirst == 0){
            startBtn.setText("시작하기");
            flag = 0;
        }
        else{
            startBtn.setText("저장하기");
            flag = 1;
        }

        startBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                SharedPreferences prefName = getSharedPreferences("prefName", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefName.edit();
                if(name_input.getText().toString() == null){
                    editor.putString("userName", "이름을 입력해주세요");
                }else{
                    editor.putString("userName", name_input.getText().toString());
                }
                editor.commit();

                if(flag == 0){
                    Intent intent = new Intent(InitialActivity.this, info_first_j.class);
                    startActivity(intent);
                    //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    finish();
                    //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                else{
                    Intent intent = new Intent(InitialActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

}
