package Utils;

import VendorsPortal.Model.VendorPortalTestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class JavaUtil {
    public static final Logger log= LoggerFactory.getLogger(JavaUtil.class);
    public static final ObjectMapper obj=new ObjectMapper();

    public static <T> T getData(String path, Class<T> tClass)  {
        log.info("Path is {}",path);
        VendorPortalTestData vendorPortalTestData= null;
        try {
            return obj.readValue(new File(System.getProperty("user.dir")+"/"+path),tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
