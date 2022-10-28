package menu;

public enum MenuItem {
    ADD(1, "Add"),
    SHOW(2, "Show"),
    EXIT(3, "Exit");

    public final int id;
    public final String name;

    MenuItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + ". " + name;
    }

    public static void printItems() {
        MenuItem[] items = MenuItem.values();
        for (MenuItem item : items) {
            System.out.println(item);
        }
    }

    public static MenuItem findById(int id) {
        for (MenuItem item : values()) {
            if (item.id == id) return item;
        }
        return null;
    }

}
