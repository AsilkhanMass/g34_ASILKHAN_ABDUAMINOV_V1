package service.imp;

import service.UserService;
import domain.Product;
import domain.User;
import enums.RoleEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static service.ProductService.PRODUCTS;

public class UserServiceImp implements UserService {
    {
        User user = new User("Admin", "7777");
        user.setRole(RoleEnum.OWNER);
        USERS.add(user);
    }
    @Override
    public User login(String name, String password) {
        for (User custom : USERS) {
            if (custom.getName().equals(name) && custom.getPassword().equals(password)) {
                return custom;
            }
        }
        System.out.println("No such user exist!");
        return null;
    }

    @Override
    public User register(String name, String password) {
        for (User custom : USERS) {
            if (custom.getName().equals(name) && custom.getPassword().equals(password)) {
                System.out.println("Such user already exist!");
                return null;
            }
        }
        User user = new User(name, password);
        USERS.add(user);
        return user;
    }

    @Override
    public void seeAllProductByCategory(Integer categoryId) {
        for (Product product : PRODUCTS) {
            if (product.getCategoryId().equals(categoryId)) {
                System.out.println(product.getId() + ". " + product);
            }
        }
    }

    @Override
    public synchronized void purchaseProduct(User user, Integer productId, Integer amount) throws IOException {
        for (Product product : PRODUCTS) {
            if (product.getId().equals(productId) && product.getAmount() >= amount && user.getLimit() >= amount) {
                product.setAmount(product.getAmount() - amount);
                user.minusLimit();
                File file = new File("C:\\Users\\99890\\OneDrive\\Desktop\\customer_history.txt");
                FileOutputStream outputStream = new FileOutputStream(file);
                String history = user.getName() + " have bought: " + product.getName() + " at " + LocalDateTime.now();
                var writeMe = history.getBytes();
                outputStream.write(writeMe);

                System.out.println("Congrats with your purchase!");
                return;
            }
        }
        System.out.println("Something went wrong! Too much amount or no such product!");

    }
}
