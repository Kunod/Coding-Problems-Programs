import java.util.*;

class Item {
    private String description;
    private double cost;
    private String dateOfListing;

    public Item(String description, double cost, String dateOfListing) {
        this.description = description;
        this.cost = cost;
        this.dateOfListing = dateOfListing;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Item: " + description + ", Cost: $" + cost + ", Listed on: " + dateOfListing;
    }
}

class Inventory {
    private Item item1;
    private Item item2;
    private Item item3;

    public Inventory() {
        item1 = null;
        item2 = null;
        item3 = null;
    }

    public Inventory(Item a, Item b, Item c) {
        item1 = a;
        item2 = b;
        item3 = c;
    }

    public double netWorth() {
        double total = 0;
        if (item1 != null) total += item1.getCost();
        if (item2 != null) total += item2.getCost();
        if (item3 != null) total += item3.getCost();
        return total;
    }

    public boolean roomForNewItem() {
        return item1 == null || item2 == null || item3 == null;
    }

    public void setItemAsSold(int itemNumber) {
        if (itemNumber == 1) item1 = null;
        else if (itemNumber == 2) item2 = null;
        else if (itemNumber == 3) item3 = null;
    }

    public void setNewItem(Item newItem, int itemNumber) {
        if (itemNumber == 1 && item1 == null) {
            item1 = newItem;
        } else if (itemNumber == 2 && item2 == null) {
            item2 = newItem;
        } else if (itemNumber == 3 && item3 == null) {
            item3 = newItem;
        } else {
            System.out.println("Can't add item to that itemNumber. Currently occupied.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(item1 == null ? "NO ITEM" : item1.toString()).append("\n");
        sb.append(item2 == null ? "NO ITEM" : item2.toString()).append("\n");
        sb.append(item3 == null ? "NO ITEM" : item3.toString());
        return sb.toString();
    }
}

public class PersonalInventory {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Inventory garage = new Inventory();
        boolean flag = false;
        int choice;

        do {
            System.out.println("Current inventory: \n" + garage.toString() + "\n");
            System.out.println("(1) Add item to inventory.");
            System.out.println("(2) Remove sold item from inventory.");
            System.out.println("(3) Get net worth of inventory");
            System.out.println("(4) Quit");
            System.out.print("What would you like to do >>> ");
            choice = console.nextInt();
            console.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("New item name/description >>> ");
                    String itemDesc = console.nextLine();
                    System.out.print("New item cost >>> $");
                    double itemCost = console.nextDouble();
                    console.nextLine();  // Consume newline
                    System.out.print("New item date of listing >>> ");
                    String itemDate = console.nextLine();
                    System.out.print("Where in the garage will you be storing this? (1-3) >>> ");
                    int storingNum = console.nextInt();
                    console.nextLine();
                    Item newItem = new Item(itemDesc, itemCost, itemDate);
                    garage.setNewItem(newItem, storingNum);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Which item did you sell? (1-3) >>> ");
                    int choiceItem = console.nextInt();
                    garage.setItemAsSold(choiceItem);
                    System.out.println("Item from spot " + choiceItem + " is now gone.");
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Net worth of inventory >>> ");
                    System.out.println(garage.netWorth());
                    System.out.println();
                    break;
                case 4:
                    flag = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        } while (!flag);

        console.close();
    }
}
