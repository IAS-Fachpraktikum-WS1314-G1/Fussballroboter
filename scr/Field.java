import java.util.ArrayList;
import java.util.LinkedList;

public class Field {
	// Das ganze Spielfeld. Array mit Felder in 2D

	private FieldSegment[][] field;
	final private int countLine;
	final private int countColumn;
	final int lengthX = 6000;
	final int lengthY = 3000;
	private Roboter ownRobot;

	private int[][] matrix;
	private LinkedList<FieldSegment> finishSegments;

	public Field(int countColumn , int countLine){  //Anzahl Spalten und Zeilen
			
			this.countLine = countLine ;
			this.countColumn = countColumn ;
			
			
			field = new FieldSegment[countColumn][countLine];
			int i = 0;
			
			for(int counterColumn = 0; counterColumn < countColumn; counterColumn++ ){ //Spalte
				for(int counterLine = 0; counterLine < countLine; counterLine ++){ // Zeile
					
					float centerY = ((lengthY / countLine) * counterLine) + ((lengthY / countLine) / 2);
					float centerX = ((lengthX / countColumn) * counterColumn) + ((lengthX / countColumn) / 2);
					
					
					boolean finishSegment = false;
					
					if( (centerY <= -20 || centerY >= 20) && (centerX <= -2980 || centerX >= 2980)  ){
						finishSegment = true;
						
					}
					
					
					
					
					FieldSegment f = new FieldSegment(i , counterColumn, counterLine, centerX , centerY, finishSegment);
					field[counterColumn][counterLine] = f;
					if(finishSegment){
						finishSegments.add(f);
					}
					i ++;
			
				}
			}
				
			for (int j = 0; j <= countColumn; j++) {
				for (int k = 0; k < countLine; k++) {
					float heuristic = Float.MAX_VALUE;
					for (int l = 0; l < finishSegments.size(); l++) {
						float absx = finishSegments.get(l).getCenterX() - field[j][k].getCenterX();
						float absy = finishSegments.get(l).getCenterY() - field[j][k].getCenterY();
						float abs = (float) Math.sqrt(absx * absx + absy *absy );
						if (heuristic > abs){
							heuristic = abs;
						}
					}
				}
			}
	}

	public void addBorder(int from, int to) {

		matrix[from][to] = 1;
		matrix[to][from] = 1;

	}

	public LinkedList<FieldSegment> aStrar(int start, int end) {
		LinkedList<FieldSegment> way = new LinkedList<FieldSegment>();
		return way;
	}

	public void addOwnRoboter(String sopiasIP, int sopiasPort, float x,
			float y, float angle) {
		ownRobot = new Roboter(sopiasIP, sopiasPort, x, y, angle, countColumn,
				countLine);
	}

	public FieldSegment getFieltElement(int colum, int line) {
		return field[colum][line];
	}

	public int getCountLine() {
		return countLine;
	}

	public int getCountColumn() {
		return countColumn;
	}

	public Roboter getOwnRoboter() {
		return ownRobot;
	}

	public int matrix(int a, int b) {
		return matrix[a][b];
	}
}
