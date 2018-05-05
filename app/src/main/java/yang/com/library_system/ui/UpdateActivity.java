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

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView back;
    private TextView textTitle;
    private EditText book_name;
    private EditText book_author;
    private EditText book_price;
    private Button update_is_ok;
    private Button update_is_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        init();
        setOnclick();
        textTitle.setText("更新图书");
    }
    private void setOnclick() {
        back.setOnClickListener(this);
        update_is_ok.setOnClickListener(this);
        update_is_cancel.setOnClickListener(this);
    }
    private void init() {
        back = (ImageView)findViewById(R.id.back);
        update_is_cancel = (Button)findViewById(R.id.update_is_cancel);
        update_is_ok = (Button)findViewById(R.id.update_is_ok);
        textTitle = (TextView)findViewById(R.id.text_title);
        book_author = (EditText)findViewById(R.id.update_book_author);
        book_name = (EditText)findViewById(R.id.update_book_name);
        book_price = (EditText)findViewById(R.id.update_book_price);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.update_is_ok:
                String user = getIntent().getStringExtra("user");
                String price = book_price.getText().toString();
                String name = book_name.getText().toString();
                String author = book_author.getText().toString();
                if (name.length() == 0 ) {
                    AlerDialogUtil.generateBookNameAlerDialog(view);
                }
                else if (author.length() == 0) {
                    AlerDialogUtil.generateAuthorAlerDialog(view);
                }
                else if (price.length() == 0) {
                    AlerDialogUtil.generatePriceAlerDialog(view);
                }
                else {
                    List<Book> books = DataSupport.where("user = ? and name = ? and author = ?",user,name,author).find(Book.class);
                        if (books.size() == 0) {
                            AlerDialogUtil.generateNoBookAlerDialog(view);
                        }
                    else {
                            for (Book book: books) {
                                book.setPrice(Integer.parseInt(price));
                                book.updateAll("user = ? and name=? and author=?", user, name, author);
                                Toast.makeText(getBaseContext(), "更新成功", Toast.LENGTH_SHORT).show();
                                break;
                            }
                            finish();
                            }
                }
                break;
            case R.id.update_is_cancel:
                book_price.setText("");
                book_name.setText("");
                book_author.setText("");
                book_name.requestFocus();//获取焦点
                break;
            default:break;
        }
    }
}
