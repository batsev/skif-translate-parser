package dev.skif.translateParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateParserController {

    private final Service service;

    @Autowired
    public TranslateParserController(Service service) {
        this.service = service;
    }

    @PostMapping("/translate")
    public ResponseEntity<Object> translateMessage(@RequestBody String requestBody) {
        return service.translateMessage(requestBody);
    }
}
