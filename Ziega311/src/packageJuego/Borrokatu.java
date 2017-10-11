package packageJuego;

import java.util.Random;

public class Borrokatu {//KOPIA PEGA EGITEKO MAIN-ean
	//atributuak
	private boolean pSahies=false;
	private boolean eSahies=false;

	//eraikitzaileak
	public Borrokatu(){
	
	}
	//gainontzeko metodoak

	public void kutxaZabaldu(Boolean pKutxa,int pLvl) {
		//pertsonaia kutxa baten gainean dagoen dioen boolean. borroka mapan bertan ematen bada ez da beharko, baina pixkat aldatuko da.
		if (pKutxa){
			Random rnd=new Random();
			if ((int)(rnd.nextDouble()*4+0)==0){
				System.out.println("Kutxa barruan etsai bat zegoen!!");
				
				this.borrokatuEtsaia(pLvl);
			}
			else{
				Objektua objektua=ListaObjektuak.getNireListaObjektuak().objektuBereziaEman();//objektu onak hautatzeko probabilitate handiagoa izateko
				Jokalaria.getJokalaria().ekipatuObjektuBerria(objektua);
			}
		}
	}
	

	
	private void borrokatuEtsaia(int pLvl) {
		//ziegan boss dagoen ala ez dioen boolean
		//bossen haurka borrokatu behar bada bossek daukan ahultasunaAldatu metodoa erabili beharko da turno bakoitzeko
		Etsaiak etsaia=ListaEtsaienIzenak.getNireListaEtsaiak().etsaiaAukeratu();
		etsaia.levelUp(Ziega.getNireZiega().getPisua());
		etsaia.bizitzaBete();
		String pEraso;
		String eEraso;
		boolean eLehena;
		boolean pLehena;

		Jokalaria jokalaria=Jokalaria.getJokalaria();
		 
		while (!etsaia.hildaDago()&&!jokalaria.hildaDago()){
			this.eSahies=false;
			this.pSahies=false;
			eLehena=false;
			pLehena=false;
			pEraso=jokalaria.hautatuErasoa();
			eEraso=etsaia.hautatuErasoa();
			//nor hasiko den erabakitzeko
			
			if(etsaia.getSpeed()*this.speedBonifikazioa(eSahies, eEraso)  >  jokalaria.getSpeed()*this.speedBonifikazioa(pSahies, pEraso)){
				eLehena=true;
				this.etsaiakEraso(pLehena, eLehena, pEraso, eEraso, etsaia, jokalaria);
				Jokalaria.getJokalaria().printBizitza();
			}
			else{
				pLehena=true;
				this.jokalariakEraso(pLehena, eLehena, pEraso, eEraso, etsaia, jokalaria);
				Jokalaria.getJokalaria().printBizitza();
			}
		}
		if(etsaia.hildaDago()){
			Ziega.getNireZiega().gehituEtsaia();
		}
		
		this.borrokaAmaituDa(etsaia, jokalaria);
	}	
	

	private void borrokatuBoss(int pLvl) {//bossari izena kendu diot
		Boss boss=ListaBoss.getNireListaBoss().bossAukeratu();
		boss.levelUp(pLvl);
		boss.bizitzaBete();
		String pEraso;
		String eEraso;
		boolean eLehena;
		boolean pLehena;

		Jokalaria jokalaria=Jokalaria.getJokalaria();

		while (!boss.hildaDago()&&!jokalaria.hildaDago()){
			this.eSahies=false;
			this.pSahies=false;
			eLehena=false;
			pLehena=false;
			pEraso=jokalaria.hautatuErasoa();
			eEraso=boss.hautatuErasoa();
			//nor hasiko den erabakitzeko
			boss.ahultasunaAldatu();
			//EZ DUT BEGIRATU ETSAIAKeRASO ZER EGITEN DUEN ORAIN, BOSSEAN GAUZA BATZUK ALDATU OSTEAN(sendatuko da??sendatzen denean joko gaitu??
			if(boss.getSpeed()*this.speedBonifikazioa(eSahies, eEraso)  >  jokalaria.getSpeed()*this.speedBonifikazioa(pSahies, pEraso)){
				eLehena=true;
				this.etsaiakEraso(pLehena, eLehena, pEraso, eEraso, boss, jokalaria);
				Jokalaria.getJokalaria().printBizitza();
			}
			else{
				pLehena=true;
				this.jokalariakEraso(pLehena, eLehena, pEraso, eEraso, boss, jokalaria);
				Jokalaria.getJokalaria().printBizitza();
			}
		}
		if(boss.hildaDago()){
			Ziega.getNireZiega().gehituBoss();
		}
	
		this.borrokaAmaituDa(boss, jokalaria);
	}	

	
	
