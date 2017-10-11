package packageJuego;

import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
public class Jokalaria {

	private Pertsonaia pertsonaia;
	
	//Jokalaria(estatikoa)
	private static Jokalaria jokalaria=null;
	
	//Eraikitzailea
	private Jokalaria(){
		this.hasieratu();
	}
	
	public static Jokalaria getJokalaria() {
		if(Jokalaria.jokalaria==null){
			Jokalaria.jokalaria = new Jokalaria();
		}
		return Jokalaria.jokalaria;
	}
	
	public void pozioaErabili(){
		pertsonaia.pozioaErabili();
	}
	
	private void hasieratu() {
		boolean inprimatua=false;
		InputStreamReader teklatua; 
		teklatua=new InputStreamReader(System.in);
		char sarrera='9';
		System.out.println( "───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────"
						+ "\n Behin batean, egun ahaztu dugun lurralde boteretsu, oparoa eta disdiratsu bat zegoen. Baina lurralde haren errege-erreginak"
						+ "\n botere gehiago nahi zuten eta azti baten laguntza bilatu. Honek haien erresuma garaitezina bihurtu zezakela ziurtatu zien,"
						+ "\n heuren gerlariak  heuren gazteluen harriak bezain gogorrak eta harri hauek bezain iraunkorrak bihurtuko zituela."
						+ "\n Aztiak errege-erreginak birritan pentsatu gabe haren eskuetan jarriko zirela zekien, hain handia zen beren botere egarria."
						+ "\n Inork ez ziola aurrerik egingo argi izan zuenean erresuma hartako biztanleen arimak lapurtu zituen inungo grinik gabeko "
						+ "\n gorputzak lagaz. Eta honela iraungo du norbaitek aztiaren lana desegin arte."
						+ "\n──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println(	    "                _  _  _  _  _                        _  _  _  _  _"
							+ "\n               | || || || || |   JavaDavaDungeonI   | || || || || |"
							+ "\n               |`' `' `' `'.|                       |`' `' `' `'. |"
							+ "\n               :          .:;                       :          .:;"
							+ "\n               '-..____..:/  _  _  _  _  _  _  _    |-..____..:/"
							+ "\n               :--------:_,' || || || || || || || `.::--------:"
							+ "\n               |]     .:|:.  `' `'_`' `' `' `' `'   | '-'  .:|"
							+ "\n               |  ,-. .[|:._     '-'____     ___    |   ,-.'-|"
							+ "\n               |  | | .:|'--'_    ,'____`.  '---'   |   | |.:|"
							+ "\n               |  |_| .:|:.'--' (),| | | |()     __ |   |_|.:|"
							+ "\n               |  '=' .:|:.      ||:_|_|_|||    '--'|  _'='.:|"
							+ "\n               | __   .:|:.      ||-,-,-,-||        | '--' .:|"
							+ "\n               |'--'  .:|:. _    ||       ||        |      .:|"
							+ "\n               |      .:|:.'-'   ||       ||     _  |]     _:|"
							+ "\n               |      '-|:.      ||       ||    '-' |     '--|"
							+ "\n               |  _   .:|].      ||       ||        |   _  .:|"
							+ "\n               | '-'  .:|:.      ||       ||        |  '-' .:|");

		System.out.println("\n ╔════════════════════════════════════════════════════════════════╗"
						 + "\n ║Zure arraza hautatu behar duzu abenturari ekin baino lehen.     ║"
						 + "\n ║Hurrengoetako bat hautatu beharko duzu:                         ║"
						 + "\n ║1 Sakatu gizakia izateko.                                       ║"
						 + "\n ║2 Sakatu orkoa izateko.                                         ║"
						 + "\n ║3 Sakatu gnomoa izateko.                                        ║"
						 + "\n ║4 Sakatu elfoa izateko.                                         ║"
						 + "\n ║Beste edozer sakatu arraza bakoitzaren xehetasunak ezagutzeko.  ║"
						 + "\n ╚════════════════════════════════════════════════════════════════╝");
		while(sarrera!='1' && sarrera!='2' && sarrera!='3' && sarrera!='4'){
			
			try {
				sarrera = (char) teklatua.read();
			} catch (IOException e) {
				System.out.println("Ezin izan da ulertu teklatutik jasotako seinalea.");
			}
			
			if(sarrera=='1'){
				this.pertsonaia = new Gizakia();
			}
			else if(sarrera=='2'){
				this.pertsonaia = new Orkoa();
			}
			else if(sarrera=='3'){
				this.pertsonaia = new Gnomoa();
			}
			else if(sarrera=='4'){
				this.pertsonaia = new Elfoa();
			}
			else if(!inprimatua){
				inprimatua=true;
				System.out.println(	    "                                  .-'`-."
									+ "\n                                 | | |  |"
									+ "\n                                |  | |   |"
									+ "\n                               |___|_|__  |"
									+ "\n                               ||<o>| <o>`|"
									+ "\n                               ||   J_   )|"
									+ "\n                               `|`-'__`-'|"
									+ "\n                                |  `--'  |"
									+ "\n                              .-|        |_"
									+ "\n                          .-'  |        | | |`-."
									+ "\n                        .-'      `.     /| |    |"
									+ "\n                       |          ````' | |     |"
									+ "\n                      |_____             | |     L"
									+ "\n                   .-' ___   `-.         F F  |  |"
									+ "\n                 .'.-'   |  `-.  `.      J J   | |"
									+ "\n                // |     |    |`.  |     / /   |||"
									+ "\n               //  |     |    |  `. `.  F F   |  |"
									+ "\n              J |  |     |    |    |  LJ J    |  |"
									+ "\n              FJ   |     |    |    |L J||    |   |"
									+ "\n             J |() | ()  | () | () | J L|     |   |"
									+ "\n             | F   |   _  |   |    |  LJ       | | L"
									+ "\n             | L   | /   '|   |    |  | L      |    |");
				System.out.println("\n [1 Gizakiak] Egoeretara moldatzeko gaitasun handia dute. "
								+  "\n Behetik zein goitik defendatu abilezia defendatu daitezke baina haragi bigunekoak dira, erraz zulatu daitekeen haragia."
								+  "\n\n [2 Orkoak] Gogorrak dira, altuak eta oso indartsuak, etsaiak lurraren kontra zanpatzea maite dute. "
								+  "\n Ala ere motelak dira eta gerlari azkar batek orkoen altuerak sorturiko ahultasunak erabili ahal izango ditu."
								+  "\n\n [3 Gnomoak] gelditu gabe arineketan ibiltzen dira. "
								+  "\n Beren gorputz txikiek ez diete defentsa askorik eskaintzen baina istorioen arabera beren zorte handiari ezker ez dute horren behar handirik."
								+  "\n\n [4 Elfoak] inguruko gerlaririk arinenak dira, dantzan egongo balira bezala burrukatuz."
								+  "\n Horren ondorioz era harroputzean aritzen dira gudan, begiak lurrera eraman gabe, heriotza lurretik etorri daitekeela ahaztu balute bezala.");
			}
		}
	}
	//gainontzeko metodoak
	public Boolean hildaDago(){
		
		return pertsonaia.hildaDago();
	}
	
	public void ekipatuObjektuBerria(Objektua pObjektua) {
		pertsonaia.ekipatuObjektuBerria(pObjektua);
	}
	
	public void hpBete(){
		pertsonaia.hpBete();
	}
	
	public void hpEguneratu(double pMina, String pErasoa){
		pertsonaia.hpEguneratu(pMina, pErasoa);
	}

	public String hautatuErasoa() {
	
		return pertsonaia.hautatuErasoa();
	}
		
	public int getSpeed(){
		return pertsonaia.getSpeed();
	}
	
	public int getLuck(){
		return pertsonaia.getLuck();
	}
	
	public void pertsonaiarenEgoeraPantailaratu(){
		pertsonaia.pertsonaiarenEgoeraPantailaratu();
	}
	
	
	public double attack(String pEraso,boolean lehena){
		return pertsonaia.attack(pEraso, lehena);
	}
	
	public static void reset(){
		Jokalaria.jokalaria=null;
	}
	
	public void printBizitza(){
		pertsonaia.printBizitza();
	}
	
	public void pozioaGehitu(){
		pertsonaia.pozioaGehitu();
	}
}
