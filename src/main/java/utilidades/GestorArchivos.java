package utilidades;

import modelo.Libro;

import java.io.File;
import java.io.IOException;

public class GestorArchivos {

    public static void guardarImagenLibro(Libro libro, String rutaReal){

        System.out.println("Guardar la imagen del libro: " + libro.getTitulo());
        System.out.println("En una carpeta de la ruta: " + rutaReal);
        // Crear un carpeta para los archivos subidos en rutaReal
        String rutaSubida = rutaReal + "subidas";
        File fileRutaSubida = new File(rutaSubida);
        if(!fileRutaSubida.exists()){
            fileRutaSubida.mkdirs();
        }
        if(libro.getImagen().getSize() > 0){
            String nombreArchivo = libro.getId() + ".jpg";
            try {
                libro.getImagen().transferTo(new File(rutaSubida, nombreArchivo) );
                System.out.println("Archivo movido a: " + rutaSubida);
            } catch (IOException e) {
                System.out.println("No pude mover el archivo a la ruta subidas");
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Se subió un producto sin imagen, no hay problema");
        }
    }

}
