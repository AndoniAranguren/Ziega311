package packageJuego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListaBoss {
	//atributuak
	private ArrayList<String> lista;
	private static ListaBoss nireLista;
	//Eraikitzailea(k)
	private ListaBoss(){
		this.lista=new ArrayList<String>();
	}
	//gainontzeko metodoak
	public static synchronized ListaBoss getNireListaBoss(){
		if(nireLista==null){
			nireLista=new ListaBoss();
		}
		return nireLista;
	}
	public void erreseteatu(){
		nireLista=null;
	}
	
	public void hasieratu() {
		String izena;
		try (BufferedReader fitxategia = new BufferedReader(new FileReader("listak/listaBoss.txt"))){
			Scanner sc = null;
			sc = new Scanner(fitxategia); 
		
			while (sc.hasNextLine()) {
				izena = sc.nextLine();
				this.lista.add(izena);
			 // en el while creamos todas las preguntas hasta que no haya mas lineas
			}
			sc.close(); //cerramos el fitxero
		} catch (Exception e) {
			System.out.println("Arazoren bat suertatu da listaBoss.txt fitxategia erabiltzen saiatzean.");
		}

	}
	public Boss bossAukeratu(){
		int zenb=(int)(Math.random()*this.lista.size());
		Iterator<String> itr=this.lista.iterator();
		int kop=-1;
		String izena=null;
		while(itr.hasNext()&&zenb!=kop){
			 izena=itr.next();
			 kop=kop+1;
		}
		if(izena==null){
			izena="JUnita";
		}
		
		Boss boss=new Boss(izena,4);
		return boss;
	}
}
