/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze.components;

/**
 * Interfaz relacionada con el funcionamiento de los bloques
 * Aquellas clases que lo implementen recibirán los métodos
 * localizados dentro de esta Interfaz de manera que harán
 * la función que necesiten segun la clase.
 * 
 * @author NGM
 */
public interface IBlockListener {
    /**
     * Método que indicará como reaccionará
     * un bloque al hacer un click en él
     * @param b Bloque que se usará en dicho método.
     */
    public void onClicked(Block b);
    
    /**
     * Método que indicará la reacción
     * de un bloque al hacer doble click
     * sobre él mismo.
     * @param b Bloque que se usará sobre dicho método
     */
    public void onDoubleClicked(Block b);
}
