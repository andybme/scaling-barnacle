// I avow that I did this exam without help from any other person.
//Andy Me
import java.util.*; 

//This program should never return 0, as the ticket ID should never be the same.
class PassengerComparator<Passenger> implements Comparator<Passenger>{
    public int compare(Passenger a, Passenger b){
        int id1 = a.getTicketNumber();
        int id2 = b.getTicketNumber();
        String class1 = a.getTicketClass();
        String class2 = b.getTicketClass();
        if (class1 == class2){
            //this is the case of the same ticket class
            if (id1 > id2){
                return 1;
            } else if(id2 > id1){
                return -1;
            }
        } else if(class1 == "First"){
            //assuming they're not equal, if one is First the other isn't.
            return 1;
        } else{
            return -1;
        }
        return -1;
    }
}