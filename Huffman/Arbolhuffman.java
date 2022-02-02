package Huffman;

public class Arbolhuffman {
    //arbol de huffman constructor

    public char letra;
    public int validacion;
    public Arbolhuffman rama_izquierda;
    public Arbolhuffman rama_derecha;

    public Arbolhuffman(char letra, int validacion, Arbolhuffman rama_izquierda, Arbolhuffman rama_derecha) {
        this.letra = letra;
        this.validacion = validacion;
        this.rama_izquierda = rama_izquierda;
        this.rama_derecha = rama_derecha;
    }

    public Arbolhuffman(char letra, int validacion) {//Inicializador
        this.letra = letra;
        this.validacion = validacion;
        this.rama_izquierda = null;
        this.rama_derecha = null;
    }

    public boolean Hoja() {
        return ((rama_izquierda == null) && (rama_derecha == null));
    }
}
