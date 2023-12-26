import service.imp.CategoryServiceImp;
import service.imp.ProductServiceImp;
import service.imp.UserServiceImp;
import domain.User;
import enums.RoleEnum;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static UserServiceImp userServiceImp = new UserServiceImp();
    static ProductServiceImp productServiceImp = new ProductServiceImp();
    static CategoryServiceImp categoryServiceImp = new CategoryServiceImp();

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            System.out.println("""
                    1. Login
                    2. Register
                    0. Exit
                    """);
            int choice = scannerInt.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.println("Enter the name: ");
                String name = scannerStr.nextLine();
                System.out.println("Enter the password: ");
                String password = scannerStr.nextLine();
                User user = userServiceImp.login(name, password);
                userMenu(user);
            } else if (choice == 2) {
                System.out.println("Enter the name: ");
                String name = scannerStr.nextLine();
                System.out.println("Enter the password: ");
                String password = scannerStr.nextLine();
                User user = userServiceImp.register(name, password);
                userMenu(user);
            } else {
                System.out.println("Choose proper function!");
            }
        }
    }

    public static void userMenu(User loggedUser) throws IOException, InterruptedException {
        if (loggedUser.getRole() == RoleEnum.CUSTOMER) {
            while (true) {
                System.out.println("""
                        1. See all product by category
                        2. Purchase product
                        0. Exit
                        """);
                int menu = scannerInt.nextInt();
                switch (menu) {
                    case 1 -> {
                        categoryServiceImp.showAllCategory();
                        System.out.print("Choose index: ");
                        Integer index = scannerInt.nextInt();
                        userServiceImp.seeAllProductByCategory(index);
                    }
                    case 2 -> {
                        ExecutorService executor = Executors.newFixedThreadPool(5);

                        productServiceImp.showAll();
                        System.out.print("Enter product id you want purchase!");
                        Integer productId = scannerInt.nextInt();
                        System.out.print("Enter how many you want purchase");
                        Integer amount = scannerInt.nextInt();
                        executor.execute(() -> {
                            try {
                                userServiceImp.purchaseProduct(loggedUser, productId, amount);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                    case 0 -> {
                        return;
                    }
                }

            }
        } else if (loggedUser.getRole() == RoleEnum.OWNER) {
            while (true) {
                System.out.println("""
                        1. Add category
                        2. Edit category
                        3. Add product
                        4. Delete product
                        5. Edit product
                        0. Exit
                        """);
                int menu = scannerInt.nextInt();
                switch (menu) {
                    case 1 -> {
                        System.out.print("Enter category name: ");
                        String categoryName = scannerStr.nextLine();
                        categoryServiceImp.addCategory(categoryName);
                    }
                    case 2 -> {
                        System.out.print("Enter category name to edit: ");
                        String categoryName = scannerStr.nextLine();
                        System.out.print("New category name: ");
                        String newName = scannerStr.nextLine();
                        categoryServiceImp.editCategory(categoryName, newName);
                    }
                    case 3 -> {
                        System.out.println("Product name: ");
                        String productName = scannerStr.nextLine();
                        System.out.println("Amount: ");
                        Integer amount = scannerInt.nextInt();
                        categoryServiceImp.showAllCategory();
                        System.out.print("Choose index: ");
                        Integer categoryId = scannerInt.nextInt();
                        productServiceImp.addProduct(productName, amount, categoryId);
                    }
                    case 4 -> {
                        productServiceImp.showAll();
                        System.out.print("Choose id: ");
                        Integer productId = scannerInt.nextInt();
                        productServiceImp.deleteProduct(productId);
                    }
                    case 5 -> {
                        productServiceImp.showAll();
                        System.out.print("Choose id: ");
                        Integer productId = scannerInt.nextInt();
                        System.out.print("New name: ");
                        String newName = scannerStr.nextLine();
                        System.out.println("Amount: ");
                        Integer amount = scannerInt.nextInt();
                        categoryServiceImp.showAllCategory();
                        System.out.print("Choose index: ");
                        Integer categoryId = scannerInt.nextInt();
                        productServiceImp.editProduct(productId, newName, amount, categoryId);
                    }
                    case 0 -> {
                        return;
                    }
                }

            }
        }
    }

    public static Thread seeProducts(Integer index) {
        return new Thread(() -> {
            userServiceImp.seeAllProductByCategory(index);
        });
    }

}