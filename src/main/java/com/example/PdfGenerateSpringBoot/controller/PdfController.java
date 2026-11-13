package com.example.PdfGenerateSpringBoot.controller;

import com.example.PdfGenerateSpringBoot.PdfGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@RestController
@RequestMapping("/api")
public class PdfController {


    @Autowired
    private PdfGenerate pdfGenerate;

    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> pdfGenerate(){

        ByteArrayInputStream generatedPdf = pdfGenerate.generatePdf();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline; filename=file.pdf");

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(generatedPdf));
    }
}
