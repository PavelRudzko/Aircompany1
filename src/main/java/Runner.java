package CleanCode.src.main.java;
/** A program for task " Clean code "
 * @ checked by Pavel Rudzko
 */


import CleanCode.src.main.java.models.MilitaryType;
import CleanCode.src.main.java.Planes.MilitaryPlane;
import CleanCode.src.main.java.Planes.PassengersPlanes;
import CleanCode.src.main.java.Planes.Plane;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static List<Plane> planes = Arrays.asList(
            new PassengersPlanes("Boeing-737", 900, 12000, 60500, 164),
            new PassengersPlanes("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengersPlanes("Boeing-747", 980, 16100, 70500, 242),
            new PassengersPlanes("Airbus A320", 930, 11800, 65500, 188),
            new PassengersPlanes("Airbus A330", 990, 14800, 80500, 222),
            new PassengersPlanes("Embraer 190", 870, 8100, 30800, 64),
            new PassengersPlanes("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengersPlanes("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
    );

    public static void main(String[] args) {
        Airport airport = new Airport(planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengersPlanes());
        System.out.println("Military airport sorted by max distance: " + militaryAirport
                .sortByMaxDistance()
                .toString());
        System.out.println("Passenger airport sorted by max speed: " + passengerAirport
                .sortByMaxSpeed()
                .toString());

        System.out.println("Plane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
