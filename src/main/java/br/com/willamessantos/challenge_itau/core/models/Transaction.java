package br.com.willamessantos.challenge_itau.core.models;



import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Transaction {
    BigDecimal value;
    OffsetDateTime dateTime;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Transaction(BigDecimal value, OffsetDateTime dateTime) {
        this.value = value;
        this.dateTime = dateTime;
    }
}
