package de.karfau.test
{
	public class MyClass
	{
		/**
		 * 
		 * @param value bla
		 * @param args blub
		 * 
		 */
		public function MyClass(value:Number,... args)
		{
			trace("construced MyClass");
		}
		private var _test:String = "TESTE";

		public function get test():String
		{
			trace("construced MyClass");
			return _test;
		}

		public function set test(value:String):void
		{
			trace("construced MyClass");
			_test = value;
		}

	}
}