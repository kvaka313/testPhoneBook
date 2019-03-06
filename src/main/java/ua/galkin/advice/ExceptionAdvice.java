package ua.galkin.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.galkin.dto.ErrorMessageDto;
import ua.galkin.exceptions.NullLoginException;
import ua.galkin.exceptions.RecordNotFoundException;
import ua.galkin.exceptions.UserAlreadyException;
import ua.galkin.exceptions.UserNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({UserAlreadyException.class, NullLoginException.class, UserNotFoundException.class, RecordNotFoundException.class, NumberFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageDto handleConstraintValidationException(
            HttpServletRequest request,
            RuntimeException ex) {

        return ErrorMessageDto.builder()
                .status(HttpServletResponse.SC_BAD_REQUEST)
                .requestUrl(request.getRequestURI())
                .message(ex.getMessage())
                .build();
    }
}
