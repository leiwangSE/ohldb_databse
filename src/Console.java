import java.sql.Timestamp;

/**
 * Book.java
 * This is a model class represents a book entity
 * @author Lei Wang
 *
 */
public class Console {
    
	protected int consoleID;
    protected String timeStamp;
    protected String rivianPN;
    protected String julianDate;
    protected String SN;
    protected boolean result;
    protected double rotationYaw;
    protected double rotationPitch;
	protected double rotationRoll;
    protected double locationX;
    protected double locationY;
    protected double locationZ;
	protected String image;
    protected String cameraID;
	
   
	public Console() {
    }

    public Console(int consoleID) {
        this.consoleID=consoleID;
    }
    
    

    public Console(String rivianPN, String julianDate, String SN,boolean result,String image) {
        this.rivianPN=rivianPN;
        this.julianDate=julianDate;
        this.SN=SN;
        this.result=result;
        this.image=image;
 //     this.cameraID=cameraID;
    }
     
    public Console(String timeStamp2, String rivianPN, String julianDate, String SN,boolean result,double rotationYaw, double rotationPitch, double rotationRoll, double locationX, double locationY, double locationZ, String image) {
    	this(rivianPN, julianDate, SN, result, image);
    	this.rotationYaw=rotationYaw;
    	this.rotationPitch=rotationPitch;
    	this.rotationRoll=rotationRoll;
    	this.locationX=locationX;
    	this.locationY=locationY;
    	this.locationZ=locationZ;
    	this.timeStamp=timeStamp2;
    }
    
    public int getConsoleID() {
		return consoleID;
	}

	public void setConsoleID(int consoleID) {
		this.consoleID = consoleID;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getRivianPN() {
		return rivianPN;
	}

	public void setRivianPN(String rivianPN) {
		this.rivianPN = rivianPN;
	}

	public String getJulianDate() {
		return julianDate;
	}

	public void setJulianDate(String julianDate) {
		this.julianDate = julianDate;
	}

	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		SN = sN;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	 public double getRotationYaw() {
			return rotationYaw;
	}
	 
	 public void setRotationYaw(double rotationYaw) {
			this.rotationYaw = rotationYaw;
	}	 

	public double getRotationPitch() {
		return rotationPitch;
	}

	public void setRotationPitch(double rotationPitch) {
		this.rotationPitch = rotationPitch;
	}

	public double getRotationRoll() {
		return rotationRoll;
	}

	public void setRotationRoll(double rotationRoll) {
		this.rotationRoll = rotationRoll;
	}

	public double getLocationX() {
		return locationX;
	}

	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	public double getLocationY() {
		return locationY;
	}

	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}

	public double getLocationZ() {
		return locationZ;
	}

	public void setLocationZ(double locationZ) {
		this.locationZ = locationZ;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	 public String getCameraID() {
			return cameraID;
		}

		public void setCameraID(String cameraID) {
			this.cameraID = cameraID;
		}

}


