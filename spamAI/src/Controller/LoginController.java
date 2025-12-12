package Controller;


import java.util.*;

import Model.Account;

public class LoginController {
    private List<Account> accounts = new ArrayList<>();

    public LoginController() {
        // demo sẵn 2 tài khoản
        accounts.add(new Account("alice@example.com", "1111", "Alice"));
        accounts.add(new Account("bob@example.com", "2222", "Bob"));
    }

    public Account login(String email, String password) {
        for (Account acc : accounts) {
            if (acc.getEmail().equals(email) && acc.getPassword().equals(password)) {
                return acc;
            }
        }
        return null;
    }
}
