/**
* MarqueeOnConsole.java
* Esta porcion de codigo nos introduce en la animacion de texto en consola se puede emplear como free.
* Crea algo parecido a la marquesina.
*
* @author root
* @version 1.0
*/
public class MarqueeOnConsole{

/** Esta instruccion nos sirve para generar la longitud de linea . **/
public static final int CONSOLE_LENGTH=40;

/** Creamos el texto a mover en la consola **/
public static void main(String []agrs) throws InterruptedException{

	String text = "Muevete***!";
	int prefixLength=-1;

	while(true){
		String prefix = "\r";
		prefixLength++;

		if(prefixLength>CONSOLE_LENGTH){
			prefixLength=0;
		}

		for(int i=0; i < (prefixLength-text.length());i++){
			prefix += " ";
		}

		int endIndex = CONSOLE_LENGTH-prefixLength;

		if (prefixLength < text.length()){
			endIndex = prefixLength;
			prefix = "\r";
			String printableText = text.substring((text.length()-endIndex),text.length());
			System.out.print("\007");
			System.out.print(prefix + printableText);

		}else if(endIndex > text.length()){
			endIndex = text.length();
			String printableText = text.substring(0,endIndex);
			System.out.print("\007");
			System.out.print(prefix + printableText);

		} else if (endIndex < text.length()){
			String printableText = text.substring(0,endIndex);
			System.out.print("\007");
			System.out.print(prefix + printableText);
		}


		Thread.sleep(100);
	}	
}
}