package nl.novi.techiteasycontroller.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Ci_Module")
public class CiModule {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private  String type;
    private double price;

    @OneToMany(mappedBy = "CiModule")
    private List<Television> television;

}
