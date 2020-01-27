/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutante;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Juancitum
 */
public class Mutante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   String[] dna = { "ABAAAT", "CAGTGT", "TTATGT", "AGAAGT", "CCCCGA",
				"TCACTG" };
		boolean mutante = isMutante(dna);
		System.out.println("Usted es Mutante? "+ mutante);

    }

    public static boolean isMutante(String[] dna) {
       
		String[][] matriz = new String[dna.length][dna.length];
		String[][] matrizTraspuesta = new String[dna.length][dna.length];
		String cadena = null;
		String[] almaceno = new String[dna.length];

		System.out.println("Cargo Matriz");

		for (int i = 0; i < dna.length; i++) {
			cadena = dna[i];
			String[] agrego = cadena.split("");
			for (int j = 0; j < agrego.length - 1; j++) {
				matriz[i][j] = agrego[j + 1];
				System.out.print(matriz[i][j]);
			}
			System.out.println("");
		}

		// Trasponer la matriz y comparar

		for (int i = 0; i < dna.length; i++) {
			for (int j = 0; j < dna.length; j++) {
				matrizTraspuesta[j][i] = matriz[i][j];
			}
		}
		System.out.println("");
		System.out.println(" Muestro matriz tranpuesta ");
		// muestro matriz tranpuesta
		for (int i = 0; i < dna.length; i++) {
			for (int j = 0; j < dna.length; j++) {
				System.out.print(matrizTraspuesta[i][j]);
			}
			System.out.println("");
		}

		int mutante = 0;
		String vectorCompara[] = new String[dna.length];
		String almacenoValFila = "";
		int contadorFila = 1;
		int contadorColumna = 1;
		int contadorOblicuo = 1;
		String almacenaValor[] = null;
		String[] separo = null;
		// por columna
		for (int i = 0; i < dna.length; i++) {
			cadena = dna[i];
			separo = cadena.split("");

			for (int j = 0; j < separo.length; j++) {
				if (j != 0) {
					if (almacenoValFila.equals(separo[j])) {
						contadorFila++;
						if (contadorFila == 4) {
							mutante++;
						}
					} else {
						almacenoValFila = separo[j];
						contadorFila = 1;
					}

				}

			}
		}

		// por fila

		for (int i = 0; i < dna.length; i++) {
			almacenoValFila = "";
			for (int j = 0; j < dna.length; j++) {
				separo[j] = matrizTraspuesta[i][j];

			}
			for (int j = 0; j < separo.length; j++) {
				if (almacenoValFila.equals(separo[j])) {
					contadorFila++;
					if (contadorFila == 4) {
						mutante++;
					}
				} else {
					almacenoValFila = separo[j];
					contadorFila = 1;
				}
			}
		}

		// por diagonal
		almacenoValFila = "";
		int avanzaPosicion = 1;
		for (int i = 0; i < dna.length; i++) {
			if (i == 0) {
				cadena = dna[i];
				vectorCompara = cadena.split("");
				contadorOblicuo = 1;
			} else {
				for (int j = 0; j < separo.length-1; j++) {
					cadena = dna[i];
					separo = cadena.split("");
					if (vectorCompara[j].equals(separo[j+1])) {
						contadorOblicuo++;
						if (contadorOblicuo == 4) {
							mutante++;
						}
					}
				}
				vectorCompara = cadena.split("");
			}
		}

		if (mutante > 3) {
			return true;
		} else {
			return false;
		}
	}

   
}
