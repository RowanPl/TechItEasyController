package nl.novi.techiteasycontroller.Dto.Input;


import nl.novi.techiteasycontroller.Model.Television;

import java.util.List;

public class WallBracketInputDto {
    public long id;
    public String name;
    public double price;
    public String size;
    public boolean adjustable;
    public List<Television> televisions;
}
