

import com.bridgelabz.cabservice.InvoiceGenerator;
import com.bridgelabz.model.InvoiceSummary;
import com.bridgelabz.model.Ride;
import com.bridgelabz.model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;


public class InvoiceServiceTest {
    public static InvoiceGenerator invoiceGenerator;
    @BeforeClass
    public static void setUp()  {
        invoiceGenerator = new InvoiceGenerator();
        User user1 = new User(101);
        User user2=   new User(102);
        Ride[] rides = {new Ride(2.0,5),
                    new Ride(0.1,1)
        };
        Ride[] ride2 = {new Ride(1.0,4),
                    new Ride(0.1,2)
        };
        invoiceGenerator.addUserDetails(user1,rides);
        invoiceGenerator.addUserDetails(user2,ride2);

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
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,10.0);
        Assert.assertEquals(expectedInvoiceSummary,summary);
    }
    @Test
    public void givenUseridShouldReturnInvoice() {
        List<Ride> rideUserDetails =invoiceGenerator.getRideUserDetails(new User(101));
         rideUserDetails.forEach(ride -> System.out.println( ride.toString()));
    }
}
