package agenda;

public abstract class Contacto {
    protected String nombre, telefono, email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Cada hijo dice qué tipo de contacto es
    public abstract String getTipo();

    // Cada hijo muestra sus datos propios
    public abstract String getDetalle();

    // Cada hijo arma su línea para el archivo CSV
    public abstract String toCSV();

    // Quita el ; del texto para no dañar el formato del CSV
    protected String limpiar(String texto) {
        return texto.replace(";", ",");
    }
}