	public void borrokatu(boolean bossDa,int pLvl) {
		if(bossDa){
			this.borrokatuBoss(pLvl);
		}
		else{
			this.borrokatuEtsaia(pLvl);
		}
	}
	
	private double speedBonifikazioa(boolean pSahies, String pEraso){
		double speed=0;
		if (pEraso=="estoke"){
			speed=1.5;
		}
		else if(pEraso=="behe"){
			speed=1;
		}
		else{
			speed=0.5;
		}
		if(pSahies){
			speed+=2;
		}
		return speed;
	}
	
	
	private void jokalariakEraso(boolean pLehena, boolean eLehena, String pEraso, String eEraso, Etsaiak etsaia, Jokalaria jokalaria){
		if (eEraso=="sahies"){
			eSahies=true;
			if (Math.random()>0.5){
				etsaia.hpEguneratu(jokalaria.attack(pEraso,pLehena), pEraso);
			}
			else{
				System.out.println("Etsaiak zure erasoa sahiestu du!");
			}
		}
		else{
			etsaia.hpEguneratu(jokalaria.attack(pEraso,pLehena), pEraso);
			if (!etsaia.hildaDago()){
				if (pEraso=="sahies"){
					pSahies=true;
					if (Math.random()>0.5){
						jokalaria.hpEguneratu(etsaia.attack(eEraso,eLehena), eEraso);
					}
					else{
						System.out.println("Erasoa sahiestu duzu!");
					}
				}
				else{
					jokalaria.hpEguneratu(etsaia.attack(eEraso,eLehena), eEraso);
				}
			}
		}
	}
	
	
	private void etsaiakEraso(boolean pLehena, boolean eLehena, String pEraso, String eEraso, Etsaiak etsaia, Jokalaria jokalaria){
		if (pEraso=="sahies"){
			pSahies=true;
			if (Math.random()>(0.5+jokalaria.getLuck()/200)){
				jokalaria.hpEguneratu(etsaia.attack(eEraso,eLehena), eEraso);
			}
			else{
				System.out.println("Erasoa sahiestu duzu!");
			}
		}		
		else if (pEraso=="aztertu"){
			if (Math.random()>(0.5-jokalaria.getLuck()/200)){
				etsaia.inprimatu();
			}
			jokalaria.hpEguneratu(etsaia.attack(eEraso,eLehena), eEraso);
		}
		else{
			jokalaria.hpEguneratu(etsaia.attack(eEraso,eLehena), eEraso);
			if (!jokalaria.hildaDago()){
				if (eEraso=="sahies"){
					eSahies=true;
					if (Math.random()>0.5){
						etsaia.hpEguneratu(jokalaria.attack(pEraso,pLehena), pEraso);
					}
					else{
						System.out.println("Etsaiak zure erasoa sahiestu du!");
					}
				}
				else{
					etsaia.hpEguneratu(jokalaria.attack(pEraso,pLehena), pEraso);
				}
			}
		}
	}

	
	private void borrokaAmaituDa(Etsaiak etsaia, Jokalaria jokalaria) {
		Objektua objektua=null;
		if (etsaia.hildaDago()){
			if (etsaia instanceof Boss){
				objektua=ListaObjektuak.getNireListaObjektuak().objektuBereziaEman();
			}
			else{
				objektua=ListaObjektuak.getNireListaObjektuak().objektuNormalaEman();
			}
			String objIzena=objektua.getIzena();
			System.out.println("Borroka irabazi duzu! Eta "+objIzena+" aurkitu duzu!");
			jokalaria.ekipatuObjektuBerria(objektua);
			if(Math.random()>0.1){
				jokalaria.pozioaGehitu();
			}
		}
		else{
			System.out.println("Etsai hau benetan gogorra izan da eta ezin izan duzu irabazi bere aurka... ");
			jokalaria.pertsonaiarenEgoeraPantailaratu();
			System.out.println("Hauexek izan da zure heroiak izandako azkeneko stat-ak.");
		}
	}
	
}
