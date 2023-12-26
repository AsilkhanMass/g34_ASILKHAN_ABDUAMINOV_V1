package service;

import domain.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface UserService {
    ArrayList<User> USERS = new ArrayList<>();
    User login(String name, String password);
    User register(String name, String password);
    void seeAllProductByCategory(Integer categoryId);
    void purchaseProduct(User user, Integer productId, Integer amount) throws IOException;
}
