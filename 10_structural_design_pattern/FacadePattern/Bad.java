public class Bad {
    public static void main(String[] args) {
        
        FlightService flight = new FlightService();
        flight.bookFlight("Varanasi", "Paris");

        HotelService hotel = new HotelService();
        hotel.bookRoom("Paris");

        CabService cab = new CabService();
        cab.bookCab("paris");
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