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
import org.litepal.tablemanager.Connector;

import java.util.List;

import yang.com.library_system.R;
import yang.com.library_system.data.Client;
import yang.com.library_system.utils.AlerDialogUtil;

public class RegisteredActivity extends AppCompatActivity implements View.OnClickListener {
    private Button registered_is_ok;
    private Button registered_is_back;
    private EditText print_username;
    private EditText print_password;
    private TextView title;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        init();
        title.setText("注册");
        setOnclickListener();
    }
    private void setOnclickListener(){
        back.setOnClickListener(this);
        registered_is_back.setOnClickListener(this);
        registered_is_ok.setOnClickListener(this);
    }
    private void init(){
        back = (ImageView)findViewById(R.id.back);
        registered_is_ok = (Button)findViewById(R.id.registered_is_ok);
        registered_is_back = (Button)findViewById(R.id.registered_is_back);
        print_username = (EditText)findViewById(R.id.registered_username);
        title= (TextView)findViewById(R.id.text_title);
        print_password = (EditText)findViewById(R.id.registered_password);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.registered_is_ok:
                String input_name = print_username.getText().toString();
                String input_password = print_password.getText().toString();
                if (input_name.length() == 0 ) {
                    AlerDialogUtil.generateUserAlerDialog(view);
                }
                else if (input_password.length() == 0) {
                    AlerDialogUtil.generatePasswordAlerDialog(view);
                }
                else {
                    List<Client> clients = DataSupport.where("user = ?",input_name).find(Client.class);
                    if (clients.size() != 0) {
                        AlerDialogUtil.generateHaveUserAlerDialog(view);
                    }
                    else {
                        Toast.makeText(getBaseContext(), "注册成功", Toast.LENGTH_LONG).show();
                        Client client = new Client();
                        client.setUser(print_username.getText().toString());
                        client.setPassword(print_password.getText().toString());
                        client.save();
                        finish();
                    }
                }
                break;
            case R.id.registered_is_back:
                finish();
            default:break;
        }
    }
}
