package dev.debride.receiptparser.servicetest;

import dev.debride.receiptparser.service.ParseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootTest
public class ParseServiceImplTest {

    @Autowired
    ParseServiceImpl parseServiceImpl;

    @Test
    void parseTest() throws URISyntaxException, IOException {
        Assertions.assertNotNull(parseServiceImpl.parse("https://images.sampletemplates.com/wp-content/uploads/2018/04/Detailed-Grocery-Payment-Receipt-Samples.jpg"));
        Assertions.assertEquals(46.30, parseServiceImpl.parse("https://images.sampletemplates.com/wp-content/uploads/2018/04/Detailed-Grocery-Payment-Receipt-Samples.jpg").getTotal());
    }
}
