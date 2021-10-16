package assignments.one;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

public class ClockWall {
    private interface Clock {
        String getTime();
    }

    private static String twelveHRtime(LocalTime city) {
        int hour = city.getHour();
        int min = city.getMinute();
        return hour > 12 ? hour - 12 + ":" + min + " PM" : hour + ":" + min + " AM";
    }

    public static void main(String[] args) {
        Map<String, Clock> clockMap24h = new HashMap<>();
        Map<String, Clock> clockMap12h = new HashMap<>();
        
        LocalTime rochester = LocalTime.now(ZoneOffset.UTC.ofHours(-4));
        clockMap24h.put("Rochester", () -> rochester.getHour() + ":" + rochester.getMinute());
        clockMap12h.put("Rochester", () -> twelveHRtime(rochester));

        LocalTime sanFran = LocalTime.now(ZoneOffset.UTC.ofHours(-7));
        clockMap24h.put("San Fransico", () -> sanFran.getHour() + ":" + sanFran.getMinute());
        clockMap12h.put("San Fransico", () -> twelveHRtime(sanFran));

        
        LocalTime houston = LocalTime.now(ZoneOffset.UTC.ofHours(-5));
        clockMap24h.put("Houston", () -> houston.getHour() + ":" + houston.getMinute());
        clockMap12h.put("Houston", () -> twelveHRtime(houston));

        
        LocalTime timbuktu = LocalTime.now(ZoneOffset.UTC.ofHours(0));
        clockMap24h.put("Timbuktu", () -> timbuktu.getHour() + ":" + timbuktu.getMinute());
        clockMap12h.put("Timbuktu", () -> twelveHRtime(timbuktu));

        System.out.println("24 hour time: ");
        for (String key : clockMap24h.keySet()) {
            System.out.println("  " + key + " - " + clockMap24h.get(key).getTime());
        }

        System.out.println();

        System.out.println("12 hour time: ");
        for (String key : clockMap12h.keySet()) {
            System.out.println("  " + key + " - " + clockMap12h.get(key).getTime());
        }
    }
}
