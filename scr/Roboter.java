import javax.swing.plaf.SliderUI;

import sopias2libraries.*;


public class Roboter extends CommunicationLibrary  {
	private CStatus cStatus;
	private String sopiasIP; 
	private int sopiasPort;
	private int fieldPositionColumn;
	private int fieldPositionLine;
	private int fieldCountColumn;
	private int fieldCountLine;
	
	
	
	
	public Roboter(String sopiasIP, int sopiasPort, float x, float y, float angle, int fieldCountColumn, int fieldCountLine ){
		cStatus = new CStatus();
		cStatus.x = x;
		cStatus.y = y;
		cStatus.angle = angle;
		this.sopiasIP = sopiasIP;
		this.sopiasPort = sopiasPort;
		this.fieldCountColumn  = fieldCountColumn;
		this.fieldCountLine = fieldCountLine;
		calculateFieldPosition();
		
	}
	
	public CStatus getCStatus(){
		return cStatus;
	}
	
	public int connectRobot(){
		int r = connectRobot(sopiasIP, sopiasPort, cStatus.x, cStatus.y, cStatus.angle);
		cStatus = getCStatus();
		return r;
	}
	
	public void calculateFieldPosition(){
		float wideFieldX = 6000 / fieldCountColumn; //5000 = breite Spielfeld
		float heightFieldY = 3000 / fieldCountLine; //3000 = höhe Spielfeld 
		
		
		fieldPositionColumn = (int) ( (cStatus.x + 3000) / wideFieldX); //3000 = negativer Bereich
		fieldPositionLine =  (int)  (  ((cStatus.y - 1500) * -1) / heightFieldY); // 1500 = negativer Bereich
		
	}
	
public void driveRobot(FieldSegment fieldSegment){
		
		float x =  (cStatus.x + 2500) - fieldSegment.getCenterX()   ; 
		float y =  ((cStatus.y - 1500) * -1) -  fieldSegment.getCenterY()  ;
		float angle = 0;
		
		
		if (x > 0 && y > 0 ) {
			angle = (float) Math.atan(y / x);
		}
		else if (x == 0 && y > 0) {
			angle = (float) Math.PI / 2;
		} 
		else if (x < 0 && y > 0 ) {
			angle = (float) (Math.PI /2 + Math.atan(y / Math.abs(x)));
		} 
		else if (x < 0 && y == 0) {
			angle = (float) Math.PI;
		}
		else if (x < 0 && y < 0) {
			angle = (float) ((Math.PI) + Math.atan(Math.abs(x) / Math.abs(y)));
		}
		else if (x == 0 && y < 0) {
			angle =  (float) (270 * Math.PI / 180);
		}
		else if (x > 0 && y < 0) {
			angle = (float) ((270 * Math.PI / 180) + (Math.atan(x / Math.abs(y))));
		}
		else{
			angle = 0;
		}

		float deltaAngle = angle - cStatus.angle;		
		 
		float distance = (float) ((float) Math.sqrt(Math.abs(x) * Math.abs(x) + Math.abs(y) * Math.abs(y)));
		rotateRobot(deltaAngle);
		driveRobot(distance);
		getOwnStatus(cStatus);
		calculateFieldPosition();
		
	}
	
	public int getFieldPosColumn(){
		return fieldPositionColumn;
	}
	
	public int getFieldPosLine() {
		return fieldPositionLine;
	}
	
	public void driveR(){
		driveRobot(610);
		getOwnStatus(cStatus);
	}
	
	public String toString(){
		return "Aktuelle Position --> x-Position: " + cStatus.x + " y-Position: " + cStatus.y + " angle: " + cStatus.angle + " fieldPositionColumn: " + fieldPositionColumn + " fieldPositionLine: " + fieldPositionLine;
	}
}
