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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ac 001
 */
public final class Data {

    static public Map<String, String> usuarios = new HashMap();
    private final static String nombre = "datos.txt";
    private static File archivo;

    public static boolean crearUsuario(String clave, String username) {
        if (usuarios.isEmpty()) {
            usuarios.put(clave, username);
            return true;
        } else {
             for (Map.Entry<String, String> usuario : usuarios.entrySet()) {
            if (usuario.getValue().equals(username)) {
                return false;
            }else{
                 usuarios.put(clave, username);
                 return true;
            }
        }
        }
        return false;
    }

    public static boolean validarUsuario(String clave, String username) {
        for (Map.Entry<String, String> usuario : usuarios.entrySet()) {
            if (usuario.getKey().equals(clave) && usuario.getValue().equals(username)) {
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
            oos.writeObject(usuarios);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    public static void CargarArchivo() {
        archivo = new File(nombre);
        if (!archivo.exists()) {
            generarDatos();
        } else {
            try {
                FileInputStream fis = new FileInputStream(nombre);
                ObjectInputStream ois = new ObjectInputStream(fis);
                usuarios = (Map<String, String>) ois.readObject();
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
        usuarios.put("aharon", "123");
        usuarios.put("David", "345");
        usuarios.put("Adrian", "678");
    }

}
