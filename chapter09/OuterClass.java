package chapter09;

public class OuterClass {
	
	private int outerField;
	public OuterClass() {
	}

	//클래스 속에 클래스 선언할 수 있음 
	class InnterClass{
		private int innerField;
		public InnterClass() {
		}
		public int getInnerField() {
			return innerField;
		}
		public void setInnerField(int innerField) {
			this.innerField = innerField;
		}
	}
	
	//static 붙은 경우 
	static class StaticInnerClass{
		private int staticInnerField;
		public StaticInnerClass() {
		}
		public int getStaticInnerField() {
			return staticInnerField;
		}
		public void setStaticInnerField(int staticInnerField) {
			this.staticInnerField = staticInnerField;
		}
	}
	
	
	public int getOuterField() {
		return outerField;
	}

	public void setOuterField(int outerField) {
		this.outerField = outerField;
	}
	
}
