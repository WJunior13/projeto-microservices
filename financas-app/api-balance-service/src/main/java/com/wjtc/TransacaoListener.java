package com.wjtc;

import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransacaoListener {

    private final Balancos balancos;

    @Autowired
    public TransacaoListener(Balancos balancos) {
        this.balancos = balancos;
    }
    @RabbitListener(queues = "transactions")
    public void receiveTransaction(byte[] jsonInBytes) {
        final var gson = new Gson();
        final var transaction = gson.fromJson(new String(jsonInBytes), Transacao.class);
        System.out.println("Receiving message: " + transaction.toString());
        var balanceOptional = balancos.findByAccountId(transaction.getContaId());
        if (balanceOptional.isPresent()) {
            final var balance = balanceOptional.get();
            balance.setValor(transaction.isIncome() ?
                    balance.getValor() + transaction.getValor() :
                    balance.getValor() - transaction.getValor()
            );
            balance.setTransacaoId(transaction.getId());
            System.out.println("Storing balance: " + balance.toString());
            balancos.save(balance);
        } else {
            final var factor = transaction.isIncome() ? 1 : -1;
            final var balance = new Balanco(transaction.getId(), transaction.getContaId(), transaction.getValor() * factor);
            System.out.println("Storing balance: " + balance.toString());
            balancos.save(balance);
        }
    }
}
