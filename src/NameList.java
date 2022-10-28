import menu.MenuCallback;
import menu.MenuController;
import menu.MenuItem;
import model.User;
import repository.UserRepository;

import java.util.Scanner;

public class NameList {

    private static UserRepository userRepository = new UserRepository();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MenuCallback menuCallback = (menuItem, menuController) -> {
            if (menuItem == null) {
                menuController.show();
            } else {
                switch (menuItem) {
                    case ADD -> {
                        addUser();
                        menuController.show();
                    }
                    case SHOW -> {
                        getAllUsers();
                        menuController.show();
                    }
                    case EXIT -> {
                        userRepository.save();
                        System.exit(0);
                    }
                }
            }
        };
        MenuController menuController = new MenuController(menuCallback);
        menuController.show();
    }

    private static void addUser() {
        System.out.println("Enter a user name:");
        String userName = scanner.nextLine();
        userRepository.add(new User(userName));
    }

    private static void getAllUsers() {
        System.out.println(userRepository.getAll());
    }
}
