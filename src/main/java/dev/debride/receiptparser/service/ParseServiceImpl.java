package dev.debride.receiptparser.service;

import dev.debride.receiptparser.models.Receipt;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

@Component
@Service
public class ParseServiceImpl implements ParseService{

    public Receipt parse(String filePath) throws URISyntaxException, IOException {
        File file;
        Tesseract tesseract = new Tesseract();
        URL url = new URL(filePath);
        FileUtils.copyURLToFile(url, new File("images\\temp.jpg"));

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("traineddata");
        if (resource == null) {
            throw new IllegalArgumentException("File not found!!");
        } else {
            file = new File(resource.toURI());
        }

        DecimalFormat df = new DecimalFormat("#.##");
        String text;

            try {
                tesseract.setDatapath(file.getPath());
                text = tesseract.doOCR(new File("Images\\temp.jpg"));
                System.out.println(text);

                List<String> tmp = Arrays.asList(text.split("\\s+"));

                System.out.println(tmp.get(tmp.indexOf("TOTAL") + 1));

                Receipt receipt = new Receipt();

                receipt.setData(text);
                receipt.setTotal(Double.valueOf(df.format(Double.valueOf(tmp.get(tmp.indexOf("TOTAL") + 1)))));
                receipt.setTaxesPaid(Double.valueOf(df.format(Double.valueOf(tmp.get(tmp.indexOf("TOTAL") + 1)) - Double.valueOf(tmp.get(tmp.indexOf("SUBTOTAL") + 1)))));
                System.out.println(receipt.toString());
                return receipt;

            } catch (TesseractException e) {
                e.printStackTrace();
            }
            return null;
    }


}
