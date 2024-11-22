package utils;

public class Menus {

    public static void menuPrincipal(String nombre){
        System.out.printf("""
                ¡BIENVENIDO %s!
                *********************
                1. Ver catálogo
                2. Crear pedido
                3. Ver perfil
                4. Modificar perfil
                5. Salir
                **********************
                """, nombre);
    }
}
