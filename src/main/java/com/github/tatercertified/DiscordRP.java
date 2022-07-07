package com.github.tatercertified;

import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRichPresence;

import java.util.concurrent.atomic.AtomicBoolean;

public class DiscordRP {
    static AtomicBoolean running = new AtomicBoolean(false);
    private static long created = 0;

    public static Thread rpcThread;

    private static void run() {
        while (running.get()) {
            DiscordRPC.discordRunCallbacks();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void start() throws Exception {
        if (running.getAndSet(true)) {
            throw new Exception("RPC Thread already running");
        }
        created = System.currentTimeMillis();
        rpcThread = new Thread(DiscordRP::run);
        rpcThread.start();
        running.set(true);

        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(user -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
            update("Starting...", "");
        }).build();

        DiscordRPC.discordInitialize("948043055582302250", handlers, true);
        DiscordRPC.discordRegister("948043055582302250", "");
    }

    public static void shutdown() throws Exception {
        if (running.getAndSet(false)) {
            DiscordRPC.discordClearPresence();
            DiscordRPC.discordShutdown();
            rpcThread.join();
            throw new Exception("RPC Thread already down");
        }
        else
            DiscordRPC.discordClearPresence();
            DiscordRPC.discordShutdown();
            rpcThread.join();
        running.set(false);
    }

    public static void update(String firstLine, String secondLine) {
        DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
        b.setBigImage("large", "");
        b.setDetails(firstLine);
        b.setStartTimestamps(created);

        DiscordRPC.discordUpdatePresence(b.build());
    }
}
