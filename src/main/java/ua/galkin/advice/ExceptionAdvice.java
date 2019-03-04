package ua.galkin.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.galkin.dto.ErrorMessageDto;
import ua.galkin.exceptions.UserAlreadyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(UserAlreadyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageDto handleConstraintValidationException(
            HttpServletRequest request,
            UserAlreadyException ex) {

        return ErrorMessageDto.builder()
                .status(HttpServletResponse.SC_BAD_REQUEST)
                .requestUrl(request.getRequestURI())
                .message(ex.getMessage())
                .build();
    }

}
