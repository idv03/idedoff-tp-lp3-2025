package py.edu.uc.lp3_2025.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import py.edu.uc.lp3_2025.dto.ErrorResponseDto;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDto> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        ErrorResponseDto errorDto = new ErrorResponseDto();
        errorDto.setTimestamp(LocalDateTime.now());
        errorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDto.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorDto.setMessage(ex.getMessage());
        errorDto.setPath(request.getDescription(false).substring(4)); // Remueve "uri="

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}