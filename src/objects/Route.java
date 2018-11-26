package objects;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.RowId;
import java.sql.Time;
import java.util.ArrayList;

@XmlRootElement(namespace = "objects.Register")
public class Route {
    private double distance;
    private double hours;
    private ArrayList<String> info;

    public Route() {

    }
    public Route(double distance, double hours, ArrayList<String> info) {
        this.distance = distance;
        this.hours = hours;
        this.info = info;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public ArrayList<String> getInfo() {
        return info;
    }

    public void setInfo(ArrayList<String> info) {
        this.info = info;
    }
}
