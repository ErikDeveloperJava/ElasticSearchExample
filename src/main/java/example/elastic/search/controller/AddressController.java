package example.elastic.search.controller;

import example.elastic.search.model.Address;
import example.elastic.search.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping
    public ResponseEntity save(@RequestBody Address address){
        addressRepository.save(address);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getAll(){
        Iterable<Address> addressIterable = addressRepository.findAll();
        List<Address> addressList = new ArrayList<>();
        addressIterable.forEach(addressList::add);
        return ResponseEntity.ok(addressList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable("id")String id){
        Optional<Address> address = addressRepository.findById(id);
        if(address.isPresent()){
            return ResponseEntity
                    .ok(address.get());
        }
        return ResponseEntity
                .notFound()
                .build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getByName(@PathVariable("name")String name){
        List<Address> addressList = addressRepository.findByName(name);
        return ResponseEntity.ok(addressList);
    }
}
