package agenda;

import java.util.ArrayList;

public class GestorContactos {
    private ArrayList<Contacto> contactos;
    private GestorArchivosCSV archivo;

    public GestorContactos(String usuario) {
        archivo = new GestorArchivosCSV(usuario);
        contactos = archivo.cargar();   // al iniciar, trae lo guardado en contactos.csv
    }

    public void agregarContacto(Contacto c) {
        contactos.add(c);
    }

    public void eliminarContacto(int posicion) {
        contactos.remove(posicion);
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public boolean guardarEnArchivo() {
        return archivo.guardar(contactos);
    }
}
