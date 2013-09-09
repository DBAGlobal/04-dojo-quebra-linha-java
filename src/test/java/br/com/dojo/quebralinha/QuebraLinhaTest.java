package br.com.dojo.quebralinha;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuebraLinhaTest {
	
	@Test	
	public void deveQuebrarLinhaNoQuintoEspaco(){
		String result = TextFormatter.forText(texto).limitWordsForLine().to(5);
		
		assertEquals(result.substring(0, result.indexOf("\n")).split("\\s").length, 5);
	}
	
	@Test	
	public void deveQuebrarLinhaNoVigesimoCaracter(){
		String result = TextFormatter.forText(texto).limitCharactersForLine().to(40);
		
		String[] lines = result.split("\\n");
		
		for (String line : lines) {
			assertTrue(line.length() <= 40);
		}
		
		System.out.println(result);
		
	}
	
	private static final String texto = "Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker.";
}
