/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;
import java.io.*;

/**
 *
 * @author Gustalex
 */
public class AbrirModificarGuardarLaberinto 
{
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    
    public AbrirModificarGuardarLaberinto()
    {
        
    }
   
    public String AbrirATexto(File archivo)//abrir u archivo de texto
    {
        String contenido="";//variable donde se almacena informacion de el txt
        try
        {
            entrada = new FileInputStream(archivo); //instanciar flujo de entrada
            int ascci;
            while((ascci = entrada.read())!=-1)
            {
                char caracter =(char)ascci;
                contenido+= caracter;//llena de caracteres el archivo 
            }
        }
        catch(Exception e)
        {
                    
        }
        return contenido;
        
        }
    
        //crear metodo para guardar archivo de texto
        public String GuardarATexto(File archivo, String contenido)
        {
            String respuesta=null;
            try
            {
                salida = new FileOutputStream(archivo);
                byte[] bytesTxt = contenido.getBytes();
                salida.write(bytesTxt);
                respuesta ="Se guardo con exito archivo";
            }
            catch(Exception e)
                    {
                        
                    }
            return respuesta;
    }
    
}
           

