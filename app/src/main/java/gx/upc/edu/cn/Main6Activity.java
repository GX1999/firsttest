package gx.upc.edu.cn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main6Activity extends AppCompatActivity {

    TextView t1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String result = (String) msg.getData().get("result");
            t1.setText(result);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        Button b1=(Button)findViewById(R.id.b1);
        t1=findViewById(R.id.t1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(Main6Activity.this,
                        new String[]{Manifest.permission.INTERNET},1);
            }
        });
        new Thread()
        {
           public void run()
           {
               getData();
           }
        }.start();


        }
      public void getData()
    {
        try {
            String path = "http://101.201.239.28:9080/grid/points/getSmilePoints";
            URL url =new URL(path);
            HttpURLConnection conn  =  (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            int responseCode = conn.getResponseCode();
            if(responseCode == 200){
                InputStream is = conn.getInputStream();
                BufferedReader bis=new BufferedReader(new InputStreamReader(is));
                String line=null;
                line=bis.readLine();
                if(line!=null)
                {
                    t1.setText(line);
                }
               // JSONObject json= new JSONObject(line);
            //    String status=json.optString("status");
                Message msg=new Message();
                Bundle bundle=new Bundle();
                bundle.putString("result",line);
                msg.setData(bundle);
                handler.sendMessage(msg);
            }
        }
        catch (IOException e)
        {e.printStackTrace();}
    }
    }
