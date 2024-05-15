/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Clase utilizada para generar el tamaño del Maze.
 * 
 * @author NGM
 */
@XmlRootElement
public class Size implements Cloneable, Comparable<Size>, Serializable {
    private int width;
    private int height;
   
    /**
     * Constructor del tamaño vacio.
     */
    public Size(){
    }

    /**
     * Constructor de tamaño sobrecargado.
     * @param width ancho que queremos que tenga de tamaño.
     * @param height altura que queremos que tenga de tamaño.
     */
    public Size(int width,int height){
        this.width=width;
        this.height=height;
    }
    /**
     * Indicamos que vamos a clonar nuestro objeto size
     * (crear otro objeto Size con las mismas características
     * que el actual.)
     * @return Devuelve un nuevo objeto size de mismas
     * proporciones que el actual.
     * @throws CloneNotSupportedException cuando no se pueda clonar el objeto.
     */
    public Object clone() throws CloneNotSupportedException{
        return new Size(this.getWidth(), this.getHeight());
    }
    /**
     * Método que compara Dos objetos para ver si ambos son iguales o no.
     * 
     * @param o objecto que vamos a comprobar si es identico al utilizado.
     * @return Este método devolverá verdadero si ambos objetos son iguales
     * y devolverá falso si esté objeto no es del tipo Size o si no tienen las
     * mismas proporciones.
     */
    @Override
    public boolean equals(Object o){
        if(! (o instanceof Size)){
            return false;
        }
        if (this.getWidth()==((Size)(o)).getWidth() && this.getHeight()==((Size)(o)).getHeight()){
            return true;
        }else{
            return false;
        }
        
    }
    /**
     * Método encargado de comparar 2 objetos Size
     * @param o objeto Size que se va a comparar con el que ejecute este método.
     * @return Nos encontramos 3 resultados distintos: <br>
     * 0: Ambos objetos Size son identicos. <br>
     * -1: El Objeto Size obtenido por parametro (o) es mayor que el que ejecuta
     * el método. <br>
     * 1: El objeto Size que ejecuta dicho método es mayor al obtenido por párametro (o)
     */
     @Override
    public int compareTo(Size o) {
        if(this.getWidth()==o.getWidth() && this.getHeight()==o.getHeight())
            return 0;
        if(this.getWidth()<o.getWidth())
            return -1;
        else
            return 1;
    }
    /**
     * Indica en una String los valores del objeto Size
     * @return String que indica la anchura y altura del objeto Size.
     */
    public String toString(){
        return "W:"+this.width+" H:"+this.height;
    }
    /**
     * Devuelve la anchura que contiene el objeto Size.
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Devuelve la altura que contiene el objeto Size.
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Método que modifica la anchura actual por una nueva pasada por párametro.
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Método que modifica la altura actual por una nueva pasada por párametro.
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
 

}
