package hotel.system;

import java.time.LocalDate;

public class Payment {

    private int paymentId;
    private double amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private boolean isPaid;

    //Constructor
    // Initialize payment details 
    public Payment(int paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = null;
        this.isPaid = false;
    }

// Process the payment
    public void processPayment() {
        if (!isPaid) {
            paymentDate = LocalDate.now(); //upload Date
            isPaid = true;

            System.out.println("Payment processed successfully!");
        } else {
            System.out.println("Payment has already been processed.");
        }
    }

// Refund the payment
    public void refundPayment() {
        if (isPaid) {
            paymentDate = LocalDate.now();
            isPaid = false;
            System.out.println("Payment refunded successfully!");
        } else {
            System.out.println("No payment available for refund.");
        }
    }

// Display payment information
    public void displayPaymentInfo() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Amount: " + amount);
        System.out.println("Payment Date: " + paymentDate);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Paid: " + isPaid);
    }

    // gets and sets
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

public boolean getisPaid() {
    return isPaid;
}

    public void setisPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

}
