package cn.newtouch.getlevel.entities;

import java.io.Serializable;

import java.util.List;

public class TruckLength implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String description;

    private List<Vehicles> vehiclessTruckLengthId = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVehiclessTruckLengthId(List vehiclessTruckLengthId) {
        this.vehiclessTruckLengthId=vehiclessTruckLengthId;
    }

    public List<Vehicles> getVehiclessTruckLengthId() {
        return vehiclessTruckLengthId;
    }
}