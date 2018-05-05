package yang.com.library_system.data;

import org.litepal.crud.DataSupport;

/**
 * 数据库中每个用户所对应的书
 * Created by 杨云杰 on 2018/4/24.
 */

public class Book extends DataSupport {
    private int id;
    private int price;
    private String user;
    private String name;
    private String author;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
