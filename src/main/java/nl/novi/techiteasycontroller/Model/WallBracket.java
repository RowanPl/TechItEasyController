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
}
