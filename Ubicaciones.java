import java.util.ArrayList;
public class Ubicaciones {
    private String nombre;
    private float dist_al;
    private int cant_z;
    
    public static String[] Menu = {"Si ingresa el número 7 se creará una nueva ciudad. ", "Si ingresa el número 8 se mostrará la información de todas las ciudades creadasa hasta el momento." ,
        "Si ingresa el número 9 se mostrará la ciudad más segura (Menor cantidad de Zombies). ", "Si ingresa el número 10 se mostrará la información de todas las ciudades ordenadas de forma ascendente acuerdo a su distancia a Alexandría. ",
        "Si ingresa el número 11 se mostrará una frase aleatoria de Zombies. ", "Si ingresa el número 12 se mostrará la ciudad más peligrosa (Mayor cantidad de Zombies)."};
    public Ubicaciones(String n, float d, int c){
        this.nombre = n;
        this.dist_al = d;
        this.cant_z = c;
    }
    public String getNombre(){
        return this.nombre;
    }
    public float getDist(){
        return this.dist_al;
    }
    public int getCantZ(){
        return this.cant_z;
    }
    public void setNombre(String n){
        this.nombre = n;
    }
    public void setDist(float d){
        this.dist_al = d;
    }
    public void setCantZ(int c){
        this.cant_z = c;
    }
    public static String mostrarInfo(Ubicaciones a){
        String info = new String(a.getNombre()+" "+a.getDist()+" "+a.getCantZ()); 
        return info;
    }
    public static Ubicaciones masSegura(ArrayList<Ubicaciones> a){  
            int tenp = a.get(0).getCantZ();
            int XD = 0;
            for(int f = 0; f < a.size(); f++){
                if(a.get(f).getCantZ() < tenp){
                    tenp = a.get(f).getCantZ();
                    XD = f;
                }
            }
            return a.get(XD);
    }
    public static Ubicaciones menosSegura(ArrayList<Ubicaciones> a){
        int tenp = a.get(0).getCantZ();
            int XD = 0;
            for(int f = 0; f < a.size(); f++){
                if(a.get(f).getCantZ() > tenp){
                    tenp = a.get(f).getCantZ();
                    XD = f;
                }
            }
            return a.get(XD);
    }
    public static void cambiarObjetos(Ubicaciones a, Ubicaciones b){
        a.setNombre(b.getNombre());
        a.setDist(b.getDist());
        a.setCantZ(b.getCantZ());
    }
    public static ArrayList<Ubicaciones> ordenarCiudades(ArrayList<Ubicaciones> a){
        int pos_menor;
        Ubicaciones tempo = a.get(0);
        for(int b = 0; b<a.size(); b++){
            pos_menor = b;
            for(int ñ = b+1; ñ<a.size(); ñ++){
                if(a.get(ñ).getDist() < a.get(pos_menor).getDist()){
                    pos_menor = ñ;
                }
            }
            tempo = a.get(b); 
            a.get(b).cambiarObjetos(a.get(b), a.get(pos_menor));
            a.get(pos_menor).cambiarObjetos(a.get(pos_menor), tempo);
        }
        return a;
    }
}