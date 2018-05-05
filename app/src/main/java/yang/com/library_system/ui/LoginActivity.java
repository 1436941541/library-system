package yang.com.library_system.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;
import org.w3c.dom.Text;

import java.util.List;

import yang.com.library_system.R;
import yang.com.library_system.data.Client;
import yang.com.library_system.utils.AlerDialogUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button registered;
    private Button log;
    private EditText user;
    private EditText password;
    private Boolean c=false;
    private ImageView back;
    private long now=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        back.setVisibility(View.INVISIBLE);
        setOnclickListener();
        Connector.getDatabase();
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
    private void setOnclickListener() {
        registered.setOnClickListener(this);
        registered.setOnClickListener(this);
        log.setOnClickListener(this);
    }
    private void init() {
        user = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        back = (ImageView)findViewById(R.id.back);
        log = (Button)findViewById(R.id.log);
        registered = (Button)findViewById(R.id.registered);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.log:
                String input_name = user.getText().toString();
                String input_password = password.getText().toString();
                if (input_name.length() == 0 ) {
                    AlerDialogUtil.generateUserAlerDialog(view);
                }
                else if (input_password.length() == 0) {
                    AlerDialogUtil.generatePasswordAlerDialog(view);
                }
                else {
                    List<Client> clients= DataSupport.findAll(Client.class);
                    if (clients.size() == 0) {
                        AlerDialogUtil.generateNoClientAlerDialog(view);
                    }
                    else {
                        for (Client client : clients) {
                            if ((client.getPassword()).equals(input_password) && (client.getUser()).equals(input_name)) {
                                c = true;
                                break;
                            }
                        }
                        if (c) {
                            Toast.makeText(getBaseContext(), "登录成功", Toast.LENGTH_SHORT).show();
                            Intent operatingActivity = new Intent(getBaseContext(), OperatingActivity.class);
                            operatingActivity.putExtra("user", input_name);
                            startActivity(operatingActivity);
                            finish();
                        } else {
                            AlerDialogUtil.generateUserPasswordAlerDialog(view);
                        }
                        c = false;
                    }
                }
                break;
            case R.id.registered:
                Intent registered = new Intent(view.getContext(),RegisteredActivity.class);
                startActivity(registered);
                break;
            default:break;
        }
    }
}

