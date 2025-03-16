import java.util.Scanner; 

/* Hecho por Alisson Quijano (20245233) y Melisa Rivas (20245324) */

public class PasswordAnalizer{
    // PRIMERA PARTE
    public static void main(String[] arg) {
        // import el scanner para tomar input
        Scanner scanner = new Scanner (System.in);
        // pedirle al user una contraseña
        System.out.println("Enter your password: ");
        // leer el input
        String password = scanner.nextLine();

        // para analizar la contraseña
        analyzePassword(password);

        // cerrar el scanner (por recomendación del IDE)
        scanner.close();
    }

    // SEGUNDA PARTE
    public static void analyzePassword(String password) {
        // Ver si el input está vacío (debe manejar contraseñas vacías)
        if (password.isEmpty()) {
            System.out.println("La contraseña no puede ir vacía. Ingrese una contraseña válida.");
            return;
        }
        // score va a representar la calidad de la contraseña, es decir, se sumará un punto por cada cumplimiento de condición
        int score = 0;
        StringBuilder suggestions = new StringBuilder("Sugerencias para mejorar su contraseña: ");

        // Longitud (8 caracteres)
        if (password.length() >= 8) {
            score++;
        } else {
            suggestions.append("\nLa contraseña debe tener al menos 8 caracteres.");
        }

        // Lleva letras mayúsculas
        // password.chars convierte el string a enteros donde cada uno representa un valor Unicode
        // anyMatch es para ver si al menos un elemento cumple con la condición dada
        if (password.chars().anyMatch(Character::isUpperCase)) { 
            score++;
        } else {
            suggestions.append("\nLa contraseña debe llevar al menos una letra mayúscula.");
        }

        // Lleva letras minúsculas
        // la misma base que el de las letras mayúsculas
        if (password.chars().anyMatch(Character::isLowerCase)) {
            score++;
        } else {
            suggestions.append("\nLa contraseña debe llevar al menos una letra minúscula.");
        }

        // Lleva números
        if (password.chars().anyMatch(Character::isDigit)) {
            score++;
        } else {
            suggestions.append("\nLa contraseña debe llevar al menos un número.");
        }

        // Lleva caracteres especiales
        //  aplicamos el predicado lambda que es una forma compacta de hacer una pregunta
        // en este caso, preguntamos si hay un caracter especial
        // si hay al menos uno, devuelve la posición del mismo, si no hay, pues devuelve -1
        // el cero hace enfásis en que el caracter se puede encontrar desde el índice 0 hasta el último
        if (password.chars().anyMatch(ch -> "!@#$%^&*()_+-=[]{}|;:,.<>?".indexOf(ch) >= 0)) {
            score++;
        } else {
            suggestions.append("\nLa contraseña debe llevar al menos un carácter especial.");
        }

        // Ahora se puede determinar cuantos puntos ha sumado
        String resultado;
        if (score == 5) {
            resultado = "Es una contraseña fuerte. \nFelicidades!. Su contraseña es válida.";
        } else if (score >= 3) {
            resultado = "Su contraseña cumple con 3-4 criterios, posee fortaleza media. \nAgregue las recomendaciones para que su contraseña sea válida";
        } else {
            resultado = "Su contraseña necesita cumplir con más criterios. Posee debilidad.";
        }

        // Imprimir los resultados y las sugerencias para mejorar la contraseña
        System.out.println(resultado);
        if (score < 5) {
            System.out.println(suggestions.toString());
        } else {
            System.out.println("Gracias por revisar tu password. Regresa pronto! ");
        }
    }
    // \n sirve para hacer un salto de línea.
}

// --------------------------------------------------------------------------
// ● PRIMER CASO
// ➤ Contraseña ingresada: Password123

// ➤ Respuesta del sistema
// Enter your password: 
// Password123
// Su contraseña cumple con 3-4 criterios, posee fortaleza media. 
// Agregue las recomendaciones para que su contraseña sea válida
// Sugerencias para mejorar su contraseña: 
// La contraseña debe llevar al menos un carácter especial.
// --------------------------------------------------------------------------
// ● SEGUNDO CASO
// ➤ Contraseña ingresada: @Esen2025!

// ➤ Respuesta del sistema
// Enter your password: 
// @Esen2025!
// Es una contraseña fuerte. 
// Felicidades!. Su contraseña es válida.
// Gracias por revisar tu password. Regresa pronto!
// --------------------------------------------------------------------------
// ● TERCER CASO
// ➤ Contraseña ingresada: petroniloja

// ➤ Respuesta del sistema
// Enter your password: 
// petroniloja
// Su contraseña necesita cumplir con más criterios. Posee debilidad.
// Sugerencias para mejorar su contraseña: 
// La contraseña debe llevar al menos una letra mayúscula.
// La contraseña debe llevar al menos un número.
// La contraseña debe llevar al menos un carácter especial.
// --------------------------------------------------------------------------
// ● CUARTO CASO
// ➤ Contraseña ingresada: -espacio en blanco-

// ➤ Respuesta del sistema
// Enter your password: 
// 
//La contraseña no puede ir vacía. Ingrese una contraseña válida.
