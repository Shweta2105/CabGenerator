package com.bridgelabz.cabservice;

import com.bridgelabz.model.InvoiceSummary;
import com.bridgelabz.model.Ride;
import com.bridgelabz.model.User;

import java.util.*;

/*
@param distance

 */
public class InvoiceGenerator {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;
    private static Map<User, List<Ride>> invoiceDetail = new HashMap<>();

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);

    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);


    }

    public void addUserDetails(User user1, Ride[] rides) {
        List<Ride> rideList = Arrays.asList(rides);
        if (invoiceDetail.containsKey(user1)) {
            List<Ride> rideList1 = invoiceDetail.get(user1);
            rideList1.addAll(rideList);
            invoiceDetail.put(user1, rideList1);

        } else {
            invoiceDetail.put(user1, rideList);
        }

    }

    public List<Ride> getRideUserDetails(User user1) {
        if (invoiceDetail.containsKey(user1)) {
            return invoiceDetail.get(user1);
        }
        return null;

    }
}
