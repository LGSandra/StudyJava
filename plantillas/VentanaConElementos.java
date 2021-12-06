import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Academia
 */
public class VentanaConElementos extends JFrame implements ActionListener, KeyListener{
    
    /*
    Aqui definiremos principalmente el aspecto de la ventana.
    
    Crearemos los JPanel, que serán las zonas en las que dividiremos la ventana.
    Añadiremos elementos como botones, campos de tecto, areas de texto...
    Y a esos elementos asociaremos "Listeners", basicamente, el programa estará
    pendiente de las acciones realizadas sobre esos elementos.
    */
    
    //Contenedor de todos los paneles
    Container content = getContentPane();

    //Zona de la ventana en la que los elementos se colocan uno detras de otro y
    //si llegan al borde de la ventana, saltarán a la siguiente "linea".
    JPanel flow = new JPanel(new FlowLayout());
    
    //Zona en la que los elementos tienen una posición fija en una cuadricula. 
    //Si no caben dentro del panel porque se ha cambiado el tamaño de la ventana,
    //pueden pasar dos cosas: que queden "fuera" y no se vean o,
    //si hemos programado correctamente los elementos, mantener posición 
    //reduciendo o aumentando su propio tamaño.
    JPanel grid = new JPanel(new GridLayout());
    
    //Panel sin ningun orden concreto. Se coloca todo uno tras de otro y si se
    // salen del panel o ventana, no se verán.
    JPanel win = new JPanel();
    
    
    //Aqui cargamos una imagen para utilizarla luego. La imagen debe estar en la
    //misma carpeta que el codigo y debe tener ese nombre exacto.
    ImageIcon check = new ImageIcon("icono.png");
    
    //En caso de utilizar un IDE (NEtbeans, etc) podemos usar esto para cargar
    //la imagen. Basicamente, buscaremos la imagen A PARTIR de la ruta donde está
    //el codigo.
    //ImageIcon check = new ImageIcon(getClass().getClassLoader().getResource("check.png"));
    
    
    //Creamos botones con el texto que mostrarán y en el caso del primero, 
    //le aplicamos la imagen antes preparada 
    //Ojo, esto NO MUESTRA LOS BOTONES, tendremos que asociarlos luego a un 
    //Panel.
    JButton btn1 = new JButton("BUTTON 1", check);
    JButton btn2 = new JButton("BUTTON 2");
    JButton btn3 = new JButton("SALIR");
    
    //Esto es un campo de texto, el mismo que usamos para poner nuestro usuario
    // en una web. Entre parentesis pondremos cuantos caracteres nos permitirá ver.
    // Ojo, no son los caracteres maximos que acepta, solo su ancho visual.
    JTextField textField = new JTextField(30);
    
    //Esto es un area de varias lineas de texto. Basicamente, es como el area de
    //escritura de NetBeans o el bloc de notas. 
    //Primer parametro: texto po defecto, lo dejaremos vacio
    //Segundo parametro: las filas, el alto del area
    //Tercer parametro: las columnas, el ancho del area
    JTextArea textArea = new JTextArea("", 10, 40);
    
    //Constructor de nuestra ventana, llamamos a esto en el metodo main
    public VentanaConElementos() {
        //Llamamos al constructor de la clase extendida JFrame para ponerle
        //un titulo a la ventana
        super("My awesome Window");
        
        //Metodos predefinidos de la clase JFrame para configurar cosillas de la
        //ventana
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //Añadimos los elementos que HEMOS CREADO ANTES al panel win
        win.add(btn1);
        win.add(btn2);
        win.add(btn3);
        win.add(textField);
        win.add(textArea);
        
        //CREAMOS Y AÑADIMOS,a la vez, elementos en el panel flow
        flow.add(new JButton("A"));
        flow.add(new JButton("B")); 
        flow.add(new JButton("C")); 
        flow.add(new JButton("D"));
        flow.add(new JButton("E"));
        flow.add(new JButton("F")); 
        flow.add(new JButton("G")); 
        flow.add(new JButton("H"));

        //CREAMOS Y AÑADIMOS, a la vez, elementos en el panel grid
        grid.add(new JButton("1"));
        grid.add(new JButton("2"));
        grid.add(new JButton("3"));
        grid.add(new JButton("4"));

        //Añadimos a la ventana los tres paneles
        //El primer parametro es la zona de la ventana en la que añadimos el panel
        content.add("North", win);
        content.add("Center", flow);
        content.add("South", grid);

        //Asociamos un Listener a tres de los botones que hemos creado, para 
        //controlar cuando los clickamos.
        //Los demas botones en la ventana no harán nada, ya que no tienen un
        //Listener indicado.
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        
        //Asociamos al campo de texto un Listener, para controlar el uso del
        //teclado
        textField.addKeyListener(this);
    }
    
