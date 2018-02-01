package com.example.bonnie.mynewnotebook;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExamMode extends Activity {
    private Button bt_a,bt_b,bt_c,bt_d,bt_nextword;
    private TextView test_title,test_result;
    private WordDatabaseAssist words_db_helper;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam);//绑定界面
//绑定控件
        test_title = (TextView) findViewById((R.id.exam_eng_word)) ;
        test_result = (TextView) findViewById(R.id.exam_result);
        bt_a = (Button) findViewById(R.id.exam_a);
        bt_b = (Button) findViewById(R.id.exam_b);
        bt_c = (Button) findViewById(R.id.exam_c);
        bt_d = (Button) findViewById(R.id.exam_d);
        bt_nextword = (Button) findViewById(R.id.exam_next_word);

        words_db_helper = new WordDatabaseAssist(this);

        SQLiteDatabase sqldb = words_db_helper.getReadableDatabase();
        String sql_eng = "SELECT * FROM words ORDER BY random() LIMIT 4";
        Cursor c = sqldb.rawQuery(sql_eng,null);

        List<String> exam_eng = new ArrayList<>();
        List<String> exam_fre = new ArrayList<>();

        while(c.moveToNext()) {
            exam_eng.add(c.getString(c.getColumnIndex(WordDatabaseInfo.Word.COLUMN_NAME_ENG)));
            exam_fre.add(c.getString(c.getColumnIndex(WordDatabaseInfo.Word.COLUMN_NAME_FRE)));
        }

        Random random = new Random();
        int i = random.nextInt(3);

        String exam_word_eng = exam_eng.get(i);
        String exam_word_fre = exam_fre.get(i);

        //法语赋值到button
        test_title.setText(exam_word_eng);
        bt_a.setText(exam_fre.get(0));
        bt_b.setText(exam_fre.get(1));
        bt_c.setText(exam_fre.get(2));
        bt_d.setText(exam_fre.get(3));

        final String test_word_fre_true = exam_word_fre;
        //单击按钮得到结果
        bt_a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(test_word_fre_true == bt_a.getText()){
                    test_result.setText("TRUE");
                }else{
                    test_result.setText("FALSE");
                }
            }
        });

        bt_b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(test_word_fre_true == bt_b.getText()){
                    test_result.setText("TRUE");
                }else{
                    test_result.setText("FALSE");
                }
            }
        });

        bt_c.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(test_word_fre_true == bt_c.getText()){
                    test_result.setText("TRUE");
                }else{
                    test_result.setText("FALSE");
                }
            }
        });

        bt_d.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(test_word_fre_true == bt_d.getText()){
                    test_result.setText("TRUE");
                }else{
                    test_result.setText("FALSE");
                }
            }
        });

        bt_nextword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onCreate(null);
            }
        });

    }
}
