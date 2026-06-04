package PDF;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.InputStream;

public class LeerPDF {

    public void leerPDF() throws Exception {

        InputStream file = LeerPDF.class.getClassLoader()
                .getResourceAsStream("N-32066670.pdf");

        if (file == null) {
            System.out.println("No se encontró el PDF");
            return;
        }

        PDDocument document = Loader.loadPDF(file.readAllBytes());

        PDFTextStripper stripper = new PDFTextStripper();

        String texto = stripper.getText(document);

        document.close();

        System.out.println(texto);
    }
}
