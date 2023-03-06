package nl.novi.techiteasycontroller.Controller;

import nl.novi.techiteasycontroller.Exceptions.RecordNotFoundException;
import nl.novi.techiteasycontroller.Model.Television;
import nl.novi.techiteasycontroller.Repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("television")
@RestController
public class TelevisionController {

    @Autowired
    TelevisionRepository repo;



    @GetMapping()
    public ResponseEntity<List<Television>> getAllTelevisions(){
        return ResponseEntity.ok(repo.findAll());
    }

    @PostMapping
    public ResponseEntity<Television> createTelevision(@RequestBody Television t) {
        repo.save(t);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + t.getId()).toUriString());

        return ResponseEntity.created(uri).body(t);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTvById(@PathVariable Long id){
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteTvWithName(@PathVariable String name){
        repo.deleteByName(name);
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/find/{name}")
    public ResponseEntity<Television> findTvByName(@PathVariable String name){
        Optional <Television> optionaltv = repo.findByName(name);
        if (optionaltv.isPresent())
            return ResponseEntity.ok(optionaltv.get());
        else
        return ResponseEntity.noContent().build();

    }


    @GetMapping("/{id}")
    public  ResponseEntity<String> getTVWithId(@PathVariable int id){
        //Check Optional

        if (id > repo.count()){
            throw new RecordNotFoundException("Novi is de beste!");
        }
        return ResponseEntity.ok("television: " + id);
    //  return new ResponseEntity("television: " + id , HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTv(@PathVariable int id, @RequestBody Television tv) {
        Television updatedTv = repo.findById((long) id)
                .orElseThrow(() -> new RecordNotFoundException("Tv " + id + " zit niet in de lijst!"));

        updatedTv.setName(tv.getName());
        updatedTv.setType(tv.getType());
        updatedTv.setPrice(tv.getPrice());
        updatedTv.setBrand(tv.getBrand());
        repo.save(updatedTv);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/" + updatedTv.getId()).toUriString());
        return ResponseEntity.created(uri).body(updatedTv);
    }







}
