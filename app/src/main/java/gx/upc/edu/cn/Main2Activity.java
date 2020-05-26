package gx.upc.edu.cn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    public int[] image=new int[]{R.mipmap.ic_launcher,R.mipmap.image1,R.mipmap.image2,
            R.mipmap.image2,R.mipmap.image2,R.mipmap.image2,R.mipmap.ic_launcher,R.mipmap.image1};
    public String[] theme=new String[]{"cat","dog","fish","pig","goat","tiger","bird","wolf"};
    public String[] content=new String[]{"miao","wang","boooo","hengheng","mieee","aooo","jijijiji","what does the fox say"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<Map<String,Object>> lists=new ArrayList<>();

        for(int i=0;i<theme.length;i++)
        {
            Map<String,Object> map=new HashMap<>();
            map.put("image",image[i]);
            map.put("theme",theme[i]);
            map.put("content",content[i]);
            lists.add(map);
        }
        ListView l1=(ListView)findViewById(R.id.l1);
        SimpleAdapter adapter=new SimpleAdapter(Main2Activity.this,lists,R.layout.fragment
                ,new String[]{"image","theme","content"}
                ,new int[]{R.id.image,R.id.theme,R.id.content});
        l1.setAdapter(adapter);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String style=intent.getStringExtra("style");
        TextView t1=findViewById(R.id.t1);
        t1.setText(name+"  "+style);
    }
}