    //Aqui empieza la ejecución del programa como tal. Antes solo hemos declarado
    //como será. Este codigo abre la ventana.
    public static void main(String[] args) {
        VentanaConElementos gui = new VentanaConElementos();
    }
    
    
    // Lo que hay a partir de aqui está relacionado con la palabra "implements"
    //que hemos usado al crear nuestra clase. No entraré en detalles, por ahora
    //simplemente es otra manera de hacer un "extends"
    
    /*
    La clase ActionListener nos obliga a utilizar el metodo:
    actionPerformed()
    
    @Override indica que en la clase original, en este caso ActionListener, ya 
    contiene la funcion que haya a continuacion, pero nosotros haremos nuestra 
    PROPIA implementacion de esa funcion.
    */
    
    //Cuando se realiza una accion sobre un elemento que el programa está controlando
    //Se llamará automaticamente a esta función.
    //En esta función controlaremos los tres botones de antes.
    //La información del evento la tenemos en la variable "event"
    @Override
    public void actionPerformed(ActionEvent event) {
        
        //event.getSource() nos devuelve el elemento SOBRE el que ha ocurrido 
        //algo, en este caso un click. Simplemente lo comparamos con los botones
        //a los que hemos añadido antes el Listener
        
        //Si el evento ha ocurrido sobre el btn1, desactivamos el btn2
        if (event.getSource() == btn1){
            btn2.setEnabled(false);
        }
        
        // Si ha ocurrido sobre el btn2, limpiamos el area de texto y mostramos 
        //una miniventana con un mensaje
        if (event.getSource() == btn2){
            textArea.setText("");
            JOptionPane.showMessageDialog(content, "Esto es un mensaje. Se ha "
                    + "borrado el Area de Texto", "Ventana de error", HEIGHT);
        }
        
        //Si ha ocurrido sobre el btn3, salimos del programa.
        if (event.getSource() == btn3) {
            System.exit(0);
        }
    }
    
    /*
    Igual que con ActionListener, la clase KeyListener nos obliga a utilizar 
    estos tres metodos:
    keyTyped()
    keyPressed()
    keyReleased()
    
    Para recordar: habiamos asociado un KeyListener (un controlador de teclas)
    al CAMPO DE TEXTO. Cuando escribamos en dicho campo, ocurrirán tres cosas.
    
    Igual que antes, tenemos la informacion de lo que ha ocurrido en la
    variable event.
    */
    
    // Se ha pulsado, pero no necesariamente soltado, una tecla.
    @Override
    public void keyPressed(KeyEvent event) {
        //Cambiamos TODO el texto del area de texto por el string indicado
        textArea.setText("Has pulsado una tecla");
    }
    
    // Se suelta una tecla que se había pulsado en algún momento.
    //Este metodo no lo usaremos PERO TENEMOS QUE CREARLO AUN ASI, el 
    //"implements" nos obliga a ello
    @Override
    public void keyReleased(KeyEvent event) {  
    }
    
    //Se "teclea" una tecla, valga la redundancia. Este evento es la combinación
    //de keyPressed y keyReleased. Añadiremos una linea al area de texto donde 
    //indicaremos que tecla se ha pulsado.
    @Override
    public void keyTyped(KeyEvent event) {
        //event.getKeyChar() nos devuelve el caracter que se ha pulsado
        textArea.append("\nHas tecleado el caracter: " + event.getKeyChar());
    }
    
}