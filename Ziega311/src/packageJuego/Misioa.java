package packageJuego;

import java.util.Random;

public class Misioa {
	//atributuak
	private int kontBoss=0;
	private int kontPisua=0;
	private int kontEtsaia=0;
	private String txt;
	//Eraikitzailea(k)
	public Misioa(){
		int mota=1+(int)(Math.random()*3);
		Random  rnd = new Random();
		if(mota==1){
			this.kontBoss=2+ (int)(rnd.nextInt(1)); //2-3 artean
			txt=			 (    "   _____________________________________"
								+ "\n  ⌠Zure misioa "+this.kontBoss+" etsai nagusi hiltzea da│"
								+ "\n  │_____________________________________⌡");
		}
		else if(mota==2){
			this.kontEtsaia=5+ (int)(rnd.nextInt(4)); //6-10 artean
			txt=			 (    "   _______________________________"
								+ "\n  ⌠Zure misioa "+this.kontEtsaia+" etsai hiltzea da│"
								+ "\n  │______________________________⌡");
		}
		else{
			this.kontPisua=2+ (int)(rnd.nextInt(1)); //2-3 artean
			txt=			 (    "   ______________________________________"
								+ "\n  ⌠Zure misioa "+this.kontPisua+" garren pisura heltzea da│"
								+ "\n  │______________________________________⌡");
		}
		System.out.println();
	}
	//gainontzeko metodoak
	public boolean misioaEginda(int pKontBoss,int pKontEtsaia,int pKontPisua){
		if(pKontBoss>=this.kontBoss&&pKontEtsaia>=this.kontEtsaia&&pKontPisua>=this.kontPisua){
			return true;
		}
		else{
			return false;
		}
	}
	public void misioaInprimatu()
	{
		System.out.println(txt);
	}
}
