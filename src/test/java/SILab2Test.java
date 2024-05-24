import org.junit.Test;
import java.util.List;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

public class SILab2Test {

    @Test
    public void testEveryBranch() {
        System.out.println("Test allItems == null");
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 200));

        System.out.println("Test name == null, barcode == null");
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item(null, null, 400, 0.5F)), 200));

        System.out.println("Testing if barcode has invalid character");
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(new Item("Item", "123abc", 400, 0.5F)), 200));

        System.out.println("Test discount > 0, price >= 300, barcode[0] == '0', sum >= payment");
        assertTrue(SILab2.checkCart(List.of(new Item("Item", "012345", 400, 0.5F)), 200));

        System.out.println("Test sum < payment, discount < 0");
        assertFalse(SILab2.checkCart(List.of(new Item("Item", "012345", 100, 0)), 50));
    }

    @Test
    public void testMultipleCondition() {
        Item item = new Item(null, null, 0, 0);
        // Test Case True|True|True
        item.setPrice(400);
        item.setDiscount(0.5F);
        item.setBarcode("012345");
        assertTrue(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');

        // Test Case True|True|False
        item.setBarcode("123456");
        assertFalse(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');

        // Test Case True|False|X
        item.setDiscount(0);
        assertFalse(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');

        // Test Case False|X|X
        item.setPrice(250);
        assertFalse(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0');
    }
}
