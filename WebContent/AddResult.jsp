<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>AddResult Application</title>
</head>
<body>
    <center>
        <h1>AddResult Application</h1>
      
    </center>
    <div align="center">
       
            <form action="AddResult" method="post">
       
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                  
                        Add Result     
                </h2>
            </caption>
                
            <tr>
                <th>RivianPN: </th>
                <td>
                    <input type="text" name="rivianPN" size="45"
                            value="<c:out value='${user.username}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>JulianDate: </th>
                <td>
                    <input type="text" name="julianDate" size="45"
                            value="<c:out value='${user.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>SerialNumber: </th>
                <td>
                    <input type="text" name="serialNumber" size="45"
                            value="<c:out value='${user.firstname}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>IsTestPass: </th>
                <td>
                    <input type="text" name="result" size="45"
                            value="<c:out value='${user.lastname}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Image: </th>
                <td>
                    <input type="text" name="image" size="45"
                            value="<c:out value='${user.age}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>CameraID: </th>
                <td>
                    <input type="text" name="cameraID" size="45"
                            value="<c:out value='${user.age}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
        
    </div>
    
    <p id="demo">Hello</p>

    	<script>
    	var xmlhttp = new XMLHttpRequest();
    	xmlhttp.onreadystatechange = function() {
    	  if (this.readyState == 4 && this.status == 200) {
    	    var myObj = JSON.parse(this.responseText);
    	    document.getElementById("demo").innerHTML = myObj.name+" , "+myObj.age;
    	  }
    	};
    	xmlhttp.open("GET", "json_demo.txt", true);
    	xmlhttp.send();
    	</script>
    	
    	<p>Take a look at <a href="json_demo.txt" target="_blank">json_demo.txt</a></p>
    	   
</body>
</html>