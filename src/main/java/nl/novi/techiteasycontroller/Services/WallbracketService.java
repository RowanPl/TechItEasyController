package nl.novi.techiteasycontroller.Services;

import nl.novi.techiteasycontroller.Dto.Input.WallBracketInputDto;
import nl.novi.techiteasycontroller.Exceptions.RecordNotFoundException;
import nl.novi.techiteasycontroller.Model.WallBracket;
import nl.novi.techiteasycontroller.Repository.WallBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallbracketService {
    @Autowired
    private final WallBracketRepository repos;

    public WallbracketService(WallBracketRepository repos) {
        this.repos = repos;
    }

    public List<WallBracketInputDto> getAllWallBrackets() {
        List<WallBracket> wallBracketList = repos.findAll();
        List<WallBracketInputDto> dtos = new ArrayList<>();
        for (WallBracket wb : wallBracketList) {
            dtos.add(transferToDto(wb));
        }
        return dtos;
    }

    public WallBracketInputDto getWallBracket(long id) {
        Optional<WallBracket> wallBracket = repos.findById(id);
        if(wallBracket.isPresent()) {
            WallBracketInputDto dto = transferToDto(wallBracket.get());
            return dto;
        } else {
            throw new RecordNotFoundException("No wallbracket found");
        }
    }

    public WallBracketInputDto addWallbracket(WallBracketInputDto wallBracketDto) {
        WallBracket wallBracket = transferToWallBracket(wallBracketDto);
        repos.save(wallBracket);
        return transferToDto(wallBracket);
    }

    public void deleteWallBracket(Long id) {
        repos.deleteById(id);
    }

    public void updateWallBracket(Long id, WallBracketInputDto wallBracketDto) {
        if(!repos.existsById(id)) {
            throw new RecordNotFoundException("No wallbracket found");
        }
        WallBracket storedWallBracket = repos.findById(id).orElse(null);
        storedWallBracket.setId(wallBracketDto.getId());
        storedWallBracket.setSize(wallBracketDto.getSize());
        storedWallBracket.setAdjustable(wallBracketDto.isAdjustable());
        storedWallBracket.setName(wallBracketDto.getName());
        storedWallBracket.setPrice(wallBracketDto.getPrice());
        repos.save(storedWallBracket);
    }

    public WallBracketInputDto transferToDto(WallBracket wallBracket){
        var dto = new WallBracketInputDto();

        dto.setId(wallBracket.getId());
        dto.setName(wallBracket.getName());
        dto.setSize(wallBracket.getSize());
        dto.setAdjustable(wallBracket.isAdjustable());
        dto.setPrice(wallBracket.getPrice());

        return dto;
    }

    public WallBracket transferToWallBracket(WallBracketInputDto wallBracketDto){
        var wallBracket = new WallBracket();
        wallBracket.setId(wallBracketDto.getId());
        wallBracket.setName(wallBracketDto.getName());
        wallBracket.setSize(wallBracketDto.getSize());
        wallBracket.setAdjustable(wallBracketDto.isAdjustable());
        wallBracket.setPrice(wallBracketDto.getPrice());

        return wallBracket;
    }





}
