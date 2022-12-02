//Write a program which keeps the information about products and their prices. Each product has a name, a price, and its quantity. If the product doesn't exist yet, add it with its starting quantity.
//If you receive a product that already exists, increases its quantity by the input quantity and if its price is different, replace the price as well.
//You will receive products' names, prices, and quantities on new lines.
// Until you receive the command "buy", keep adding items.
// When you do receive the command "buy", print the items with their names and the total price of all the products with that name.
//Input
//• Until you receive "buy", the products come in the format: "{name} {price} {quantity}".
//• The product data is always delimited by a single space.
//Output
//• Print information about each product, following the format:
//"{productName} -> {totalPrice}"
//• Format the average total price to the 2nd decimal place.





import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class orders {

    private String type;
    private double price;
    private int qty;

    public orders(String type, double price, int qty) {
        this.type = type;
        this.price = price;
        this.qty = qty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<orders> list = new ArrayList<>();
        int counter = 1;
        boolean exists = false;
        while (!input.equals("buy")) {
            String[] tempArray = input.split(" ");

            orders tempObject = new orders(tempArray[0], Double.parseDouble(tempArray[1]), Integer.parseInt(tempArray[2]));
            if (counter == 1) {
                list.add(tempObject);
            }
            int tempArrayQty = Integer.parseInt(tempArray[2]);
            if (counter > 1) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getType().equals(tempObject.getType())) {
                        int newQty = list.get(i).getQty() + tempArrayQty;
                        list.get(i).setQty(newQty);
                        if (list.get(i).getPrice() != tempObject.getPrice()) {
                            double newPrice = Double.parseDouble(tempArray[1]);
                            list.get(i).setPrice(newPrice);
                            exists = true;
                            break;
                        }
                    }
                }
                if (!exists){
                    list.add(tempObject);
                }
            }
            counter++;
            input = scanner.nextLine();
        }



        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s -> %.2f\n", list.get(i).getType(), list.get(i).getPrice() * list.get(i).getQty());
        }
    }
}
