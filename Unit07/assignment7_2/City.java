package assignment7_2;

public class City {
    private final String name;
    private final String state;
    private final double latitude;
    private final double longitude;

    public City (String name, String state, double latitude, double longitude) {
        this.name = name;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        return (int)latitude ^ 7 + (int)longitude ^ 13;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof City)) {
            return false;
        }

        City other = (City)(obj);
        return other.latitude == this.latitude && other.longitude == this.longitude;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.state;
    }

    public double distanceFrom(City city) {
        return Math.sqrt(Math.pow(this.longitude - city.longitude, 2) + Math.pow(this.latitude - city.latitude, 2));
    }
}
