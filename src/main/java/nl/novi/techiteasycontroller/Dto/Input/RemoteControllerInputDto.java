package nl.novi.techiteasycontroller.Dto.Input;


import nl.novi.techiteasycontroller.Model.Television;

public class RemoteControllerInputDto {
    public long id;
    public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    public double price;
    public int originalStock;
    public Television television;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }
}
