import java.util.ArrayList;
import java.util.LinkedList;


public class Field {
	//Das ganze Spielfeld. Array mit Felder in 2D
	
		 
			private FieldSegment[][] field;
			final private int countLine;
			final private int countColumn;
			final int lengthX = 6000;
			final int lengthY = 3000;
			private Roboter ownRobot;
			private LinkedList<FieldSegment> fieldSegments;
			private int [][] matrix;
			
			
		public Field(int countColumn , int countLine){  //Anzahl Spalten und Zeilen
			this.countLine = countLine ;
			this.countColumn = countColumn ;
			fieldSegments = new LinkedList<FieldSegment>();
			
			field = new FieldSegment[countColumn][countLine];
			int i = 0;
			
			for(int counterColumn = 0; counterColumn < countColumn; counterColumn++ ){ //Spalte
				for(int counterLine = 0; counterLine < countLine; counterLine ++){ // Zeile
					
					float centerY = ((lengthY / countLine) * counterLine) + ((lengthY / countLine) / 2);
					float centerX = ((lengthX / countColumn) * counterColumn) + ((lengthX / countColumn) / 2);
			 
					FieldSegment f = new FieldSegment(i, counterLine, counterLine, centerX , centerY);
					field[counterColumn][counterLine] = f;
					fieldSegments.add(f);		
					i ++;
				}
				
				
			}
			
		}
		
		public void addBorder(int from, int to) {
			
			matrix[from][to] = 1;
			matrix[to][from] = 1;
			
		}
		
		public void addFieldSegment(FieldSegment fieldSegment) {
			fieldSegments.add(fieldSegment);
		}
		
		public void createMatrix() {
			matrix = new int [fieldSegments.size()]	[fieldSegments.size()];
			
			for (int i = 0; i < fieldSegments.size(); i++) {
				for (int j = 0; j < fieldSegments.size(); j++) {
					float absx = fieldSegments.get(i).getCenterX() - fieldSegments.get(j).getCenterX();
					float absy = fieldSegments.get(i).getCenterY() - fieldSegments.get(j).getCenterY();
					if(absx == 6000 / countColumn || absy == 3000 / countLine ){
						addBorder(i, j);
					}
					
				}
			}
		}
		
		
		public LinkedList<FieldSegment> aStrar(int start, int end) {
			LinkedList<FieldSegment> way = new LinkedList<FieldSegment>();
			return way;
		}
		
		public void addOwnRoboter(String sopiasIP, int sopiasPort, float x, float y, float angle){
			ownRobot = new Roboter(sopiasIP, sopiasPort, x, y, angle, countColumn, countLine);
		}
		
		public FieldSegment getFieltElement(int colum, int line){
			return field[colum][line];
		}
		
		public int getCountLine(){
			return countLine;
		}
		
		public int getCountColumn(){
			return countColumn;
		}
		
		
		
		
		
		public Roboter getOwnRoboter(){
			return ownRobot;
		}
		
		public int matrix(int a, int b){
			return matrix[a][b];
		}
}
