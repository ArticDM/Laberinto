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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.concurrent.ThreadLocalRandom;

import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;

import java.util.LinkedList;
import java.util.Queue;


import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Grid extends JPanel 
{

    public int fila, columna;
    public int opcion;
    public static int boton;
    public int i=0,j=0;

    private int gridRows;
    private int gridCols;
    private Color[][] gridColor;
    private Color lineColor;

    public int number1= ThreadLocalRandom.current().nextInt(4, 15 + 1);
    public int number2= ThreadLocalRandom.current().nextInt(4, 15 + 1);
    
    int inicio_x;
    int inicio_y;
    int fin_x;
    int fin_y;
    
    
    
    public Grid(int btn)
    {
        this.boton= btn;
        
    }
    
    public Grid(int rows, int columns, int preferredSquareSize) 
    {
        gridColor = new Color[rows][columns];
        gridRows = rows;
        gridCols = columns;
        lineColor = Color.BLACK;
        setPreferredSize(new Dimension(preferredSquareSize * columns, preferredSquareSize * rows));
   
    }
    
    
    
    public void aleatorio()
    {
         //Esto es para modo aleatorio********************
        
        /*
        int numero1 = (int) (Math.random() * 50);
        int numero2 = (int) (Math.random() * 50);
        */
        
        //************************************************
        
        JFrame marco;
        marco = new JFrame("Laberinto");
        Grid content = new Grid(number1, number2, 30);
        marco.setContentPane(content);
        marco.pack();
        Dimension screenSize;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int top, left;
        
        /*
        left = (screenSize.width - marco.getWidth()) / 2;
        top = (screenSize.height - marco.getHeight()) / 2;
        */
        
        left = (screenSize.width - marco.getWidth()) / 8;
        top = (screenSize.height - marco.getHeight()) /2;
        
        marco.setLocation(left, top);
        marco.setResizable(false);
        marco.setVisible(true);
    }
    
    public void hacer_ventana()
    {
            
        int fila=0,columna=0;
        
         
         try
         {
            FileReader archivo =new FileReader("E:\\Verano\\Grid - copia - copia\\src\\grid\\laberinto_t1.txt");

            //BufferedReader buffer = new BufferedReader(archivo);

            int caract= archivo.read();

            while(caract != 10)
            {

               if(caract=='0' || caract=='1') columna++;

               caract = archivo.read();
            }

            
            archivo.close();
            
            System.out.println(columna);

            FileReader archivo2 =new FileReader("E:\\Verano\\Grid - copia - copia\\src\\grid\\laberinto_t1.txt");

            caract= archivo2.read();

            while (caract != -1)
            {
                  if(caract == 10) fila++;
                  caract = archivo2.read();

            }
            archivo2.close();
            
            System.out.println(fila);

            //caract = archivo.
            //ancho = columnas
            //alto = filas

            
            //Obtener matrix ******************************************************
            char[][] laberinto = new char[fila][columna];
            
            System.out.println(laberinto.length);

            FileReader matrix =new FileReader("E:\\Verano\\Grid - copia - copia\\src\\grid\\laberinto_t1.txt");

            int dato= matrix.read();

            while(dato != -1)
            {
                
                       if(dato=='0' || dato=='1')
                       {
                           System.out.print("if");
                           
                           laberinto [i][j]= (char)dato;
                           j++;
                           
                           System.out.print("laberinto");
                       }
                       
                       if(dato == 10)
                       {
                           i++;
                           j=0;
                       }
                       
                       dato = matrix.read(); //continuar con el siguiente caracter y reinicia el ciclo del while

            }


            matrix.close();

            //*********************************************************************/
            
            //Verificar si la matriz se lleno bien
            
            for(i=0; i<fila; i++)
            {
                for(j=0; j<columna; j++)
                {
                    System.out.print(laberinto[i][j]);
                }
                
                System.out.println("\n");
            }
            
            
            //***************************
         
         
         }
                
         catch(Exception e)
         {
         System.out.println("Error de lectura del fichero");
         }
 
        JFrame marco;
        marco = new JFrame("Laberinto");
        Grid content = new Grid(fila, columna, 30);
        marco.setContentPane(content);
        marco.pack();
        Dimension screenSize;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int top, left;
        
        left = (screenSize.width - marco.getWidth()) / 8;
        top = (screenSize.height - marco.getHeight()) / 2;
        
        marco.setLocation(left, top);
        marco.setResizable(false);
        marco.setVisible(true);
        
    }
    
  
    public void BSM()
    {
        
        System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡BSM!!!!!!!!!!!!!!!");
        
        int fila=0,columna=0;
        
         
         try
         {
            FileReader archivoA =new FileReader("E:\\Verano\\Grid - copia - copia\\src\\grid\\laberinto_t1.txt");

            //BufferedReader buffer = new BufferedReader(archivo);

            int caract= archivoA.read();

            while(caract != 10)
            {

               if(caract=='0' || caract=='1') columna++;

               caract = archivoA.read();
            }

            
            archivoA.close();
            
            System.out.println(columna);

            FileReader archivoB =new FileReader("E:\\Verano\\Grid - copia - copia\\src\\grid\\laberinto_t1.txt");

            caract= archivoB.read();

            while (caract != -1)
            {
                  if(caract == 10) fila++;
                  caract = archivoB.read();

            }
            archivoB.close();
            
            System.out.println(fila);

            //caract = archivo.
            //ancho = columnas
            //alto = filas

            
            //Obtener matrix ******************************************************
            
            i=0;
            j=0;
            
            char[][] laberinto2 = new char[fila][columna];
            
            System.out.println(laberinto2.length);

            FileReader matrixB =new FileReader("E:\\Verano\\Grid - copia - copia\\src\\grid\\laberinto_t1.txt");

            int dato= matrixB.read();

            while(dato != -1)
            {
                
                       if(dato=='0' || dato=='1')
                       {
                           
                           laberinto2 [i][j]= (char)dato;
                           j++;
                       }
                       
                       if(dato == 10)
                       {
                           i++;
                           j=0;
                       }
                       
                       dato = matrixB.read(); //continuar con el siguiente caracter y reinicia el ciclo del while

            }


            matrixB.close();

            //*********************************************************************/
            
            //Verificar si la matriz se lleno bien
            
            System.out.println("Datos en LABERINTO 2");
            
            for(i=0; i<fila; i++)
            {
                for(j=0; j<columna; j++)
                {
                    System.out.print(laberinto2[i][j]);
                }
                
                System.out.println("\n");
            }
            
            
            //***************************
            
            System.out.println(laberinto2.length);
            /*

            int [] actual= new int[2];
            actual = inicio;

            */
        
            //***************************
            //  METE INICIOY FIN 
            
            inicio_x= 0;
            inicio_y= 0;
            
            
            fin_x= 4;
            fin_y= 10;
            
            //***************************
        
            nodo actual= new nodo(inicio_x, inicio_y);
            nodo padre;
            //***************
            
            Queue cola = new LinkedList();

            cola.add(actual);

            padre= actual;
            
            

            //****************

            DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Raiz");
            DefaultTreeModel modelo = new DefaultTreeModel(raiz);
            JTree tree = new JTree(modelo);
        
        
            while((padre.x_ini != fin_x && padre.y_ini != fin_y) || (cola != null))
            {

                //arriba************************************************************
                if(padre.x_ini -1 >= 0)
                {
                    if(laberinto2[padre.x_ini-1][padre.y_ini] == '1')
                    {
                        //list.add();
                        DefaultMutableTreeNode hijo = new DefaultMutableTreeNode("hijo");

                        if(padre.visitado == false)
                        {
                            nodo hijo1= padre;
                            hijo1.x_ini= padre.x_ini-1;
                            hijo1.y_ini= padre.x_ini;

                            cola.add(hijo1);
                        }

                    }
                }


                //derecha************************************************************
                if(padre.y_ini +1 < 4)
                {
                    if(laberinto2[padre.x_ini][padre.y_ini+1] == '1')
                    {
                        //list.add();
                        DefaultMutableTreeNode hijo = new DefaultMutableTreeNode();

                        if(padre.visitado == false)
                        {
                            nodo hijo2= padre;
                            hijo2.x_ini= padre.x_ini-1;
                            hijo2.y_ini= padre.x_ini;

                            cola.add(hijo2);
                        }

                    }
                }


                //abajo************************************************************
                if(padre.x_ini +1 < 4)
                {
                    if(laberinto2[padre.x_ini+1][padre.y_ini] == '1')
                    {
                        //list.add();
                        DefaultMutableTreeNode hijo = new DefaultMutableTreeNode();

                        if(padre.visitado == false)
                        {
                            nodo hijo3= padre;
                            hijo3.x_ini= padre.x_ini-1;
                            hijo3.y_ini= padre.x_ini;

                            cola.add(hijo3);
                        }

                    }
                }


                //izq************************************************************
                if(padre.y_ini -1 > 0)
                {
                    if(laberinto2[padre.x_ini][padre.y_ini-1] == '1')
                    {
                        //list.add();
                        DefaultMutableTreeNode hijo = new DefaultMutableTreeNode();

                        if(padre.visitado == false)
                        {
                            nodo hijo4= padre;
                            hijo4.x_ini= padre.x_ini-1;
                            hijo4.y_ini= padre.x_ini;

                            cola.add(hijo4);
                        }

                    }
                }

                //******************************************************************
                padre.visitado= true;

                cola.remove(padre);

            }
         
         
         }
                
         catch(Exception e)
         {
         System.out.println("Error de lectura del fichero");
         }
       
    }
    

   public void actualizarPantalla()
   {
        SwingUtilities.updateComponentTreeUI(this);
        this.validateTree();
   } 

    public void paintComponent(Graphics g) 
    {
 
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, getWidth(), getHeight());

        int row, col;
        
        double cellWidth = (double) getWidth() / gridCols;
        double cellHeight = (double) getHeight() / gridRows;
      
        
        if (boton==1)   
        {
            
            try
            {
                        row=0;
                        col=-1;
                        
                        FileReader archivo3 =new FileReader("E:\\Verano\\Grid - copia - copia\\src\\grid\\laberinto_t1.txt");
                        int caract= archivo3.read();
                        
                        while (caract != -1)
                        {
                                if(caract == 10)
                                {
                                    col=-1;
                                    row++;
                                }
                                  if(caract=='0' || caract=='1') col++;
                                  
                                  if(caract == '1')
                                  {
                                      int x1 = (int) (col * cellWidth);
                                       int y1 = (int) (row * cellHeight);
                                       int x2 = (int) ((col + 1) * cellWidth);
                                       int y2 = (int) ((row + 1) * cellHeight);
                                       g.setColor(Color.white);
                                       g.fillRect(x1, y1, (x2 - x1), (y2 - y1));
                                  }
                                  
                                  if(caract == '0')
                                  {
                                       int x1 = (int) (col * cellWidth);
                                       int y1 = (int) (row * cellHeight);
                                       int x2 = (int) ((col + 1) * cellWidth);
                                       int y2 = (int) ((row + 1) * cellHeight);
                                       g.setColor(Color.blue);
                                       g.fillRect(x1, y1, (x2 - x1), (y2 - y1));

                                  }

                                  caract = archivo3.read();

                        }
                        
                        archivo3.close();
            }
            
            catch(Exception e)
            {
                System.out.println("Error de lectura del fichero");
            }
        }
        
        char [][] matrix_aleatorio= new char [gridRows][gridCols];
        
        if(boton == 2)
        {
                int color;
         
                for (row = 0; row < gridRows; row++) 
                {
                    for (col = 0; col < gridCols; col++) 
                    {
                        if (gridColor[row][col] == null) 
                        {
                            int x1 = (int) (col * cellWidth);
                            int y1 = (int) (row * cellHeight);
                            int x2 = (int) ((col + 1) * cellWidth);
                            int y2 = (int) ((row + 1) * cellHeight);

                            color = (int) (Math.random() * 4);

                            if (color == 0) 
                            {
                                g.setColor(Color.red);
                                g.fillRect(x1, y1, (x2 - x1), (y2 - y1));
                                
                                matrix_aleatorio[row][col]= '0';
                            } 
                            
                            else
                            {
                                g.setColor(Color.white);
                                g.fillRect(x1, y1, (x2 - x1), (y2 - y1));
                                
                                matrix_aleatorio[row][col]= '1';
                            }

                        }
                    }
                }
                
                //**********************************
                
                System.out.println("AQUI EMPIEZA!!!");
                
                for(i=0; i<gridRows; i++)
                {
                    for(j=0; j<gridCols; j++)
                    {
                        System.out.print( matrix_aleatorio[i][j]);
                    }

                    System.out.println("\n");
                }
                
        }
        
        
        
        
        //*********************************************************************
        //Pintar lineas
        
        if (lineColor != null) 
        {
            g.setColor(lineColor);

            for (row = 1; row < gridRows; row++) 
            {
                int y = (int) (row * cellHeight);
                g.drawLine(0, y, getWidth(), y);
            }

            for (col = 1; col < gridCols; col++) 
            {
                int x = (int) (col * cellWidth);
                g.drawLine(x, 0, x, getHeight());
            }
        }
        
        //*********************************************************************
    }

} // end class Grid

