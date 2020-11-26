/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.clases;

import ec.edu.espol.proyectoedd.App;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 *
 * @author Ac 001
 */
public final class Data {

    private final static String nombre = "datos.txt";
    private static File archivo;
    
    public static boolean validarUsuario(String clave, String username){
       for(Map.Entry<String,String> usuario: App.usuarios.entrySet()){
           if(usuario.getKey()==clave && usuario.getValue()==username){
               return true;
           }
       }
        return false;
    }
    public static void guardarArchivo() {
        String titulo = "Error al cargar el archivo";
        try {
            FileOutputStream fos = new FileOutputStream(nombre);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(App.usuarios);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
           
        }
    }

    public static void CargarArchivo() {
        archivo= new File(nombre);
        if (!archivo.exists()) {
            generarDatos();
        } else {
            try {
                FileInputStream fis = new FileInputStream(nombre);
                ObjectInputStream ois = new ObjectInputStream(fis);
                App.usuarios = (Map<String, String>) ois.readObject();
                ois.close();
                fis.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Problema 1");
             
            } catch (IOException ex) {
              System.out.println("Problema 2");
            } catch (ClassNotFoundException ex) {
                 System.out.println("Problema 2");
            }

        }

    }

    public static void generarDatos() {
        App.usuarios.put("aharon", "123");
        App.usuarios.put("David", "345");
        App.usuarios.put("Adrian", "678");
    }

}
