package practice.nestedClass;

public class OuterClass {

	private int outerField;

	public OuterClass() {

	}

	public int getOuterField() {
		return outerField;
	}

	public void setOuterField(int outerField) {
		this.outerField = outerField;
	}

	// innerClass 시작
	class InnerClass {
		private int innerField;

		public InnerClass() {

		}

		public int getInnnerField() {
			return innerField;
		}

		public void setInnerField(int innerField) {
			this.innerField = innerField;
		}
	}

	// static StaticInnerClass 시작
	static class StaticInnerClass {
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

}
