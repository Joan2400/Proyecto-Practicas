package TESTAEV5.AVSYP5;

 
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * @author Usuario
 *
 */
@ComponentScan({"TESTAEV5.Controller","TESTAEV5.Service"})
@EntityScan("TESTAEV5.model")
@EnableJpaRepositories("TESTAEV5.repository")
@SpringBootApplication
public class SprintBootH2Application {
	
   /**
 * @param args
 * @throws IOException
 * inicializa la aplicacion y recoje la ip y el timestrap del servidor, despues los plasma en un fichero de texto
 */
public static void main(String[] args) throws IOException {
	   
	   
      SpringApplication.run(SprintBootH2Application.class, args);
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      
      InetAddress ip = null;
      String hostname;
      try {
          ip = InetAddress.getLocalHost();
          hostname = ip.getHostName();
          System.out.println("Your current IP address : " + ip);
          System.out.println("Your current Hostname : " + hostname);
      } catch (UnknownHostException e) {
          e.printStackTrace();
      }
  
      try {
          FileWriter writer = new FileWriter("C:\\Users\\Usuario\\eclipse-workspace\\AVSYP5\\AVSYP5-backend\\src\\main\\resources\\log.txt", true);
          writer.write(timestamp.toString());
          writer.write("\r\n");   
          writer.write(ip.toString());
          writer.write("\r\n"); // write new line
          writer.write("\r\n"); 

          writer.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
   }
}