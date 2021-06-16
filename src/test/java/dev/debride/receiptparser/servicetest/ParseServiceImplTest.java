package dev.debride.receiptparser.servicetest;

import dev.debride.receiptparser.models.Receipt;
import dev.debride.receiptparser.service.ParseService;
import dev.debride.receiptparser.service.ParseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootTest
public class ParseServiceImplTest {

    @Autowired
    ParseService parseService;

    Receipt test;

    @BeforeEach
    void setUp() throws URISyntaxException, IOException {
        test = parseService.parse("https://images.sampletemplates.com/wp-content/uploads/2018/04/Detailed-Grocery-Payment-Receipt-Samples.jpg");
    }

    @Test
    void parseData() {
        Assertions.assertNotNull(test);
    }

    @Test
    void parseTotal() {
        Assertions.assertEquals(46.3, test.getTotal());
    }
}
