import java.util.ArrayList;


public class FieldSegment {
	private int positionLine;
	private int positionColum;
	private int id;
	private boolean obstacleStatus;
	public boolean visited;
	final private float centerX;
	final private float centerY;
	private int heuristic; //geschätzter weg Knoten->Ziel
	private int range; //weg Start->Knoten
	private int comefrom;
	
	public FieldSegment(int id, int positionColum, int positionLine, float centerX, float centerY){
		this.id = id;
		this.positionLine = positionLine;
		this.positionColum = positionColum;
		this.centerX = centerX;
		this.centerY = centerY;
		
	}

	

	public int getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(int heuristic) {
		this.heuristic = heuristic;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getComefrom() {
		return comefrom;
	}

	public void setComefrom(int comefrom) {
		this.comefrom = comefrom;
	}

	public float getCenterX() {
		return centerX;
	}

	public float getCenterY() {
		return centerY;
	}
	
	public int getValue(){
		return heuristic + range;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}




