package ua.org.fits.server.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.fits.entity.error.ErrorInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.PatternSyntaxException;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(PatternSyntaxException.class)
    @ResponseBody
    ResponseEntity<ErrorInfo> handleRegexExeption(HttpServletRequest req, PatternSyntaxException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorInfo(req.getRequestURI(), "regex is not true"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    ResponseEntity<ErrorInfo> handleillegalStateExeption(HttpServletRequest req, IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorInfo(req.getRequestURI(), ex.getLocalizedMessage()));
    }
}
