package yang.com.library_system.data;

import org.litepal.crud.DataSupport;

/**
 * 数据库中的表用来存储用户的数据
 * Created by 杨云杰 on 2018/4/24.
 */

public class Client extends DataSupport {
    private int id;
    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
