/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadordepersonas;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Isaac Huertas
 */
public class GeneradorDePersonas {

    private static  String[] nombresDeHombre = {"Sergio", "Jose", "Juan Isaac", "David", 
                                    "Carlos", "Pablo", "Diego", "Daniel", "Alejandro"};
    private static String[] nombresDeMujer = {"Silvia", "Raquel", "Marta", "Lourdes", 
                                   "Eva", "Sara", "Paula", "Maria", "Laura", "Helena"};
        
    private static String[] apellidos = {"Gonzalez", "Rodiguez", "Gomez", "Fernandez", "Huertas", "Trujillo", 
                              "Diaz", "Perez", "Garcia", "Suarez", 
                              "Torrez","Medina", "Lopez","Ruiz","Silva", 
                              "Santafosta","Jimenez","Castillo","Muñoz","Villalba"};
    private static final String CADENA = "TRWAGMYFPDXBNJZSQVHLCKE";
    private static List<Persona> listaPeronsas = new ArrayList<Persona>();
    private static Persona p;
    
    public static void main(String[] args) {
  
        String file = "personas.csv";
        boolean existe = new File(file).exists();
        
        if(existe){
            File filePersonas = new File(file);
            filePersonas.delete();
        }
        generarPersonas();
        try {
            CsvWriter csvOutput = new CsvWriter(new FileWriter(file, true), ',');
            
            csvOutput.write("Nombre");
            csvOutput.write("Apellidos");
            csvOutput.write("Genero");
            csvOutput.write("DNI");
            csvOutput.endRecord();
            
            for(int i = 0;i<10;i++){
                generarPersonas();
                csvOutput.write(listaPeronsas.get(i).getNombre());
                csvOutput.write(listaPeronsas.get(i).getApellidos());
                csvOutput.write(listaPeronsas.get(i).getGenero());
                csvOutput.write(listaPeronsas.get(i).getDni());
                csvOutput.endRecord();
            }
            csvOutput.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(GeneradorDePersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String generarHombres(){
        String nombre = "";
        String apellido1 = "";
        String apellido2 = "";
        String apellidosHombre = "";
        for (int i = 0;i< nombresDeHombre.length +1;i++){
            int nombreAleatorio = (int) (Math.random() * nombresDeHombre.length);
            nombre = nombresDeHombre[nombreAleatorio]+ ""; 
        }
       
        return nombre;
    }
    
        public static String generarMujeres(){
        String nombre = "";
        String apellido1 = "";
        String apellido2 = "";
        String apellidosMujer = "";
        for (int i = 0;i< nombresDeMujer.length +1;i++){
            int nombreAleatorio = (int) (Math.random() * nombresDeMujer.length);
            nombre = nombresDeMujer[nombreAleatorio]+ "";      
        } 
        return nombre;
    }
    
    public static String generarApellidos(){
        String apellido1 = "";
        String apellido2 = "";
        String apellidoCompleto = "";
        
        for (int j = 0; j< apellidos.length;j++){
                int apellidoAleatorio1 = (int) (Math.random() * apellidos.length);
                apellido1 = apellidos[apellidoAleatorio1] + "";
                //System.out.println(apellidosPersonas);
                for(int k = 0; k< apellidos.length;k++){
                    int apellidoAleatorio2 = (int) (Math.random() * apellidos.length);
                    apellido2 = apellidos[apellidoAleatorio2] +"";
                    apellidoCompleto= apellido1 + " " + apellido2;
                }
            }
        
        return apellidoCompleto;
    }    
        
    public static String generarDNI(){
        int numeroDNI = (int) (Math.random() * 99999999);
        String letra = CADENA.charAt(numeroDNI % 23)+ "";
        //System.out.println(numeroDNI + letra);
        String dni =  numeroDNI +letra + "";
        return dni;
    }
    
    public static void generarPersonas(){
        int dado = (int) Math.round(Math.random()) ;
        String nombre = "";
        String apellido = "";
        String dni = "";
        String genero = "";
        
        
            if(dado == 1){
                    nombre = generarHombres();
                    apellido = generarApellidos();
                    dni = generarDNI();
                    genero = "Hombre";
                    p = new Persona(nombre, apellido, dni, genero);
                    listaPeronsas.add(p);
                    //System.out.println(p.toString());
            }else {  
                    nombre = generarMujeres();
                    apellido = generarApellidos();
                    dni = generarDNI();
                    genero = "Mujer";
                    p = new Persona(nombre, apellido, dni, genero);
                    listaPeronsas.add(p);
                    //System.out.println(p.toString());
            }
    }
}
   
    

