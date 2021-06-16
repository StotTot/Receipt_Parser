package dev.debride.receiptparser.controller;

import dev.debride.receiptparser.models.Receipt;
import dev.debride.receiptparser.models.ReceiptDTO;
import dev.debride.receiptparser.service.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
@RestController
public class ParseController {

    @Autowired
    ParseService parseService;

    @PostMapping("/parse")
    public ResponseEntity<ReceiptDTO> parseReceipt(@RequestBody Receipt url) throws URISyntaxException, IOException {
        if(url.getUrl() == null)
            return ResponseEntity.status(400).body(null);
        return ResponseEntity.status(200).body(new ReceiptDTO(parseService.parse(url.getUrl())));
    }

}
