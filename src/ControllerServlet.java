
import java.io.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.*;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author 	Lei
 */

/**
 * To do after test on 1/5/2021
  1. call the api
 *2. store the JSON result into a string variable
 */

public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
	
    private ConsoleDao consoleDao;
    private CameraDao cameraDao;
    private HasDao hasDao;
    private HttpSession session=null;
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        consoleDao = new ConsoleDao(jdbcURL, jdbcUsername, jdbcPassword);
        cameraDao = new CameraDao(jdbcURL, jdbcUsername, jdbcPassword);
        hasDao = new HasDao(jdbcURL, jdbcUsername, jdbcPassword);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String action = request.getServletPath();
        String action = "/AddResult";
        System.out.println("Action + " + action);
        try {
			addResult(request, response);
		} catch (JSONException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        try {
//            switch (action) {
//           
//                
//            case "/AddResult":
//                addResult(request, response);
//                break;
//            case "/AddCamera":
//                addCamera(request, response);
//                break;
//            case "/AddHas":
//                addHas(request, response);
//                break;
//            }
//        } catch (SQLException | JSONException ex) {
//            throw new ServletException(ex);
//        }
    }



 
    private void addResult(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, JSONException {
//    	String st=null;
//    	
//    	 File file = 
//    		      new File("C:\\Users\\leo.wang.DAIMAYUS\\eclipse-workspace\\ohldb\\json_demo.txt"); 
//    		    Scanner sc = new Scanner(file); 
//    		  
//    		    while (sc.hasNextLine()) {
//    		      System.out.println(sc.nextLine()); 
//    		      
//    		      st=st+sc.nextLine();
//    		      
//   		     
//    		    }
//    		    System.out.println("JSON file is: "+st); 
//    	
//    	BufferedReader br = 
//    			new BufferedReader(new InputStreamReader(request.getInputStream()));
//    			System.out.println("BR is "+br);
//    			String str = null;
//    			if(br != null){
//    				str = br.readLine();
//    				System.out.println("Json is "+str);
//    			}
    			System.out.println("aaaaaaaaaaaa");
    			String str;
//    			 save the json insider body into BufferedReader
    			try(BufferedReader br = new BufferedReader(
    					  new InputStreamReader(request.getInputStream()))) {
    					    StringBuilder sBuilder = new StringBuilder();
    					    String responseLine = null;
    					    //Use a StringBuilder object to save each line of JSON and append them to the object sBuilder
    					    while ((responseLine = br.readLine()) != null) {
    					        sBuilder.append(responseLine.trim());
    					    }
    					    // Convert the StringBuilder object to String
    					     str=sBuilder.toString();
    					    System.out.println("Json is "+str);
    					    System.out.println("bbbbbbb");
    					}
//    			
//    	 String str="{ \n" + 
//    			"  \"TimeStamp\": \"1602659086\", \n" + 
//    			"  \"RivianPN\": \"PT00001318\", \n" + 
//    			"  \"JulianDate\": \"15220\", \n" + 
//    			"  \"SerialNumber\": \"S0002\", \n" + 
//    			"  \"IsTestPass\": true, \n" + 
//    			"  \"cameraPosition\": { \n" + 
//    			"    \"rotationYaw\": -0.1427205900014383, \n" + 
//    			"    \"rotationPitch\": 0.10641959321769616, \n" + 
//    			"    \"rotationRoll\": 0.0046324585548323865, \n" + 
//    			"    \"locationX\": -8.8967075940954228, \n" + 
//    			"    \"locationY\": -6.180881120975962, \n" + 
//    			"    \"locationZ\": 28.494181203192852 \n" + 
//    			"  }, \n" + 
//    			"  \"Base64Image\": \"/9j/4AAQSkZJRgABAQEAYABg.....\" \n" + 
//    			"}";
    	

    	JSONObject obj = new JSONObject(str);
    	String timeStamp = obj.getString("TimeStamp");
//    	String rivianPN = obj.getString("RivianPN");
//    	String julianDate = obj.getString("JulianDate");
//    	String serialNumber = obj.getString("SerialNumber");
    	String decodeBarcode = obj.getString("DecodedBarcode");
    	boolean isTestPass = obj.getBoolean("IsTestPass");
    	String base64Image = obj.getString("Base64Image");
//    	String cameraID ="a14";
    	JSONObject camera = obj.getJSONObject("cameraPosition");
    	Double rotationYaw =camera.getDouble("rotationYaw");
    	Double rotationPitch =camera.getDouble("rotationPitch");
    	Double rotationRoll =camera.getDouble("rotationRoll");
    	Double locationX =camera.getDouble("locationX");
    	Double locationY =camera.getDouble("locationY");
    	Double locationZ =camera.getDouble("locationZ");
    	String rivianPN=decodeBarcode.substring(0,16);
		String julianDate=decodeBarcode.substring(16,21);
		String serialNumber=decodeBarcode.substring(21,34);
		
        
//        Double rotationPitch =Double.parseDouble(request.getParameter("rotationPitch"));
//        System.out.println("rotationPitch: "+rotationPitch);
//        Double rotationRoll =Double.parseDouble(request.getParameter("rotationRoll"));
//        System.out.println("rotationRoll: "+rotationRoll);
//        Double locationX =Double.parseDouble(request.getParameter("locationX"));
//        System.out.println("locationX: "+locationX);
//        Double locationY =Double.parseDouble(request.getParameter("locationY"));
//        System.out.println("locationY: "+locationY);
//        Double locationZ =Double.parseDouble(request.getParameter("locationZ"));
//        System.out.println("locationZ: "+locationZ);
        
//    	String cameraPosition = obj.getString("cameraPosition");
//    	String rotation = obj.getString("rotation");
    	
    	System.out.println("timeStamp from JSON: "+timeStamp);
        System.out.println("rivianPN from JSON: "+rivianPN);
        System.out.println("julianDate from JSON: "+julianDate );
        System.out.println("serialNO from JSON: "+serialNumber);
    	System.out.println("decodeBarcode from JSON: "+decodeBarcode);
        System.out.println("isTestPass from JSON: "+isTestPass);
        System.out.println("image from JSON: "+base64Image);
	    System.out.println("cameraPosition is "+camera);
	    System.out.println("rotationYaw from JSON: "+rotationYaw);
	    System.out.println("rotationPitch from JSON: "+rotationPitch);
	    System.out.println("rotationRoll from JSON: "+rotationRoll);
	    System.out.println("locationX from JSON is \""+locationX+"\"");
	    System.out.println("locationY from JSON is "+locationY);
	    System.out.println("locationZ from JSON is "+locationZ);
//      System.out.println("rotation: "+rotation);
        
    	
    	
//    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        String rivianPN = request.getParameter("rivianPN");
//        String julianDate =request.getParameter("julianDate");
//        String sn =request.getParameter("serialNumber");
//        String result =request.getParameter("result");
//        String image =request.getParameter("image");
//        String cameraID =request.getParameter("cameraID");
//      
//        System.out.println(timestamp);
//        System.out.println(rivianPN);
//        System.out.println(julianDate);
//        System.out.println(sn);
//        System.out.println(result);
//        System.out.println(image);
//        System.out.println(cameraID);
        
//        sc.close();
        Console newConsole = new Console(timeStamp, rivianPN, julianDate, serialNumber, isTestPass, rotationYaw, rotationPitch, rotationRoll, locationX, locationY, locationZ, base64Image);
        consoleDao.insertConsole(newConsole);
        response.sendRedirect("Updated.jsp");
    }
    
//    private void addCamera(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//    	System.out.println("addCamera");
//        String cameraID = request.getParameter("cameraID");
//        System.out.println("cameraID: "+cameraID);
//        Double rotationYaw =Double.parseDouble(request.getParameter("rotationYaw"));
//        System.out.println("rotationYaw "+request.getParameter("rotationYaw"));
//        Double rotationPitch =Double.parseDouble(request.getParameter("rotationPitch"));
//        System.out.println("rotationPitch: "+rotationPitch);
//        Double rotationRoll =Double.parseDouble(request.getParameter("rotationRoll"));
//        System.out.println("rotationRoll: "+rotationRoll);
//        Double locationX =Double.parseDouble(request.getParameter("locationX"));
//        System.out.println("locationX: "+locationX);
//        Double locationY =Double.parseDouble(request.getParameter("locationY"));
//        System.out.println("locationY: "+locationY);
//        Double locationZ =Double.parseDouble(request.getParameter("locationZ"));
//        System.out.println("locationZ: "+locationZ);
//      
//        System.out.println(cameraID);
//        System.out.println(rotationYaw);
//        System.out.println(rotationPitch);
//        System.out.println(rotationRoll);
//        System.out.println(locationX);
//        System.out.println(locationY);
//        System.out.println(locationZ);
//        
//        Camera newCamera = new Camera(cameraID, rotationYaw, rotationPitch, rotationRoll, locationX,locationY,locationZ);
//        cameraDao.insertCamera(newCamera);
//        response.sendRedirect("Updated.jsp");
//    }
//    
//    private void addHas(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//    	int consoleID=Integer.parseInt(request.getParameter("consoleID"));
//        String cameraID =request.getParameter("cameraID");
//      
//        System.out.println(consoleID);
//        System.out.println(cameraID);
//        
//        Has newHas = new Has(consoleID, cameraID);
//        hasDao.insertHas(newHas);
//        response.sendRedirect("Updated.jsp");
//    }
    
}