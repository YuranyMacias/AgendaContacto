package agenda;

public class ContactoTrabajo extends Contacto {
    private String empresa, puesto;

    public ContactoTrabajo(String nombre, String telefono, String email, String empresa, String puesto) {
        super(nombre, telefono, email);
        this.empresa = empresa;
        this.puesto = puesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String getTipo() {
        return "Trabajo";
    }

    @Override
    public String getDetalle() {
        return "Empresa: " + empresa + " - Puesto: " + puesto;
    }

    @Override
    public String toCSV() {
        return "Trabajo;" + limpiar(nombre) + ";" + limpiar(telefono) + ";"
                + limpiar(email) + ";" + limpiar(empresa) + ";" + limpiar(puesto);
    }
}
