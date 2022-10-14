
/**
 * ENTREGA UT3
 * @author - Aitor Cuadrado
 * 
 * 
 * Un centro deportivo oferta clases de yoga, pilates y spinning
 * en sus diferentes salas. En cada sala se realiza una actividad de la misma duración
 * que se repite a lo largo del día un nº de veces. Puede haber salas
 * con la misma actividad pero de duración diferentes (ej. en la sala 1 
 * se hace spinning en clases de 40 minutos y en la sala 3 se
 * hace también spinning pero de duración 70 minutos).
 * 
 * El precio de las clases depende de su duración.
 * El precio base es 5.0€ y se añade a este precio 0.40€ por cada período completo de 15 minutos.
 * 
 * 
 * La primera clase comienza siempre a las 10.30 (a.m) y la última no puede acabar después
 * de las 8.30 (p.m). En todas las salas entre clase y clase (incluida la última) 
 * hay un descanso de 10 minutos
 * 
 * El centro quiere mostrar al usuario el nº de clases que se dan en cada sala con su precio
 * y además quiere efectuar ciertos cálculos dependiendo del nº de personas que se han inscrito 
 * a las actividades de las diferentes salas
 */
public class CentroDeportivo
{
    private final int HORA_PRIMERA_CLASE = 10;
    private final int MINUTOS_PRIMERA_CLASE = 30;
    private final int HORA_ULTIMA_CLASE = 8;
    private final int MINUTOS_ULTIMA_CLASE = 30;
    private final int DESCANSO = 10;

    private final double PRECIO_BASE = 5.0;
    private final double PRECIO_QUINCE_MINUTOS = 0.40;

    private final char YOGA = 'Y';
    private final char PILATES = 'P';
    private final char SPINNING = 'S';

    private String nombre;
    private int yoga;
    private int pilates;
    private int spinning;
    private double totalAcumulado;
    private int salaMaximoYoga;
    private int maximoInscripcionesYoga; 

    /**
     * Constructor  - 
     * Recibe un único parámetro, el nombre del centro deportivo
     * e inicializa el resto de atributos adecuadamente 
     */
    public CentroDeportivo(String queNombre)    {
        nombre = queNombre;
        yoga = 0;
        pilates = 0;
        spinning = 0;
        totalAcumulado = 0;
        salaMaximoYoga = 0;
        maximoInscripcionesYoga = 0; 

    }

    /**
     *  Accesor para el nombre del centro deportivo
     *
     */
    public String getNombre()    {
        return nombre;
        
    }
    
    /**
     *  Mutador para el nombre del centro deportivo
     */
    public void setNombre(String queNombre)    {
       nombre = queNombre; 
       
    }

    /**
     *  Accesor para el importe total acumulado 
     *  entre todos los inscritos en el centro 
     */
    public double getImporteTotal()    {
        return totalAcumulado; 
        
    }

    /**
     *  Este método recibe 5 parámetros: 
     *      - sala: el nº de sala donde se hace la actividad
     *      - tipo: el tipo de actividad, un carácter 'Y' yoga, 'P' pilates 'S' spinning
     *      - horas y minutos : duración de la actividad en nº horas y minutos
     *      - inscritos: el nº de personas inscritas en esa actividad en la sala
     *      
     *      Por ej, tarificarClaseEnSala(4, 'P', 1, 5, 15) significa que en la sala 4 se hace
     *      pilates, las clases duran 1 hora y  5 minutos y se han inscrito en esta sala 15 personas
     *   
     *   A partir de esta información el método debe calcular:
     *      - total inscritos por tipo de actividad (independientemente de la sala)
     *      - la sala con máximo nº de inscritos en yoga y dicho valor máximo 
     *   
     *   Utiliza una sentencia switch  para analizar el tipo de actividad
     *   
     *   También el método calculará:
     *   
     *      - el precio de la clase en la sala (basándose en su duración). En el ejemplo anterior
     *      la clase de pilates duraba 1 hora y 5 minutos . Como el total de minutos
     *      de duración es 65 su precio será: 5 + 0,40 *  4 = 6,60 ya que son 4 los períodos completos de
     *      15 minutos que hay
     *      - nº de veces que la clase se ofertará en la sala (dependerá de su duración. No olvidar que entre clase 
     *      y clase siempre hay un descanso)
     *      - la hora de finalización de la última clase (hora y minutos) - !!Ver resultados de ejecución!!
     *      - el método además irá registrando el importe total que lleva acumulado el centro entre todas
     *      las personas inscritas 
     *      
     *   En pantalla se mostrarán los datos de la sala tal como indican los resultados de ejecución
     *              
     */
    public void tarificarClaseEnSala(int sala, char tipo, int horas, int minutos, int inscritos)    {
        int horasAminutos = 0;
        int tiempoClase = 0;
        double precioClase = 0;
        double totalAcumulado = 0;
        
        switch (tipo){
            case YOGA: yoga =+ inscritos;
                if (inscritos > maximoInscripcionesYoga){
                    salaMaximoYoga = sala;
                }
                break;
            case PILATES: pilates =+ inscritos;
                break;
            case SPINNING: spinning =+ inscritos;
                break;
                
        }
        horasAminutos = horas * 60;
        tiempoClase = horasAminutos + minutos;
        precioClase = ((tiempoClase / 15) * PRECIO_QUINCE_MINUTOS + PRECIO_BASE) * inscritos;
        totalAcumulado =+ precioClase;
    }

    /**
     *  nº sala en la que hay más inscritos en yoga
     *   
     */
    public int getSala()   {
         return salaMaximoYoga;
        
    }

    /**
     * Devuelve el nombre de la actividad con más inscritos 
     * independientemente de la sala  (puede haber coincidencias)  
     */
    public String getActividadMaximasInscripciones()    {
        String actividadMaximasInscripciones = "";
        if (yoga > pilates){
            if (yoga > spinning){
                actividadMaximasInscripciones = "YOGA"; 
            }
            else if (yoga == spinning){
                actividadMaximasInscripciones = "YOGA SPINNING";
            }
            else {
                actividadMaximasInscripciones = "SPINNING";
            }
        }
        if (pilates > yoga){
            if(pilates > spinning){
                actividadMaximasInscripciones = "PILATES";
            }
            else if (pilates == spinning){
                actividadMaximasInscripciones = "PILATES SPINNING";
            }
            else {
                actividadMaximasInscripciones = "SPINNING";
            }
        }
        // else if (pilates > spinning){
            // actividadMaximasInscripciones = "PILATES";
        // }
        // else if (pilates == spinning){
            // actividadMaximasInscripciones = "PILATES SPINNING";
        // }
        // else if (pilates == yoga){
            // actividadMaximasInscripciones = "PILATES YOGA";
        // }
        // else{
            // actividadMaximasInscripciones = "SPINNING";
        // }
        return actividadMaximasInscripciones;
    }
    
}
