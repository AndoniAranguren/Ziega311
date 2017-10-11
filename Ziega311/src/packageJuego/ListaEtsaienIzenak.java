package packageJuego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListaEtsaienIzenak {
	//atributuak
	private ArrayList<String> lista;
	private static ListaEtsaienIzenak nireLista;
	//Eraikitzailea(k)
	private ListaEtsaienIzenak(){
		this.lista=new ArrayList<String>();
	}
	//gainontzeko metodoak
	public static synchronized ListaEtsaienIzenak getNireListaEtsaiak(){
		if(nireLista==null){
			nireLista=new ListaEtsaienIzenak();
		}
		return nireLista;
	}
	public void erreseteatu(){
		nireLista=null;
	}
	
	public void hasieratu() {
		String izena;
		try (BufferedReader fitxategia = new BufferedReader(new FileReader("listak/listaEtsaienIzenak.txt"))){
			Scanner sc = null;
			sc = new Scanner(fitxategia); 
			while (sc.hasNextLine()) {
				izena = sc.nextLine();
				this.lista.add(izena); 
			}
			sc.close();
		} catch (Exception e){
			System.out.println("Arazoren bat suertatu da listaEtsaienIzenak.txt fitxategia erabiltzen saiatzean.");
		}

	}
	public Etsaiak etsaiaAukeratu(){
		int zenb=(int)(Math.random()*this.lista.size());
		Iterator<String> itr=this.lista.iterator();
		int kop=-1;
		String izena=null;
		while(itr.hasNext()&&zenb!=kop){
			 izena=itr.next();
			 kop=kop+1;
		}
		int mota=0;
		if(zenb<=this.lista.size()/3){
			mota=1;
		}
		else if(zenb<=(this.lista.size()*2)/3){
			mota=2;
		}
		else{
			mota=3;
		}
		if(izena==null){
			izena="Ohe azpiko hautsa";
			mota=1;
		}
		
		Etsaiak etsai=new Etsaiak(izena,mota);
		return etsai;
	}
}
