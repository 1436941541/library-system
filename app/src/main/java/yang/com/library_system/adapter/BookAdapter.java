package yang.com.library_system.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

import yang.com.library_system.R;
import yang.com.library_system.data.Book;

/**
 * 适配器用来展示图书
 * Created by 杨云杰 on 2018/4/25.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> bookList;
    public OnItemClickListener itemClickListener;
    public interface OnItemClickListener{
        void onClick(View view,int position);
        void onLongClick(View view,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.itemClickListener=onItemClickListener;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout item;
        TextView book_name_item;
        TextView book_author_item;
        TextView book_price_item;
        public ViewHolder(View itemView) {
            super(itemView);
            book_author_item = (TextView)itemView.findViewById(R.id.book_author_item);
            book_price_item = (TextView)itemView.findViewById(R.id.book_price_item);
            book_name_item = (TextView)itemView.findViewById(R.id.book_name_item);
            item = (LinearLayout)itemView.findViewById(R.id.look_item);
        }
    }

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }
    public void removeItem(int position){
        bookList.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Book book = bookList.get(position);
        holder.book_author_item.setText(book.getAuthor());
        holder.book_name_item.setText(book.getName());
        String price = String.valueOf(book.getPrice());
        holder.book_price_item.setText(price);
        if (itemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    itemClickListener.onClick(holder.itemView,position);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    itemClickListener.onLongClick(holder.itemView,position);
                    return true;
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
