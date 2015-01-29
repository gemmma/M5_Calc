/*
 * CFGS DAW 2n Curs
 * M5: Entorns de desenvolupament
 * Grup 3 CAS 4 de la UF2 RA2
 */
package calc_grup3_m5;

import java.io.*;

/**
 * @grup3
 */
public class Calculadora_m5 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            FileWriter fw;
            try (BufferedReader reader = new BufferedReader(new FileReader("proves_cn.txt"))) {
                fw = new FileWriter("resultats_cn.txt");
                String linea = reader.readLine();
                while (linea != null) {// procesar el texto de la línea

                    int n = 0;
                    char operador = ' ';
                    //operador
                    if (linea.indexOf('+', 1) != -1) {
                        operador = '+';
                        n = linea.indexOf('+', 1);
                    } else if (linea.indexOf('*', 1) != -1) {
                        operador = '*';
                        n = linea.indexOf('*', 1);
                    } else if (linea.indexOf('/', 1) != -1) {
                        operador = '/';
                        n = linea.indexOf('/', 1);
                    } else if (linea.indexOf('%', 1) != -1) {
                        operador = '%';
                        n = linea.indexOf('%', 1);
                    } else if (linea.indexOf('-', 1) != -1) {
                        operador = '-';
                        n = linea.indexOf('-', 1);
                    } else {
                        fw.write("No te Operador\n");
                    }

                    if (n != 0) {
                        try {
                            //numero1
                            String string1 = linea.substring(0, n);
                            int numero1 = Integer.parseInt(string1);
                            //numero2
                            String string2 = linea.substring(n + 1, linea.length());
                            int numero2 = Integer.parseInt(string2);

                            if (operador == '+') {
                                Suma resultat = new Suma(numero1, numero2);
                                fw.write(resultat.Suma() + "\n");
                            } else if (operador == '*') {
                                Multiplicacio resultat = new Multiplicacio(numero1, numero2);
                                fw.write(resultat.Multiplicacio() + "\n");
                            } else if (operador == '/') {
                                Divisio resultat = new Divisio(numero1, numero2);
                                fw.write(resultat.Divisio() + "\n");
                            } else if (operador == '%') {
                                Residu resultat = new Residu(numero1, numero2);
                                fw.write(resultat.Residu() + "\n");
                            } else if (operador == '-') {
                                Resta resultat = new Resta(numero1, numero2);
                                fw.write(resultat.Resta() + "\n");
                            }

                        } catch (Exception e) {
                            fw.write("Error\n");
                        }
                    }

                    linea = reader.readLine();
                }
            }
            fw.close();
        } catch (FileNotFoundException e) {
            // no se encontró el fichero
            System.out.println("No es troba fitxer");
        } catch (IOException e) {
            // algo fue mal al leer o cerrar el fichero
            System.out.println("Hi ha hagut un error a l'hora de llegir");
        }

    }

}
