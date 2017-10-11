package packageJuego;

import static java.lang.System.*;
import java.util.Random;

public class Mapa {
	//atributua
	private char[][] mapaOriginala;
	private char[][] mapa;
	private String mapaSelec;
	private int distantziaMapa=14, maxKofre,maxAte;
	private static int Begi = 4;
	Random  rnd = new Random();
	

	//eraikitzailea
	public Mapa(char pNondik, boolean pHurGelaEskail)
	{
		int randomNum=99;
		mapa= new char[14][14];
		
		switch (pNondik)
		{
			case 'E':
				mapaSelec="Boss";
				break;
				
			case 'W':
				randomNum = (int)(rnd.nextInt(4)); //Handiena 3a da
				switch(randomNum)
				{
					case 0:
						mapaSelec="L1";
						break;
					case 1:
						mapaSelec="L2";
						break;
					case 2:
						mapaSelec="Pasillo2";
						break;
					case 3:
						mapaSelec="Gurutze";
						break;
				}
				break;
			 case 'S':
					randomNum = (int)(rnd.nextInt(4)); //Handiena 3a da
					switch(randomNum)
					{
						case 0:
							mapaSelec="L3";
							break;
						case 1:
							mapaSelec="L4";
							break;
						case 2:
							mapaSelec="Pasillo2";
							break;
						case 3:
							mapaSelec="Gurutze";
							break;
					}
					break;
			case 'A':case 'D':				
				randomNum = (int)(rnd.nextInt(6)); //Handiena 5a da
				switch(randomNum)
				{
					case 0:
						mapaSelec="L1";
						break;
					case 1:
						mapaSelec="L2";
						break;
					case 2:
						mapaSelec="L3";
						break;
					case 3:
						mapaSelec="L4";
						break;
					case 4:
						mapaSelec="Pasillo1";
						break;
					case 5:
						mapaSelec="Gurutze";
						break;
				}
				break;
		}
		switch (mapaSelec)
		{
			case "Boss":
				mapaOriginala=new char[][]{	//5   6   7   8   9  10   11  12  13  14
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //1
					{'█','█','█','╔','═','═','∏','═','═','╗','█','█','█','█',}, //2 
					{'█','█','█','║',' ',' ','Ж',' ',' ','║','█','█','█','█',}, //3
					{'█','█','█','║',' ',' ',' ',' ',' ','║','█','█','█','█',}, //4
					{'█','█','█','║',' ',' ',' ',' ',' ','║','█','█','█','█',}, //5
					{'█','█','█','║',' ',' ',' ',' ',' ','║','█','█','█','█',}, //6
					{'█','█','█','║',' ',' ',' ',' ',' ','║','█','█','█','█',}, //7
					{'█','█','█','╚','═','╗',' ','╔','═','╝','█','█','█','█',}, //8
					{'█','█','█','█','╔','╝',' ','╚','╗','█','█','█','█','█',}, //9
					{'█','█','█','█','║','۩',' ','ʊ','║','█','█','█','█','█',}, //10
					{'█','█','█','█','║',' ',' ',' ','║','█','█','█','█','█',}, //11
					{'█','█','█','█','╚','╗',' ','╔','╝','█','█','█','█','█',}, //12
					{'█','█','█','█','█','╚','♯','╝','█','█','█','█','█','█',}, //13
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',} //14
					};
				maxKofre=0;
				maxAte=0;
				break;
			case "L1":
				mapaOriginala=new char[][]{	//5   6   7   8   9  10   11  12  13  14
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //1
					{'█','╔','═','═','═','═','═','═','═','═','═','═','╗','█',}, //2 
					{'█','║','K',' ',' ',' ',' ',' ',' ',' ',' ',' ','║','█',}, //3
					{'█','║',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','║','█',}, //4
					{'█','D',' ',' ',' ',' ','E',' ',' ',' ',' ',' ','A','█',}, //5
					{'█','║',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','║','█',}, //6
					{'█','║',' ',' ',' ',' ',' ',' ',' ',' ',' ','K','║','█',}, //7
					{'█','║',' ',' ',' ','╔','═','═','═','═','═','═','╝','█',}, //8
					{'█','║',' ',' ',' ','║','█','█','█','█','█','█','█','█',}, //9
					{'█','║',' ',' ',' ','║','█','█','█','█','█','█','█','█',}, //10
					{'█','║',' ',' ','K','║','█','█','█','█','█','█','█','█',}, //11
					{'█','║',' ',' ',' ','║','█','█','█','█','█','█','█','█',}, //12
					{'█','╚','═','W','═','╝','█','█','█','█','█','█','█','█',}, //13
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',} //14
					};
					maxKofre=3;
					maxAte=2;
				break;
			case "L2":
				mapaOriginala=new char[][]{	//5   6   7   8   9  10   11  12  13  14
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //1
					{'█','╔','═','═','═','═','═','═','═','═','═','═','╗','█',}, //2 
					{'█','║','K',' ',' ',' ',' ',' ',' ',' ',' ',' ','║','█',}, //3
					{'█','║',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','║','█',}, //4
					{'█','D',' ',' ',' ',' ',' ',' ','E',' ',' ',' ','A','█',}, //5
					{'█','║',' ',' ',' ',' ',' ',' ',' ',' ',' ','K','║','█',}, //6
					{'█','║',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','║','█',}, //7
					{'█','╚','═','═','═','═','═','═','╗',' ',' ',' ','║','█',}, //8
					{'█','█','█','█','█','█','█','█','║',' ',' ',' ','║','█',}, //9
					{'█','█','█','█','█','█','█','█','║',' ',' ',' ','║','█',}, //10
					{'█','█','█','█','█','█','█','█','║',' ',' ',' ','║','█',}, //11
					{'█','█','█','█','█','█','█','█','║',' ',' ','K','║','█',}, //12
					{'█','█','█','█','█','█','█','█','╚','═','W','═','╝','█',}, //13
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',} //14
					};
					maxKofre=3;
					maxAte=2;
				break;
			case "L3":
				mapaOriginala=new char[][]{	//5   6   7   8   9  10   11  12  13  14
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //1
					{'█','█','█','█','█','█','█','█','╔','═','S','═','╗','█',}, //2 
					{'█','█','█','█','█','█','█','█','║',' ',' ',' ','║','█',}, //3
					{'█','█','█','█','█','█','█','█','║',' ',' ',' ','║','█',}, //4
					{'█','█','█','█','█','█','█','█','║','K',' ',' ','║','█',}, //5
					{'█','█','█','█','█','█','█','█','║',' ',' ',' ','║','█',}, //6
					{'█','╔','═','═','═','═','═','═','╝',' ',' ',' ','║','█',}, //7
					{'█','║',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','║','█',}, //8
					{'█','║',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','║','█',}, //9
					{'█','D',' ',' ',' ',' ',' ',' ','E',' ',' ',' ','A','█',}, //10
					{'█','║',' ',' ','K',' ',' ',' ',' ',' ',' ',' ','║','█',}, //11
					{'█','║',' ',' ',' ',' ',' ',' ',' ',' ','K',' ','║','█',}, //12
					{'█','╚','═','═','═','═','═','═','═','═','═','═','╝','█',}, //13
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',} //14
					};
					maxKofre=3;
					maxAte=2;
				break;			
			case "L4":
				mapaOriginala=new char[][]{	//5   6   7   8   9  10   11  12  13  14
						{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //1
						{'█','╔','═','S','═','╗','█','█','█','█','█','█','█','█',}, //2 
						{'█','║',' ',' ',' ','║','█','█','█','█','█','█','█','█',}, //3
						{'█','║',' ',' ',' ','║','█','█','█','█','█','█','█','█',}, //4
						{'█','║',' ',' ',' ','║','█','█','█','█','█','█','█','█',}, //5
						{'█','║',' ',' ',' ','║','█','█','█','█','█','█','█','█',}, //6
						{'█','║',' ',' ',' ','╚','═','═','═','═','═','═','╗','█',}, //7
						{'█','║','K',' ',' ',' ',' ',' ',' ',' ',' ','K','║','█',}, //8
						{'█','║',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','║','█',}, //9
						{'█','D',' ',' ',' ','E',' ',' ',' ',' ',' ',' ','A','█',}, //10
						{'█','║',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','║','█',}, //11
						{'█','║',' ',' ',' ',' ','K',' ',' ',' ',' ',' ','║','█',}, //12
						{'█','╚','═','═','═','═','═','═','═','═','═','═','╝','█',}, //13
						{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',} //14
						};
						maxKofre=3;
						maxAte=2;
					break;
			case "Pasillo1":
				mapaOriginala=new char[][]{	//5   6   7   8   9  10   11  12  13  14
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //1
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //2 
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //3
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //4
					{'█','╔','═','═','═','═','═','═','═','═','═','═','╗','█',}, //5
					{'█','║',' ',' ',' ',' ',' ',' ','K',' ',' ',' ','║','█',}, //6
					{'█','D',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','A','█',}, //7
					{'█','║',' ',' ','K',' ',' ','E',' ',' ',' ',' ','║','█',}, //8
					{'█','╚','═','═','═','═','═','═','═','═','═','═','╝','█',}, //9
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //10
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //11
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //12
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //13
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',} //14
					};
					maxKofre=2;
					maxAte=1;
				break;
			case "Pasillo2":
				mapaOriginala=new char[][]{	//5   6   7   8   9  10   11  12  13  14
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //1
					{'█','█','█','█','╔','═','S','═','╗','█','█','█','█','█'}, //2 
					{'█','█','█','█','║',' ',' ',' ','║','█','█','█','█','█',}, //3
					{'█','█','█','█','║',' ',' ',' ','║','█','█','█','█','█',}, //4
					{'█','█','█','█','║','K',' ',' ','║','█','█','█','█','█',}, //5
					{'█','█','█','█','║',' ',' ',' ','║','█','█','█','█','█',}, //6
					{'█','█','█','█','║',' ',' ','E','║','█','█','█','█','█',}, //7
					{'█','█','█','█','║',' ',' ',' ','║','█','█','█','█','█',}, //8
					{'█','█','█','█','║',' ','K',' ','║','█','█','█','█','█',}, //9
					{'█','█','█','█','║',' ',' ',' ','║','█','█','█','█','█',}, //10
					{'█','█','█','█','║',' ',' ',' ','║','█','█','█','█','█',}, //11
					{'█','█','█','█','║',' ',' ',' ','║','█','█','█','█','█',}, //12
					{'█','█','█','█','╚','═','W','═','╝','█','█','█','█','█',}, //13
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',} //14
					};
					maxKofre=2;
					maxAte=1;
				break;
			case "Gurutze":
				mapaOriginala=new char[][]{	//5   6   7   8   9  10   11  12  13  14
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',}, //1
					{'█','█','█','█','╔','═','S','═','╗','█','█','█','█','█'}, //2 
					{'█','█','█','█','║',' ',' ','K','║','█','█','█','█','█',}, //3
					{'█','█','█','█','║',' ',' ',' ','║','█','█','█','█','█',}, //4
					{'█','╔','═','═','╝',' ',' ',' ','╚','═','═','╗','█','█',}, //5
					{'█','║','K',' ',' ',' ',' ',' ',' ',' ',' ','║','█','█',}, //6
					{'█','D',' ',' ',' ',' ','E','K',' ',' ',' ','A','█','█',}, //7
					{'█','║',' ',' ',' ',' ',' ',' ',' ',' ',' ','║','█','█',}, //8
					{'█','╚','═','═','╗',' ',' ',' ','╔','═','═','╝','█','█',}, //9
					{'█','█','█','█','║',' ',' ',' ','║','█','█','█','█','█',}, //10
					{'█','█','█','█','║',' ',' ','K','║','█','█','█','█','█',}, //11
					{'█','█','█','█','║',' ',' ',' ','║','█','█','█','█','█',}, //12
					{'█','█','█','█','╚','═','W','═','╝','█','█','█','█','█',}, //13
					{'█','█','█','█','█','█','█','█','█','█','█','█','█','█',} //14
					};
					maxKofre=4;
					maxAte=3;
				break;
		}
		if (pNondik!='E')
		{
			setKofreakIrteerakMapa(pNondik,pHurGelaEskail);
		}
	}

	//metodoak
	
	private void setKofreakIrteerakMapa(char pNondik, boolean pEskailerak)
	{
		int row, column;
		int randomKofrea= (int)(rnd.nextInt(maxKofre));
		int randomAtea=(int)(rnd.nextInt(maxAte));
		boolean kofreaJarriGabe =true, ateaJarriGabe =true;
		char karak;
		
		if((int)(rnd.nextInt(20))!=0)
		{
			kofreaJarriGabe=false;
		}

		for (row = (-1)*(distantziaMapa/2); row < (distantziaMapa/2); row ++ )
		{
			for(column = (-1)*(distantziaMapa/2); column < (distantziaMapa/2); column++)
			{
				karak = mapaOriginala[eraldatuPos(row)][eraldatuPos(column)];
				if(karak==pNondik)
				{
					mapaOriginala[eraldatuPos(row)][eraldatuPos(column)]='♯';
				}
				else if(!pEskailerak && karak=='E')
				{
					mapaOriginala[eraldatuPos(row)][eraldatuPos(column)]=' ';
				}
				else if(karak=='K')
				{
					randomKofrea--;
					if(randomKofrea<0 && kofreaJarriGabe)
					{
						mapaOriginala[eraldatuPos(row)][eraldatuPos(column)]='ʊ';

						kofreaJarriGabe= false;
					}
					else
					{
						mapaOriginala[eraldatuPos(row)][eraldatuPos(column)]=' ';
					}
				}
				else if (karak=='W'||karak=='S')
				{
					randomAtea--;
					if(randomAtea<0 && ateaJarriGabe)
					{
						mapaOriginala[eraldatuPos(row)][eraldatuPos(column)]='∏';
						ateaJarriGabe= false;
					}
					else
					{
						mapaOriginala[eraldatuPos(row)][eraldatuPos(column)]='═';
					}
				}
				else if (karak=='A'||karak=='D')
				{
					randomAtea--;
					if(randomAtea<0&& ateaJarriGabe)
					{
						mapaOriginala[eraldatuPos(row)][eraldatuPos(column)]='∏';
						ateaJarriGabe= false;
					}
					else
					{
						mapaOriginala[eraldatuPos(row)][eraldatuPos(column)]='║';
					}
				}
			}
        }
	}
	private int eraldatuPos (int pPos)
	{
		int posBerri= (distantziaMapa/2)+ pPos;
		return posBerri;
	}
	/*
	private void bilatuKaraktEtaEral(char pChar,char pCharNew)
	{
		int row, column;
		char karak;
		for (row = (-1)*(distantziaMapa/2); row < (distantziaMapa/2); row ++ )
		{
			for(column = (-1)*(distantziaMapa/2); column < (distantziaMapa/2); column++)
			{
			karak = mapaOriginala[eraldatuPos(row)][eraldatuPos(column)];

				if (karak==pChar)
				{
					mapaOriginala[eraldatuPos(row)][eraldatuPos(column)]=pCharNew;
				}
			}
		}
	}
	*/
	public Koordenatuak bilatuAtearenKoor()
	{
		int row=(-1)*(distantziaMapa/2), column=(-1)*(distantziaMapa/2);
		boolean aurkituta = false;
		Koordenatuak koor= new Koordenatuak();
		while (!(aurkituta))
		{
			while(column<(distantziaMapa/2)&& !(aurkituta))
			{
				if(mapaOriginala[eraldatuPos(row)][eraldatuPos(column)]=='♯')
				{
					aurkituta = true;
				}
				else
				{
					column++;
				}
			}
			if (!(aurkituta))
			{
				column=(-1)*(distantziaMapa/2);
				row++;
			}
		}
		koor.setPos(column, row);
		return koor;
	}
	public char getChar(int pPosY, int pPosX)
	{
		return mapa[eraldatuPos(pPosY)][eraldatuPos(pPosX)];
	}
	
	public void mapaEguneratu(Koordenatuak pKoor)
	{

		int posX=pKoor.getPosX();
		int posY=pKoor.getPosY();
		int row, column;
		double distantzia;
		for (row = (-1)*(distantziaMapa/2); row < (distantziaMapa/2); row ++ )
		{
			for(column = (-1)*(distantziaMapa/2); column < (distantziaMapa/2); column++)
			{
				distantzia = Math.abs(row-posY) + Math.abs(column-posX);
				if(distantzia<Begi)
				{
					mapa[eraldatuPos(row)][eraldatuPos(column)]=mapaOriginala[eraldatuPos(row)][eraldatuPos(column)];
				}
			}
        }
	}
	public void printMapa(Koordenatuak pKoor,int pGela, int pPisua)
	{
		int posX=pKoor.getPosX();
		int posY=pKoor.getPosY();
	    int row, column;
	    char letra;
	    
	    System.out.println();
    	System.out.print("[MAPA]");
    	System.out.print("  Pisua:");
    	System.out.print(pPisua);
    	System.out.print("  Gela:");
    	System.out.println(pGela);
    	
	    System.out.print("◊"); //Goiko margina
	    for(row = (-1)*(distantziaMapa/2); row < (distantziaMapa/2); row ++ )
	    {	    
	    	System.out.print("──");
	    }
	    System.out.print("◊");
	    
	    out.println(); //Mapa
	    for (row = (-1)*(distantziaMapa/2); row < (distantziaMapa/2); row ++ )
        {
		   for(column = (-1)*(distantziaMapa/2); column < (distantziaMapa/2); column++)
           {
		       if(column== (-1)*(distantziaMapa/2))
		       {
		    	   System.out.print("│");
		       }
			   if( posY==row && posX==column)
        	   {
            	   out.print(" ☺");
        	   }
        	   else
        	   {
            	   letra = mapa[eraldatuPos(row)][eraldatuPos(column)];
            	   out.print(" " +letra);
        	   }
		       if(column== (distantziaMapa/2)-1)
		       {
		    	   System.out.print("│");
		       }
           }
		   out.println();
        }
	    
	    System.out.print("◊"); //Beheko margina
	    for(row = (-1)*(distantziaMapa/2); row < (distantziaMapa/2); row ++ )
	    {	    
	    	System.out.print("──");
	    }
	    System.out.print("◊");
		out.println();
	}
	public boolean mugimenduEgokia(Koordenatuak pKoor)
	{
		char c = getChar(pKoor.getPosY(), pKoor.getPosX());
		boolean egokia=false;
		switch (c)
		{
			case ' ':
			case '∏':
			case 'ʊ':
			case 'ᴗ':
			case 'E':
			case '۩':
			case 'Ж':
				egokia=true;
				break;
			default:
				egokia=false;
				break;
		}
		return egokia;
	}
	public void setChar(Koordenatuak pKoor, char pChar)
	{
		int pPosY= pKoor.getPosY();
		int pPosX= pKoor.getPosX();
		mapa[eraldatuPos(pPosY)][eraldatuPos(pPosX)]=pChar;
		mapaOriginala[eraldatuPos(pPosY)][eraldatuPos(pPosX)]=pChar;
	}
}
