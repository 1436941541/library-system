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

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textTitle;
    private ImageView back;
    private Button add;
    private EditText book_price;
    private EditText book_name;
    private EditText book_author;
    private Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        init();
        textTitle.setText("添加图书");
        onClick();
    }
    private void onClick() {
        back.setOnClickListener(this);
        add.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }
    private void init() {
        book_author = (EditText)findViewById(R.id.book_author);
        book_name = (EditText)findViewById(R.id.book_name);
        book_price = (EditText)findViewById(R.id.book_price);
        add = (Button)findViewById(R.id.add_is_ok);
        cancel = (Button)findViewById(R.id.add_is_cancel);
        back = (ImageView)findViewById(R.id.back);
        textTitle = (TextView)findViewById(R.id.text_title);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back :
                finish();
                break;
            case R.id.add_is_ok :
                String price = book_price.getText().toString();
                String name = book_name.getText().toString();
                String author = book_author.getText().toString();
                String user = getIntent().getStringExtra("user");
                if (name.length() == 0 ) {
                    AlerDialogUtil.generateBookNameAlerDialog(view);
                }
                else if (author.length() == 0){
                    AlerDialogUtil.generateAuthorAlerDialog(view);
                }
                else if (price.length() == 0){
                    AlerDialogUtil.generatePriceAlerDialog(view);
                }
                else {
                    List<Book> books = DataSupport.where("user = ? and name = ?",user,name).find(Book.class);
                        if (books.size() >= 0) {
                            AlerDialogUtil.generateHasBookAlerDialog(view);
                        }
                    else {
                            Book book = new Book();
                            book.setName(name);
                            book.setAuthor(author);
                            book.setPrice(Integer.parseInt(price));
                            book.setUser(user);
                            book.save();
                            Toast.makeText(getBaseContext(), "添加成功", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                }
                break;
            case R.id.add_is_cancel :
                book_price.setText("");
                book_name.setText("");
                book_author.setText("");
                book_name.requestFocus();
                break;
            default:break;
        }
    }
}