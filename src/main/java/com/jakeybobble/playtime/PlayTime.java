package com.jakeybobble.playtime;

import net.fabricmc.api.ModInitializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayTime implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "playtime_count";
    public static final String MOD_NAME = "PlayTime-Fabric";
    
    public static LocalDateTime date_started = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
    
    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing.");
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}