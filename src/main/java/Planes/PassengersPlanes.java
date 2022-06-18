package CleanCode.src.main.java.Planes;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019


import java.util.Objects;

public class PassengersPlanes extends Plane{

    
    private final int passengersCapacity;

    
    public PassengersPlanes(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }


    
    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                '}');
    }



    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PassengersPlanes)) return false;
            if (!super.equals(o)) return false;
            PassengersPlanes plane = (PassengersPlanes) o;
            return passengersCapacity == plane.passengersCapacity;
        }



    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
