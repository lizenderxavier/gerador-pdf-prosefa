package com.prosefaguias.gerador_pdfs.controller;

import com.prosefaguias.gerador_pdfs.service.PdfService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
@RequestMapping("/guias")
public class GuiaController {

    private final PdfService pdfService;
    private final TemplateEngine templateEngine;

    public GuiaController(PdfService pdfService, TemplateEngine templateEngine) {
        this.pdfService = pdfService;
        this.templateEngine = templateEngine;
    }

    @GetMapping("/baixar")
    public ResponseEntity<byte[]> baixarGuia() throws Exception {
        // 1. Processa o HTML estático
        String html = templateEngine.process("guia", new Context());

        // 2. Converte para PDF
        byte[] pdfBytes = pdfService.gerarPdfDeHtml(html);

        // 3. Prepara o download
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=guia-prosefa.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}