package com.example.enzi_mac1.contract2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.enzi_mac1.contract2.DAO.UserManager;
import com.example.enzi_mac1.contract2.model.User;
import java.util.List;

public class Login extends AppCompatActivity{
    EditText txtUser, txtPass;
    Button btnLogin;
    private List<User> curUser;
    private UserManager userManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        txtUser = (EditText) findViewById(R.id.txtUsername);
        txtPass = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        loadUser();


    }

    public void loadUser() {
        userManager = new UserManager();
        curUser = userManager.init();
        for (int i = 0; i < curUser.size(); i++) {
            String a = ("Tên: "+curUser.get(i).getAccount());
            String b = ("Điểm vừa chơi: "+curUser.get(i).getPass());
            String c = ("Điểm cao nhất: "+curUser.get(i).getUser_name());
            System.out.print(a);
            System.out.print(b);
            System.out.print(c);
        }
    }
}
