package retoIndraProg;

import java.util.Scanner;

public class PortalEventos {
	
	//Declaración de teclado para introducir datos.
	public static Scanner teclado = new Scanner(System.in);
	public static String[][] usuario = new String[100][3];
	public static String usuarioA = null;
	public static String[] evento = new String[100];
	public static String[][] inscripcion = new String[100][2];
	public static int totalU = 0, totalE = 0, totalI = 0;

	public static void main(String[] args) {
		//Declaración de variables.
		int opc;
		boolean salir = false;
		
		//Llamada a la función para registrar usuario.
		registroUsuario();
		
		System.out.println();
		
		//Bucle para reproducir las opciones del menú.
		do {
			System.out.println("Portal para la Gestión de Eventos Sostenibles");
			System.out.println("1. Incluir Evento.");
			System.out.println("2. Cartelera de Eventos.");
			System.out.println("3. Inscribirse a Evento.");
			System.out.println("4. Mostrar Inscripciones.");
			System.out.println("5. Salir.");
			System.out.print("Selecciona una opción: ");
			opc = teclado.nextInt();
			
			System.out.println();
			
			//Bucle con las opciones y sus funciones.
			switch (opc) {
			case 1: {
				//Llamada a la función que registra eventos.
				incluirEvento();
				break;
			}
			case 2: {
				//Llamada a la función que muestra la cartelera de eventos.
				cartelera();
				break;
			}
			case 3: {
				//Llamada a la función para inscribirse en eventos.
				inscripcion();
				break;
			}
			case 4: {
				//Llamada a la función que muestra las inscripciones.
				lista();
				break;
			}
			case 5: {
				System.out.println("Gracias por visitar nuestra página.");
				System.out.println("Saliendo...");
				salir = true;
				break;
			}
			//Opción por si el valor introducido no es correcto.
			default:
				System.out.println("Introduce una opción válida.");
				System.out.println();
			}
		} while (!salir);

	}
	
	/*
	 * Función para que los usuarios se registren en la web.
	 * 
	 */
	public static void registroUsuario() {
		String nomb, correo, contrasenia;
		
		System.out.print("Nombre de usuario: ");
		nomb = teclado.nextLine();
		System.out.print("Correo Electrónico: ");
		correo = teclado.next();
		System.out.print("Contraseña: ");
		contrasenia = teclado.next();
		
		usuarioA = nomb;
		
		usuario[totalU][0] = nomb;
		usuario[totalU][1] = correo;
		usuario[totalU][2] = contrasenia;
		totalU++;
		System.out.println("Resgistro correcto, " + nomb);
	}
	
	/*
	 * Función para introducir la información de eventos en la web.
	 * 
	 */
	public static void incluirEvento() {
		String nomb, fecha, ubi, duracion, tipo;
		if (totalE >= 100) {
			System.out.println("No se pueden incluir más eventos.");
			System.out.println();
			return;
		}
		
		teclado.nextLine();
		
		System.out.print("Nombre del evento: ");
		nomb = teclado.nextLine();
		System.out.print("Fecha del evento: ");
		fecha = teclado.nextLine();
		System.out.print("Ubicación del evento: ");
		ubi = teclado.nextLine();
		System.out.print("Duración del evento: ");
		duracion = teclado.nextLine();
		System.out.print("Tipo de evento: ");
		tipo = teclado.nextLine();
		
		evento[totalE] = nomb + ", " + fecha + ", " + ubi + ", " + duracion + ", " + tipo;
		totalE++;
		System.out.println("Evento incluido.");
		System.out.println();
	}
	
	/*
	 * Función para ver la cartelera de eventos.
	 * 
	 */
	public static void cartelera() {
		if (totalE == 0) {
			System.out.println("No hay eventos en cartelera.");
		} else {
			System.out.println("Cartelera de Eventos:");
			for (int i = 0; i < totalE; i++) {
				System.out.println("- " + evento[i]);
			}
		}
		System.out.println();
	}
	
	/*
	 * Función para inscribirse en un evento de la cartelera.
	 * 
	 */
	public static void inscripcion() {
		int numerador = 0;
		
		if (totalE == 0) {
			System.out.println("No hay eventos a los que inscribirse.");
			return;
		}
		
		System.out.println("Eventos:");
		for (int i = 0; i < totalE; i++) {
			System.out.println((i + 1) + ". " + evento[i]);
		}
		
		System.out.println();
		
		System.out.print("Selecciona el número del evento: ");
		numerador = teclado.nextInt() - 1;
		
		if (numerador >= 0 && numerador < totalE) {
			inscripcion[totalI][0] = usuarioA;
			inscripcion[totalI][1] = evento[numerador];
			totalI++;
			System.out.println("Inscripción realizada.");
		} else {
			System.out.println("Selección erronea.");
		}
		System.out.println();
	}
	
	/*
	 * Función para listar las inscripciones que hay a los eventos.
	 */
	public static void lista() {
		if (totalI == 0) {
			System.out.println("No hay usuarios inscritos a eventos.");
		} else {
			System.out.println("Lista de inscripciones: ");
			for (int i = 0; i < totalI; i++) {
				System.out.println(inscripcion[i][0] + "esta inscrito en " + inscripcion[i][1]);
			}
		}
	}

}
