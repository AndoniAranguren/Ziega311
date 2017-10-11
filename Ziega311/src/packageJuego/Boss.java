package packageJuego;


import java.util.ArrayList;
import java.util.Random;


public class Boss extends Etsaiak{
	//atributuak
	private int ahultasunaAldatu;//0ra heltzen denean ahultasuna aldatuko dugu, eta MAIN ean hau random bategas eguneratuko da
	
	//eraikitzaileak
	public Boss(String pIzena,int pMota){
		super (pIzena,pMota);
		this.ahultasunaAldatu=0;
		
	}
	//gainontzeko metodoak
	
	private void sendatu(){
		double zenbatSendatu=0.0;
		Random rnd=new Random();
		int chance; 
		chance=(int)(rnd.nextDouble()*(20-this.getLuck())+0);
		//ausazko balioa 0_(20-luck) tartean
		if (chance<4){
			if(Math.random()<0.95){
				zenbatSendatu=(20+super.getMaxhp()*0.1)*(-1);
				if(zenbatSendatu+super.getHp()>super.getMaxhp()){
					zenbatSendatu=super.getMaxhp()-super.getHp();
				}
				this.hpEguneratu(zenbatSendatu, " ");
				System.out.println("Etsaia "+zenbatSendatu+" sendatu da.");
			}
			else{
				this.bizitzaBete();
				System.out.println("Etsaiak bere bizitza osoa berreskuratu du. Zorte On!");
			}
		}
	}
	public void ahultasunaAldatu(){
		if (this.ahultasunaAldatuBeharra()){
			Random rnd=new Random();
			ArrayList<String> ahultasunak=new ArrayList<String>();
			ahultasunak.add("goi");
			ahultasunak.add("behe");//ahultasunen izenak
			ahultasunak.add("estoke");
			ahultasunak.remove(super.getAhultasuna());
			this.setAhultasuna(ahultasunak.get((int)(rnd.nextDouble()*1+0)));
			//ausaz 0_1 tarteko balio bat, gelditzen diren bi ahultasunetatik bat hautatzeko
					
		}
		
	}
	private boolean ahultasunaAldatuBeharra(){
		//ahultasuna noiz aldatu begiratuko du, MAIN etik ahultasunaAldatu-ri soilik deitu beharko zaio.
		if (this.ahultasunaAldatu==0){
			Random rnd=new Random();
			this.ahultasunaAldatu=(int)(rnd.nextDouble()*4+2);
			return true;
		}
		else{
			this.ahultasunaAldatu--;
			return false;
		}
	}
	
	public double  attack(String pEraso,boolean pLehena){
		double damage=0;
		damage=super.attack(pEraso, pLehena);
		if(pEraso.equals("sendatu")){
			this.sendatu();
		}
		return damage;
		
	}
	
	public String hautatuErasoa(){
		String emaitza=null;
		Random rnd=new Random();
		int hautaketa;
		hautaketa=(int)(rnd.nextDouble()*5+1);
		if(hautaketa<5){
			emaitza=super.hautatuErasoa();
		}
		else {
			emaitza="sendatu";
		}
		return emaitza;
	}
}
