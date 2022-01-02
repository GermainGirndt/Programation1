
/**
 * Beschreiben Sie hier die Klasse ArrayFunctions.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ArrayFunctions
{
 private static final double INITIALWERT = 0.0;
  
 private ArrayFunctions(){
     
 }
 
 /**
 * Diese Funktion berechnet den Mittelwert und den nahesten und entferntesten Wert davon eines Double Arrays
 * ist das Array leer wird 0 zurueckgegeben, sind zwei Zahlen gleich weit vom Mittelwert entfernt
 * wird die mit dem kleineren Betrag genommen
 *@param messwerte ist ein Array von double Messwerten
 *@return ein Mittelwert wird zurückgegeben, diser enthaelt den Mittel-, Nahester- und Entferntesterwert
 */  
  public static Mittelwert berechneMittelwert(double[] messwerte){
    double mittelwert        = INITIALWERT;
    double nahesterwert      = INITIALWERT;
    double entferntesterwert = INITIALWERT;
    double nahedifferenz     = INITIALWERT;
    double weitedifferenz    = INITIALWERT;
    
    //berechnet den Mittelwert
    for(int i = 0; i < messwerte.length ; i++ ){
        mittelwert += messwerte[i];   
    }
    
    if(messwerte.length > 0){
        mittelwert = mittelwert / messwerte.length; 
    
    
    //berechnet den nahesten und entferntesten Wert
        for(int j = 0; j < messwerte.length ; j++ ){
            if(j == 0){
                nahedifferenz     = differenzbetrag(mittelwert, messwerte[j]);    
                nahesterwert      = messwerte[j];
            
                weitedifferenz    = differenzbetrag(mittelwert, messwerte[j]); 
                entferntesterwert = messwerte[j];
            }
            else{
                if(differenzbetrag(mittelwert, messwerte[j]) < nahedifferenz){
                    nahedifferenz = differenzbetrag(mittelwert, messwerte[j]);  
                    nahesterwert  = messwerte[j];
                }
            
                if(differenzbetrag(mittelwert, messwerte[j])> weitedifferenz){
                    weitedifferenz    = differenzbetrag(mittelwert, messwerte[j]);    
                    entferntesterwert = messwerte[j];
                }
            }
        }
    }
    Mittelwert mittelwerte = new Mittelwert(mittelwert, nahesterwert, entferntesterwert);
    
    return mittelwerte;
  }
  
 private static double differenzbetrag(double  zahl1, double zahl2){
      return Math.abs(zahl1 - zahl2);
 }
 
 
 public static int stringsAuswerten(String[] strings){
     int anzahl             = 0;
     boolean istKlein       = true;
     boolean trifftzu       = true; 
     
     for(String s : strings){
         s = s.trim();
         if(s.isEmpty()){
             trifftzu = false;
         }
         else{
             for(int i = 0; i < s.length(); i++){
                 if(i == 0){
                     if(Character.isUpperCase( s.charAt(i) )){
                          istKlein = false;
                     }   
                     else{
                          istKlein = true;
                     }
                 }
             
                 if( istKlein){
                     if(Character.isUpperCase( s.charAt(i) )){
                         trifftzu = false;
                     }     
                 }
                 else{
                    if(Character.isLowerCase( s.charAt(i) )){
                         trifftzu = false;
                         } 
                 }
             
             }
         }
         if(trifftzu){
             anzahl++;
            
         }
         trifftzu = true;
     }
     
     return anzahl;
 }
}
