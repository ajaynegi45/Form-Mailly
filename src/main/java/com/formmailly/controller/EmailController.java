package com.formmailly.controller;

import com.formmailly.dto.ContactFormDTO;
import com.formmailly.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin("*")
public class EmailController {

    private final EmailService emailService;
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public String check() {
        return "Warning: This endpoint is not intended for public access. Unauthorized usage will be logged.";
    }

    @PostMapping
    public ResponseEntity<?> handleForm(@RequestBody ContactFormDTO form) {
        try {
            emailService.sendHtmlEmail(form);
            return ResponseEntity.ok(Map.of("message", "Message sent successfully!"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of(
                    "message", "Error sending email",
                    "error", e.getMessage()
            ));
        }
    }
}
