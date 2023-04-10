package nl.novi.techiteasycontroller.Model;

import jakarta.persistence.*;

import javax.naming.Name;
import java.util.List;

@Entity
@Table(name = "televisions")
public class Television {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String type;
    private String name;
    private double price;
    private double availableSize;
    private double refreshRate;
    private String screenType;
    private String screenQuality;
    private boolean smartTv;
    private boolean wifi;
    private boolean voiceControl;
    private boolean hdr;
    private boolean bluetooth;
    private boolean ambiLight;
    private int originalStock;
    private int sold;

    @OneToOne
    private RemoteController remoteController;


    @ManyToMany
    @JoinTable(name = "tussen_tabel",
    joinColumns = @JoinColumn(name = "tv_Id"),
    inverseJoinColumns = @JoinColumn(name = "wb_id"))
    private List<WallBracket> wallBrackets;


    @OneToMany(mappedBy = "television")
    private List<TelevisionWallbrackets> televisions;

    public static void television() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(double availableSize) {
        this.availableSize = availableSize;
    }

    public double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreentype() {
        return screenType;
    }

    public void setScreentype(String screentype) {
        this.screenType = screentype;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public boolean isHdr() {
        return hdr;
    }

    public void setHdr(boolean hdr) {
        this.hdr = hdr;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public RemoteController getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
    }

    public List<WallBracket> getWallBrackets() {
        return wallBrackets;
    }

    public void setWallBrackets(List<WallBracket> wallBrackets) {
        this.wallBrackets = wallBrackets;
    }

    public List<TelevisionWallbrackets> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(List<TelevisionWallbrackets> televisions) {
        this.televisions = televisions;
    }


}
