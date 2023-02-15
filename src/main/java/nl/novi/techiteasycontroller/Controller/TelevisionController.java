package nl.novi.techiteasycontroller.Controller;

import nl.novi.techiteasycontroller.Exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionController {

    @GetMapping("television")
    public ResponseEntity<String> getAllTelevisions(){
        return ResponseEntity.ok("television");
    //    return new ResponseEntity("television" , HttpStatus.OK)
    }


    @GetMapping("television/{id}")
    public  ResponseEntity<String> getTVWithId(@PathVariable int id){

        if (id == 5){
            throw new RecordNotFoundException("Novi is de beste!");
        }
        return ResponseEntity.ok("television: " + id);
    //  return new ResponseEntity("television: " + id , HttpStatus.OK);
    }


    @PutMapping("television/{id}")
    public ResponseEntity<String> updateTvList(@PathVariable int id, @RequestParam String name){
        return ResponseEntity.noContent().build();
    }

    @PostMapping("television")
    public ResponseEntity<String> addTvList(@RequestBody String television ){
        return ResponseEntity.created(null).body(television);
    }

    @DeleteMapping("television/{id}")
    public ResponseEntity<String> deleteTvById(@PathVariable int id){
        return ResponseEntity.noContent().build();
    }


}
