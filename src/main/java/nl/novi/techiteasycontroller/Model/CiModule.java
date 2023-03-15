package nl.novi.techiteasycontroller.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ci_Module")
public class CiModule {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private  String type;
    private double price;


}
