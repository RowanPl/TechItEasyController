package nl.novi.techiteasycontroller.Services;

import nl.novi.techiteasycontroller.Dto.Output.TelevisionOutputDto;
import nl.novi.techiteasycontroller.Exceptions.RecordNotFoundException;
import nl.novi.techiteasycontroller.Model.Television;
import nl.novi.techiteasycontroller.Repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;


    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }



    public List<TelevisionOutputDto> getAllTelevisions(){
        Iterable<Television> television = repos.findAll();
        List<TelevisionOutputDto> televisionOutputDtos = new ArrayList<>();
        for (Television t : television){
            TelevisionOutputDto tdto = televisionToDto(t);
            televisionOutputDtos.add(tdto);

        }
        return televisionOutputDtos;
    }

    public TelevisionOutputDto getTelevisionById(Long id){
        Optional<Television> television = repos.findById(id);

        if (television.isEmpty()){
            throw new RecordNotFoundException("Television not found..");
        }
        else{
            Television t = television.get();
         TelevisionOutputDto tdto = televisionToDto(t);
            return tdto;
        }
    }

    public TelevisionOutputDto televisionToDto(Television t) {

        TelevisionOutputDto tdto = new TelevisionOutputDto();
        tdto.id = t.getId();
        tdto.brand = t.getBrand();
        tdto.type = t.getType();
        tdto.name = t.getName();
        tdto.price = t.getPrice();
        tdto.availableSize = t.getAvailableSize();
        tdto.refreshRate = t.getRefreshRate();
        tdto.screenType = t.getScreentype();
        tdto.screenQuality = t.getScreenQuality();
        tdto.smartTv = t.isSmartTv();
        tdto.voiceControl = t.isVoiceControl();
        tdto.hdr = t.isHdr();
        tdto.bluetooth = t.isBluetooth();
        tdto.ambiLight = t.isAmbiLight();
        tdto.originalStock = t.getOriginalStock();
        tdto.sold = t.getSold();
        return tdto;
    }

}
