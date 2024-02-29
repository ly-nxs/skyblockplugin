package com.lynx.skyblocktp;

import java.util.HashMap;
import java.util.Map;

// here's how you do this:
// Cooldown.getCooldowns() = get a list of all players and when their cooldown expires
// Cooldown.inCooldown(playerName) = check if a player is in cooldown
// Cooldown.addToCooldown(playerName, time) = add a player to cooldown, time is seconds to keep in cooldown

public class Cooldown {
    private static Map<String, Long> cooldowns = new HashMap<>();

    public static Map<String, Long> getCooldowns() {
        return cooldowns;
    }

    public static boolean inCooldown(String playerName) {
        if (cooldowns.containsKey(playerName)) {
            if (cooldowns.get(playerName) > System.currentTimeMillis()) {
                return true;
            } else {
                cooldowns.remove(playerName);
                return false;
            }
        } else {
            return false;
        }
    }

    // time has to be in seconds
    public static void addToCooldown(String playerName, long time) {
        cooldowns.put(playerName, System.currentTimeMillis() + (24 * 60 * 60 * time));
    }
}
