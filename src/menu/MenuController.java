package menu;

import java.util.Scanner;

public class MenuController {

    private final static String SEPARATOR = "********************* %s ********************** \n";
    private Scanner scanner = new Scanner(System.in);
    private MenuCallback menuCallback;

    public MenuController(MenuCallback menuCallback) {
        this.menuCallback = menuCallback;
    }

    public void show() {
        System.out.printf(SEPARATOR, "Main Menu");
        MenuItem.printItems();
        selectMenu();
    }

    private void selectMenu() {
        System.out.println("Enter a menu code: ");
        String stringInputChoice = scanner.nextLine();
        try {
            int integerInputChoice = Integer.parseInt(stringInputChoice);
            MenuItem selectedMenuItem = MenuItem.findById(integerInputChoice);
            if(selectedMenuItem != null){
                System.out.printf(SEPARATOR, selectedMenuItem.name);
            }
            menuCallback.onMenuSelected(selectedMenuItem, this);
        } catch (NumberFormatException e) {
            menuCallback.onMenuSelected(null, this);
        }
    }

}
