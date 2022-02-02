package Huffman;

import java.util.*;

public class codigoletras {

    public static List codificacion(String entrada) {
        ArrayList<Arbolhuffman> hoja = (ArrayList<Arbolhuffman>) creacionhojas(entrada); //creamos un arraylist con el arbol binario
        Arbolhuffman procesohuffman = creador(hoja);
        HashMap<Character, String> hashMap = generador(procesohuffman);
        ArrayList<String> finalizacion = (ArrayList<String>) letras(entrada, hashMap);
        return finalizacion;
    }

    private static List<Arbolhuffman> creacionhojas(String entrada) {
        List<Arbolhuffman> nodos = new ArrayList<>();// creacion de arraylist donde estaran las hojas
        for (int i = 0; i < entrada.length(); i = i + 1) {
            Arbolhuffman arbol = new Arbolhuffman(entrada.charAt(i), 1);//creacion de la estructura que entrara en el arbol
            int indice = -1;
            for (int j = 0; j < nodos.size(); j++) {
                if (nodos.get(j).letra == arbol.letra) {
                    indice = j;
                    break;
                }
            }
            if (indice != -1) {
                nodos.get(indice).validacion += 1;
            } else {
                nodos.add(arbol);
            }
        }
        return nodos;
    }

    private static Arbolhuffman creador(List<Arbolhuffman> hoja) { // Creacion codigo de prioridad para el arbol
        PriorityQueue<Arbolhuffman> priorityQueue = new PriorityQueue<>(hoja.size(), (Arbolhuffman h1, Arbolhuffman h2) -> h1.validacion - h2.validacion);

        for (Arbolhuffman nodo : hoja) {
            priorityQueue.add(nodo);
        }

        while (priorityQueue.size() > 1) {
            Arbolhuffman alfa = priorityQueue.poll();
            Arbolhuffman beta = priorityQueue.poll();
            Arbolhuffman union = new Arbolhuffman('_', alfa.validacion + beta.validacion, alfa, beta);
            priorityQueue.add(union);
        }
        return priorityQueue.poll();
    }

    private static HashMap<Character, String> generador(Arbolhuffman t) { // se crea las entradas en el arbol
        HashMap<Character, String> hashMap = new HashMap<>();
        auxiliar(t, "", hashMap);
        return hashMap;
    }

    private static void auxiliar(Arbolhuffman arbol, String texto, HashMap<Character, String> arbolbinario) {
        if (arbol.Hoja()) {
            arbolbinario.put(arbol.letra, texto);
        } else {
            if (arbol.rama_izquierda != null) {
                auxiliar(arbol.rama_izquierda, texto + "0", arbolbinario);
            }
            if (arbol.rama_derecha != null) {
                auxiliar(arbol.rama_derecha, texto + "1", arbolbinario);
            }
        }
    }

    private static List letras(String entrada, HashMap<Character, String> arbol) {// se codifica para mostrar en la salida
        List<String> valores = new ArrayList<>();
        for (int i = 0; i < entrada.length(); i = i + 1) {
            valores.add(arbol.get(entrada.charAt(i)));
        }
        return valores;
    }
}
