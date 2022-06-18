package CleanCode.src.test.java;

import CleanCode.src.main.java.Airport;
import CleanCode.src.main.java.Planes.ExperimentalPlane;
import CleanCode.src.main.java.Planes.MilitaryPlane;
import CleanCode.src.main.java.Planes.PassengersPlanes;
import CleanCode.src.main.java.Planes.Plane;
import CleanCode.src.main.java.Runner;
import CleanCode.src.main.java.models.ClassificationLevel;
import CleanCode.src.main.java.models.MilitaryType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AirportTest {

    private static final PassengersPlanes planeWithMaxPassengerCapacity = new PassengersPlanes("Boeing-747", 980, 16100, 70500, 242);
    //private List<? extends Plane> planes;

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(Runner.planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        boolean flag = false;
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryType.TRANSPORT)) {
                flag = true;
                break;
            }
        }
        Assert.assertEquals(flag, true);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        System.out.println("TEST testGetPassengerPlaneWithMaxCapacity started!");
        Airport airport = new Airport(Runner.planes);
        PassengersPlanes expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertTrue(expectedPlaneWithMaxPassengersCapacity.equals(planeWithMaxPassengerCapacity));
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(Runner.planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();

        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMinLoadCapacity() > nextPlane.getMinLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(Runner.planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        boolean flag = false;
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryType.BOMBER)) {
                flag = true;
            }
            else {
                Assert.fail("Test failed!");
            }
        }

    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(Runner.planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for(ExperimentalPlane experimentalPlane : experimentalPlanes){
            if(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED){
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
