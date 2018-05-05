package yang.com.library_system.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.litepal.crud.DataSupport;

import java.util.List;

import yang.com.library_system.R;
import yang.com.library_system.data.Book;
import yang.com.library_system.utils.ActionIntent;
import yang.com.library_system.utils.AlerDialogUtil;

public class OperatingActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private ImageView back;
    private long now = 0;
    private static boolean b = false;//用来判断是否存已经存在了该用户的数据库
    private RelativeLayout book_set;
    private RelativeLayout book_add;
    private RelativeLayout book_update;
    private RelativeLayout book_query;
    private RelativeLayout book_delete;
    private RelativeLayout book_look;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operating);
        init();
        back.setVisibility(View.GONE);
        textView.setText("主界面");
        setOnclick();
        List<Book> books = DataSupport.findAll(Book.class);
        String user = getIntent().getExtras().getString("user");
        for (Book book:books){
            if (book.getUser().equals(user)){
                b = true;
                break;
            }
        }
    }
    private void setOnclick(){
        book_update.setOnClickListener(this);
        book_query.setOnClickListener(this);
        book_look.setOnClickListener(this);
        book_delete.setOnClickListener(this);
        book_add.setOnClickListener(this);
        book_set.setOnClickListener(this);
        back.setOnClickListener(this);
    }
    private void init(){
        back = (ImageView)findViewById(R.id.back);
        textView = (TextView)findViewById(R.id.text_title);
        book_set = (RelativeLayout) findViewById(R.id.book_set);
        book_add = (RelativeLayout) findViewById(R.id.book_add);
        book_delete = (RelativeLayout) findViewById(R.id.book_delete);
        book_look = (RelativeLayout) findViewById(R.id.book_look);
        book_query = (RelativeLayout) findViewById(R.id.book_query);
        book_update = (RelativeLayout) findViewById(R.id.book_update);
    }
    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - now > 2000) {                          //如果两次按键时间间隔大于2秒，则不退出
            Toast.makeText(this, "再按一次退出我的应用", Toast.LENGTH_SHORT).show();
            now = secondTime;
        } else {
            finish();  //两次按键小于2秒时，退出应用
        }
    }//重写返回键
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.book_set :
                if (b){
                    AlerDialogUtil.generateDataBaseAlerDialog(view);
                }
                else {
                    Toast.makeText(getBaseContext(),"书库创建成功",Toast.LENGTH_SHORT).show();
                    b = true;
                }
                break;
            case R.id.book_add :
                if (b) {
                    String user = getIntent().getStringExtra("user");
                    Intent intent = new Intent(getBaseContext(),AddActivity.class);
                    intent.putExtra("user",user);
                    Log.d("yyj", "onClick: "+user);
                    startActivity(intent);
                }
                else {
                    AlerDialogUtil.generateSetDataAlerDialog(view);
                }
                break;
            case R.id.book_update :
                if (b) {
                    String user = getIntent().getStringExtra("user");
                    Intent intent=new Intent(getBaseContext(),UpdateActivity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }
                else {
                    AlerDialogUtil.generateSetDataAlerDialog(view);
                }
                break;
            case R.id.book_query :
                if (b) {
                    String user = getIntent().getStringExtra("user");
                    Intent intent=new Intent(getBaseContext(),QueryActivity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }
                else {
                    AlerDialogUtil.generateSetDataAlerDialog(view);
                }
                break;
            case R.id.book_delete :
                if (b) {
                    String user = getIntent().getStringExtra("user");
                    Intent intent=new Intent(getBaseContext(),DeleteActivity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }
                else {
                    AlerDialogUtil.generateSetDataAlerDialog(view);
                }
                break;
            case R.id.book_look :
                if (b){
                String user=getIntent().getStringExtra("user");
                    Intent intent=new Intent(getBaseContext(),LookActivity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }
                else {
                    AlerDialogUtil.generateSetDataAlerDialog(view);
                }
                break;
            default:break;
        }
    }
}
