package yang.com.library_system.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

import yang.com.library_system.R;
import yang.com.library_system.data.Book;
import yang.com.library_system.utils.ActionIntent;
import yang.com.library_system.utils.AlerDialogUtil;

public class QueryActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;
    private TextView textTitle;
    private Button query_is_ok;
    private EditText query_book_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        init();
        textTitle.setText("查询图书");
        onClick();
    }
    private void onClick() {
        back.setOnClickListener(this);
        query_is_ok.setOnClickListener(this);
    }
    private void init() {
        query_book_name = (EditText)findViewById(R.id.query_book_name);
        back = (ImageView)findViewById(R.id.back);
        textTitle = (TextView)findViewById(R.id.text_title);
        query_is_ok = (Button)findViewById(R.id.query_is_ok);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.query_is_ok:
                String user = getIntent().getStringExtra("user");
                String book_name = query_book_name.getText().toString();
                if (book_name.length() == 0) {
                    AlerDialogUtil.generateBookNameAlerDialog(view);
                }
                else {
                    Intent intent = new Intent(getBaseContext(),LookActivity.class);
                    intent.putExtra("user",user);
                    intent.putExtra("book_name",book_name);
                    ActionIntent.a = true;
                    startActivity(intent);
                }
                break;
            default:break;
        }
    }
}
