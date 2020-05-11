// I avow that I did this exam without help from any other person.
//Andy Me
import java.util.*; 

public class Flight<Passenger> {
    String flightName;
    int seats;
    int seatsSold;
    Random randy;
    LinkedList<Passenger> passBooked = new LinkedList<Passenger>();
    PriorityQueue<Passenger> boardingQueue = new PriorityQueue<Passenger>(seats, new PassengerComparator());

    public Flight(String flightName, int seed){
        setFlightName(flightName);
        Random randy = new Random(seed);
        setSeats();
    }

    void setFlightName(String fName){
        this.flightName = fName;
    }

    void setSeats(){
        this.seats = randy.nextInt(76) + 75;
    }

    void sellSeats(){
        seatsSold = randy.nextInt(this.seats/2) + this.seats/2;
        for (int i = 0; i < seatsSold; i++){
            if(randy.nextInt(5) == 0){
                passBooked.add(FirstClassPassenger());
            } else {
                passBooked.add(CoachPassenger());
            }
        }
    }
}