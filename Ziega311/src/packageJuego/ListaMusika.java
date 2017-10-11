package packageJuego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListaMusika {
	//atributuak
	private ArrayList<String> lista;
	private static ListaMusika nireLista;
	//Eraikitzailea(k)
	private ListaMusika(){
		this.lista=new ArrayList<String>();
	}
	//gainontzeko metodoak
	public static synchronized ListaMusika getNireListaMusika(){
		if(nireLista==null){
			nireLista=new ListaMusika();
		}
		return nireLista;
	}
	public void erreseteatu(){
		nireLista=null;
	}
	
	public void hasieratu() {
		String helbidea;
		try (BufferedReader fitxategia = new BufferedReader(new FileReader("listak/listaMusika.txt"))){
			Scanner sc = null;
			sc = new Scanner(fitxategia); 
			while (sc.hasNextLine()) {
				helbidea = sc.nextLine();
				this.lista.add(helbidea);
			// en el while creamos todas las preguntas hasta que no haya mas lineas
			}
			sc.close(); //cerramos el fitxero
		} catch (Exception e){
			System.out.println("Arazoren bat suertatu da listaMusika.txt fitxategia erabiltzen saiatzean.");
		}

	}
	public String helbideaAukeratu(){
		int mota=(int)(Math.random()*this.lista.size());
		Iterator<String> itr=this.lista.iterator();
		int kop=-1;
		String helbidea=null;
		while(itr.hasNext()&&mota!=kop){
			 helbidea=itr.next();
			 kop=kop+1;
		}
		if(helbidea==null){
			helbidea="musika/Utopia.mp3";
		}
		return helbidea;
	}
}
