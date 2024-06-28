public class Item {
    String negocio;
    String nombre;
    String direccion;
    String ciudad;
    String estado;
    int codigoPostal;
    double latitud;
    double longitud;

    public Item(String negocio, String nombre, String direccion, String ciudad, String estado, int codigoPostal, double latitud, double longitud) {
        this.negocio = negocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Item{" +
                "negocio='" + negocio + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
