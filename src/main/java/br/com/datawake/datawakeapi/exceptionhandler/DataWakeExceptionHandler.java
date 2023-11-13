package br.com.datawake.datawakeapi.exceptionhandler;

import br.com.datawake.datawakeapi.exceptionhandler.exception.ApiException;
import br.com.datawake.datawakeapi.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class DataWakeExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String messageUser = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
        String messageDeveloper = ex.getCause().toString();

        List<Error> erros = Arrays.asList(new Error(messageUser, messageDeveloper));

        return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Error> erros = criarListaDeErros(ex.getBindingResult());
        return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ UserNotFoundException.class })
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        String messageUser = messageSource.getMessage("user.not.found", null, LocaleContextHolder.getLocale());
        String messageDeveloper = ex.toString();
        List<Error> erros = Arrays.asList(new Error(messageUser, messageDeveloper));
        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({WebClientRequestException.class})
    public ResponseEntity<?> WebClientException(WebClientRequestException ex, WebRequest request) {
        String messageUser = "Não foi possível completar a requisição, parte do serviço está offline";
        String messageDeveloper = ex.toString();
        List<Error> erros = Arrays.asList(new Error(messageUser, messageDeveloper));
        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    private List<Error> criarListaDeErros(BindingResult bindingResult) {

        List<Error> erros = new ArrayList<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String messageUser = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            String messageDeveloper = fieldError.toString();
            erros.add(new Error(messageUser, messageDeveloper));
        }

        return erros;
    }

    @ExceptionHandler({ ApiException.class })
    public ResponseEntity<?> handleApiException(ApiException ex, WebRequest request) {
        String messageUser = ex.getUserMessage();
        String messageDeveloper = ex.toString();

        Error error = new Error(messageUser, messageDeveloper);

        return handleExceptionInternal(ex, error, HttpHeaders.EMPTY, HttpStatus.NOT_ACCEPTABLE, request);
    }

    public static class Error {

        private final String messageUser;
        private final String messageDeveloper;

        public Error(String messageUser, String messageDeveloper) {
            super();
            this.messageUser = messageUser;
            this.messageDeveloper = messageDeveloper;
        }

        public String getMessageUser() {
            return messageUser;
        }

        public String getMessageDeveloper() {
            return messageDeveloper;
        }

    }

}