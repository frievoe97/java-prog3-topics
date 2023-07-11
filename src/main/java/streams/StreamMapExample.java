package streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamMapExample {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 80);
        scores.put("Charlie", 70);
        scores.put("David", 85);
        scores.put("Eve", 90);

        // Filter: Behalte Einträge mit Werten größer als 80
        Map<String, Integer> filteredScores = scores.entrySet().stream()
                .filter(entry -> entry.getValue() > 80)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Filtered Scores: " + filteredScores);

        // Distinct: Entferne doppelte Einträge
        Map<String, Integer> distinctScores = scores.entrySet().stream()
                .distinct()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Distinct Scores: " + distinctScores);

        // Map: Quadriere die Werte
        Map<String, Integer> squaredScores = scores.entrySet().stream()
                .map(entry -> new HashMap.SimpleEntry<>(entry.getKey(), entry.getValue() * entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Squared Scores: " + squaredScores);

        // Sorted: Sortiere nach Werten absteigend
        Map<String, Integer> sortedScores = scores.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Sorted Scores: " + sortedScores);

        // Concat: Füge zwei Maps zusammen
        Map<String, Integer> moreScores = new HashMap<>();
        moreScores.put("Frank", 75);
        moreScores.put("Grace", 88);
        Map<String, Integer> concatenatedScores = Stream.concat(scores.entrySet().stream(), moreScores.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Concatenated Scores: " + concatenatedScores);

        // Limit: Begrenze die Anzahl der Einträge
        Map<String, Integer> limitedScores = scores.entrySet().stream()
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Limited Scores: " + limitedScores);

        // forEach: Gib jeden Eintrag aus
        System.out.println("Scores:");
        scores.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // Reduce: Summiere die Werte
        int sum = scores.values().stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        // toList: Konvertiere die Map in eine List von Schlüssel-Wert-Paaren
        Map<String, Integer> convertedMap = scores.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Converted Map: " + convertedMap);

        // anyMatch: Überprüfe, ob mindestens ein Eintrag den Wert 90 hat
        boolean anyMatchNinety = scores.entrySet().stream()
                .anyMatch(entry -> entry.getValue() == 90);
        System.out.println("Any Match Ninety: " + anyMatchNinety);

        // allMatch: Überprüfe, ob alle Einträge den Wert größer als 60 haben
        boolean allMatchSixty = scores.entrySet().stream()
                .allMatch(entry -> entry.getValue() > 60);
        System.out.println("All Match Sixty: " + allMatchSixty);
    }
}

