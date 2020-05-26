package gx.upc.edu.cn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5Activity extends AppCompatActivity {

    EditText e1;
    EditText e2;
    Button b1;
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        b1=findViewById(R.id.b1);

////////////////////////////////////////////////////////////////////////////////////

        SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);    //sharepreferences存储
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name", "婉儿");
        editor.putInt("style", 8);
        editor.commit();

        String data=sp.getString("name","");
        e1.setText(data);



///////////////////////////////////////////////////////////////////////////////////

      /* String c1 = "";
        FileInputStream fis = null;
        try {
            fis = openFileInput("account.txt");                //内部存储读入
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            c1 = new String(buffer);//转换成字符串
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            i=0;
        }
        String c2 = "";
        FileInputStream fis1 = null;
        try {
            fis1 = openFileInput("password.txt");                //内部存储读入
            byte[] buffer = new byte[fis1.available()];
            fis1.read(buffer);
            c2 = new String(buffer);//转换成字符串
            fis1.close();
        } catch (IOException e) {
            e.printStackTrace();
            i=0;
        }

            e1.setText(c1);
            e2.setText(c2);
*/

/////////////////////////////////////////////////////////////////////////
     /*   String state= Environment.getExternalStorageState();               //外部存储写入
        if(state.equals(Environment.MEDIA_MOUNTED))
        {
            File SDpath=Environment.getExternalStorageDirectory();
            Toast.makeText(Main5Activity.this,SDpath.toString(), Toast.LENGTH_SHORT).show();
            File file=new File(SDpath,filename);

            try {
                FileOutputStream fos1=new FileOutputStream(file);
                fos1.write(content.getBytes());
                fos1.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }*/
      /*  String state = Environment.getExternalStorageState();      //外部存储读入
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            File SDPath = Environment.getExternalStorageDirectory();
            File file = new File(SDPath, "data.txt");
            FileInputStream fis = null;
            BufferedReader br = null;
            try {
                fis = new FileInputStream(file);
                //创建字符输入缓冲流的对象
                br = new BufferedReader(new InputStreamReader(fis));
                String data = br.readLine();
                br.close();
                fis.close();
                Toast.makeText(Main5Activity.this,data.toString(), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

    }
    public void login(View v)
    {

        String filename1="account.txt";
        String filename2="password.txt";
        String content1=e1.getText().toString();
        String content2=e2.getText().toString();
        try {
            FileOutputStream fos1=openFileOutput(filename1,MODE_PRIVATE);        //内部存储写入
            fos1.write(content1.getBytes());
            fos1.close();

            FileOutputStream fos2=openFileOutput(filename2,MODE_PRIVATE);        //内部存储写入
            fos2.write(content2.getBytes());
            fos2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        e1.setText("");
        e2.setText("");
    }
}
