package io.github.qpcrummer;

import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRichPresence;

import java.util.concurrent.atomic.AtomicBoolean;

public class DiscordRP {
    static AtomicBoolean running = new AtomicBoolean(false);
    private static long created = 0;

    public static Thread rpcThread = new Thread(DiscordRP::run);

    private static void run() {
        while (running.get()) {
            DiscordRPC.discordRunCallbacks();
        }
    }

    public static void start() {
        if (running.getAndSet(true)) {
            throw new IllegalStateException("RPC Thread already running");
        }
        created = System.currentTimeMillis();
        rpcThread = new Thread(DiscordRP::run);
        rpcThread.start();

        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(user -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
            update("Starting...", "");
        }).build();

        DiscordRPC.discordInitialize("948043055582302250", handlers, true);
        DiscordRPC.discordRegister("948043055582302250", "");
    }

    public static void shutdown() throws InterruptedException {
        if (!running.getAndSet(false)) {
            throw new IllegalStateException("RPC Thread already down");
        }
            running.set(false);
            DiscordRPC.discordClearPresence();
            DiscordRPC.discordShutdown();
            rpcThread.join();
    }

    public static void update(String firstLine, String secondLine) {
        DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
        b.setBigImage("large", "");
        b.setDetails(firstLine);
        b.setStartTimestamps(created);

        DiscordRPC.discordUpdatePresence(b.build());
    }
}
