package nl.novi.techiteasycontroller.Controller;

import nl.novi.techiteasycontroller.Dto.Input.RemoteControllerInputDto;
import nl.novi.techiteasycontroller.Services.RemoteControllerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RemoteControllerController {
    private final RemoteControllerService remoteControllerService;

    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }


    @GetMapping("/remotecontrollers")
    public List<RemoteControllerInputDto> getAllRemotecontrollers() {

        List<RemoteControllerInputDto> dtos = remoteControllerService.getAllRemoteControllers();

        return dtos;
    }

    @GetMapping("/remotecontrollers/{id}")
    public RemoteControllerInputDto getRemotecontroller(@PathVariable("id") Long id) {

        RemoteControllerInputDto dto = remoteControllerService.getRemoteController(id);

        return dto;
    }

    @PostMapping("/remotecontrollers")
    public RemoteControllerInputDto addRemoteController(@RequestBody RemoteControllerInputDto dto) {
        RemoteControllerInputDto dto1 = remoteControllerService.addRemoteController(dto);
        return dto1;
    }

    @DeleteMapping("/remotecontrollers/{id}")
    public void deleteRemoteController(@PathVariable("id") Long id) {
        remoteControllerService.deleteRemoteController(id);
    }

    @PutMapping("/remotecontrollers/{id}")
    public RemoteControllerInputDto updateTelevision(@PathVariable("id") Long id, @RequestBody RemoteControllerInputDto dto) {
        remoteControllerService.updateRemoteController(id, dto);
        return dto;
    }

}