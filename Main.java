import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void mostrarMenu(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Zombie> Zombies = new ArrayList<Zombie>();
        ArrayList<Ubicaciones> Ciudades = new ArrayList<Ubicaciones>();
        System.out.println("Menu se mostrará cuándo deba ingresar una opción del mismo.");
        int cont = 0;
        int temp;
        for(int i = 0; i < Zombie.Menu.length; i++){
            System.out.println(Zombie.Menu[i]);
        }
        for(int i = 0; i < Ubicaciones.Menu.length; i++){
            System.out.println(Ubicaciones.Menu[i]);
        }
        for(int i = 0;true; i++){
            System.out.print("Menu: "); int num = sc.nextInt();
            if(num == 0){
                break;
            }
            switch(num){
                case 1: System.out.println("(Creando un Zombie) ");
                    System.out.print("Ingrese el nombre: "); String n = sc.next();
                    System.out.print("Ingrese la salud: "); double s = sc.nextInt(); 
                    System.out.print("Ingrese el año: "); int fc = sc.nextInt(); 
                    System.out.print("Ingrese el tipo de sangre: "); String t = sc.next(); 
                    Zombies.add(Zombie.crearZombie(n, s, fc, t));
                    cont++;
                    break;
                case 2: 
                    for(int j = 0; j < Zombies.size(); j++){
                        System.out.println(Zombie.mostrarInformacion(Zombies.get(j)));
                    }
                    break;
                case 3: 
                    System.out.println("El número de Zombies creados es: "+cont);
                    break;
                case 4: 
                    for(int h = 0; h < Zombies.size(); h++){
                        System.out.println(Zombie.mostrarInformacion(Zombie.filtrarSangre(Zombies.get(h))));
                    }
                    break;
                case 5:
                    for(int r = 0; r < Zombies.size(); r++){
                        System.out.println(Zombie.mostrarInformacion(Zombie.filtrarFecha(Zombies.get(r))));
                    }
                    break;
                case 6: 
                    Zombie.disminuirSalud(Zombies);
                    for(int w = 0; w < Zombies.size(); w++){
                        System.out.println("La salud del Zombie #"+(w+1)+" es: "+Zombies.get(w).getSalud());
                    }
                    break;
                case 7:
                    System.out.print("Ingrese el nombre: "); String m = sc.next();
                    System.out.print("Ingrese la distancia entre esta y Alexandría: "); float dis = sc.nextFloat(); 
                    System.out.print("Ingrese la cantidad de Zombies en la ciudad: "); int cant = sc.nextInt(); 
                    Ciudades.add(new Ubicaciones(m, dis, cant));
                    break;
                case 8:
                    for(int g = 0; g < Ciudades.size(); g++){
                        System.out.println(Ubicaciones.mostrarInfo(Ciudades.get(g)));
                    }
                case 9: 
                    System.out.println("La ubicación más segura es: "+Ubicaciones.mostrarInfo(Ubicaciones.masSegura(Ciudades)));
                    break;
                case 10: 
                    for(int c = 0; c<Ciudades.size(); c++){
                        System.out.println(Ubicaciones.mostrarInfo(Ubicaciones.ordenarCiudades(Ciudades).get(c)));
                    }
                    break;
                case 11: 
                    System.out.println(Zombie.fraseR(Zombie.Frases));
                    break;
                case 12: 
                    System.out.println("La ubicación más peligrosa es: "+Ubicaciones.mostrarInfo(Ubicaciones.menosSegura(Ciudades)));
                    break;
                default:
                    System.out.println("Ingrese una opción valida para el programa. "); 
            }
        }
     }
}
