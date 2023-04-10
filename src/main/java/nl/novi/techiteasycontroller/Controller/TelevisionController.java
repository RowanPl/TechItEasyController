package nl.novi.techiteasycontroller.Controller;

import nl.novi.techiteasycontroller.Dto.Input.TelevisionInputDto;
import nl.novi.techiteasycontroller.Dto.Output.TelevisionOutputDto;
import nl.novi.techiteasycontroller.Exceptions.RecordNotFoundException;
import nl.novi.techiteasycontroller.Model.Television;
import nl.novi.techiteasycontroller.Services.TelevisionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("television")
@RestController
public class TelevisionController {

    private final TelevisionService televisionService;

    public TelevisionController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }


    @GetMapping()
    public ResponseEntity<List<TelevisionOutputDto>> getAllTelevisions() {
        List<TelevisionOutputDto> Televisionoutput = televisionService.getAllTelevisions();
        return ResponseEntity.ok(Televisionoutput);
    }

    @PostMapping
    public ResponseEntity<Object> createTelevision(@RequestBody TelevisionInputDto tdto, BindingResult br) {

        if (br.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage() + "\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        Long id = televisionService.createTelevision(tdto);
        tdto.id = id;

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + id).toUriString());

        return ResponseEntity.created(uri).body(tdto);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTvById(@PathVariable Long id) {
        televisionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
