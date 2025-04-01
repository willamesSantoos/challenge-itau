package br.com.willamessantos.challenge_itau.service;

import br.com.willamessantos.challenge_itau.dto.StatisticResponse;
import br.com.willamessantos.challenge_itau.dto.TransactionRequest;
import br.com.willamessantos.challenge_itau.core.models.Transaction;
import br.com.willamessantos.challenge_itau.service.validators.TransactionValidator;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class TransactionService {

    private final List<Transaction> transactions;
    private final TransactionValidator validator;

    public TransactionService(List<Transaction> transactions, TransactionValidator validator) {
        this.transactions = transactions;
        this.validator = validator;
    }

    public void create(TransactionRequest request) {
        validator.validate(request);

        Transaction transaction = new Transaction(request.value(), OffsetDateTime.now());
        transactions.add(transaction);
    }

    public void delete() {
        transactions.clear();
    }

    public StatisticResponse viewStatistic () {
        DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
        transactions.stream()
                .filter(transaction ->
                        transaction.getDateTime().toInstant().isAfter(Instant.now().minusSeconds(60))
                )
                .forEach(transaction -> doubleSummaryStatistics.accept(transaction.getValue().doubleValue()));

        return new StatisticResponse(
                (int) doubleSummaryStatistics.getCount(),
                doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getAverage(),
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getMax()
        );
    }
}
