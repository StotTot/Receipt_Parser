package dev.debride.receiptparser.controller;

import dev.debride.receiptparser.models.Receipt;
import dev.debride.receiptparser.models.ReceiptDTO;
import dev.debride.receiptparser.repos.ReceiptRepo;
import dev.debride.receiptparser.service.ParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@CrossOrigin
public class ParseController {

    @Autowired
    ReceiptRepo receiptRepo;

    @Autowired
    ParseService parseService;

    @PostMapping("/parse")
    public ResponseEntity<ReceiptDTO> parseReceipt(@RequestBody(required = true) String url) throws URISyntaxException, IOException {
        return ResponseEntity.status(200).body(new ReceiptDTO(parseService.parse(url)));
    }

    @GetMapping("/receipts")
    public ResponseEntity<List<ReceiptDTO>> getReceipts() {
        List<Receipt> receiptList = new ArrayList<>();
        List<ReceiptDTO> receiptDTOList = new ArrayList<>();
        receiptRepo.findAll().forEach(receiptList :: add);
        for (Receipt r : receiptList) {
            receiptDTOList.add(new ReceiptDTO(r));
        }
        return ResponseEntity.status(200).body(receiptDTOList);
    }

}
