package nl.novi.techiteasycontroller.Services;

import nl.novi.techiteasycontroller.Repository.RemoteControllerRepository;


public class RemoteControllerService {
    private final RemoteControllerRepository repos;

    public RemoteControllerService(RemoteControllerRepository repos) {
        this.repos = repos;
    }
}
