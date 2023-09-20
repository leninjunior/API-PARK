package com.lenin.demoparkapi.web.exception;


import com.lenin.demoparkapi.exception.UsernameUniqueViolationException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class) // vai ficar escutando esssa exception, toda vez que ela for lançada, vai cair neste método.
    public ResponseEntity<ErrorMessage> methodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                                        HttpServletRequest request,
                                                                        BindingResult result){
        log.error("API ERROR ->", ex);
    return ResponseEntity
            .status(HttpStatus.UNPROCESSABLE_ENTITY)//STATUS ONDE APLICATION NÃO CONSEGUE PROCESSAR O OBJETO QUE FOI ENVIADO.
            .contentType(MediaType.APPLICATION_JSON)
            .body(new ErrorMessage(request, HttpStatus.UNPROCESSABLE_ENTITY, "Campos inválidos", result) );
    }




    @ExceptionHandler(UsernameUniqueViolationException.class) // Quando trabalhar com UNIQUE, É BOM USAR O RUNTIMEEXCEPTION.

    // vai ficar escutando esssa exception, toda vez que ela for lançada, vai cair neste método.
    public ResponseEntity<ErrorMessage> methodArgumentNotValidException(RuntimeException ex,
                                                                        HttpServletRequest request
                                                                       ){
        log.error("API ERROR ->", ex);
        return ResponseEntity
                .status(HttpStatus.CONFLICT)//CONFLITO DE INFORMAÇÕES
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage()) );
    }







}
