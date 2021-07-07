

import com.bridgelabz.cabservice.InvoiceGenerator;
import com.bridgelabz.model.InvoiceSummary;
import com.bridgelabz.model.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator= null;
    @Before
    public void setUp() throws Exception {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance =2.0;
        int time =5;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 3;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0,5),
                        new Ride(0.1,1)
                        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30.0);
        Assert.assertEquals(String.valueOf(expectedInvoiceSummary),summary);
    }
}