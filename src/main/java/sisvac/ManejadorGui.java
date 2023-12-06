package sisvac;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import sisvac.gui.BloqueFactory;


import sisvac.gui.BloqueInBuscador;
import sisvac.gui.BloqueInEmpleado;
import sisvac.gui.BloqueInVacaciones;
import sisvac.gui.BloqueInColaboradores;
import sisvac.gui.BloqueInLogin;
import sisvac.gui.Header;
import sisvac.gui.Bloque;

public class ManejadorGui {
 
    private static ManejadorGui instance;
    private JFrame frame;
    private JScrollPane contentPanel; // Panel donde se mostrarán las vistas
    private JPanel headerPanel; // Panel donde se mostrarán las vistas

    private ManejadorGui() {
        // Constructor privado para evitar instanciación directa
    }

    public static ManejadorGui getInstance() {
        if (instance == null) {
            instance = new ManejadorGui();
        }
        return instance;
    }

    public void inicializar() {
        //La principal JFRAME
        frame = new JFrame("Sistema Programacion Vacaciones V0.001 beta");
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
        
        BloqueFactory bloqueFactory = new BloqueFactory();
        Bloque boxEmpleado;
        Bloque boxVacaciones, boxBuscador, boxColaboradores, boxLogin;
        switch (userType) {
            
            case "colaborador":
                //Bloque informacion del empleado
                boxEmpleado = bloqueFactory.getBloque("empleado");
                boxEmpleado.initialize();
                vista.add(boxEmpleado.getViewPanel());
                
                //Bloque vacaciones del empleado
                boxVacaciones = bloqueFactory.getBloque("vacaciones");
                boxVacaciones.initialize();
                vista.add(boxVacaciones.getViewPanel() );
                break;
                
            case "visor":
                //Bloque buscador
                boxBuscador = bloqueFactory.getBloque("buscador");
                boxBuscador.initialize();
                vista.add(boxBuscador.getViewPanel() );
                
                //Bloque informacion del empleado
                boxEmpleado = bloqueFactory.getBloque("empleado");
                boxEmpleado.initialize();
                vista.add(boxEmpleado.getViewPanel());
                
                //Bloque vacaciones del empleado
                boxVacaciones = new BloqueInVacaciones();
                boxVacaciones.initialize();
                vista.add(boxVacaciones.getViewPanel() );
                
                break;
            case "jefe":
                 //Bloque informacion del empleado
                boxEmpleado = bloqueFactory.getBloque("empleado");
                boxEmpleado.initialize();
                vista.add(boxEmpleado.getViewPanel());
                
                //Bloque vacaciones del empleado
                boxVacaciones = bloqueFactory.getBloque("vacaciones");
                boxVacaciones.initialize();
                vista.add(boxVacaciones.getViewPanel() );
                
                //Colaboradores del empleado
                boxColaboradores =  bloqueFactory.getBloque("colaboradores");
                boxColaboradores.initialize();
                vista.add(boxColaboradores.getViewPanel() );
                break;
                
            case "editor":
                
                //Colaboradores del empleado
                boxColaboradores =  bloqueFactory.getBloque("colaboradores");
                boxColaboradores.initialize();
                vista.add(boxColaboradores.getViewPanel() );
                break;
            
            case "login":
            default:
                mostrarHeader = false;
                //Bloque Login
                boxLogin =  bloqueFactory.getBloque("login");
                boxLogin.initialize();
                vista.add(boxLogin.getViewPanel() );
                break;
        }
        
   
        
         
        System.out.println("mostrasr: "+userType);
        contentPanel.getViewport().removeAll();
        headerPanel.removeAll();
        
        //condicion para imprimir Cabecera
        if (mostrarHeader) {
            JPanel headerBox2 = new Header();
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

    public void showView(Bloque view, boolean printHeader) {
        // Limpiar el contenido actual y mostrar el nuevo panel de vista 
        contentPanel.getViewport().removeAll();
        headerPanel.removeAll();
        
        //condicion para imprimir Cabecera
        if (printHeader) {
            JPanel headerBox2 = new Header();
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
    public JFrame getFrame() {
        return frame;
    }

}