import java.security.acl.Owner;
import java.util.LinkedList;


public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<E>
		Field f1 = new Field(5, 5);
//		f1.addOwnRoboter("127.0.0.1", 22223, 0, 100, 0);
//		f1.getOwnRoboter().connectRobot();
//		System.out.println(f1.getOwnRoboter());
//		
//		f1.getOwnRoboter().driveRobot(f1.getFieltElement(f1.getOwnRoboter().getFieldPosColumn(), f1.getOwnRoboter().getFieldPosLine() - 1));
//		System.out.println(f1.getOwnRoboter());
//		f1.getOwnRoboter().driveRobot(f1.getFieltElement(f1.getOwnRoboter().getFieldPosColumn() + 1, f1.getOwnRoboter().getFieldPosLine() ));
//		System.out.println(f1.getOwnRoboter());
		
		f1.createMatrix();
		
		System.out.println(f1.matrix(0, 4));
		
		for (int i = 0; i <= 8 ; i++) {
			System.out.println(i + "  " + f1.matrix(0, i));
		}
	}
//höklhjköhöhöjkhökjhkjöasdhg
//adfgdjgäldfkjgäfdasa
//adsfgkfdägldfkgflök
}
