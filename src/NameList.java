import java.util.ArrayList;
import java.util.Scanner;

public class NameList {
    static ArrayList<String> names = new ArrayList<>();

    private static void addNames(ArrayList<String> names) {

    }

    private static void showList() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Add Names\n2. Show List\n3. Exit");
            System.out.print("Please enter a number:");
            int inputChoice = scanner.nextInt();
            scanner.nextLine();
            switch (inputChoice) {
                case 1:
                    String name;
                    do {
                        System.out.print("Please enter name: ");
                        name = scanner.nextLine();
                        if (!name.equals("exit")) {
                            names.add(name);
                        }
                    } while (!name.equals("exit"));

                    addNames(names);
                    break;
                case 2:
                    showList();
                    break;
                case 3:
                    return;
                default:
                    System.out.print("Please enter a number between 1-3: ");
            }
            System.out.println(names);
        } while (true);
    }
}
