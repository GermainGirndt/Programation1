/**
 * FileDoesNotExistException wird geworfen, wenn die eingegebene Datei nicht existiert
 * 
 * @author Girndt, Germain; Krier, Katharina
 * @version 1.0
 */
public class FileDoesNotExistException extends Exception {

    private static String exceptionMessageMuster = "Es existiert keine Datei mit dem Namen %s";
    
    public FileDoesNotExistException(String dateiname) {
        super(String.format(FileDoesNotExistException.exceptionMessageMuster, dateiname));
    }
    
}
