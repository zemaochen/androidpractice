package com.example.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.alertdialog.R;


public class MainActivity extends Activity {
    TextView show;
    String[] items = new String[] {
            "疯狂Java讲义", "疯狂Ajax讲义",
            "轻量级Java EE企业应用实战",
            "疯狂Android讲义" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        show = (TextView) findViewById(R.id.show);
    }

    public void simple(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // 设置对话框标题
                .setTitle("简单对话框")
                // 设置图标
                .setIcon(R.drawable.tools)
                .setMessage("对话框的测试内容\n第二行内容");
        // 为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void simpleList(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // 设置对话框标题
                .setTitle("简单列表对话框")
                // 设置图标
                .setIcon(R.drawable.tools)
                // 设置简单的列表项内容
                .setItems(items, new OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        show.setText("你选中了《" + items[which] + "》");
                    }
                });
        // 为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void singleChoice(View source)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                // 设置对话框标题
                .setTitle("单选列表项对话框")
                // 设置图标
                .setIcon(R.drawable.tools)
                // 设置单选列表项，默认选中第二项（索引为1）
                .setSingleChoiceItems(items, 1, new OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        show.setText("你选中了《" + items[which] + "》");
                    }
                });
        // 为AlertDialog.Builder添加“确定”按钮
        setPositiveButton(builder);
        // 为AlertDialog.Builder添加“取消”按钮
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void customView(View source)
    {
        TableLayout loginForm = (TableLayout)getLayoutInflater()
                .inflate( R.layout.login, null);
        new AlertDialog.Builder(this)
                // 设置对话框的图标
                .setIcon(R.drawable.tools)
                // 设置对话框的标题
                .setTitle("自定义View对话框")
                // 设置对话框显示的View对象
                .setView(loginForm)
                // 为对话框设置一个“确定”按钮
                .setPositiveButton("登录", new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        // 此处可执行登录处理
                        EditText username = findViewById(R.id.username);
                        EditText password = findViewById(R.id.password);
                        EditText tel = findViewById(R.id.tel);
                        Intent intent = new Intent(MainActivity.this,result.class);
                        intent.putExtra("username",username.getText().toString());
                        intent.putExtra("password",password.getText().toString());
                        intent.putExtra("tel",tel.getText().toString());
                        startActivity(intent);
                    }
                })
                // 为对话框设置一个“取消”按钮
                .setNegativeButton("取消", new OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        // 取消登录，不做任何事情
                    }
                })
                // 创建并显示对话框
                .create()
                .show();
    }

    private AlertDialog.Builder setPositiveButton(
            AlertDialog.Builder builder)
    {
        // 调用setPositiveButton方法添加“确定”按钮
        return builder.setPositiveButton("确定", new OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                show.setText("单击了【确定】按钮！");
            }
        });
    }
    private AlertDialog.Builder setNegativeButton(
            AlertDialog.Builder builder)
    {
        // 调用setNegativeButton方法添加“取消”按钮
        return builder.setNegativeButton("取消", new OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                show.setText("单击了【取消】按钮！");
            }
        });
    }
}
