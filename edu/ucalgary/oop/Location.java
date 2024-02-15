package edu.ucalgary.oop;

public class Location {
    private String name;
    private String address;
    private DisasterVictim[] occupants;
    private Supply[] supplies;

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DisasterVictim[] getOccupants() {
        return occupants;
    }

    public void setOccupants(DisasterVictim[] occupants) {
        this.occupants = occupants;
    }

    public Supply[] getSupplies() {
        return supplies;
    }

    public void setSupplies(Supply[] supplies) {
        this.supplies = supplies;
    }
    public void addOccupant(DisasterVictim occupant) {
        DisasterVictim[] newOccupants = new DisasterVictim[occupants.length + 1];
        System.arraycopy(occupants, 0, newOccupants, 0, occupants.length);
        newOccupants[occupants.length] = occupant;
        occupants = newOccupants;
    }

    public void removeOccupant(DisasterVictim occupant) {
        int index = -1;
        for (int i = 0; i < occupants.length; i++) {
            if (occupants[i].equals(occupant)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            DisasterVictim[] newOccupants = new DisasterVictim[occupants.length - 1];
            System.arraycopy(occupants, 0, newOccupants, 0, index);
            System.arraycopy(occupants, index + 1, newOccupants, index, occupants.length - index - 1);
            occupants = newOccupants;
        }
    }

    public void addSupply(Supply supply) {
        Supply[] newSupplies = new Supply[supplies.length + 1];
        System.arraycopy(supplies, 0, newSupplies, 0, supplies.length);
        newSupplies[supplies.length] = supply;
        supplies = newSupplies;
    }

    public void removeSupply(Supply supply) {
        int index = -1;
        for (int i = 0; i < supplies.length; i++) {
            if (supplies[i].equals(supply)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Supply[] newSupplies = new Supply[supplies.length - 1];
            System.arraycopy(supplies, 0, newSupplies, 0, index);
            System.arraycopy(supplies, index + 1, newSupplies, index, supplies.length - index - 1);
            supplies = newSupplies;
        }
    }
}