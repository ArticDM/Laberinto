/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

/**
 *
 * @author Casa
 */
public class nodo 
{
    public int x_ini; //fila
    public int y_ini; //columna
    public boolean visitado;
    
    nodo(int fil, int colu)
    {
        this.x_ini = fil;
        this.y_ini = colu;
        
        this.visitado = false;
        
        nodo sig;
        
    }
    
}
