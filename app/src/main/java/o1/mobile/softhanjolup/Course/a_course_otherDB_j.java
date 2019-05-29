package o1.mobile.softhanjolup.Course;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import o1.mobile.softhanjolup.R;


public class a_course_otherDB_j extends AppCompatActivity {

    Button confirmBtn;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_course_otherDB_x);

        confirmBtn = findViewById(R.id.other_confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

    }
}
