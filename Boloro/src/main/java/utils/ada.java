package utils;

import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.LocalDateTime;    

public class ada {
	  

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd" );  
		   LocalDateTime now = LocalDateTime.now();  
		   DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");  
		   LocalDateTime now1 = LocalDateTime.now();
		   String Date =dtf.format(now);
		   String Time =dtf1.format(now1);
		   System.out.println(Date+"T"+Time+".000Z");
		   
		   DateTimeFormatter fdtf = DateTimeFormatter.ofPattern("yyyy-MM-dd" );  
		   LocalDateTime fnow = LocalDateTime.now().plusHours(1);  
		   DateTimeFormatter fdtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");  
		   LocalDateTime fnow1 = LocalDateTime.now().plusHours(1);;
		   String fDate =fdtf.format(fnow);
		   String fTime =fdtf1.format(fnow1);
		   System.out.println(fDate+"T"+fTime+".000Z");
		   
		   System.out.println( Instant.now().toString()  );
		   System.out.println( Instant.now().plusSeconds(3600).toString()  );
		   
	}

}
