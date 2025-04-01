package br.com.willamessantos.challenge_itau.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionRequest(BigDecimal value, OffsetDateTime dateTime) { }
