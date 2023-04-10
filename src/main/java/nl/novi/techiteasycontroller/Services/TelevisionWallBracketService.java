package nl.novi.techiteasycontroller.Services;

import nl.novi.techiteasycontroller.Dto.Input.TelevisionInputDto;
import nl.novi.techiteasycontroller.Dto.Input.WallBracketInputDto;
import nl.novi.techiteasycontroller.Exceptions.RecordNotFoundException;
import nl.novi.techiteasycontroller.Model.Television;
import nl.novi.techiteasycontroller.Model.TelevisionWallBracket;
import nl.novi.techiteasycontroller.Model.TelevisionWallBracketKey;
import nl.novi.techiteasycontroller.Model.WallBracket;
import nl.novi.techiteasycontroller.Repository.TelevisionRepository;
import nl.novi.techiteasycontroller.Repository.TelevisionWallBracketRepository;
import nl.novi.techiteasycontroller.Repository.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class TelevisionWallBracketService{

    private TelevisionRepository televisionRepository;

    private WallBracketRepository wallBracketRepository;

    private TelevisionWallBracketRepository televisionWallBracketRepository;

    public TelevisionWallBracketService(TelevisionRepository televisionRepository, WallBracketRepository wallBracketRepository, TelevisionWallBracketRepository televisionWallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.wallBracketRepository = wallBracketRepository;
        this.televisionWallBracketRepository = televisionWallBracketRepository;
    }

    public Collection<TelevisionInputDto> getTelevisionsByWallBracketId(Long wallBracketId) {
        Collection<TelevisionInputDto> dtos = new HashSet<>();
        Collection<TelevisionWallBracket> televisionWallbrackets = televisionWallBracketRepository.findAllByWallBracketId(wallBracketId);
        for (TelevisionWallBracket televisionWallbracket : televisionWallbrackets) {
            Television television = televisionWallbracket.getTelevision();
            TelevisionInputDto televisionDto = new TelevisionInputDto();

            televisionDto.setId(television.getId());
            televisionDto.setType(television.getType());
            televisionDto.setBrand(television.getBrand());
            televisionDto.setName(television.getName());
            televisionDto.setPrice(television.getPrice());
            televisionDto.setAvailableSize(television.getAvailableSize());
            televisionDto.setRefreshRate(television.getRefreshRate());
            televisionDto.setScreenType(television.getScreenType());
            televisionDto.setScreenQuality(television.getScreenQuality());
            televisionDto.setSmartTv(television.isSmartTv());
            televisionDto.setWifi(television.isWifi());
            televisionDto.setVoiceControl(television.isVoiceControl());
            televisionDto.setHdr(television.isHdr());
            televisionDto.setBluetooth(television.isBluetooth());
            televisionDto.setAmbiLight(television.isAmbiLight());
            televisionDto.setOriginalStock(television.getOriginalStock());
            televisionDto.setSold(television.getSold());

            dtos.add(televisionDto);
        }
        return dtos;
    }

    public Collection<TelevisionInputDto> getWallBracketsByTelevisionId(Long televisionId) {

        Set<TelevisionInputDto> dtos = new HashSet<>();
        List<TelevisionWallBracket> televisionWallbrackets = televisionWallBracketRepository.findAllByTelevisionId(televisionId);
        for (TelevisionWallBracket televisionWallbracket : televisionWallbrackets) {
            WallBracket wallBracket = televisionWallbracket.getWallBracket();
            var dto = new TelevisionInputDto();

            dto.setId(wallBracket.getId());
            dto.setName(wallBracket.getName());
            dto.setSize(wallBracket.getSize());
            dto.setAdjustable(wallBracket.isAdjustable());
            dto.setPrice(wallBracket.getPrice());

            dtos.add(dto);
        }
        return dtos;
    }


    public TelevisionWallBracketKey addTelevisionWallBracket(Long televisionId, Long wallBracketId) {
        var televisionWallBracket = new TelevisionWallBracket();
        if (!televisionRepository.existsById(televisionId)) {throw new RecordNotFoundException("error");}
        Television television = televisionRepository.findById(televisionId).orElse(null);
        if (!wallBracketRepository.existsById(wallBracketId)) {throw new RecordNotFoundException("error");}
        WallBracket wallBracket = wallBracketRepository.findById(wallBracketId).orElse(null);
        televisionWallBracket.setTelevision(television);
        televisionWallBracket.setWallBracket(wallBracket);
        TelevisionWallBracketKey id = new TelevisionWallBracketKey(televisionId, wallBracketId);
        televisionWallBracket.setId(id);
        televisionWallBracketRepository.save(televisionWallBracket);
        return id;
    }
}
