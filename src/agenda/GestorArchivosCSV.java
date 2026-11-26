package agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorArchivosCSV {
    // Cada usuario tiene su propio archivo en la carpeta del proyecto
    private final String ruta;

    public GestorArchivosCSV(String usuario) {
        ruta = "contactos_" + usuario + ".csv";   // contactos_admin.csv, contactos_maria.csv
    }

    // Escribe una línea por contacto: tipo;nombre;telefono;email;dato1;dato2
    public boolean guardar(ArrayList<Contacto> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, false))) {
            for (Contacto c : lista) {
                writer.write(c.toCSV());   // polimorfismo: cada hijo arma su línea
                writer.newLine();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    // Lee el archivo y crea la subclase correcta según el tipo
    public ArrayList<Contacto> cargar() {
        ArrayList<Contacto> lista = new ArrayList<>();
        File archivo = new File(ruta);

        if (!archivo.exists()) {
            return lista;   // la primera vez no hay archivo
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] p = linea.split(";", -1);
                if (p.length < 6) {
                    continue;   // línea incompleta, se ignora
                }
                if (p[0].equals("Personal")) {
                    lista.add(new ContactoPersonal(p[1], p[2], p[3], p[4]));
                } else if (p[0].equals("Trabajo")) {
                    lista.add(new ContactoTrabajo(p[1], p[2], p[3], p[4], p[5]));
                }
            }
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        }
        return lista;
    }
}
