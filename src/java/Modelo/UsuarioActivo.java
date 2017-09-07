
package Modelo;


public class UsuarioActivo {
    String identificador;
    String clave;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "UsuarioActivo{" + "identificador=" + identificador + ", clave=" + clave + '}';
    }
    
    
}
