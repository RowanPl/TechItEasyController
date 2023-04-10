package nl.novi.techiteasycontroller.Controller;

import nl.novi.techiteasycontroller.Dto.Input.TelevisionInputDto;
import nl.novi.techiteasycontroller.Model.Television;
import nl.novi.techiteasycontroller.Model.TelevisionWallBracket;
import nl.novi.techiteasycontroller.Model.TelevisionWallBracketKey;
import nl.novi.techiteasycontroller.Repository.TelevisionWallBracketRepository;
import nl.novi.techiteasycontroller.Services.TelevisionWallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashSet;

@RestController
@RequestMapping("/tvwb")
public class TelevisionWallBracketController {
    private TelevisionWallBracketService televisionWallBracketService;
    private TelevisionWallBracketRepository televisionWallBracketRepository;

    public TelevisionWallBracketController(TelevisionWallBracketService televisionWallBracketService) {
        this.televisionWallBracketService = televisionWallBracketService;
    }

    @PostMapping("/{televisionId}/{wallBracketId}")
    public ResponseEntity<TelevisionWallBracketKey> addTelevisionWallBracket(@PathVariable("televisionId") Long televisionId, @PathVariable("wallBracketId") Long wallbracketId) {
        TelevisionWallBracketKey key = televisionWallBracketService.addTelevisionWallBracket(televisionId, wallbracketId);
        return ResponseEntity.created(null).body(key);
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

}

