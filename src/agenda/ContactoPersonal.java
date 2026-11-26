package agenda;

public class ContactoPersonal extends Contacto {
    private String cumpleanos;

    public ContactoPersonal(String nombre, String telefono, String email, String cumpleanos) {
        super(nombre, telefono, email);
        this.cumpleanos = cumpleanos;
    }

    public String getCumpleanos() {
        return cumpleanos;
    }

    public void setCumpleanos(String cumpleanos) {
        this.cumpleanos = cumpleanos;
    }

    @Override
    public String getTipo() {
        return "Personal";
    }

    @Override
    public String getDetalle() {
        return "Cumpleaños: " + cumpleanos;
    }

    @Override
    public String toCSV() {
        return "Personal;" + limpiar(nombre) + ";" + limpiar(telefono) + ";"
                + limpiar(email) + ";" + limpiar(cumpleanos) + ";";
    }
}
