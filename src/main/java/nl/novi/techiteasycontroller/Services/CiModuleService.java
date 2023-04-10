package nl.novi.techiteasycontroller.Services;

import nl.novi.techiteasycontroller.Controller.CiModuleDto;
import nl.novi.techiteasycontroller.Exceptions.RecordNotFoundException;
import nl.novi.techiteasycontroller.Model.CiModule;
import nl.novi.techiteasycontroller.Repository.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService  {


    private CiModuleRepository ciModuleRepository;

    public  CiModuleService(CiModuleRepository ciModuleRepository) {
        this.ciModuleRepository = (CiModuleRepository) ciModuleRepository;
    }

    public List<CiModuleDto> getAllCiModules() {
        List<CiModule> ciModules = ciModuleRepository.findAll();
        List<CiModuleDto> dtos = new ArrayList<>();
        for (CiModule ci : ciModules) {
            dtos.add(transferToDto(ci));
        }
        return dtos;
    }

    public CiModuleDto getCiModule(long id) {
        Optional<CiModule> ciModule = ciModuleRepository.findById(id);
        if(ciModule.isPresent()) {
            CiModuleDto ci = transferToDto(ciModule.get());
            return ci;
        } else {
            throw new RecordNotFoundException("No ci-module found");
        }
    }

    public CiModuleDto addCiModule(CiModuleDto ciModuleDto) {
        ciModuleRepository.save(transferToCIModule(ciModuleDto));
        return ciModuleDto;
    }

    public void deleteCiModule(Long id) {
        ciModuleRepository.deleteById(id);
    }

    public void updateCiModule(Long id, CiModuleDto ciModuleDto) {
        if(!ciModuleRepository.existsById(id)) {
            throw new RecordNotFoundException("No ci-module found");
        }
        CiModule storedCiModule = ciModuleRepository.findById(id).orElse(null);
        storedCiModule.setId(ciModuleDto.getId());
        storedCiModule.setType(ciModuleDto.getType());
        storedCiModule.setName(ciModuleDto.getName());
        storedCiModule.setPrice(ciModuleDto.getPrice());
        ciModuleRepository.save(storedCiModule);
    }

    public CiModule transferToCIModule(CiModuleDto dto){
        CiModule ciModule = new CiModule();

        ciModule.setId(dto.getId());
        ciModule.setName(dto.getName());
        ciModule.setType(dto.getType());
        ciModule.setPrice(dto.getPrice());

        return ciModule;
    }

    public static CiModuleDto transferToDto(CiModule ciModule){
        var dto = new CiModuleDto();

        dto.id = ciModule.getId();
        dto.name = ciModule.getName();
        dto.type = ciModule.getType();
        dto.price = ciModule.getPrice();

        return dto;
    }

}
