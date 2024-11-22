package view;

import models.Usuario;
import utils.Menus;
import utils.Utils;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Ejemplo1 {
    public static void main(String[] args) {
        var s = new Scanner(System.in);

        Usuario usuario1 = new Usuario(); //usuario1 es un objeto de la clase Usuario
        Usuario usuario2 = new Usuario();
        Usuario usuario3 = new Usuario();

        usuario1.setNombre("Carlos");

        Menus.menuPrincipal(usuario1.getNombre());

        usuario1.setDni("12345678A");

        String claveUsuario = "";

        do {
            System.out.print("Intruduzca su clave: ");
            claveUsuario = s.nextLine();
        } while (!Usuario.validaClave(claveUsuario));

        usuario1.setClave(claveUsuario);

        System.out.println(usuario1.pintaUsuario());

        Utils.pulsaParaContinuar();
    }
}