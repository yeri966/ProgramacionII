package co.edu.uniquindio;

//Clase usuario que representa un cliente del bacno con sus respectivos atributos

public class Usuario {
    private  String identificacion;
    private String nombre;
    private String direccion;
    private String email;
    private String contrasena;
    private boolean estado;
    private BilleteraVirtual billetera;

    public Usuario( String nombre, String direccion,String identificacion, String email,String contrasena) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.email = email;
        this.contrasena = contrasena;
        this.billetera = new BilleteraVirtual();
    }

    public String getIdentificacion(){
        return identificacion;
    }

    public boolean validarCredenciales(String identificacion,String contrasena){
        return this.identificacion.equals(identificacion) && this.contrasena.equals(contrasena);
    }

    public BilleteraVirtual getBilletera() {
        return billetera;
    }

}
