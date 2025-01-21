package com.product.testscanner;

import java.util.Scanner;

import com.product.model.Item;
import com.product.shopping.ShoppingCart;

public class ShoppingCartScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("\n1. Add Item\n2. Remove Item\n3. Show Cart\n4. Total Amount\n5. Payable Amount\n6. Apply Coupon\n7. Print Invoice\n8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter unit price: ");
                    double unitPrice = scanner.nextDouble();
                    cart.addToCart(new Item(productName, quantity, unitPrice));
                    break;
                case 2:
                    System.out.print("Enter product name to remove: ");
                    String removeName = scanner.nextLine();
                    Item item = new Item();
                    item.setProductName(removeName);
                    cart.removeFromCart(item);
                    break;
                case 3:
                    cart.showCart();
                    break;
                case 4:
                    System.out.println("Total Amount: " + cart.getTotalAmount());
                    break;
                case 5:
                    System.out.println("Payable Amount: " + cart.getPayableAmount());
                    break;
                case 6:
                    System.out.print("Enter coupon code: ");
                    String coupon = scanner.nextLine();
                    cart.applyCoupon(coupon);
                    break;
                case 7:
                    cart.printInvoice();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
