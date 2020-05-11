// I avow that I did this exam without help from any other person.
//Andy Me

class Passenger {
    String passengerID, ticketClass;
    int ticketNumber;
    static int ticketCounter = 0;

    public Passenger(String ticketClass){
        setTicketNumber();
        setTicketClass(ticketClass);
        setPassengerID();
    }

    void setTicketNumber(){
        ticketCounter++;
        ticketNumber = ticketCounter;
    }
    
    void setTicketClass (String tClass){
        ticketClass = tClass;
    }

    void setPassengerID(){
        passengerID = "PID_" + ticketClass + " " + ticketNumber;
    }

    public String toString() {
        return this.passengerID;
    }

    public String getPassengerID(){
        return this.passengerID;
    }

    public String getTicketClass(){
        return this.ticketClass;
    }

    public int getTicketNumber(){
        return this.ticketNumber;
    }

}