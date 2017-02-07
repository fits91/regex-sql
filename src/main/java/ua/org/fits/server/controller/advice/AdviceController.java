package ua.org.fits.server.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.org.fits.entity.error.ErrorInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.PatternSyntaxException;

@RestController
@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(PatternSyntaxException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorInfo handleRegexExeption(HttpServletRequest req, PatternSyntaxException ex) {
        return new ErrorInfo(req.getRequestURI(), "regex is not true");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorInfo handleillegalStateExeption(HttpServletRequest req, IllegalArgumentException ex) {
        return new ErrorInfo(req.getRequestURI(), ex.getLocalizedMessage());
    }
}
