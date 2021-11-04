package dev.skif.translateParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TranslateParserController {

    private final Service service;

    @Autowired
    public TranslateParserController(Service service) {
        this.service = service;
    }

    @PostMapping("/translate")
    public String translateMessage(@RequestBody String requestBody) throws IOException {
        return service.translateMessage(requestBody);
    }
}
