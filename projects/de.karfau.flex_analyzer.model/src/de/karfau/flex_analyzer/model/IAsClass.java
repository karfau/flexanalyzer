package de.karfau.flex_analyzer.model;

public interface IAsClass extends IAsResource{
	//TODO: extend IAsScope
	String getPackageName();


	static final IAsClass VOID = new AbstractClass() {
		private final String VOID = "void";
		@Override
		public String getPackageName() { return "";	}
		@Override
		public String getName() { return VOID; }
		@Override
		public String getQualifiedName() { return VOID; }
		@Override
		public boolean equals(IAsResource other) { return other == IAsClass.VOID; }
		@Override
		public boolean isSourceAvailable() { return false;	}
	};

}
