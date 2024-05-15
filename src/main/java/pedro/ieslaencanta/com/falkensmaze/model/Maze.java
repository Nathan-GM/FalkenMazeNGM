/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze.model;

import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Serializable;

import java.io.UnsupportedEncodingException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import pedro.ieslaencanta.com.falkensmaze.Size;

/**
 *
 * @author NGM
 * @see Size
 * @see Block
 */
@XmlRootElement
public class Maze implements Serializable {

    private Size size;
    private Block[][] blocks;
    private double time;
    private String sound;

    /**
     * Constructor del Maze vacio.
     */
    public Maze() {
    }

    /**
     * Método que inicializará el Maze (explicar más)
     */
    public void init() {
        this.setBlocks(new Block[this.getSize().getHeight()][this.getSize().getWidth()]);
        for (int i = 0; i < this.getBlocks().length; i++) {
            for (int j = 0; j < this.getBlocks()[i].length; j++) {
                this.getBlocks()[i][j] = new Block();

            }
        }
    }

    /**
     * Método que reiniciará el Maze borrando todos los bloques existentes.
     */
    public void reset() {
        for (int i = 0; i < this.getBlocks().length; i++) {
            for (int j = 0; j < this.getBlocks()[i].length; j++) {
                this.getBlocks()[i][j] = null;

            }
        }
        this.setBlocks(null);
    }

    /**
     * Método que vaciará el tablero, despues actualizará el tamaño y por último
     * lo inicializará de nuevo.
     *
     * @param newsize Nuevo tamaño que tendrá el Maze que se generé
     */
    public void reset(Size newsize) {
        this.reset();
        this.setSize(newsize);
        this.init();
    }

    /**
     * Método usado para cambiar el valor de un Bloque
     *
     * @param value nuevo valor del bloque.
     * @param row Fila del Bloque a modificar
     * @param col Columna del Bloque a modificar.
     */
    public void setBlockValue(String value, int row, int col) {
        this.getBlocks()[col][row].setValue(value);
    }

    /**
     * Método que devolverá el valor actual de un bloque en base a su posicion
     * en fila y columna.
     *
     * @param row Fila del bloque a obtener
     * @param col Columna del bloque a obtener.
     * @return Devuelve el valor del bloque que se encuentre en dicha posición.
     */
    public String getBlockValue(int row, int col) {
        return this.getBlocks()[row][col].getValue();
    }

    /**
     * Método que devuelve el Size actual del Maze.
     *
     * @return Size actual usado para generar Mazes.
     */
    public Size getSize() {
        return size;
    }

    /**
     * Método utilizado para indicar un nuevo Size.
     *
     * @param size Objeto Size que indicará el nuevo tamaño.
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Método que devuelve el tiempo
     *
     * @return Tiempo que se tiene para realizar el Maze.
     */
    public double getTime() {
        return time;
    }

    /**
     * Método utilizado para asignar un nuevo tiempo.
     *
     * @param time Double que contendrá la nueva cantidad de tiempo.
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Método que devuelve la string del sonido utilizado
     *
     * @return String del sonido usado durante el Maze.
     */
    public String getSound() {
        return sound;
    }

    /**
     * Método que indica un nuevo sonido
     *
     * @param sound String que indica donde y el nombre que tiene el sonido.
     */
    public void setSound(String sound) {
        this.sound = sound;
    }

    /**
     *
     * @return
     */
    public Block[][] getBlocks() {
        return blocks;
    }

    /**
     *
     * @param blocks
     */
    public void setBlocks(Block[][] blocks) {
        this.blocks = blocks;
    }

    /**
     * Método utilizado para cargar un Maze desde un fichero.
     *
     * @param file nombre y extensión del fichero que contiene el Maze. Dicho
     * fichero puede tener las siguientes extensiones:
     * <ol>
     * <li>XML</li>
     * <li>JSON</li>
     * <li>BIN</li>
     * </ol>
     * @return Maze cargado del fichero
     * @throws JAXBException
     * @throws IOException
     * @throws FileNotFoundException Error provocado al no encontrar el fichero
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public static Maze load(File file) throws JAXBException, IOException, FileNotFoundException, ClassNotFoundException, Exception {
        String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Maze m = null;
        if (extension.equals("xml")) {
            m = Maze.loadXML(file);
        } else {
            if (extension.equals("json")) {
                m = Maze.loadJSON(file);

            } else {
                if (extension.equals("bin")) {
                    m = Maze.loadBin(file);
                } else {
                    throw new Exception("Exencsión " + extension + " no permitida");

                }
            }

        }
        return m;

    }

    /**
     * Método utilizado para guardar un Maze en un fichero.
     *
     * @param maze Maze actual que deseamos guardar.
     * @param file Nombre y Extensión del fichero donde se guardará el Maze. Se
     * aceptan las siguientes extensiones:
     * <ol>
     * <li>XML</li>
     * <li>JSON</li>
     * <li>BIN</li>
     * </ol>
     * @throws JAXBException
     * @throws Exception
     */
    public static void save(Maze maze, File file) throws JAXBException, Exception {
        if (maze.sound == null || maze.sound.equals("")) {
            throw new Exception("Es necesario indicar el sonido del laberinto");
        }
        String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (extension.equals("xml")) {
            Maze.saveXML(maze, file);
        } else {
            if (extension.equals("json")) {
                Maze.saveJSON(maze, file);

            } else {
                if (extension.equals("bin")) {
                    Maze.saveBin(maze, file);
                } else {
                    throw new Exception("Exencsión " + extension + " no permitida");

                }
            }

        }
    }

    private static Maze loadJSON(File file) throws FileNotFoundException, IOException {
        Gson gson = new Gson();
        Reader reader;
        reader = Files.newBufferedReader(file.toPath());
        Maze m = gson.fromJson(reader, Maze.class);
        reader.close();
        return m;
    }

    private static Maze loadXML(File file) throws JAXBException, IOException {

        JAXBContext context = JAXBContext.newInstance(Maze.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Maze maze = (Maze) unmarshaller.unmarshal(
                file);
        return maze;

    }

    public static Maze loadBin(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream os = new FileInputStream(file);

        ObjectInputStream oos = new ObjectInputStream(os);
        Maze m = (Maze) oos.readObject();
        oos.close();;
        os.close();
        return m;
    }

    private static void saveJSON(Maze maze, File file) throws FileNotFoundException, UnsupportedEncodingException {
        Gson gson = new Gson();
        String json = gson.toJson(maze);
        java.io.PrintWriter pw = new PrintWriter(file, "UTF-8");
        pw.print(json);
        pw.close();
    }

    private static void saveXML(Maze maze, File file) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(maze.getClass());
        // create an instance of `Marshaller`
        Marshaller marshaller = context.createMarshaller();
        // enable pretty-print XML output
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // write XML to `StringWriter`
        FileWriter fw = new FileWriter(file, StandardCharsets.UTF_8);//(file, "UTF-8");
        marshaller.marshal(maze, fw);
        fw.close();

    }

    public static void saveBin(Maze maze, File file) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(maze);
        oos.close();;
        os.close();
    }

}
