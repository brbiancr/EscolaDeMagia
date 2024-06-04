package utilitarios;

import java.util.concurrent.ThreadLocalRandom;

public class GerarIDs {	
	public static String gerarIdAdministrador() {
		return gerarNumeroAleatorio() + "ADM" + gerarNumeroAleatorio();
	}
	
	public static String gerarMatricula(String reino) {
		String intervalo = reino.substring(0, 3);
		return gerarNumeroAleatorio() + intervalo.toUpperCase() + gerarNumeroAleatorio();
	}
	
	public static String gerarCodigo(String nome) {
		return gerarNumeroAleatorio() + nome.toUpperCase() + gerarNumeroAleatorio();
	}
	
	public static String gerarIdProfessor() {
		return gerarNumeroAleatorio() + "PROF" + gerarNumeroAleatorio();
	}
	
	public static String gerarNumeroAleatorio() {
		int numeroAleatorio = ThreadLocalRandom.current().nextInt(100, 1000);
		return Integer.toString(numeroAleatorio);
	}
	
}
