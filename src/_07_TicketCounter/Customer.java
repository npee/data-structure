package _07_TicketCounter;

public class Customer {
    private int arrivalTime, departureTime;

    public Customer(int arrives) {
        arrivalTime = arrives;
        departureTime = 0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setDepartureTime(int departs) {
        this.departureTime = departs;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int totalTime() {
        return departureTime - arrivalTime;
    }

    @Override
    public String toString() {
        return "" + getArrivalTime();
    }
}
