package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private String employer;
    private String location;
    private String positionType;
    private String coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, String employer, String location, String positionType, String coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }



    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmployer() {
        return employer;
    }

    public String getLocation() {
        return location;
    }

    public String getPositionType() {
        return positionType;
    }

    public String getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(String coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String str = "\n"+
                "ID: " + id +
                "\nName: " + name +
                "\nEmployer: " + employer +
                "\nLocation: " + location +
                "\nPosition Type: " + positionType +
                "\nCore Competency: " + coreCompetency +
                "\n";

        if(getName() == null || getName() == ""){
            name = "Data not available";
        }

        if(getEmployer() == null || getEmployer() == ""){
            employer = "Data not available";
        }

        if(getLocation() == null || getLocation() == ""){
            location = "Data not available";
        }

        if(getPositionType() == null || getPositionType() == ""){
            positionType = "Data not available";
        }

        if(getCoreCompetency() == null || getCoreCompetency() == ""){
            coreCompetency = "Data not available";
        }
        return str;
    }
}
