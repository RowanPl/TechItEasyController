package nl.novi.techiteasycontroller.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "WallBracket")
public class WallBracket {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double price;
    private String size;
    private boolean adjustable;

    @ManyToMany (mappedBy = "wallBrackets")
    private List<Television> televisions;

    @OneToMany(mappedBy= "wallBracket")
    private List<TelevisionWallbrackets> wallbracket;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAdjustable() {
        return adjustable;
    }

    public void setAdjustable(boolean adjustable) {
        this.adjustable = adjustable;
    }

    public List<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(List<Television> televisions) {
        this.televisions = televisions;
    }

    public List<TelevisionWallbrackets> getWallbracket() {
        return wallbracket;
    }

    public void setWallbracket(List<TelevisionWallbrackets> wallbracket) {
        this.wallbracket = wallbracket;
    }
}
