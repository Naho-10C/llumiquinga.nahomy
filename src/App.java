import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void nllMuestraContenido(String archivo) throws FileNotFoundException, IOException { 
	String linea; 
	FileReader f = new FileReader(archivo); 
	BufferedReader b = new BufferedReader(f); 
	while((linea = b.readLine())!=null) { 
        String columnas[]=linea.split(";");
		System.out.println(columnas[1]+ "\t"+columnas[2]); 
	} 
	b.close(); 
}
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        final String nllCedula = "1725630204";
        final String nllCorreo = "nahomy.llumiquinga@epn.edu.ec";
        final String nllNombre = "NAHOMY NAYELI LLUMIQUINGA CANDO";
        int nllcontador = 1; 

        nllLogin(nllCedula, nllCorreo, nllNombre, nllcontador, sc);
        System.out.println("\033[H\033[2J");

        boolean nllSalir = false;
        int nllOpcion;
        while(!nllSalir){    
        System.out.println("-----------------------------");
        System.out.println(" Carga Horaria de Profesores");
        System.out.println("-----------------------------\n");
        System.out.println("1. Visualizar Profesores");
        System.out.println("2. Vizualizar Titulo");
        System.out.println("3. Visualizar Horario");
        System.out.println("4. Visualizar Horario de una asignatura");
        System.out.println("0. Salir");
            
        System.out.print("\n Escribe una de las opciones: ");
        nllOpcion = sc.nextInt();  
        switch(nllOpcion){
               case 1:
                System.out.println("\033[H\033[2J");
                System.out.println("[+] Listado de Profesores");
                System.out.println("- 202110105-CHUNCHO JIMENEZ ANGEL DAVID");
                System.out.println("- 202111083-HIDALGO CRUZ PABLO ESTEBAN");
                System.out.println("- 202120757-ALEMAN OSORIO CARLOS ALEJANDRO");
                   break;
               case 2:
                System.out.println("\033[H\033[2J");
                System.out.println("[+] Listado de Titulos");
                nllMuestraContenido("src\\ARCHIVOS\\202110105-CHUNCHO JIMENEZ ANGEL DAVID.csv");
                nllMuestraContenido("src\\ARCHIVOS\\202111083-HIDALGO CRUZ PABLO ESTEBAN.csv");
                nllMuestraContenido("src\\ARCHIVOS\\202120757-ALEMAN OSORIO CARLOS ALEJANDRO.csv");
                   break;
                case 3:
                System.out.println("\033[H\033[2J");
                System.out.println("PRESENTAR HORARIO");
                    String[][] nllHorario = new String[13][7];
                    for (int i = 0; i < 13; i++) {
                    for (int j = 0; j < 7; j++) {
                    nllHorario[i][j] = "\t-";
                    }
                    }
                nllHorario[0][0] = "7:00 AM";
                nllHorario[1][0] = "8:00 AM";
                nllHorario[2][0] = "9:00 AM";
                nllHorario[3][0] = "10:00AM";
                nllHorario[4][0] = "11:00AM";
                nllHorario[5][0] = "12:00PM";
                nllHorario[6][0] = "1:00 PM";
                nllHorario[7][0] = "2:00 PM";
                nllHorario[8][0] = "3:00 PM";
                nllHorario[9][0] = "4:00 PM";
                nllHorario[10][0] = "5:00 PM";
                nllHorario[11][0] = "6:00 PM";
                nllHorario[12][0] = "7:00 PM";
                System.out.println("Hora\t\tLunes\t\tMartes\t\tMiércoles\tJueves\t\tViernes\t\tSábado");
                for (int i = 0; i < 13; i++) {
                    System.out.print(nllHorario[i][0] + "\t");
                for (int j = 1; j < 7; j++) {
                System.out.print(nllHorario[i][j] + "\t");
                }
                System.out.println();
                }
                   break;
                case 4:
                System.out.println("HORARIO DE UNA MATERIA");
                   break;
                case 0:
                System.out.println("REGRESE PRONTO ");
                nllSalir=true;
                    break;
           }
       }
    sc.close();
    }
    private static void nllLogin(final String nllCedula, final String nllCorreo, final String nllNombre,
            int nllcontador, Scanner sc) {
        System.out.println("\033[H\033[2J");
        System.out.print(nllCedula +"\n" + nllCorreo + "\n" +nllNombre + "\n\n");
        while (nllcontador<4) {
            String nllUsuario, nllContraseña;
            String nllProfe = "profe";
            String nllContraseñaProfe = "1234";
            //System.out.println("\033[H\033[2J");
            System.out.print("\t--------------------------- \n\t   Usuario: ");
            nllUsuario = sc.nextLine();
            if (nllUsuario.equals(nllProfe) || nllUsuario.equals(nllCorreo)) {
                System.out.print("\t   Contraseña: ");
                nllContraseña = sc.nextLine(); 
                if (nllContraseña.equals(nllContraseñaProfe)||nllContraseña.equals(nllCedula)) {
                    System.out.println("\t--------------------------- \n\t   BIENVENIDO " + nllUsuario.toUpperCase());
                    break;
                } else 
                System.out.println("\t--------------------------- \n\t Numero de intentos "+nllcontador +"\n");
            } else 
            System.out.println("\t--------------------------- \n\t Numero de intentos " + nllcontador+ "\n");
            nllcontador = nllcontador+1;
        }
    }
    @Override
    public String toString() {
        return "App []";
    }
}
