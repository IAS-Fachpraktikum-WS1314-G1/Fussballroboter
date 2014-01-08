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
		float wideFieldX = 5000 / fieldCountColumn; //5000 = breite Spielfeld
		float heightFieldY = 3000 / fieldCountLine; //3000 = höhe Spielfeld 
		
		
		fieldPositionColumn = (int) ( (cStatus.x + 2500) / wideFieldX); //2500 = negativer Bereich
		fieldPositionLine = (int) ( (1500 + cStatus.y) / heightFieldY); // 1500 = negativer Bereich
		
	}
	
	public void driveRobot(FieldSegment fieldSegment){
		System.out.println("Roboter");
		float x = Math.abs( (cStatus.x + 2500) - fieldSegment.getCenterX()   ); 
		float y = Math.abs( (cStatus.y + 1500) -  fieldSegment.getCenterY()  );
		float angle;
		System.out.println(cStatus.x + " +2500 - " + fieldSegment.getCenterX() + " = " + x);
		System.out.println("für x ist das ergebnis: " + x);
		if (x == 0 ) {
			angle = (float) 1.57;
			System.out.println("agfjaödfklgjadflökjg " + x);
		
		} else {
			angle = (float) Math.tan(y / x);
			System.out.println("ok");
		}
		 
		float distance = (float) ((float) Math.sqrt(x * x + y * y) + 3.5);
		System.out.println(angle);
		System.out.println(distance + 3.5 );
		System.out.println(rotateRobot(angle));
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
		this.driveRobot(50);
	}
	
	public String toString(){
		return "Aktuelle Position --> x-Position: " + cStatus.x + " y-Position: " + cStatus.y + " angle: " + cStatus.angle + " fieldPositionColumn: " + fieldPositionColumn + " fieldPositionLine: " + fieldPositionLine;
	}
}
