package interview.tasks.task1;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ChequeTests {

    private static Cheque cheque;
    private static String organization;
    private static LocalDateTime dateTime;

    @BeforeClass
    public static void setup() {
        organization = "USF";
        dateTime = LocalDateTime.now();
        cheque = new Cheque(organization);
        cheque.addAllProducts(
                List.of(
                        getRandomProduct(),
                        getRandomProduct(),
                        getRandomProduct()
                )
        );
        cheque.setDateTime(dateTime);
        cheque.setAmount();
    }

    @Test
    public void checkOrganization() {
        String actual = cheque.getOrganization();
        String expected = organization;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void checkAmount() {
        BigDecimal actual = cheque.getAmount();
        BigDecimal expected = getAmount(cheque);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void checkDateTime() {
        var actual = cheque.getDateTime();
        var expected = dateTime;
        Assert.assertEquals(actual, expected);
    }

    private static BigDecimal getAmount(Cheque cheque) {
        BigDecimal result = BigDecimal.ZERO;
        for (Product product : cheque.getProductList()) {
            result = result.add(product.getPrice());
        }
        return result;
    }

    private static Product getRandomProduct() {
        int price = new Random().nextInt(500);
        String name = UUID.randomUUID().toString();
        return new Product(name, price);
    }
}
