import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Die mögliche Auswahl bei Schere-Stein-Papier
 * @author Doro
 *
 */
enum Auswahl
{
	SCHERE, STEIN, PAPIER;
}

/**
 * Das Schere-Stein-Papier-Spiel
 * @author Doro
 *
 */
public class SchereSteinPapier {
	/**
	 * Die Auswahlen der Mitspieler
	 */
	private Auswahl[] gewaehlt = new Auswahl[2];
	
	/**
	 * ein Mitspieler
	 * @author Doro
	 *
	 */
	private class Spieler implements Runnable
	{
		private int nr;
		/**
		 * erstellt einen Spieler
		 * @param nr Spielernummer (0 oder 1)
		 */
		public Spieler(int nr)
		{
			this.nr = nr;
		}
		
		/**
		 * trifft eine Zufallsauswahl
		 * @return die getroffene Auswahl
		 */
		public Auswahl waehlen()
		{
			Random r = new Random();
			return Auswahl.values()[r.nextInt(3)];
		}

		@Override
		public void run() {
			try {
				synchronized(SchereSteinPapier.this)
				{
					SchereSteinPapier.this.wait();
				}
			} catch (InterruptedException e) {}
			Auswahl a = waehlen();
			gewaehlt[nr] = a;
		}
	}
	
	/**
	 * Der Signalgeber; bei seinem Startsignal geht es los
	 * @author Doro
	 *
	 */
	private class Signalgeber implements Runnable
	{

		@Override
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			synchronized(SchereSteinPapier.this)
			{
				SchereSteinPapier.this.notifyAll();	
			}
		}
		
	}
	
	/**
	 * ermittelt die Spielernummer des Gewinners,
	 * @return 0 oder 1
	 */
	public int gewinnerErmitteln()
	{
		return gewaehlt[0].compareTo(gewaehlt[1])>0? 0:1;
	}
	
	/**
	* startet das eigentliche Spiel
	*/
	public void spielStarten()
	{
		Spieler hans = new Spieler(0);
		Spieler otto = new Spieler(1);
		Thread t1 = new Thread(hans);
		Thread t2 = new Thread(otto);
		t1.start();
		t2.start();
		Signalgeber signal = new Signalgeber();
		Thread s = new Thread(signal);
		s.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {}
		int gewinner = gewinnerErmitteln();
		System.out.println(gewinner==0?"Hans":"Otto");
	}
	
	/**
	 * startet das Spiel
	 * @param args wird nicht verwendet
	 */
	public static void main(String[] args) {
		SchereSteinPapier ssp = new SchereSteinPapier();
		for(int i=0; i< 100; i++)
		{
			ssp.spielStarten();
		}
	}
}

