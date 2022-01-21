
    import com.qbitra.rpa.QbitraRpa;
    import com.qbitra.rpa.ExcelSession;
    import com.qbitra.rpa.QbitraRunSession;
    import com.qbitra.rpa.QbitraRpaSettings;
    import com.qbitra.rpa.utils.ScrollType;
    import org.sikuli.script.*;
    import org.sikuli.vnc.*;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;

    import com.google.gson.*;
import java.util.*;
import java.text.*;

    
    public class AirbusSureci {
      private static int  ExitCode = 0;
      public static String HomePath = "";
      public static String FlowPath = "";
      public static String DesktopPath = "";
      public static String TempPath = "";
      public static String DownloadsPath = "";
      public static void main(String[] args) throws Exception {
      
        QbitraRpa rpa = null;
        try {
          rpa = new QbitraRpa(args);
          HomePath = rpa.getHomePath();
          TempPath = rpa.getTempFolderPath();
          FlowPath = rpa.getFlowPath();
          DesktopPath = rpa.getDesktopPath();
          DownloadsPath = rpa.getDownloadsPath();
          Exception Exception = new Exception();
          

    QbitraRpaSettings.DefaultTimeOut=20;
  ///>
rpa.echo("Execute Node:31");

 //< [Variable] [comment="Z"] [rows="[{"firtsValueInput":{"value":"INVOICENUMBER","type":"input"},"secondValueInput":{"value":"\"123\"","type":"input"},"id":0,"selected":"String","uuid":"5NMke"},{"firtsValueInput":{"value":"ponum","type":"input"},"secondValueInput":{"value":"\"2222\"","type":"input"},"id":1,"selected":"String","uuid":"RMTRJ"},{"firtsValueInput":{"value":"ACCOUNTNAME","type":"input"},"secondValueInput":{"value":"\"AIRBUS\"","type":"input"},"id":2,"selected":"String","uuid":"oy14C"}]"] 
String INVOICENUMBER="123";
String ponum="2222";
String ACCOUNTNAME="AIRBUS";

 
rpa.echo("Execute Node:30");


    rpa.addValuesMapping("INVOICENUMBER",INVOICENUMBER);
    rpa.addValuesMapping("ponum",ponum);
    rpa.addValuesMapping("ACCOUNTNAME",ACCOUNTNAME);
String apiResponse = rpa.callApi("POST","https://webhook.site/b5169a01-5ace-4b8c-9088-0b0a75f0b963","{ \"INVOICENUMBER\": ${INVOICENUMBER}, \"ponum\": ${ponum},\"ACCOUNTNAME\":${ACCOUNTNAME}}","{\"Content-Type\":\"application/json\"}");

        } catch (Exception ex) {
          ex.printStackTrace();
          Thread.sleep(1);
          ExitCode =- 1;
        } finally {
          rpa.quit();
          System.exit(ExitCode);
        }
      }
    
    }
  