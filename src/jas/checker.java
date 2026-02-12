package jas;
import java.util.*;



public class checker {
    private HashMap<String, Integer> users = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();
    private int userId = 1;

    public void register(String username) {
        users.put(username, userId++);
    }

    public boolean checkAvailability(String username) {
        if (attempts.containsKey(username)) {
            attempts.put(username, attempts.get(username) + 1);
        } else {
            attempts.put(username, 1);
        }

        if (users.containsKey(username)) {
            return false;
        }

        return true;
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            String newName = username + i;
            if (!users.containsKey(newName)) {
                suggestions.add(newName);
            }
        }

        return suggestions;
    }

    public String getMostAttempted() {
        String result = "";
        int max = 0;

        for (String name : attempts.keySet()) {
            if (attempts.get(name) > max) {
                max = attempts.get(name);
                result = name;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        checker system = new checker();

        system.register("john_doe");
        system.register("admin");

        System.out.println(system.checkAvailability("john_doe"));
        System.out.println(system.checkAvailability("jane_smith"));
        System.out.println(system.suggestAlternatives("john_doe"));
        System.out.println(system.getMostAttempted());
    }
}

