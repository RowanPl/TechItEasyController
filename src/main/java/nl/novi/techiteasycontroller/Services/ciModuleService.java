package nl.novi.techiteasycontroller.Services;

import nl.novi.techiteasycontroller.Repository.CiModuleRepository;
import nl.novi.techiteasycontroller.Repository.WallBracketRepository;

public class ciModuleService {
    private final CiModuleRepository repos;

    public ciModuleService(CiModuleRepository repos) {
        this.repos = repos;
    }
}
