package dev.debride.receiptparser.service;

import dev.debride.receiptparser.models.Receipt;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public interface ParseService {
    Receipt parse(String filePath) throws URISyntaxException, IOException;
}
