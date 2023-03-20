package nl.novi.techiteasycontroller.Model;

import jakarta.persistence.*;

@Entity
public class TelevisionWallbrackets {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private WallBracket wallBracket;

    @ManyToOne
    private Television television;

}
