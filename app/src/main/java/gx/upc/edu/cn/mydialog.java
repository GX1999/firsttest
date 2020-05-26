package gx.upc.edu.cn;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

public class mydialog extends Dialog {

    public mydialog(@NonNull Context context, int themeResId) {
                 super(context, themeResId);
                 setContentView(R.layout.mydialog);//输出自定义对话框布局
             }
}
