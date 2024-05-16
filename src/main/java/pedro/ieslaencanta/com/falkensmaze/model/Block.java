/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Clase que creará los bloques que tendrá el Maze.
 * @author NGM
 */
@XmlRootElement
public class Block implements  Serializable {
    private String value;
    
    /**
     * Constructor del bloque vacio.
     * El valor de este bloque por tanto es nulo.
     */
    public Block(){
        this.value=null;
    }
    /**
     * Método usado para obtener el valor actual del Bloque
     * @return Valor del bloque en dicho momento.
     */
    public String getValue(){
        return this.value;
    }
    /**
     * Método usado para modificar el valor actual por uno
     * pasado por parámetro.
     * @param value Nuevo valor que tendrá el bloque.
     */
    public void setValue(String value){
        this.value=value;
    }
    /**
     * Método que comprobará si el valor del bloque esta vacio.
     * @return Devuelve true si el bloque actual se encuentra vacio.
     */
    public boolean isEmpty(){
        return this.value==null;
    }
}
