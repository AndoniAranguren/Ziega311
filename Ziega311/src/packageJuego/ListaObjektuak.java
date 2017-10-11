package packageJuego;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaObjektuak {
	//atributuak
	private ArrayList<Objektua> lista;
	private static ListaObjektuak nireLista;
	//Eraikitzailea(k)
	private ListaObjektuak(){
		this.lista=new ArrayList<Objektua>();
	}
	//gainontzeko metodoak
	public static synchronized ListaObjektuak getNireListaObjektuak(){
		if(nireLista==null){
			nireLista=new ListaObjektuak();
		}
		return nireLista;
	}
	public void erreseteatu(){
		nireLista=null;
	}
	
	public void hasieratu() {
		String mota,izena,hpS,strengthS,luckS,speedS;
		int hpI,strengthI,luckI,speedI;
		try (BufferedReader fitxategia = new BufferedReader(new FileReader("listak/listaObjektuak.txt"))){
			Scanner sc = null;
			sc = new Scanner(fitxategia); 
			while (sc.hasNextLine()){
				mota = sc.nextLine();
				izena = sc.nextLine();
				hpS = sc.nextLine();
				strengthS = sc.nextLine();
				luckS = sc.nextLine();
				speedS=sc.nextLine();
				hpI=Integer.parseInt(hpS);
				strengthI=Integer.parseInt(strengthS);
				luckI=Integer.parseInt(luckS);
				speedI=Integer.parseInt(speedS);
				//System.out.println(mota);
				if(mota.equals("Arma")){
					Arma objektua;
					objektua=new Arma(izena,hpI,strengthI,luckI,speedI);
					this.lista.add(objektua);
				}	
				else if(mota.equals("Galtza")){
					Galtza objektua;
					objektua=new Galtza(izena,hpI,strengthI,luckI,speedI);
					this.lista.add(objektua);
				}	
				else if(mota.equals("Kasko")){
					Kasko objektua;
					objektua=new Kasko(izena,hpI,strengthI,luckI,speedI);
					this.lista.add(objektua);
				}	
				else{
					Peto objektua;
					objektua=new Peto(izena,hpI,strengthI,luckI,speedI);
					this.lista.add(objektua);
				}
			}
			sc.close();
		} catch (Exception e){
			System.out.println("Arazoren bat suertatu da listaObjektuak.txt fitxategia erabiltzen saiatzean.");
		}
			

	}
	public Objektua objektuNormalaEman() {
		int zenb=(int)(Math.random()*(this.lista.size()/2+Jokalaria.getJokalaria().getLuck()/6)+Ziega.getNireZiega().getPisua());
		Objektua obj;
		try{
			obj=this.lista.get(zenb);
		}catch(Exception e){
			zenb=this.lista.size()-1;
			obj=this.lista.get(zenb);
		}
		return obj;
	}
	public Objektua objektuBereziaEman() {
		int zenb=(int)(Math.random()*this.lista.size()/3+Ziega.getNireZiega().getPisua()+this.lista.size()/2+Jokalaria.getJokalaria().getLuck()/6);
		Objektua obj;
		try{
			obj=this.lista.get(zenb);
		}catch(Exception e){
			zenb=this.lista.size()-1;
			obj=this.lista.get(zenb);
		}
		return obj;
	}
}
