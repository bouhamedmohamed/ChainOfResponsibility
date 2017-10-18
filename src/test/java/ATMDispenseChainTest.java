import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ATMDispenseChainTest {

    private DispenseChain c1;
    private DispenseChain c2;
    private DispenseChain c3;

    @Before
    public void setUp() throws Exception {

        c1 = new Dollar50Dispenser();
        c2 = new Dollar20Dispenser();
        c3 = new Dollar10Dispenser();
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    @Test
    public void should_dispense_2_50() throws Exception {
        c1.dispense(new Currency(100));
        Integer bill50Count = DispenseChain.dispencePices.get("50$");
        Assert.assertEquals(bill50Count, 2, 0.001);
    }

    @Test
    public void should_dispense_1_10_and_1_20() throws Exception {
        c1.dispense(new Currency(30));
        Integer bill20Count = DispenseChain.dispencePices.get("20$");
        Integer bill10Count = DispenseChain.dispencePices.get("10$");
        Assert.assertEquals(bill20Count, 1, 0.001);
        Assert.assertEquals(bill10Count, 1, 0.001);

    }


}
