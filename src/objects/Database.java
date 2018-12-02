package objects;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"bicycles", "cyclists", "routes"})

public class Database {
    private ArrayList<Bicycle> bicycles;
    private ArrayList<Cyclist> cyclists;
    private ArrayList<Route> routes;

    public Database() {

    }

    public ArrayList<Bicycle> getBicycles() {
        return bicycles;
    }
    @XmlElementWrapper(name="bicycleList")
    @XmlElement(name="bicycle")
    public void setBicycles(ArrayList<Bicycle> bicycles) {
        this.bicycles = bicycles;
    }
    public void addBicycle(Bicycle bicycle) {
        this.bicycles.add(bicycle);
    }

    public ArrayList<Cyclist> getCyclists() {
        return cyclists;
    }
    @XmlElementWrapper(name="cyclistList")
    @XmlElement(name="cyclist")
    public void setCyclists(ArrayList<Cyclist> cyclists) {
        this.cyclists = cyclists;
    }
    public void addCyclist(Cyclist cyclist) {
        this.cyclists.add(cyclist);
    }

    public ArrayList<Route> getRoutes() {
        return routes;
    }
    @XmlElementWrapper(name="routeList")
    @XmlElement(name="route")
    public void setRoutes(ArrayList<Route> routes) {
        this.routes = routes;
    }
    public void addRoutes(Route route) {
        this.routes.add(route);
    }

    //    private String countryNam e;
//    private double countryPopulation;
//
//    private ArrayList<State> listOfStates;
//

//    public String getCountryName() {
//        return countryName;
//    }
//    @XmlElement
//    public void setCountryName(String countryName) {
//        this.countryName = countryName;
//    }
//    public double getCountryPopulation() {
//        return countryPopulation;
//    }
//    @XmlElement
//    public void setCountryPopulation(double countryPopulation) {
//        this.countryPopulation = countryPopulation;
//    }
//    public ArrayList<State> getListOfStates() {
//        return listOfStates;
//    }
//
//    @XmlElementWrapper(name="stateList")
//    @XmlElement(name="state")
//    public void setListOfStates(ArrayList<State> listOfStates) {
//        this.listOfStates = listOfStates;
//    }


}
