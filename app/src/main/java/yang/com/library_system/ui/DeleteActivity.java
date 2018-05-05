package yang.com.library_system.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import yang.com.library_system.utils.AlerDialogUtil;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private ImageView back;
    private Button delete_is_ok;
    private Boolean b = false;
    private EditText delete_book_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        init();
        textView.setText("删除图书");
        setOnclick();
    }

    private void setOnclick() {
        back.setOnClickListener(this);
        delete_is_ok.setOnClickListener(this);
    }

    private void init() {
        delete_book_name = (EditText) findViewById(R.id.delete_book_name);
        delete_is_ok = (Button) findViewById(R.id.delete_is_ok);
        textView = (TextView) findViewById(R.id.text_title);
        back = (ImageView) findViewById(R.id.back);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.delete_is_ok:
                String user = getIntent().getExtras().getString("user");
                String book_name = delete_book_name.getText().toString();
                if (book_name.length() == 0) {
                    AlerDialogUtil.generateBookNameAlerDialog(view);
                } else {
                        List<Book> books = DataSupport.where("user = ?", user).find(Book.class);
                        for (Book book : books) {
                            if (book.getName().equals(book_name)) {
                                b = true;
                            }
                        }
                    if (b) {
                        DataSupport.deleteAll(Book.class, "user = ? and name = ?",user,book_name);
                        Toast.makeText(getBaseContext(), "删除成功", Toast.LENGTH_SHORT).show();
                        b = false;
                    }
                    else {
                        AlerDialogUtil.generateNoBookAlerDialog(view);
                    }
                    }
                break;
            default:break;
        }
    }
}
