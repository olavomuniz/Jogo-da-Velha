import java.util.Random;
import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Random rand = new Random();
        int[] j = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int r = 0;
        int jog = 0;
        int p;
        int robo;
        int marc;
        while (r == 0) {
            for (int i = 0; i < 9; i++) {
                if (j[i] == 0) {
                    System.out.print("-");
                } else if (j[i] == 1) {
                    System.out.print("X");
                } else {
                    System.out.print("O");
                }
                if (i == 2 || i == 5) {
                    System.out.println();
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\nEscolha uma casa de 1 a 9: ");
            p = read.nextInt();
            p--;
            while (p < 0 || p > 8 || j[p] != 0) {
                System.out.println("Casa inválida ou ocupada!");
                System.out.print("Escolha outra casa: ");
                p = read.nextInt();
                p--;
            }
            j[p] = 1;
            jog++;
            marc = 1;
            for (int i = 0; i < 9; i += 3) {
                if (j[i] == marc && j[i + 1] == marc && j[i + 2] == marc) {
                    r = 1;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (j[i] == marc && j[i + 3] == marc && j[i + 6] == marc) {
                    r = 1;
                }
            }
            if (j[0] == marc && j[4] == marc && j[8] == marc) {
                r = 1;
            }
            if (j[2] == marc && j[4] == marc && j[6] == marc) {
                r = 1;
            }
            if (jog == 9 && r == 0) {
                r = 3;
            }
            if (r == 0) {
                robo = rand.nextInt(9);
                while (j[robo] != 0) {
                    robo = rand.nextInt(9);
                }
                j[robo] = 2;
                jog++;
                marc = 2;
                for (int i = 0; i < 9; i += 3) {
                    if (j[i] == marc && j[i + 1] == marc && j[i + 2] == marc) {
                        r = 2;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    if (j[i] == marc && j[i + 3] == marc && j[i + 6] == marc) {
                        r = 2;
                    }
                }
                if (j[0] == marc && j[4] == marc && j[8] == marc) {
                    r = 2;
                }
                if (j[2] == marc && j[4] == marc && j[6] == marc) {
                    r = 2;
                }
                if (jog == 9 && r == 0) {
                    r = 3;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (j[i] == 0) {
                System.out.print("-");
            } else if (j[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
            if (i == 2 || i == 5) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
        if (r == 1) {
            System.out.println("\nVenceu");
        } else if (r == 2) {
            System.out.println("\nPerdeu");
        } else {
            System.out.println("\nEmpatou");
        }
    }
}