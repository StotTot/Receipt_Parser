package dev.debride.receiptparser.service;

import dev.debride.receiptparser.models.Receipt;
import dev.debride.receiptparser.repos.ReceiptRepo;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import java.net.URISyntaxException;
import java.net.URL;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Component
@Service
public class ParseServiceImpl implements ParseService{

    @Autowired
    ReceiptRepo receiptRepo;

    private static Pattern DATE_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{2}$");

    public Receipt parse(String filePath) throws URISyntaxException, IOException {
        File file;
        Tesseract tesseract = new Tesseract();
        URL url = new URL(filePath);
        FileUtils.copyURLToFile(url, new File("images/temp.jpg"));

        DecimalFormat df = new DecimalFormat("#.##");
        String text;
        String date = null;

            try {
                tesseract.setDatapath("traineddata");
                text = tesseract.doOCR(new File("images/temp.jpg"));
                System.out.println(text);

                List<String> tmp = Arrays.asList(text.split("\\s+"));

                System.out.println(tmp.get(tmp.indexOf("TOTAL") + 1));

                Receipt receipt = new Receipt();

                receipt.setData(text);
                receipt.setTotal(Double.valueOf(df.format(Double.valueOf(tmp.get(tmp.indexOf("TOTAL") + 1)))));
                receipt.setTaxesPaid(Double.valueOf(df.format(Double.valueOf(tmp.get(tmp.indexOf("TOTAL") + 1)) - Double.valueOf(tmp.get(tmp.indexOf("SUBTOTAL") + 1)))));
                receipt.setUrl(filePath);



                for (int i = tmp.size() - 1; i > 0; i-- ) {
                    if (DATE_PATTERN.matcher(tmp.get(i)).matches()) {
                        date = tmp.get(i);
                        break;
                    }
                    date = "N/A";
                }
                
                receipt.setDate(date);

                receipt = receiptRepo.save(receipt);
                System.out.println(receipt.toString());
                return receipt;

            } catch (TesseractException e) {
                e.printStackTrace();
            }
            return null;
    }


}
