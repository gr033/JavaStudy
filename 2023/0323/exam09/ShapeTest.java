package exam09;
public class ShapeTest {

	public static void main(String[] args) {
		Shape []data = new Shape[3];
		data[0] = new Shpere(10, 10, 5);
		data[1] = new Triangle(5, 5, 10, 5);
		data[2] = new Cylinder(3, 3, 10, 3);
		for(int i=0;i<data.length;i++) {
			if(data[i] instanceof TwoDimShape) {
				((TwoDimShape)data[i]).calcArea();
			}
			else if (data[i] instanceof ThreeDimShape) {
				((ThreeDimShape)data[i]).calcVolume();
			}
		}
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
		
	}

}
