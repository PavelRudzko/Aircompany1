package CleanCode.src.main.java.Planes;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

import CleanCode.src.main.java.models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private final MilitaryType type;

    public MilitaryPlane(String model,
                         int maxSpeed,
                         int maxFlightDistance,
                         int maxLoadCapacity,
                         MilitaryType type) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
    }

    public MilitaryType getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + type +
                '}');
    }

    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof MilitaryPlane that)) return false;
//        if (!super.equals(o)) return false;
//        return type == that.type;
//    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane)) return false;
        if (!super.equals(o)) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return type == that.type;
    }



    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
