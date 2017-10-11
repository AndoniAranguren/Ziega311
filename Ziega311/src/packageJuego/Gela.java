package packageJuego;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Gela {
	//atributuak
	private int gela, pisua,etsaiKop,turnoKont;
	private Koordenatuak koor;
	private Mapa mapaGela;
	boolean lehenengoGela;
	

	
	private char azkenekoMug='W';
	Random  rnd = new Random();
    InputStreamReader cin = new InputStreamReader(System.in);;
	
	//eraikitzailea

	public Gela()
	{
		gela=1;
		pisua=0;
		lehenengoGela=true;
		sortuGelaBerria(false,false);
	}
//	metodoak
	public void jokatu() 
	{
		
        while(!Jokalaria.getJokalaria().hildaDago()&&!Ziega.getNireZiega().eginda()){
        	boolean teklaOkerra = true;	
        	this.konprobatuPos();
			
			mapaGela.printMapa(koor,gela,pisua);
	        
			cin = new InputStreamReader(System.in); 
			System.out.println(" ►Sakatu zure aukera 'WASD'◄");
			printEtsaiak();
			while(teklaOkerra){
				try {
					azkenekoMug = Character.toUpperCase((char) cin.read());
					teklaOkerra = false;
				} catch (IOException e) {
					System.out.println(" ►Sakatu zure aukera 'WASD'◄");
				}
			}
			
			while(mugitu(azkenekoMug))
			{
				teklaOkerra = true;
				cin = new InputStreamReader(System.in); 
				System.out.println(" ►Saihatu berriro◄");
				while(teklaOkerra){
					try {
						azkenekoMug =Character.toUpperCase((char) cin.read());
						teklaOkerra = false;
					} catch (IOException e) {
						System.out.println(" ►Sakatu zure aukera 'WASD'◄");
					}
				}
			}
//			Musika.getMusika().musikaJarraitu();
				
        }
        if(Ziega.getNireZiega().eginda()){
        		
        	System.out.println("ZORIONAAAAK!!!Zure misioa bete duzu :D");
        }
        else{
        	System.out.println("Hil zara   :("
				+"\n                .....'',;;::cccllllllllllllcccc:::;;,,,''...'',,'.."
				+"\n                ..';cldkO00KXNNNNXXXKK000OOkkkkkxxxxxddoooddddddxxxxkkkkOO0XXKx:."
				+"\n          .':ok0KXXXNXK0kxolc:;;,,,,,,,,,,,;;,,,''''''',,''..              .'lOXKd'"
				+"\n     .,lx00Oxl:,'............''''''...................    ...,;;'.             .oKXd."
				+"\n  .ckKKkc'...'',:::;,'.........'',;;::::;,'..........'',;;;,'.. .';;'.           'kNKc."
				+"\n.:kXXk:.    ..       ..................          .............,:c:'...;:'.         .dNNx."
				+"\n:0NKd,          .....''',,,,''..               ',...........',,,'',,::,...,,.        .dNNx."
				+"\n.xXd.         .:;'..         ..,'             .;,.               ...,,'';;'. ...       .oNNo"
				+"\n.0K.         .;.              ;'              ';                      .'...'.           .oXX:"
				+"\n.oNO.         .                 ,.              .     ..',::ccc:;,..     ..                lXX:"
				+"\n.dNX:               ......       ;.                'cxOKK0OXWWWWWWWNX0kc.                    :KXd."
				+"\n.l0N0;             ;d0KKKKKXK0ko:...              .l0X0xc,...lXWWWWWWWWKO0Kx'                   ,ONKo."
				+"\n.lKNKl...'......'. .dXWN0kkk0NWWWWWN0o.            :KN0;.  .,cokXWWNNNNWNKkxONK: .,:c:.      .';;;;:lk0XXx;"
				+"\n:KN0l';ll:'.         .,:lodxxkO00KXNWWWX000k.       oXNx;:okKX0kdl:::;'',;coxkkd, ...'. ...'''.......',:lxKO:."
				+"\noNNk,;c,'',.                      ...;xNNOc,.         ,d0X0xc,.     .dOd,           ..;dOKXK00000Ox:.   ..''dKO,"
				+"\n'KW0,:,.,:..,oxkkkdl;'.                'KK'              ..           .dXX0o:'....,:oOXNN0d;.'. ..,lOKd.   .. ;KXl."
				+"\n;XNd,;  ;. l00kxoooxKXKx:..ld:         ;KK'                             .:dkO000000Okxl;.   c0;      :KK;   .  ;XXc"
				+"\n'XXdc.  :. ..    '' 'kNNNKKKk,      .,dKNO.                                   ....       .'c0NO'      :X0.  ,.  xN0."
				+"\n.kNOc'  ,.      .00. ..''...      .l0X0d;.             'dOkxo;...                    .;okKXK0KNXx;.   .0X:  ,.  lNX'"
				+"\n,KKdl  .c,    .dNK,            .;xXWKc.                .;:coOXO,,'.......       .,lx0XXOo;...oNWNXKk:.'KX;  '   dNX."
				+"\n:XXkc'....  .dNWXl        .';l0NXNKl.          ,lxkkkxo' .cK0.          ..;lx0XNX0xc.     ,0Nx'.','.kXo  .,  ,KNx."
				+"\ncXXd,,;:, .oXWNNKo'    .'..  .'.'dKk;        .cooollox;.xXXl     ..,cdOKXXX00NXc.      'oKWK'     ;k:  .l. ,0Nk."
				+"\ncXNx.  . ,KWX0NNNXOl'.           .o0Ooldk;            .:c;.':lxOKKK0xo:,.. ;XX:   .,lOXWWXd.      . .':,.lKXd."
				+"\nlXNo    cXWWWXooNWNXKko;'..       .lk0x;       ...,:ldk0KXNNOo:,..       ,OWNOxO0KXXNWNO,        ....'l0Xk,"
				+"\n.dNK.   oNWWNo.cXK;;oOXNNXK0kxdolllllooooddxk00KKKK0kdoc:c0No        .'ckXWWWNXkc,;kNKl.          .,kXXk,"
				+"\n'KXc  .dNWWX;.xNk.  .kNO::lodxkOXWN0OkxdlcxNKl,..        oN0'..,:ox0XNWWNNWXo.  ,ONO'           .o0Xk;"
				+"\n.ONo    oNWWN0xXWK, .oNKc       .ONx.      ;X0.          .:XNKKNNWWWWNKkl;kNk. .cKXo.           .ON0;"
				+"\n.xNd   cNWWWWWWWWKOkKNXxl:,'...;0Xo'.....'lXK;...',:lxk0KNWWWWNNKOd:..   lXKclON0:            .xNk."
				+"\n.dXd   ;XWWWWWWWWWWWWWWWWWWNNNNNWWNNNNNNNNNWWNNNNNNWWWWWNXKNNk;..        .dNWWXd.             cXO."
				+"\n.xXo   .ONWNWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNNK0ko:'..OXo          'l0NXx,              :KK,"
				+"\n.OXc    :XNk0NWXKNWWWWWWWWWWWWWWWWWWWWWNNNX00NNx:'..       lXKc.     'lONN0l.              .oXK:"
				+"\n.KX;    .dNKoON0;lXNkcld0NXo::cd0NNO:;,,'.. .0Xc            lXXo..'l0NNKd,.              .c0Nk,"
				+"\n:XK.     .xNX0NKc.cXXl  ;KXl    .dN0.       .0No            .xNXOKNXOo,.               .l0Xk;."
				+"\n.dXk.      .lKWN0d::OWK;  lXXc    .OX:       .ONx.     . .,cdk0XNXOd;.   .'''....;c:'..;xKXx,"
				+"\n.0No         .:dOKNNNWNKOxkXWXo:,,;ONk;,,,,,;c0NXOxxkO0XXNXKOdc,.  ..;::,...;lol;..:xKXOl."
				+"\n,XX:             ..';cldxkOO0KKKXXXXXXXXXXKKKKK00Okxdol:;'..   .';::,..':llc,..'lkKXkc."
				+"\n:NX'    .     ''            ..................             .,;:;,',;ccc;'..'lkKX0d;."
				+"\nlNK.   .;      ,lc,.         ................        ..,,;;;;;;:::,....,lkKX0d:."
				+"\n.oN0.    .'.      .;ccc;,'....              ....'',;;;;;;;;;;'..   .;oOXX0d:."
				+"\n.dN0.      .;;,..       ....                ..''''''''....     .:dOKKko;."
				+"\nlNK'         ..,;::;;,'.........................           .;d0X0kc'."
				+"\n.xXO'                                                 .;oOK0x:."
				+"\n.cKKo.                                    .,:oxkkkxk0K0xc'."
				+"\n.oKKkc,.                         .';cok0XNNNX0Oxoc,."
				+"\n.;d0XX0kdlc:;,,,',,,;;:clodkO0KK0Okdl:,'.."
				+"\n.,coxO0KXXXXXXXKK0OOxdoc:,.."
				+"\n           ...");

        }
//        Musika.getMusika().musikaAmaitu();
	}
	
	private void konprobatuPos() 
	{
		char c = mapaGela.getChar(koor.getPosY(), koor.getPosX());
		switch (c)
		{
			case '∏':
				boolean eskailerak = (gela+1)%5 == 0;
				gela++;
				sortuGelaBerria(eskailerak,false);
				eskailerak=false;
				System.out.println("┌──────────────────────────────────────────────────┐");
				System.out.println("   (Gela berri batera sartu zara)"
								+"\n   (Gela ezezagun eta ilun batera...)");
				System.out.println();
				System.out.println("└──────────────────────────────────────────────────┘");
				Jokalaria.getJokalaria().printBizitza();
				break;
			case 'ʊ':
				mapaGela.setChar(koor, 'ᴗ');
				System.out.println("┌──────────────────────────────────────────────────┐");
				Borrokatu b1;
				b1=new Borrokatu();
				b1.kutxaZabaldu(true, Ziega.getNireZiega().getPisua());
				System.out.println("└──────────────────────────────────────────────────┘");
				Jokalaria.getJokalaria().printBizitza();
				break;
			case '۩':
				Jokalaria.getJokalaria().hpBete();
				System.out.println("┌──────────────────────────────────────────────────┐");
				System.out.print("   ._Λ_.");System.out.println("  Mari, emaidazu zure indarra"
							  +"\n    |n|");System.out.println(" (Bizitza osoa berreskuratu duzu)");
				System.out.println("└──────────────────────────────────────────────────┘");
	
				Jokalaria.getJokalaria().printBizitza();
				break;
			case 'E':
				sortuGelaBerria(false,true);
				gela=0;
				pisua=pisua+1;
				Ziega.getNireZiega().gehituPisua();
				break;
			case 'Ж':
				borrokanSartu(pisua, true);
				break;
			case '♯':
				if (lehenengoGela)
				{
					System.out.println("┌──────────────────────────────────────────────────┐");
					Ziega.getNireZiega().misioaInprimatu();
					System.out.println("└──────────────────────────────────────────────────┘");
					try {
						Thread.sleep(6000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					Jokalaria.getJokalaria().printBizitza();
				}
				else
				{
					System.out.println("┌──────────────────────────────────────────────────┐");
					System.out.println("   -Gela hau ez da besteak bezalakoa"
									+"\n   -Eta... Zerbait somatzen dut..."
									+"\n   -Agian, nire irudimena baino ez da. Aurrera!");
					System.out.println("└──────────────────────────────────────────────────┘");
					Jokalaria.getJokalaria().printBizitza();
				}
				break;
			default:
				System.out.println();
				System.out.println();
				System.out.println();
				etsaiakEguneratu();
				Jokalaria.getJokalaria().printBizitza();
				break;
		}

	}
	private boolean mugitu(char pNora)
	{
		Koordenatuak koorBerri= new Koordenatuak();
		koorBerri.setPos(koor.getPosX(),koor.getPosY());
		boolean okerra=false;
		switch (pNora) {
		case 'W':
			koorBerri.mugituW();
			if(mapaGela.mugimenduEgokia(koorBerri))
			{
				koor.mugituW();
				mapaGela.mapaEguneratu(koor);
			}
			else
			{
				System.out.print("Ezin duzu mugimendu hori egin");
				okerra=true;
			}
			break;
		case 'A':
			koorBerri.mugituA();
			if(mapaGela.mugimenduEgokia(koorBerri))
			{
				koor.mugituA();
				mapaGela.mapaEguneratu(koor);
			}
			else
			{
				System.out.print("Ezin duzu mugimendu hori egin");
				okerra=true;
			}
			break;
		case 'S':
			koorBerri.mugituS();
			if(mapaGela.mugimenduEgokia(koorBerri))
			{
				koor.mugituS();
				mapaGela.mapaEguneratu(koor);
			}
			else
			{
				System.out.print("Ezin duzu mugimendu hori egin");
				okerra=true;
			}
			break;
		case 'D':
			koorBerri.mugituD();
			if(mapaGela.mugimenduEgokia(koorBerri))
			{
				koor.mugituD();
				mapaGela.mapaEguneratu(koor);
			}
			else
			{
				System.out.print("Ezin duzu mugimendu hori egin");
				okerra=true;
			}
			break;
		default:
			System.out.print("Tekla okerra");
			okerra=true;
			break;

		}
		return okerra;
	}
	private void sortuGelaBerria(boolean eskailerak,boolean boss)
	{
		if(boss)
		{
			azkenekoMug='E';
		}
		else
		{
			etsaiKop= (int)(rnd.nextInt(2))+2; //2 eta 4 etsaien artean
			turnoKont= 1+(int)(Math.random()*8); //3 eta 5 turno borrokatzeko
		}
		
		mapaGela= new Mapa(azkenekoMug,eskailerak);
		koor= new Koordenatuak();
		koor = mapaGela.bilatuAtearenKoor();
		mapaGela.mapaEguneratu(koor);

	}
	private void etsaiakEguneratu() 
	{
		if(etsaiKop>0)
		{
			turnoKont--;
			if (turnoKont ==0)
			{
				turnoKont= 1+(int)(Math.random()*8);
				this.borrokanSartu(pisua,false);

				etsaiKop--;
			}
		}
	}
	private void printEtsaiak()
	{
		System.out.println("╔═════════════════════════════╗");
		if (etsaiKop==0)
		{
			System.out.print("║Ez dira etsaiik geratzen     ║"); 
		}
		else
		{
			System.out.print("║"+this.turnoKont+" turno hurrengo borrokarako ║"); 
		}
		
		System.out.println("\n║"+this.etsaiKop+" etsai geratzen dira bizirik║"
		
		+"\n╚═════════════════════════════╝");
	}

	
	
	private void borrokanSartu(int pPisu,boolean pBoss)
	{
		Borrokatu b1=new Borrokatu();
		b1.borrokatu(pBoss, pPisu);
	}
	//ENPALMEA EGITEKO ^
}