package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 5, 3, 2, 7, 1, 9, 4, 5, 8);

        // Filter: Nur die Zahlen größer als 4 behalten
        List<Integer> filteredNumbers = numbers.stream()
                .filter(n -> n > 4)
                .toList();
        System.out.println("Filtered Numbers: " + filteredNumbers);

        // Distinct: Entfernt doppelte Werte
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println("Distinct Numbers: " + distinctNumbers);

        // Map: Quadriere jede Zahl
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .toList();
        System.out.println("Squared Numbers: " + squaredNumbers);

        // Sorted: Sortiere die Zahlen aufsteigend
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();
        System.out.println("Sorted Numbers: " + sortedNumbers);

        // Concat: Verbinde zwei Streams
        List<Integer> moreNumbers = Arrays.asList(10, 11, 12);
        List<Integer> concatenatedNumbers = Stream.concat(numbers.stream(), moreNumbers.stream())
                .toList();
        System.out.println("Concatenated Numbers: " + concatenatedNumbers);

        // Limit: Begrenze die Anzahl der Elemente
        List<Integer> limitedNumbers = numbers.stream()
                .limit(5)
                .toList();
        System.out.println("Limited Numbers: " + limitedNumbers);

        // forEach: Gib jedes Element aus
        System.out.print("Numbers: ");
        numbers.stream()
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Reduce: Summiere die Zahlen
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        // toList: Konvertiere Stream in List
        List<Integer> convertedList = numbers.stream()
                .toList();
        System.out.println("Converted List: " + convertedList);

        // anyMatch: Überprüfe, ob mindestens ein Element größer als 10 ist
        boolean anyMatchGreaterThanTen = numbers.stream()
                .anyMatch(n -> n > 10);
        System.out.println("Any Match Greater Than Ten: " + anyMatchGreaterThanTen);

        // allMatch: Überprüfe, ob alle Elemente kleiner als 100 sind
        boolean allMatchLessThanHundred = numbers.stream()
                .allMatch(n -> n < 100);
        System.out.println("All Match Less Than Hundred: " + allMatchLessThanHundred);

        List<Integer> result = numbers.stream()
                .filter(n -> n > 2)                             // Filter: Behalte nur Zahlen größer als 2
                .distinct()                                     // Distinct: Entferne doppelte Werte
                .map(n -> n * 2)                                // Map: Verdopple jede Zahl
                .sorted()                                       // Sorted: Sortiere aufsteigend
                .limit(4)                               // Limit: Begrenze auf 4 Elemente
                .toList();                                      // Sammle in eine List

        System.out.println("Result: " + result);

        String result2 = numbers.stream()
                .filter(n -> n > 2)                             // Filter: Behalte nur Zahlen größer als 2
                .distinct()                                     // Distinct: Entferne doppelte Werte
                .map(n -> n * 2)                                // Map: Verdopple jede Zahl
                .sorted()                                       // Sorted: Sortiere aufsteigend
                .limit(4)                               // Limit: Begrenze auf 4 Elemente
                .map(Object::toString)                          // Map: Konvertiere jede Zahl zu einem String
                .collect(Collectors.joining(", "));     // Sammle als String mit Trennzeichen

        System.out.println("Result: " + result2);
    }
}

