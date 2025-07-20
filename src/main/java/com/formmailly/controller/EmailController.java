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

    /**
     * Handles the submission of a contact form and attempts to send an HTML email using the provided form data.
     * @example
     * ResponseEntity<?> response = EmailController.handleForm(sampleForm);
     * System.out.println(response.getBody()); // Expected output {message: "Message sent successfully!"} or {message: "Error sending email", error: "Detailed error message"}
     * @param {ContactFormDTO} form - The contact form data submitted by the user, containing necessary information for sending the email.
     * @return {ResponseEntity<?>} - Returns a ResponseEntity containing a success message or error information.
     * @description
     *   - Executes emailService.sendHtmlEmail(form) to send the email.
     *   - The email sending operation might throw exceptions, which are caught and logged.
     *   - Returns HTTP status 500 on failure with error details.
     *   - The method is mapped to POST requests.
     */
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
