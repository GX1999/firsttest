package gx.upc.edu.cn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private int i=0;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.t1);
        Button button=(Button)findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this,"you touched button",Toast.LENGTH_SHORT).show();
            }
        });

        /*ImageView im=findViewById(R.id.imageView2);
        im.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String inf="X="+String.valueOf(event.getX())+"Y="+String.valueOf(event.getY());
                Toast.makeText(MainActivity.this,inf,Toast.LENGTH_SHORT).show();
                return true;
            }
        });*/

       /* new Thread()
        {
            public void run()
            {
                while(true) {refreshMSG();}
            }
        }.start();*/

    }
    public void refreshMSG()
    {
        try{Thread.sleep(500);} catch (InterruptedException e){}
        i++;
        Message msg=Message.obtain();
        msg.arg1 =i ;
        mHandler.sendMessage(msg);
    }
    Handler mHandler=new Handler()
    {
      public void handleMessage(Message msg)
      {
          super.handleMessage(msg);
          tv.setText(msg.arg1+"");
      }
    };

    public void display(View v)
    {
       Intent intent=new Intent(this,Main2Activity.class);
       intent.putExtra("name","婉儿");
       intent.putExtra("style","2331333");
       startActivity(intent);
    }
    public void display1(View v)
    {
       AlertDialog dialog=new AlertDialog.Builder(this)
                .setTitle("simple dialog")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("login successful?")
                .setPositiveButton("Yes",null)
                .setNegativeButton("No",null)
                .create();
        dialog.show();
    }
    public void display3(View v)
    {
        AlertDialog dialog=new AlertDialog.Builder(this)
                .setTitle("single dialog")
                .setIcon(R.mipmap.ic_launcher)
                .setSingleChoiceItems(new String[]{"first blood", "double kill", "triple kill"},18,new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}
                        })
                .setPositiveButton("Yes",null)
                .setNegativeButton("No",null)
                .create();
        dialog.show();
    }
    public void display4(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("连接wifi");
        final EditText et = new EditText(this);
        et.setHint("请输入密码");
        et.setSingleLine(true);
        builder.setView(et);
        builder.setNegativeButton("取消",null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String password = et.getText().toString();
                if (password.equals("123456")) {
                    Toast.makeText(MainActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                }else{  Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                }  }    });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void display5(View v)
    {
        mydialog my=new mydialog(this,R.style.mydialog);
        my.show();
    }
    public void display6(View v)
    {
        Intent intent=new Intent();
        intent.setAction("cn.itcast.START_ACTIVITY");
        intent.addCategory("android.intent.category.DEFAULT");
        startActivity(intent);

    }
    public void display7 (View v)
    {

    }
    public void b1(View v)
    {
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
    public void b2(View v)
    {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
