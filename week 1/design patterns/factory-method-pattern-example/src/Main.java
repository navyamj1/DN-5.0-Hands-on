

public class Main {

    public static void main(String[] args) {

        System.out.println("factory method pattern demo\n");
        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };

        for (DocumentFactory factory : factories) {
            String name = factory.getClass().getSimpleName();
            System.out.println("--- " + name + " ---");
            Document doc = factory.createDocument();
            doc.open();
            doc.save();
            doc.close();
            System.out.println();
        }

        System.out.println("using factory template methods\n");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.openDocument();
        pdfFactory.saveDocument();
        pdfFactory.closeDocument();
    }
}
