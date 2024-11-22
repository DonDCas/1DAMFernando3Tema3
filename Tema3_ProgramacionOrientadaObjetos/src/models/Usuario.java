package models;

import java.util.Locale;

public class Usuario {

    //Atributos (no son Variables, el orden en el que se desglosan importan)
    String dni;
    String nombre;
    String email;
    String clave;
    char sexo;

    //Métodos
    /*boolean validaClave(String claveTeclado){
     return clave.equals(claveTeclado);
    }*/  //NO SE SUELE HACER ASÍ

/*    boolean validaClave(String clave){
        return this.clave.equals(clave); //siendo el atributo con el this el de la clase.
    }*/

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre.toLowerCase();
    }

    public String getSexo() {
        if (sexo == 'M') return "Mujer";
        if (sexo == 'H') return "Hombre";
        return "Indeterminado";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public boolean setDni(String dni) {
        // Primero valido el dni
        if (dni.length() != 9) return false;
        this.dni = dni;
        return true;
    }

    public String getDni() {
        return dni;
    }


    //EJERCICIO CALIENTE: Crea el set clave para que valide que la clave tenga como minimo 6 caract y como maximo 10
    // , contenga una letra minuscula como minimo, contenga una letra mayuscula como minimo, un número como mínimo y
    // un caracter que sea . - + o *. A la hora de pintar el usuario la clave no debe de aparecer como texto, debe de
    // aparecer con asteriscos.

    public boolean setClave(String clave) {
        if (!validaClave(clave)) return false;
        this.clave = clave;
        return  true;
    }

     public static boolean validaClave(String clave){
        // Primero validamos la longitud:
        if (clave.length() < 6 || clave.length() > 10) return false;
        // Después validamos si tienen mayúsculas y minúsculas:
        if (clave.equals(clave.toUpperCase()) || clave.equals(clave.toLowerCase())) return false;
        // A continuación validamos que tengan números:
        boolean claveValida = false;
        for (int i = 0; i < clave.length(); i++) {
            if (Character.isDigit(clave.charAt(i))){
                claveValida = true;
                i = clave.length(); //rompemos el bucle
            }
        }
        if (!claveValida) return false;
        // Finalmente valido si tiene alguno de los caracteres ". + * -"
        claveValida = clave.contains(".") || clave.contains("+") || clave.contains("*") || clave.contains("-");
        if (!claveValida) return false;
        return true;
    }

    public String getClave() {
        //GENERAR ASTERISCOS
        return "*".repeat(clave.length());
    }




    // ToString:
    public String pintaUsuario(){
        String resultado = "";
        resultado += "*********************" + "\n";
        resultado += "Nombre: " + nombre + "\n";
        resultado += "DNI: " + dni + "\n";
        resultado += "Email: " + email + "\n";
        resultado += "Sexo: " + getSexo() + "\n";
        resultado += "Clave: " + getClave() + "\n";
        resultado += "*********************";

        return resultado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", clave='" + clave + '\'' +
                ", sexo=" + sexo +
                '}';
    }



}
