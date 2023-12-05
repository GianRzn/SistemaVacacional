package sisvac.app.gui;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.border.LineBorder;

public class GestorGui {
 
    private static GestorGui instance;
    private JFrame frame;
    private JScrollPane contentPanel; // Panel donde se mostrarán las vistas
    private JPanel headerPanel; // Panel donde se mostrarán las vistas

    private GestorGui() {
        // Constructor privado para evitar instanciación directa
    }

    public static GestorGui getInstance() {
        if (instance == null) {
            instance = new GestorGui();
        }
        return instance;
    }

    public void initializeMainFrame() {
        //La principal JFRAME
        frame = new JFrame("BorderLayout with JScrollPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        // JPanel Contenedores  : Central y Norte
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
        scrollPanel.add(new JLabel("Contenido " ));
        
        contentPanel = new JScrollPane( scrollPanel );
        contentPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        contentPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        centerPanel.add(contentPanel, BorderLayout.CENTER);

        // Agregar el panel en el norte y centro al BorderLayout
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        headerPanel = new JPanel();
        //headerPanel.setBorder(new LineBorder(Color.RED, 5));
        headerPanel.setLayout(new BorderLayout());

        frame.add(headerPanel, BorderLayout.NORTH); 
    }

    
    public void mostrarPanel(String userType) {
        
        
        JPanel vista = new JPanel();
        vista.setLayout(new BoxLayout(vista, BoxLayout.Y_AXIS));
        boolean mostrarHeader = true;
        
        BloqueLogin boxLogin;
        BloqueABuscador boxBuscador;
        BloqueAEmpleado boxEmpleado;
        BloqueBVacaciones boxVacaciones;
        BloqueCColaboradores boxColaboradores ;
        switch (userType) {
            
                
            case "colaborador":
                //Bloque informacion del empleado
                boxEmpleado = new BloqueAEmpleado();
                boxEmpleado.initialize();
                vista.add(boxEmpleado.getViewPanel());
                
                //Bloque vacaciones del empleado
                boxVacaciones = new BloqueBVacaciones();
                boxVacaciones.initialize();
                vista.add(boxVacaciones.getViewPanel() );
                break;
                
            case "visor":
                 //Bloque buscador
                boxBuscador = new BloqueABuscador();
                boxBuscador.initialize();
                vista.add(boxBuscador.getViewPanel() );
                
                //Bloque informacion del empleado
                boxEmpleado = new BloqueAEmpleado();
                boxEmpleado.initialize();
                vista.add(boxEmpleado.getViewPanel());
                
                //Bloque vacaciones del empleado
                boxVacaciones = new BloqueBVacaciones();
                boxVacaciones.initialize();
                vista.add(boxVacaciones.getViewPanel() );
                
                break;
            case "jefe":
                 //Bloque informacion del empleado
                boxEmpleado = new BloqueAEmpleado();
                boxEmpleado.initialize();
                vista.add(boxEmpleado.getViewPanel());
                
                //Bloque vacaciones del empleado
                boxVacaciones = new BloqueBVacaciones();
                boxVacaciones.initialize();
                vista.add(boxVacaciones.getViewPanel() );
                
                //Colaboradores del empleado
                 boxColaboradores = new BloqueCColaboradores();
                boxColaboradores.initialize();
                vista.add(boxColaboradores.getViewPanel() );
                break;
                
            case "editor":
                
                //Colaboradores del empleado
                boxColaboradores = new BloqueCColaboradores();
                boxColaboradores.initialize();
                vista.add(boxColaboradores.getViewPanel() );
                break;
            
            case "login":
            default:
                mostrarHeader = false;
                //Bloque Login
                boxLogin = new BloqueLogin( instance);
                boxLogin.initialize();
                vista.add(boxLogin.getViewPanel() );
                break;
        }
        
   
        
        
      
        
        
        
        
        
         
        
        /*switch (userType){
            case "colaborador" -> { 
               
               // todosBloques.add(boxEmpleado );
            }
            default -> { 
                boolean mostrarHeader = false;
                GestorGuiVista vista = new GestorGuiVistaLogin(instance);
            }
        }*/
     //   showView(vista, mostrarHeader);
              
        System.out.println("mostrasr: "+userType);
        contentPanel.getViewport().removeAll();
        headerPanel.removeAll();
        
        //condicion para imprimir Cabecera
        if (mostrarHeader) {
            JPanel headerBox2 = new Header("frank");
            //headerBox2.setBorder(new LineBorder(Color.PINK, 5));

            headerPanel.add(headerBox2);
            //headerPanel.getRootPane().setBorder(new LineBorder(Color.GREEN, 5));
        }
        
        //condicion para imprimir abecera
        //JPanel contPanel = view.getViewPanel(); 
        contentPanel.setViewportView( vista);
        frame.revalidate();
        frame.repaint();
           
        System.out.println("se intentó inetgrar el login,");
      
        
    }

    private void showView(Bloque view, boolean printHeader) {
        // Limpiar el contenido actual y mostrar el nuevo panel de vista 
        contentPanel.getViewport().removeAll();
        headerPanel.removeAll();
        
        //condicion para imprimir Cabecera
        if (printHeader) {
            JPanel headerBox2 = new Header("frank");
            //headerBox2.setBorder(new LineBorder(Color.PINK, 5));

            headerPanel.add(headerBox2);
            //headerPanel.getRootPane().setBorder(new LineBorder(Color.GREEN, 5));
        }
        
        //condicion para imprimir abecera
        JPanel contPanel = view.getViewPanel(); 
        contentPanel.setViewportView( contPanel);
        frame.revalidate();
        frame.repaint();
           
        System.out.println("se intentó inetgrar el login,");
    }

    public void showFrame() {
        frame.setVisible(true);
    }

}