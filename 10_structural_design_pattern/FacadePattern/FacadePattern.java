public class FacadePattern {
    public static void main(String[] args) {
        
        TravelFacade travelAgent = new TravelFacade();
        travelAgent.bookTrip("Varanasi", "Paris");
    }
}

class TravelFacade{
    private FlightService flight;
    private HotelService hotel;
    private CabService cab;
    public TravelFacade(){
        this.flight = new FlightService();
        this.hotel = new HotelService();
        this.cab = new CabService();
    }

    public void bookTrip(String from, String to){
        flight.bookFlight(from, to);
        hotel.bookRoom(to);
        cab.bookCab(to);
        System.out.println("--- Trip Booked Successfully! ---");
    }
}


class FlightService {
    public void bookFlight(String from, String to) {
        System.out.println("Flight booked from " + from + " to " + to);
    }
}

class HotelService {
    public void bookRoom(String location) {
        System.out.println("Hotel room booked in " + location);
    }
}

class CabService {
    public void bookCab(String location) {
        System.out.println("Airport pickup arranged in " + location);
    }
}