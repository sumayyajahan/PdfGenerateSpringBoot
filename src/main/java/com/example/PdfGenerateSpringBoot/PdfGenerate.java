package com.example.PdfGenerateSpringBoot;

import org.openpdf.text.*;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfGenerate {

    public ByteArrayInputStream generatePdf(){

        String title = "Spring Boot Pdf Generation";
        String summary = "Yes! It's started to work.";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document d = new Document();
        PdfWriter.getInstance(d, out);

        d.open();
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15);
        Paragraph p = new Paragraph(title, titleFont);
        p.setAlignment(Element.ALIGN_CENTER);
        d.add(p);

        Font sumF = FontFactory.getFont(FontFactory.COURIER_OBLIQUE, 20);
        Paragraph sumP = new Paragraph(summary, sumF);
        sumP.setAlignment(Element.ALIGN_CENTER);
        d.add(sumP);

        d.close();

        return new ByteArrayInputStream(out.toByteArray());
    }
}
