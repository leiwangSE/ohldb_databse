
public class Camera {

	private String cameraID;
	private double rotationYaw;
	private double rotationPitch;
	private double rotationRoll;
	private double locationX;
	private double locationY;
	private double locationZ;
	
	public Camera() {
	}
	
	public Camera(double rotationYaw, double rotationPitch,double rotationRoll,double locationX,double locationY,double locationZ) {
		this.rotationYaw=rotationYaw;
		this.rotationPitch=rotationPitch;
		this.rotationRoll=rotationRoll;
		this.locationX=locationX;
		this.locationY=locationY;
		this.locationZ=locationZ;
	}
	
	public Camera(String cameraID, double rotationYaw, double rotationPitch,double rotationRoll,double locationX,double locationY,double locationZ) {
		this(rotationYaw,rotationPitch,rotationRoll,locationX,locationY,locationZ);
		this.cameraID=cameraID;
	}
	
	public String getCameraID() {
		return cameraID;
	}
	public void setCameraID(String cameraID) {
		this.cameraID = cameraID;
	}
	public double getRotationYaw() {
		return rotationYaw;
	}
	public void setRotationYAW(double rotationYaw) {
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
	
}
