package com.example.enzi_mac1.contract2.DAO;

import com.example.enzi_mac1.contract2.model.ConnectService;
import com.example.enzi_mac1.contract2.model.User;
import java.util.List;

public class UserManager {
    private List<User> listUser;

    public List<User> init(){
        ConnectService cn = new ConnectService();
        listUser = cn.doGetListUser("getListUser");
        return listUser;
    }

}
