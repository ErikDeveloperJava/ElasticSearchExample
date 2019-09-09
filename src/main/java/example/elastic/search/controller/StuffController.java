package example.elastic.search.controller;

import example.elastic.search.repository.StuffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stuff")
public class StuffController {

    @Autowired
    private StuffRepository stuffRepository;
}