package yang.com.library_system.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import yang.com.library_system.R;
import yang.com.library_system.adapter.BookAdapter;
import yang.com.library_system.data.Book;
import yang.com.library_system.utils.ActionIntent;

public class LookActivity extends AppCompatActivity {
    private List<Book> bookList = new ArrayList<>();
    private TextView noBook;
    private ImageView back;
    private BookAdapter adapter;
    private RecyclerView recyclerView;
    private TextView textTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look);
        init();
        textTitle.setText("查询结果");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final String user = getIntent().getStringExtra("user");
        if (ActionIntent.a) {
            String name = getIntent().getStringExtra("book_name");
            bookList = init_data_2(user, name);
        } else {
            bookList = init_data(user);
        }
        ActionIntent.a = false;
        if (bookList.size() != 0) {
            noBook.setVisibility(View.GONE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
            recyclerView.setLayoutManager(layoutManager);
            adapter = new BookAdapter(bookList);
            adapter.setOnItemClickListener(new BookAdapter.OnItemClickListener() {


                @Override
                public void onClick(View view, int position) {

                }
                @Override
                public void onLongClick(View view, int position) {
                    showPopMenu(view,position);
                    String user = bookList.get(position).getUser();
                    int id = bookList.get(position).getId();
                    DataSupport.deleteAll(Book.class,"user = ? and id = ?",user,String.valueOf(id));
                }
            });
            recyclerView.setAdapter(adapter);
        } else {
            recyclerView.setVisibility(View.INVISIBLE);
        }


    }

    public void showPopMenu(View view, final int pos) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_item, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                adapter.removeItem(pos);
                return false;
            }
        });

}
    private List init_data_2(String user,String name){
        List<Book> List = DataSupport.where("user = ? and name = ?", user,name).find(Book.class);
        return  List;
    }
    private List init_data(String user){
        List<Book> List = DataSupport.where("user = ?", user).find(Book.class);
        return  List;
    }
    private void init(){
        noBook = (TextView)findViewById(R.id.no_book);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        back = (ImageView)findViewById(R.id.back);
        textTitle = (TextView)findViewById(R.id.text_title);
    }
}
