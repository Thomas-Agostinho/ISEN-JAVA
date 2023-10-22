package TP5;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.krysalis.barcode4j.impl.datamatrix.DataMatrixBean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class QRCodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L; 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérez les paramètres du formulaire
        String code = request.getParameter("code");
        String libelle = request.getParameter("libelle");

        // Générez le message
        String message = "Le code du formulaire est " + code + ". Le libellé est " + libelle + ".";

        // Configurez le générateur DataMatrix
        DataMatrixBean bean = new DataMatrixBean();

        // Générez le code-barres et renvoyez-le sous forme d'image
        response.setContentType("image/png");
        try {
            OutputStream out = response.getOutputStream();
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, "image/png", 300,
                    BufferedImage.TYPE_BYTE_BINARY, false, 0);
            bean.generateBarcode(canvas, message);
            canvas.finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
