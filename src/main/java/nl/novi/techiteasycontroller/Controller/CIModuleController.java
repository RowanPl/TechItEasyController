package nl.novi.techiteasycontroller.Controller;

import nl.novi.techiteasycontroller.Services.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    public class CIModuleController {
        private CiModuleService CiModuleService;
        private nl.novi.techiteasycontroller.Services.CiModuleService ciModuleService;

        public CIModuleController(CiModuleService ciModuleService) {
            this.CiModuleService = ciModuleService;
        }


        @GetMapping("/cimodules")
        public <CiModuleDto> ResponseEntity<List<CiModuleDto>> getAllCIModules() {

            List<CiModuleDto> dtos = (List<CiModuleDto>) CiModuleService.getAllCiModules();

            return ResponseEntity.ok(dtos);
        }

        @GetMapping("/cimodules/{id}")
        public ResponseEntity<CiModuleDto> getCIModule(@PathVariable("id") Long id) {

            CiModuleDto ciModuleDto = ciModuleService.getCiModule(id);

            return ResponseEntity.ok(ciModuleDto);
        }

        @PostMapping("/cimodules")
        public ResponseEntity<CiModuleDto> addCIModule(@RequestBody CiModuleDto dto) {
            CiModuleDto ciModuleDto = ciModuleService.addCiModule(dto);
            return ResponseEntity.created(null).body(ciModuleDto);
        }

        @DeleteMapping("/cimodules/{id}")
        public ResponseEntity<Object> deleteCIModule(@PathVariable("id") Long id) {

            ciModuleService.deleteCiModule(id);

            return ResponseEntity.noContent().build();
        }

        @PutMapping("/cimodules/{id}")
        public ResponseEntity<CiModuleDto> updateCIModule(@PathVariable("id") Long id, @RequestBody CiModuleDto ciModuleDto) {
            ciModuleService.updateCiModule(id, ciModuleDto);
            return ResponseEntity.ok(ciModuleDto);
        }
    }


