package br.com.datawake.datawakeapi.resource.exception;

import br.com.datawake.datawakeapi.exceptionhandler.exception.ApiException;
import org.springframework.http.HttpStatus;

public class PutIdFromParameterIsDifferentFromBody extends ApiException {
    public PutIdFromParameterIsDifferentFromBody() {
        super(
                HttpStatus.NOT_ACCEPTABLE,
                "Id from route is different from the id from body. Cannot change object's id on PUT.",
                "Id enviado é diferente do id no corpo da requisição."
        );
    }
}
