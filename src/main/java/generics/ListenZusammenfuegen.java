package generics;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Übung zu Bounds
 * @author Doro
 */
public class ListenZusammenfuegen {
	
	/**
	 * fügt l1 und l2 zu einer neuen gemeinsamen List zusammen
	 * @param l1
	 * @param l2
	 * @return die neue gemeinsame Liste aus l1 und l2
	 */
	public static <T> List<T> zusammenfuegen(List<? extends T> l1, List<? extends T> l2)
	{
		List<T> newlist = Stream.concat(l1.stream(), l2.stream()).collect(Collectors.toList());
		return newlist;
	}

	/**
	 * fügt zwei Listen zusammen
	 * @param args wird nicht gebraucht
	 */
	public static void main(String[] args) {
		List<LocalDate> eins = List.of(LocalDate.now(), LocalDate.of(1990,1,1));
		List<LocalDate> zwei = List.of(LocalDate.of(2000,4,5), LocalDate.of(2023,12,24));
		List<LocalDate>	drei = zusammenfuegen(eins, zwei);
		List<Temporal> vier = zusammenfuegen(eins, zwei);		

		List<Integer> ganzeZahlen = new LinkedList<>();
		ganzeZahlen.add(1);
		ganzeZahlen.add(2);
		ganzeZahlen.add(3);
		
		List<Double> kommaZahlen = new LinkedList<>();
		kommaZahlen.add(1.1);
		kommaZahlen.add(2.2);
		kommaZahlen.add(3.3);
		
		List<Number> zusammen;
		zusammen = zusammenfuegen(ganzeZahlen, kommaZahlen);

		//Das sollte nicht gehen:
		//List<String> z1 = zusammenfuegen(ganzeZahlen, kommaZahlen);
		//List<Integer> z2 = zusammenfuegen(ganzeZahlen, kommaZahlen);
		//List<Double> z3 = zusammenfuegen(ganzeZahlen, kommaZahlen);
	}
}
