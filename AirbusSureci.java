
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
rpa.echo("Execute Node:2");

 //< [KillProcess] [comment="Ax32.exe"] [rows="[{"applicationExe":{"value":"Ax32.exe","type":"input"},"id":0}]"]  
rpa.killProcess("Ax32.exe");

 
rpa.echo("Execute Node:3");

  rpa.sleep(3);

rpa.echo("Execute Node:4");

	App app = rpa.openApp("C:\\\\Program Files (x86)\\\\Microsoft Dynamics AX\\\\50\\\\Client\\Bin\\\\Ax32.exe");
rpa.echo("Execute Node:5");
QbitraRpaSettings.getScreen().type(Key.UP,Key.WIN);
rpa.sleep(1);
rpa.echo("Execute Node:6");

  rpa.click("images/satinalma.png");

rpa.echo("Execute Node:8");

  rpa.sleep(3);

rpa.echo("Execute Node:5");
QbitraRpaSettings.getScreen().type(Key.UP,Key.WIN);
rpa.sleep(1);
rpa.echo("Execute Node:9");

  rpa.click("images/stok.png");

rpa.echo("Execute Node:13");

  rpa.click("images/hareketler.png.targetOffset(-13,-17)");

rpa.echo("Execute Node:5");
QbitraRpaSettings.getScreen().type(Key.UP,Key.WIN);
rpa.sleep(1);
rpa.echo("Execute Node:14");

  rpa.click("images/genel.png.targetOffset(-19,-2)");

rpa.echo("Execute Node:15");

  rpa.doubleClick("images/miktar.png.targetOffset(107,-2)");

rpa.echo("Execute Node:16");

	rpa.sleep(0.5);
	rpa.keyboardWrite("ctrl+c");
	rpa.sleep(0.5);
rpa.echo("Execute Node:18");

    String miktar = rpa.getFromClipboard();

rpa.echo("Execute Node:20");

  rpa.click("images/guncellestir.png.targetOffset(-32,-3)");

rpa.echo("Execute Node:21");

	rpa.keyboardWrite("ctrl + shift+Left Arrow");
	rpa.keyboardWrite("ctrl+c");
rpa.echo("Execute Node:22");

    String malitarih = rpa.getFromClipboard();

rpa.echo("Execute Node:23");

  rpa.click("images/alindi.png");

rpa.echo("Execute Node:25");

	rpa.keyboardWrite("ctrl+c");
rpa.echo("Execute Node:26");

    String girisdurumu = rpa.getFromClipboard();
rpa.echo("Execute Node:19");

 //< [Condition] [comment="."] [combine="ALL"] [rows="[{"firtsValueInput":{"value":"UNITQUANTITY","type":"variable"},"secondValueInput":{"value":"miktar","type":"variable"},"id":0,"selected":"isequal"},{"firtsValueInput":{"value":"malitarih","type":"variable"},"secondValueInput":{"value":"","type":""},"id":1,"selected":"isnull"},{"firtsValueInput":{"value":"girisdurumu","type":"input"},"secondValueInput":{"value":"\"Alındı\"","type":"input"},"id":2,"selected":"isequalforstring"}]"] 
 if((UNITQUANTITY == miktar)&&(malitarih == null)&&(girisdurumu.equals("Alındı")))
 {
 
rpa.echo("Execute Node:28");

  rpa.click("images/kapatma.png.targetOffset(48,-3)");

}else{
rpa.echo("Execute Node:30");


    rpa.addValuesMapping("INVOICENUMBER",INVOICENUMBER);
    rpa.addValuesMapping("ponum",ponum);
    rpa.addValuesMapping("ACCOUNTNAME",ACCOUNTNAME);
String apiResponse = rpa.callApi("POST","http://172.23.27.18:8000/hype/webhook/undefined/miktarhatawebhook/miktarhata","{\"INVOICENUMBER\": \"${INVOICENUMBER}\", \"ponum\": \"${ponum}\",\"ACCOUNTNAME\":\"${ACCOUNTNAME}\"}","{\"Content-Type\":\"application/json\"}");

}
rpa.echo("Execute Node:32");

    rpa.type("images/flyantid.png.targetOffset(-25,10)",numberOnly);

rpa.echo("Execute Node:33");

	rpa.keyboardSend(Key.ENTER);
rpa.echo("Execute Node:31");

    rpa.type("images/nettutar.png.targetOffset(-9,10)",INVOICEAMOUNT);

rpa.echo("Execute Node:34");

	rpa.keyboardSend(Key.ENTER);
rpa.echo("Execute Node:35");

    rpa.type("images/simdialQuantity.png.targetOffset(-3,23)",UNITQUANTITY);

rpa.echo("Execute Node:36");

    rpa.type("images/departmanKodu.png.targetOffset(-4,22)",ACCOUNTCODE);

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
  