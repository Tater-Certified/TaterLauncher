package com.github.tatercertified;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class DiscordRP {
    private static final AtomicBoolean running = new AtomicBoolean(false);
    private static long created;
    private static ScheduledExecutorService rpcThreadPool;

    public static void start() throws Exception {
        if (running.getAndSet(true)) {
            throw new Exception("RPC Thread already running");
        }

        created = System.currentTimeMillis();

        // Initialize DiscordRPC
        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(user -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
            update("Starting...", "");
        }).build();

        DiscordRPC.discordInitialize("948043055582302250", handlers, true);
        DiscordRPC.discordRegister("948043055582302250", "");

        // Create a new scheduled executor service
        rpcThreadPool = Executors.newScheduledThreadPool(1);
        rpcThreadPool.scheduleAtFixedRate(DiscordRPC::discordRunCallbacks, 0, 5, TimeUnit.SECONDS);
    }

    public static void shutdown() throws Exception {
        if (!running.getAndSet(false)) {
            throw new Exception("RPC Thread already down");
        } else {
            DiscordRPC.discordClearPresence();
            DiscordRPC.discordShutdown();
            rpcThreadPool.shutdownNow();
        }
    }

    public static void update(String firstLine, String secondLine) {
        DiscordRichPresence presence = new DiscordRichPresence.Builder(secondLine)
                .setBigImage("large", "")
                .setDetails(firstLine)
                .setStartTimestamps(created)
                .build();

        DiscordRPC.discordUpdatePresence(presence);
    }
}