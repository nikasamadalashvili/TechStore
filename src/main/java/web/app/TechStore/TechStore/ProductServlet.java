package web.app.TechStore.TechStore;

import lombok.SneakyThrows;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.hibernate.id.GUIDGenerator;
import web.app.TechStore.TechStore.DomainModels.Gps;
import web.app.TechStore.TechStore.service.MobileService;
import web.app.TechStore.TechStore.service.models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mail.internet.ContentType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {
     // garbage testing code
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getServletContext();
        response.setContentType("text/html");
        MobileService mobileService = (MobileService) request.getServletContext().getAttribute("mobileService");
        //FilteredMobileListResponse responseRes = mobileService.getFilteredMobileList(new FilteredMobileListRequest("xiaomi"));
        //MobileDetailsResponse responseResult = mobileService.getMobileDetails(new MobileDetailsRequest(1L));
        // Hello
        //String a = mobileService.getMobileDetails(new MobileDetailsRequest(1L)).getFingerprint();
        List<String> brands = new ArrayList<>();
        List<String> opSyss = new ArrayList<>();
        List<Integer> scrSizes = new ArrayList<>();
        List<String> scrResos = new ArrayList<>();
        List<String> rams = new ArrayList<>();
        List<String> internalMems = new ArrayList<>();
        List <String> memCardSupports = new ArrayList<>();
        List<Integer> numberOfCameras = new ArrayList<>();
        List<String> mainCameraMps = new ArrayList<>();
        List<String> secondCameraMps = new ArrayList<>();
        List<String> typeOfProcessors = new ArrayList<>();
        List<Integer> numberOfCoress = new ArrayList<>();
        List<String> waterResistants = new ArrayList<>();
        List<String> dualSims = new ArrayList<>();
        List<String> ltes = new ArrayList<>();
        List<String> lteAs = new ArrayList<>();
        List<String> fiveGs = new ArrayList<>();
        List<String> nfcs = new ArrayList<>();
        List<String> colors = new ArrayList<>();
        double pricefrom = 10;
        double priceTo = 20;
        //scrSizes.add(4);
        //scrSizes.add(8);
        //opSyss.add("ios");
        //opSyss.add("win10");
        //brands.add("Nokia");
        //brands.add("apple");
        FilteredMobileListResponse responseRes = mobileService.getFilteredMobileList(new FilteredMobileListRequest(
                "", brands, opSyss, scrSizes, scrResos, rams, internalMems, memCardSupports,numberOfCameras,
                mainCameraMps, secondCameraMps, typeOfProcessors, numberOfCoress, waterResistants, dualSims, ltes,
                lteAs, fiveGs, nfcs, colors, pricefrom, priceTo));
        String a = responseRes.getFilteredProducts().toString();

        AddProductResponse responseResu = mobileService.addProduct(new AddProductRequest("a", "a", "a",
        "a", null, 123, 19,50.0, "kkkkkkk",9, "a", null, "a", 5, null,
                "a","a","a","a","a","a","a",
                "a","a","a","a","a","a","a","a",
                "a","a","a", "a","a","a",
                "a","a","a","a","a","a",
                "a","a","a","a","a","a","a","a","a",
                "a","a","a", "a","a","a","a","a","a",
                "a","a","a","a","a",
                "a","a",5, "a","a", 5,
                "a","a","a","a","a","a",
                "a","a","a","a","a","a","a",
                "a","a","a","a","a","a"));

        /*EditProductResponse resp = mobileService.editProduct(new EditProductRequest(127,"k", "alo", "a",
                "a", null, 7,5,111.0,"kbva", 7, "a", null, "a", 5, null,
                "a","a","a","a","a","a","a",
                "a","a","a","a","a","a","a","a",
                "a","a","a", "a","a","a",
                "a","a","a","a","a","a",
                "a","a","a","a","a","a","a","a","a",
                "a","a","a", "a","a","a","a","a","a",
                "a","a","a","a","a",
                "a","a",5, "a","a", 5,
                "a","a","a","a","a","a",
                "a","a","a","a","a","a","a",
                "a","a","a","a","a","a"));*/
        //DeleteProductResponse deleteResp = mobileService.deleteProduct(new DeleteProductRequest(127));
        //boolean a = responseRes.isAddedSuccesfully();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>" + responseResu.getProductId() + "<h2>");
        out.println("</body></html>");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String appPath = "/home/nika/Desktop/TechStore/src/main/webapp/images/";
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator;
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.parseRequest(request).stream()
                .filter(o -> !((FileItem)o).isFormField())
                .forEach(o -> {
                    FileItem item = (FileItem) o;
                    try {
                        MimeType mimeType = MimeTypes.getDefaultMimeTypes().forName(item.getContentType());
                        File newImagePath = new File(appPath + UUID.randomUUID() + mimeType.getExtension());
                        item.write(newImagePath);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

    }

    public void destroy() {
    }
}