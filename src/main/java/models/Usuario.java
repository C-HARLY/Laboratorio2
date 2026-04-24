/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;


public class Usuario {

    public static ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public static void setListaUsuario(ArrayList<Usuario> aListaUsuario) {
        listaUsuario = aListaUsuario;
    }
    
    //creamos los usuarios
    private String userName;
    private String password;
    private String rol;
    private boolean activo;
    private int intentos = 0;
    private boolean debeCambiarPass; 
    
    //aqui guardamos los usuarios de momento
     private static ArrayList<Usuario> listaUsuario = new ArrayList<>();  
     
    
    //constructor
     
    public Usuario(String userName, String password, String rol ){
        this.userName = userName;
        this.password = password;
        this.rol = rol;
        this.activo =  true;
        this.debeCambiarPass = true; 
    };
    
   public static void UsuarioDef(){
       if(listaUsuario.isEmpty()){
          listaUsuario.add(new Usuario("Cjuarez", "Umariano24", "ADMIN"));
          listaUsuario.add(new Usuario("Ctomas", "Umariano24", "USER"));
          listaUsuario.add(new Usuario("Tzun", "Umariano24", "USER"));
          listaUsuario.add(new Usuario("Mperez", "Umariano24", "USER"));
          listaUsuario.add(new Usuario("Asantizo", "Umariano24", "USER"));
       }
   }
   
    public boolean isDebeCambiarPass() { return debeCambiarPass; }
    public void setDebeCambiarPass(boolean debeCambiarPass) { this.debeCambiarPass = debeCambiarPass; }
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
   
   public static String login(String user, String pass) {
    for (Usuario u : listaUsuario) {
        // 1. Buscamos al usuario (ignorar mayúsculas/minúsculas en el nombre)
        if (u.getUserName().equalsIgnoreCase(user)) {
            
            // 2. ÚNICA VALIDACIÓN DE ESTADO: 
           
            if (!u.isActivo()) {
                return "EL USUARIO SE ENCUENTRA INACTIVO O BLOQUEADO";
            }

            // 3. Validación de la contraseña (esta sí debe ser exacta)
            if (u.getPassword().equals(pass)) {
                u.setIntentos(0); // Éxito: Limpiamos historial de fallos
                return "LOGEADO EXITOSAMENTE";
            } else {
                u.setIntentos(u.getIntentos() + 1);
                
                //bloquear usuario
                if (u.getIntentos() >= 3) {
                    u.setActivo(false); 
                    return "USUARIO BLOQUEADO";
                }
                return "CONTRASEÑA INCORRECTA";
            }
        }
    }
    return "Usuario No encontrado"; 
    }
}
