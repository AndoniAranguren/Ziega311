package packageJuego;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public abstract class Pertsonaia {
	//Hasierako balioak klase jokalariaren sorketaren araberakoak izango dira
	//Eguneraketa objektuen arabera erabakiko da
	private double hpMax;
	private double hpCurrent;
	private int speed;
	private int luck;
	private int strength;

	//pozioak
	private int pozioKopurua;
	private final  int pozioKopuruMax=9;
	
	//ekipatutako objektuak aldatzen jungo dira erabiltzaileak erabakita. Bat kentzen bada desagertzen da
	private Objektua arma= new Arma("Adar ziztrin bat",0,0,0,0);
	private Objektua peto= new Peto("Inoiz aldatu ez duzun kamiseta",0,0,0,0);
	private Objektua kasko= new Kasko("Bolatxoak dituen amonaren kapela",0,0,0,0);
	private Objektua galtza= new Galtza("Zulaturiko galtzontxiloak",0,0,0,0);
		
	//Eraikitzailea
	public void pozioaErabili(){
		if (pozioKopurua>0){
			this.hpEguneratu(-100, " ");
			this.pozioKopurua--;
			System.out.println("Pozioa erabili duzu.");
			System.out.println(" ");
		}
		else{
			System.out.println("Zure poltsiko hutsetan pozio bat bilatzen pasa zaizu erasotzeko txanda.");
			System.out.println("Hurrengoan hobe irakurri ezazu.");
		}
	}
	
	//gainontzeko metodoak
	public Boolean hildaDago(){//pertsonaia hil den ala ez esango dio burruka sistemari
		Boolean hilda=false;
		if(this.hpCurrent<0.5){
			hilda=true;
		}
		return hilda;
	}
	
	public void ekipatuObjektuBerria(Objektua pObjektua) {
		char sarrera='8';
		boolean inprimatua=false;
		Objektua pZaharra;
		InputStreamReader teklatua; 
		teklatua=new InputStreamReader(System.in);
		System.out.println("Objektu berria ekipatu nahi duzu? Ekipatuz gero zaharra galduko da.");
		//ikusi behar da zein azpiklasekoa den objektua
		if(pObjektua instanceof Arma){
			//objektuen izenen trantsizioa erakutsi
			//stat-ei gertatuko zaiena erakutsi
			pZaharra=this.arma;
			System.out.println(pZaharra.getIzena()+"---->"+pObjektua.getIzena());
			System.out.println("Bizitza Maximoa: "+String.valueOf(pObjektua.getHp()-pZaharra.getHp()));
			System.out.println("Indarra: "+String.valueOf(pObjektua.getStrength()-pZaharra.getStrength()));
			System.out.println("Abiadura: "+String.valueOf(pObjektua.getSpeed()-pZaharra.getSpeed()));
			System.out.println("Zortea: "+String.valueOf(pObjektua.getLuck()-pZaharra.getLuck()));
		}
		else if(pObjektua instanceof Peto){
			//objektuen izenen trantsizioa erakutsi
			//stat-ei gertatuko zaiena erakutsi
			pZaharra=this.peto;
			System.out.println(pZaharra.getIzena()+"---->"+pObjektua.getIzena());
			System.out.println("Bizitza Maximoa: "+String.valueOf(pObjektua.getHp()-pZaharra.getHp()));
			System.out.println("Indarra: "+String.valueOf(pObjektua.getStrength()-pZaharra.getStrength()));
			System.out.println("Abiadura: "+String.valueOf(pObjektua.getSpeed()-pZaharra.getSpeed()));
			System.out.println("Zortea: "+String.valueOf(pObjektua.getLuck()-pZaharra.getLuck()));
			System.out.println(" ");
		}
		else if(pObjektua instanceof Kasko){
			//objektuen izenen trantsizioa erakutsi
			//stat-ei gertatuko zaiena erakutsi
			pZaharra=this.kasko;
			System.out.println(pZaharra.getIzena()+"---->"+pObjektua.getIzena());
				System.out.println("Bizitza Maximoa: "+String.valueOf(pObjektua.getHp()-pZaharra.getHp()));
			System.out.println("Indarra: "+String.valueOf(pObjektua.getStrength()-pZaharra.getStrength()));
			System.out.println("Abiadura: "+String.valueOf(pObjektua.getSpeed()-pZaharra.getSpeed()));
			System.out.println("Zortea: "+String.valueOf(pObjektua.getLuck()-pZaharra.getLuck()));
			System.out.println(" ");
		}
		else{
			//objektuen izenen trantsizioa erakutsi
			//stat-ei gertatuko zaiena erakutsi
			pZaharra=this.galtza;
			System.out.println(pZaharra.getIzena()+"---->"+pObjektua.getIzena());
			System.out.println("Bizitza Maximoa: "+String.valueOf(pObjektua.getHp()-pZaharra.getHp()));
			System.out.println("Indarra: "+String.valueOf(pObjektua.getStrength()-pZaharra.getStrength()));
			System.out.println("Abiadura: "+String.valueOf(pObjektua.getSpeed()-pZaharra.getSpeed()));
			System.out.println("Zortea: "+String.valueOf(pObjektua.getLuck()-pZaharra.getLuck()));
			System.out.println(" ");
		}
		//erabiltzailearen Input-aren arabera ekipatu edo ez
		System.out.println("Sakatu B aldatzeko edo E aldaketarik ez baduzu nahi.");
		while(sarrera!='b' && sarrera!='B' && sarrera!='e' && sarrera!='E'){//sarrera ona izatera behartzeko
			//honek teklatutik sartzen dena String forman hartzen du ENTER sakatu arte
			try {
				sarrera=(char) teklatua.read();
			} catch (IOException e) {
				System.out.println("Ezin izan da ulertu teklatutik jasotako seinalea.");
			}
			//baldintzak sarrera egokia dela ziurtatzeko
			if(sarrera=='b' || sarrera=='B'){
				this.statObjektuEguneraketa(pZaharra, pObjektua);
				System.out.println(pObjektua.getIzena()+" ekipatu duzu!");
				this.pertsonaiarenEgoeraPantailaratu();
			}
			else if(sarrera=='e' || sarrera=='E'){
				System.out.println("Objektu berria gaitzetsi duzu.");
				this.pertsonaiarenEgoeraPantailaratu();
			}
			else if(!inprimatua){
				inprimatua=true;
				System.out.println("Sar ezazu B edo E!!");
			}
		}
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public void hpBete(){
		this.hpCurrent=this.hpMax;
	}
	
	public void hpEguneratu(double pMina, String pErasoa){
				
		if(pMina!=0.0){
			this.hpCurrent-=pMina;
			if(pMina<0){
				System.out.println((int)(-pMina)+" Bizitza berreskuratu duzu");
			}
			else{
				System.out.println((int)pMina+" ko mina egin dizu!!");
			}
		}
		if (this.hpCurrent<0){
			this.hpCurrent=0.0;
		}
		else if(this.hpCurrent>this.hpMax){
			this.hpCurrent=this.hpMax;
		}
	}
	
	public String hautatuErasoa() {
		//erabiltzaileari eraso aukerak pantailaratuko zaizkio
		//Inputaren bidez metodoaren emaitza erabakiko du
		boolean inprimatua=false;
		InputStreamReader teklatua; 
		teklatua=new InputStreamReader(System.in);
		char sarrera='8';
		String emaitza=" ";
		System.out.println("╔══════════════════════════════════════════════════════════╗"
						+"\n║ Zure akzioa hautatu ezazu:                               ║"
						+"\n║1 Goitik-beherako erasoa.                                 ║"
						+"\n║2 Behetik-gorako erasoa.                                  ║"
						+"\n║3 Estokada batekin eraso.                                 ║"
						+"\n║4 Etsaiaren erasoa sahiestu.                              ║"
						+"\n║5 Etsaia aztertu.                                         ║"
						+"\n║6 Pozioa erabili.      "+this.pozioKopurua+" geratzen zaizkizu.               ║"
						+"\n║Beste edozer sakatu erasoen azalpena ikusteko             ║"
						+"\n╚══════════════════════════════════════════════════════════╝");
		while(sarrera!='1' && sarrera!='2' && sarrera!='2' && sarrera!='3' && sarrera!='4' && sarrera!='5' && sarrera!='6'){
			try {
				sarrera=(char) teklatua.read();
			} catch (IOException e) {
				System.out.println("Ezin izan da ulertu teklatutik jasotako seinalea.");
			}
			if(sarrera=='1'){
				emaitza="goi";
			}
			else if(sarrera=='2'){
				emaitza="behe";
			}
			else if(sarrera=='3'){
				emaitza="estoke";
			}
			else if(sarrera=='4'){
				emaitza="sahies";
			}
			else if(sarrera=='5'){
				emaitza="aztertu";
			}
			else if(sarrera=='6'){
				emaitza="pozioa";
				this.pozioaErabili();
			}
			else if(!inprimatua){
				inprimatua=true;
				this.erasoenDeskribapena();
			}
		}
//		Musika.getMusika().musikaJarraitu();
		return emaitza;
		
	}
	
	private void erasoenDeskribapena() {
		System.out.println("\n[1 Goitik-beherako erasoa]: Eraso hau indartsua baina motela da."
						+"\n[2 Behetik-gorako erasoa]: Eraso honek ez dauka berezitasun handirik, zure abileziak erabakiko du."
						+"\n[3 Estokada]: Estokadak azkarrak dira baina orokorrean ez dute min gehiegirik egingo."
						+"\n[4 Sahiestu]: Etsaiaren erasoa ekiditeko aukera izango duzu hurrengo txandan abiadura plus bat irabaziz"
						+"\n[5 Aztertu]: Ez diozu minik egingo, baina bere egoera ezagutzeko aukera izango duzu.");	
	}
	
	public int getSpeed(){
		return this.speed;
	}
	public int getLuck(){
		return this.luck;
	}
	
	
	private void statObjektuEguneraketa(Objektua pZaharra, Objektua pBerria){
		this.hpMax=this.hpMax -pZaharra.getHp() +pBerria.getHp();
		if(this.hpCurrent>this.hpMax){
			this.hpCurrent=this.hpMax;
		}
		this.strength=this.strength-pZaharra.getStrength()+pBerria.getStrength();
		this.luck=this.luck-pZaharra.getLuck()+pBerria.getLuck();
		this.speed=this.speed-pZaharra.getSpeed()+pBerria.getSpeed();
		if (pZaharra instanceof Arma){
			this.setArma(pBerria);
		}
		else if(pZaharra instanceof Peto){
			this.setPetoa(pBerria);
		}
		else if(pZaharra instanceof Kasko){
			this.setKaskoa(pBerria);
		}
		else{this.setGaltza(pBerria);
		}
	}
	
	private void setArma(Objektua pArma){
		this.arma=pArma;
	}
	
	private void setPetoa(Objektua pPetoa){
		this.peto=pPetoa;
	}
	
	private void setKaskoa(Objektua pKaskoa){
		this.kasko=pKaskoa;
	}
	
	private void setGaltza(Objektua pGaltza){
		this.galtza=pGaltza;
	}
	
	public void pertsonaiarenEgoeraPantailaratu(){
		//honek zenbakia string-ean bihurtzen dute
		String bizi=String.valueOf((int)hpCurrent);
		String biziMax=String.valueOf((int)hpMax);
		String abiadura=String.valueOf(speed);
		String zortea=String.valueOf(luck);
		String indarra=String.valueOf(strength);
		//pentsatu dut hola jartzea politago geratzeko, totxolinea batean agertu beharrean
		System.out.println("Zure heroiaren egoera: ");
		System.out.println("Bizitza Maximoa: "+bizi+'/'+biziMax);
		System.out.println("Indarra: "+indarra);
		System.out.println("Abiadura: "+abiadura);
		System.out.println("Zortea: "+zortea);
		System.out.println(" ");
	}
	
	
	public double attack(String pEraso,boolean lehena){
		
		Random rnd=new Random();
		double damage=0;
		double damMod=1;
		if (rnd.nextInt(this.luck)!=0){
			damMod=(rnd.nextDouble()+this.luck/100);//dado motako randoma, zortea kontuan hartuz min ezberdinak hautatzeko
			if(damMod<0.5){//mina txikiegia ez izateko dadoaren eraginez
				damMod=0.5;
			} else if(damMod > 1){
				damMod = 1;
			}
			if(!lehena){//erasoa egiten lehena ez bada izan minak penalizazioa jasango du
				damMod*=0.75;
			}
			if (pEraso=="estoke"){
				damMod*=0.8;
				damage=this.strength*damMod;
			}
			else if(pEraso=="behe"){
				damage=this.strength*damMod;
			}
			else if(pEraso=="goi"){
				damMod*=1.3;
				damage=this.strength*damMod;
			}
			else if (pEraso=="sahies"){
				System.out.println("Txanda honetan etsaia sahiesten saiatu zara.");
				System.out.println(" ");
			}
			else if(pEraso=="aztertu"){
				System.out.println("Etsaia aztertzen saiatu zara.");
				System.out.println(" ");
			}
		}
		else {
			System.out.println("Zure erasoak huts egin du.");
			System.out.println(" ");
		}

		return damage;
	}
		
	public void printBizitza(){
		System.out.println("\nBizitza: " +(int)this.hpCurrent);
		System.out.print("■▬▌");
	    double vidaJugBarra=0.0;
		while(vidaJugBarra<=this.hpMax)
		{
			if(vidaJugBarra<=this.hpCurrent)
			{
			System.out.print("▓");
			}
			else
			{ 
				System.out.print("░");
			}
			vidaJugBarra=vidaJugBarra+10;
		}							
		System.out.print(" ►");
    
		System.out.println();
	}
	
	public void pozioaGehitu(){
		if(pozioKopurua+1<=pozioKopuruMax){
			pozioKopurua++;
		}
		else{
			System.out.println("Ezin duzu pozio gehiago eraman.");
		}
		System.out.println(pozioKopurua + " Pozio dituzu.");
		System.out.println();
	}

	protected double getHpMax() {
		return hpMax;
	}

	protected void setHpMax(double hpMax) {
		this.hpMax = hpMax;
	}

	protected void setHpCurrent(double hpCurrent) {
		this.hpCurrent = hpCurrent;
	}

	protected int getStrength() {
		return strength;
	}

	protected void setStrength(int strength) {
		this.strength = strength;
	}

	protected void setPozioKopurua(int pozioKopurua) {
		this.pozioKopurua = pozioKopurua;
	}

	protected Objektua getPeto() {
		return peto;
	}

	protected void setPeto(Objektua peto) {
		this.peto = peto;
	}

	protected Objektua getKasko() {
		return kasko;
	}

	protected void setKasko(Objektua kasko) {
		this.kasko = kasko;
	}

	protected Objektua getArma() {
		return arma;
	}

	protected Objektua getGaltza() {
		return galtza;
	}

	protected void setSpeed(int speed) {
		this.speed = speed;
	}

	protected void setLuck(int luck) {
		this.luck = luck;
	}

	protected double getHpCurrent() {
		return hpCurrent;
	}
	
	

}


