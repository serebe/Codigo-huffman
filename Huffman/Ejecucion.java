package Huffman;

import java.util.*;

public class Ejecucion {

    public static void main(String[] args) {
        System.out.println("Digite la entrada de textos: ");
        Scanner texto = new Scanner(System.in);
        String entrada = texto.nextLine();
        boolean ayuda = validacion(entrada);
        if (ayuda==true) {
                System.out.println("El resultado de aplicar el codigo huffman es el siguiente");
                System.out.println(creacioncodigohuffman.codificacion(entrada));
                System.out.println("Desea validar los nodos y valores que le corresponde(si/no)");
                String segundo = texto.next();
                if ("si".equals(segundo) || "s".equals(segundo)) {
                    System.out.print("Letra   ||    valor");
                    System.out.print(" ");
                    for (int i = 0; i < entrada.length(); i++) {
                        System.out.println(" ");
                        System.out.print(entrada.charAt(i)+ "   ||    " + codigoletras.codificacion(entrada).get(i));
                    }
                }
            }     
            else {
                System.out.print("Solo se permite caracteres de tipo alfabetico o espaciado,vuelve a correr el codigo");
            }    
    }

    public static boolean validacion(String entrada) { // validacion de entrada alfabeticos y  espaciado
        String[] archivo = entrada.split(" ");
        boolean boton = true;
        for (int y = 0; y < archivo.length; y++) {
            for (int x = 0; x < archivo[y].length(); x++) {
                char c = archivo[y].charAt(x);
                if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                    boton = false;
                    break;
                }
                boton = true;
            }
            if (boton == false) {
                boton = false;
                break;
            }
        }
        return boton;
    }
}
