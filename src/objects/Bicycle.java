package objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "objects.Register")
public class Bicycle {
    private String type;
    private int wheelSize;
    private String brake;

    public Bicycle() {

    }
    public Bicycle(String type, int wheelSize, String brake) {
        super();
        this.type = type;
        this.wheelSize = wheelSize;
        this.brake = brake;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getBrake() {
        return brake;
    }

    public void setBrake(String brake) {
        this.brake = brake;
    }
}
