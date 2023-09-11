package com.mkyong.poi.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class WordToPdf {
    public static void main(String[] args) {
        POIFSFileSystem fs = null;
        Document document = new Document();

        try {
            System.out.println("Starting the test");
            fs = new POIFSFileSystem(new FileInputStream("template.docx"));
            HWPFDocument doc = new HWPFDocument(fs);
            WordExtractor we = new WordExtractor(doc);

            OutputStream file = new FileOutputStream(new File("test.pdf"));

            PdfWriter writer = PdfWriter.getInstance(document, file);
        } catch (Exception e) {
            System.out.println("Exception during test");
            e.printStackTrace();
        } finally {
            // close the document
            document.close();
        }
    }
}
