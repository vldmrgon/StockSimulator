package com.naya.simulator;

import com.naya.simulator.service.Simulator;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartApplication {
    private static int DELAY = 20;

    @SneakyThrows
    public static void main(String[] args) {

        final List<String> listTickets = new ArrayList<>();
        listTickets.add("msft");
        listTickets.add("pfe");
        listTickets.add("pep");
        listTickets.add("orcl");
        listTickets.add("hpq");
        listTickets.add("dis");
        listTickets.add("aapl");
        listTickets.add("googl");
        listTickets.add("wmt");
        listTickets.add("intc");

        final ExecutorService threadPool = Executors.newCachedThreadPool();

        for (String ticket : listTickets) {
            threadPool.execute(() -> {
                new Simulator().start(ticket, DELAY);
            });
        }
    }
}
