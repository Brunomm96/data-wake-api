package br.com.datawake.datawakeapi.resource.exception;

import br.com.datawake.datawakeapi.exceptionhandler.exception.ApiException;
import org.springframework.http.HttpStatus;

public class PageSizeOutOfBoundsException extends ApiException {
    public PageSizeOutOfBoundsException() {
        super(
                HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE,
                "Page size is out of bounds, choose a different value.",
                "Índice da página é maior que o tamanho total da mesma."
        );
    }
}
