package com.huatec.hiot_cloud.Test.MvpTest.Gson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huatec.hiot_cloud.R;
import com.huatec.hiot_cloud.Test.MvpTest.RXJAVA.RxJavaActivity;
import com.huatec.hiot_cloud.UI.MainActivity;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class GsonActivity extends AppCompatActivity {

    private static final String TAG = "GsonActivity";

    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        Button but1 = findViewById(R.id.Gson_but1);
        Button but2 = findViewById(R.id.Gson_but2);
        Button but3 = findViewById(R.id.Gson_but3);
        Button but4 = findViewById(R.id.Gson_but4);
        Button but5 = findViewById(R.id.Gson_but5);
        Button but6 = findViewById(R.id.Gson_but6);
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GsonActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //对象转Gson
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setName("吴锋泰");
                student.setAge(22);
                student.setMarried(false);
                String json = gson.toJson(student);
                Log.d(TAG, "onClick" + json);


            }
        });
        //Gson转对象
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student student = gson.fromJson("{\n" +
                        "\t\"age\": 20,\n" +
                        "\t\"married\": false,\n" +
                        "\t\"name\": \"张三\"\n" +
                        "}", Student.class);
                if (student != null) {
                    String str = String.format("姓名：%s,年龄：%d,婚否：%b", student.getName(),
                            student.getAge(), student.getMarried());
                    Toast.makeText(GsonActivity.this, str, Toast.LENGTH_SHORT).show();
                }
            }
        });
        //json转列表
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = "[\n" +
                        "\t{\n" +
                        "\t\t\"age\": 20,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"张三\"\n" +
                        "\t},\n" +
                        "\t{\n" +
                        "\t\t\"age\": 21,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"李四\"\n" +
                        "\t},\n" +
                        "\t{\n" +
                        "\t\t\"age\": 22,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"王五\"\n" +
                        "\t}\n" +
                        "]";
                String str = "";
                Type type = new TypeToken<List<Student>>() {
                }.getType();
                List<Student> studentList = gson.fromJson(json, type);
                if (studentList != null || !studentList.isEmpty()) {
                    for (Student student : studentList) {
                        str = str + String.format("姓名：%s,年龄：%d,婚否：%b", student.getName(),
                                student.getAge(), student.getMarried());

                    }
                    Toast.makeText(GsonActivity.this, str, Toast.LENGTH_SHORT).show();
                }
            }
        });
        //json转map
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = "{\n" +
                        "\t\"1\":{\n" +
                        "\t\t\"age\": 20,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"张三\"\n" +
                        "\t},\n" +
                        "\t\"2\":{\n" +
                        "\t\t\"age\": 21,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"李四\"\n" +
                        "\t},\n" +
                        "\t\"3\":{\n" +
                        "\t\t\"age\": 22,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"王五\"\n" +
                        "\t}\n" +
                        "}";
                String str = "";
                Type type = new TypeToken<Map<String, Student>>() {
                }.getType();
                Map<String, Student> map = gson.fromJson(json, type);
                if (map != null) {
                    for (String key : map.keySet()) {
                        str = str + String.format("序号:%s, 姓名：%s,年龄：%d,婚否：%b", key, map.get(key).getName(),
                                map.get(key).getAge(), map.get(key).getMarried());

                    }
                    Toast.makeText(GsonActivity.this, str, Toast.LENGTH_SHORT).show();
                }
            }
        });
        //嵌套
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json ="{\n" +
                        "\t\"data\":\n" +
                        "\t{\n" +
                        "\t\t\"age\": 20,\n" +
                        "\t\t\"married\": false,\n" +
                        "\t\t\"name\": \"张三\"\n" +
                        "\t},\n" +
                        "\t\"status\":1,\n" +
                        "\t\"msg\":\"正常\"\n" +
                        "}";
                Type type = new TypeToken<ResultBase<Student>>(){}.getType();
                ResultBase<Student> resultBase = gson.fromJson(json,type);

                String  str = String.format("姓名：%s,年龄：%d,婚否：%b",resultBase.data.getName(),
                        resultBase.data.getAge(), resultBase.data.getMarried());
                Toast.makeText(GsonActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
