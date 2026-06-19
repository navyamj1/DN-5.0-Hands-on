// abstract creator in the factory method pattern
// this class defines what to do with a document but not which type to create
// subclasses handle the which part by overriding createDocument()
// adding a new document type means writing a new subclass - nothing here changes

public abstract class DocumentFactory {

    // subclasses return their specific Document type here
    public abstract Document createDocument();

    // template methods - call createDocument() internally so the right type is used
    public void openDocument() {
        createDocument().open();
    }

    public void saveDocument() {
        createDocument().save();
    }

    public void closeDocument() {
        createDocument().close();
    }
}
