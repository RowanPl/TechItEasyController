package nl.novi.techiteasycontroller.Controller;


import nl.novi.techiteasycontroller.Dto.Input.TelevisionInputDto;

import nl.novi.techiteasycontroller.Dto.Input.WallBracketInputDto;
import nl.novi.techiteasycontroller.Services.WallbracketService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class WallBracketController {

        private final WallbracketService wallBracketService;
        private final TelevisionWallBracketController televisionWallBracketService;
        public WallBracketController(WallbracketService wallBracketService,
                                     TelevisionWallBracketController television) {
            this.wallBracketService = wallBracketService;
            this.televisionWallBracketService = television;
        }

        @GetMapping("/wallbrackets")
        public List<WallBracketInputDto> getAllWallBrackets() {

            List<WallBracketInputDto> wallBrackets = wallBracketService.getAllWallBrackets();

            return wallBrackets;
        }

        @GetMapping("/wallbrackets/{id}")
        public WallBracketInputDto getWallBracket(@PathVariable("id") Long id) {

            WallBracketInputDto wallBracketDto = wallBracketService.getWallBracket(id);

            return wallBracketDto;
        }

        @PostMapping("/wallbrackets")
        public WallBracketInputDto addWallBracket(@RequestBody WallBracketInputDto dto) {
            WallBracketInputDto wallBracket = wallBracketService.addWallbracket(dto);
            return wallBracket;
        }

        @DeleteMapping("/wallbrackets/{id}")
        public void deleteWallBracket(@PathVariable("id") Long id) {
            wallBracketService.deleteWallBracket(id);
        }

        @PutMapping("/wallbrackets/{id}")
        public WallBracketInputDto updateWallBracket(@PathVariable("id") Long id, @RequestBody WallBracketInputDto dto) {
            wallBracketService.updateWallBracket(id, dto);
            return dto;
        }

        // Deze methode haalt alle televisies op die aan een bepaalde wallbracket gekoppeld zijn.
        // Deze methode maakt gebruikt van de televisionWallBracketService.
        @GetMapping("/wallbrackets/televisions/{wallBracketId}")
        public Collection<TelevisionInputDto> getTelevisionsByWallBracketId(@PathVariable("wallBracketId") Long wallBracketId){
            return televisionWallBracketService.getTelevisionsByWallBracketId(wallBracketId);
        }
    }