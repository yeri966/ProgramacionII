package co.edu.uniquindio;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Usuario> usuarios;
    private List<BilleteraVirtual> billeteras;

    public Banco() {
        this.usuarios = new ArrayList<>();
        this.billeteras = new ArrayList<>();
    }


    public void agregarUsuario(String nombre, String direccion, String identificacion,String email,String contrasena){
        usuarios.add(new Usuario(nombre,direccion,identificacion,email,contrasena)) ;
 }

 public Usuario autenticarUsuario(String identificacion, String contrasena){
        for(Usuario usuario : usuarios){
            if (usuario.validarCredenciales(identificacion,contrasena)){
                return usuario;
            }
        }
        throw new IllegalArgumentException("Credenciales no encontradas");
 }
}
