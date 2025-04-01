package br.com.willamessantos.challenge_itau.service.validators;

import br.com.willamessantos.challenge_itau.dto.TransactionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import java.time.OffsetDateTime;

@Component
public class TransactionValidator implements Validator<TransactionRequest> {

    @Override
    public void validate(TransactionRequest request)  {
        if(request.value() == null || request.dateTime() == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "It is necessary to inform the amount and date to carry out the transaction.");
        }

        if(request.value().doubleValue() < 0 ) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "The transaction cannot have a value less than zero");
        }

        if(request.dateTime().isAfter(OffsetDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "The transaction date cannot be in the future");
        }
    }
}
