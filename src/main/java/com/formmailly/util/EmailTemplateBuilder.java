package com.formmailly.util;
import org.springframework.stereotype.Component;

@Component
public class EmailTemplateBuilder {

    /**
     * Builds an HTML email template with the provided sender details and message content.
     * @example
     * String emailTemplate = EmailTemplateBuilder.buildEmail("John Doe", "john.doe@example.com", "Inquiry", "Hello, I have a question about...");
     * System.out.println(emailTemplate); // Expected output: A formatted HTML email template with provided details.
     * @param {String} senderName - Name of the sender.
     * @param {String} senderEmail - Email address of the sender.
     * @param {String} senderReason - Reason for contacting.
     * @param {String} messageContent - Content of the message.
     * @return {String} - A HTML string formatted as an email template.
     * @description
     *   - Generates an email template with consistent styling using inline CSS.
     *   - Ensures the template is responsive by using table formatting.
     *   - Includes a section for sender details and message within the template.
     *   - Suitable for rendering within an email client without external dependencies.
     */
    public String buildEmail(String senderName, String senderEmail, String senderReason, String messageContent) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif; font-size:16px; margin:0; color:#0b0c0c; background-color:#ffffff\">\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +

                "<table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "  <tr>\n" +
                "    <td bgcolor=\"#0b0c0c\">\n" +
                "      <table role=\"presentation\" align=\"center\" width=\"100%\" style=\"max-width:580px; border-collapse:collapse;\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "        <tr>\n" +
                "          <td style=\"padding: 20px 10px;\">\n" +
                "            <span style=\"font-size:28px; font-weight:700; color:#ffffff;\">Contact Form Submission</span>\n" +
                "          </td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +

                "<table role=\"presentation\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"max-width:580px; width:100%!important;\">\n" +
                "  <tr>\n" +
                "    <td>\n" +
                "      <table width=\"100%\" style=\"border-collapse:collapse\">\n" +
                "        <tr>\n" +
                "          <td bgcolor=\"#1D70B8\" height=\"10\"></td>\n" +
                "        </tr>\n" +
                "      </table>\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>\n" +

                "<table role=\"presentation\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"max-width:580px; width:100%!important;\">\n" +
                "  <tr><td height=\"30\"></td></tr>\n" +
                "  <tr>\n" +
                "    <td style=\"font-size:19px; line-height:1.4; color:#0b0c0c;\">\n" +
                "      <p><strong>Name:</strong> " + senderName + "</p>\n" +
                "      <p><strong>Email:</strong> " + senderEmail + "</p>\n" +
                "      <p><strong>Reason:</strong> " + senderReason + "</p>\n" +
                "      <p><strong>Message: </strong>"+ messageContent + "</p>\n" +
                "      <br>\n" +
                "      <p>Best regards,<br><strong>Ajay Negi</strong></p>\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  <tr><td height=\"30\"></td></tr>\n" +
                "</table>\n" +
                "</div>";
    }
}
