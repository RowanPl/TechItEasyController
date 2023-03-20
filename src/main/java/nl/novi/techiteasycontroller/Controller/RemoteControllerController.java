package nl.novi.techiteasycontroller.Controller;

import nl.novi.techiteasycontroller.Services.RemoteControllerService;
import nl.novi.techiteasycontroller.Services.TelevisionService;

public class RemoteControllerController {

    private final RemoteControllerService remoteController;

    public RemoteControllerController(RemoteControllerService RemoteController) {
        this.remoteController = RemoteController;
    }

}