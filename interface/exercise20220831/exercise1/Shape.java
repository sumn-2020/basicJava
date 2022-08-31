package exercise20220831.exercise1;

public abstract class Shape implements Comparable<Shape> {

	public abstract double area();

	public abstract double perimeter();

	@Override
	public int compareTo(Shape target) {

		if (this.area() > target.area()) {
			return 1;
		} else if (this.area() < target.area()) {
			return -1;
		} else {
			return 0;
		}

	}
}
