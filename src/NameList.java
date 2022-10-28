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
        System.out.println("Enter any number of user names separated with enter:");
        String input;
        do {
            input = scanner.nextLine();
            if(!input.equals("back")) {
                String[] splited = input.split("-");
                userRepository.add(new User(splited[0], splited[1]));
            }
        } while (!input.equals("back"));
    }

    private static void getAllUsers() {
        System.out.println(userRepository.getAll());
    }

//    private static void repeatUntil(String until, Action action) {
//        String input;
//        do {
//            input = scanner.nextLine();
//            if(!input.equals(until)) action.doAction(input);
//        } while (!input.equals(until));
//    }
//
//    interface Action {
//        void doAction(String input);
//    }

}
