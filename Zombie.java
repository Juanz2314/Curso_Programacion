import java.util.ArrayList;
public class Zombie {
    private String nombre;
    private double salud;
    private int fecha_nac;
    private String tipo_san;
    
    public static String[] Frases = {"Los Zombies son los únicos hombres que te aman por tu cerebro", "Los Zombies que hablan español e inglés, ¿Zombilingües?",
        "Entrena porque los zombies se comeran al más lento.", "Cada ser humano que salvamos es un Zombie menos que combatir", "Sobrevivir significa tomar decisiones dificiles"};
    public static String[] Menu = {"Si ingresa el número 0 se detendrá el programa.", "Si ingresa el número 1 se creará un nuevo Zombie.", "Si ingresa el número 2 se mostrará por pantalla la información de todos los Zombies ingresados hasta el momento.", 
        "Si ingresa el número 3 se mostrará la cantidad de Zombies creados hasta el momento.", "Si ingresa el número 4 se mostrará la información de todos los Zombies con tipo de Sangre O+ y AB+. ",
        "Si ingresa el número 5 se mostrará la información de todos los Zombies que nacieron después del 2000. ", "Si ingresa el número 6 se disminuirá a la mitad la salud de todos los Zombies. "};
    public Zombie(String n, double s, int fc, String t){
        this.nombre = n;
        this.salud = s;
        this.fecha_nac = fc;
        this.tipo_san = t;
    }
    public Zombie(){
    }
    public void setNombre(String n){
        this.nombre = n;
    }
    public void setSalud(double s){
        this.salud = s;
    }
    public void setFecha(int fc){
        this.fecha_nac = fc;
    }
    public void setTipo(String t){
        this.nombre = t;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public double getSalud(){
        return this.salud;
    }
    public int getFecha(){
        return this.fecha_nac;
    }
    public String getTipo(){
        return this.tipo_san;
    }
    public static Zombie crearZombie(String n, double s, int fc, String t){
        Zombie z1 = new Zombie(n, s, fc, t);
        return z1;
    }
    public static String mostrarInformacion(Zombie a){
        String info = new String(a.getNombre()+" "+a.getSalud()+" "+a.getFecha()+" "+a.getTipo());
        String error = new String("Este zombie no cumple esta condición. ");
        if(a.getTipo()==null){
            return error;
        }
        else{
            return info;
        }
    }
    public static String fraseR(String[] f){
        int random = (int)(Math.random()*(5-0))+0;  
        return f[random];
    }
    public static Zombie filtrarSangre(Zombie a){
        Zombie b = new Zombie(); 
            if(a.getTipo().equalsIgnoreCase("O+") || a.getTipo().equalsIgnoreCase("AB+")){
                return a;
            }
            else{
                return b;
            }
    }
    public static void disminuirSalud(ArrayList<Zombie> a){
        for(int i = 0; i < a.size(); i++){
            double temp;
            temp = a.get(i).getSalud()/2;
            a.get(i).setSalud(temp);
        }
    }
    public static Zombie filtrarFecha(Zombie a){    
        Zombie b = new Zombie(); 
            if(a.getFecha() >= 2000){
                return a;
            }
            else{
                return b;
            }
    }
}