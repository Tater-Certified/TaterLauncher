package io.github.qpcrummer;

import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRichPresence;

public class DiscordRP {
    private static boolean running = true;
    private static long created = 0;

    public static void start() {
        created = System.currentTimeMillis();

        DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(user -> {
            System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
            update("Starting...", "");
        }).build();

        DiscordRPC.discordInitialize("948043055582302250", handlers, true);
        DiscordRPC.discordRegister("948043055582302250", "");

        new Thread(() -> {
            while (running) {
                DiscordRPC.discordRunCallbacks();
            }
        }).start();
    }

    public static void shutdown() {
        running = false;
        DiscordRPC.discordShutdown();
    }

    public static void update(String firstLine, String secondLine) {
        DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
        b.setBigImage("large", "");
        b.setDetails(firstLine);
        b.setStartTimestamps(created);

        DiscordRPC.discordUpdatePresence(b.build());
    }
}
