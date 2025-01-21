package com.product.junit;




import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.product.model.Item;
import com.product.shopping.ShoppingCart;

class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void testAddToCart() {
        Item item = new Item("Milk", 2, 20.0);
        cart.addToCart(item);
        assertEquals(1, cart.getItems().size(), "Cart size should be 1 after adding an item.");
    }

    @Test
    void testRemoveFromCart() {
        Item item = new Item("Bread", 1, 30.0);
        cart.addToCart(item);
        cart.removeFromCart(item);
        assertEquals(0, cart.getItems().size(), "Cart size should be 0 after removing the item.");
    }

    @Test
    void testGetTotalAmount() {
        cart.addToCart(new Item("Cheese", 2, 50.0));
        cart.addToCart(new Item("Butter", 1, 80.0));
        assertEquals(180.0, cart.getTotalAmount(), "Total amount should be the sum of item prices.");
    }

    @Test
    void testApplyCoupon() {
        cart.addToCart(new Item("Eggs", 12, 10.0));
        cart.applyCoupon("IND10");
        assertEquals(108.0, cart.getPayableAmount(), 0.01, "Payable amount should include a 10% discount.");
    }

    @Test
    void testInvalidCoupon() {
        cart.addToCart(new Item("Juice", 3, 40.0));
        cart.applyCoupon("INVALID");
        assertEquals(137.6, cart.getPayableAmount(), 0.01, "Payable amount should not include discount for invalid coupon.");
    }

    @Test
    void testPrintInvoice() {
        cart.addToCart(new Item("Coffee", 1, 100.0));
        cart.addToCart(new Item("Tea", 2, 50.0));
        cart.applyCoupon("IND10");
        // Printing the invoice is not testable directly but you can ensure no exceptions occur.
        assertDoesNotThrow(() -> cart.printInvoice(), "Print invoice should not throw an exception.");
    }
}
