public class FileNotExistsException extends Exception {

    private static String exceptionMessageMuster = "Es existiert keine Datei mit dem Namen %s";
    
    public FileNotExistsException(String dateiname) {
        super(String.format(FileNotExistsException.exceptionMessageMuster, dateiname));
    }
    
}
