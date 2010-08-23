package
{
	import de.karfau.test.MyClass;
	
	import flash.display.Sprite;
	
	/**
	 * My desription
	 *
	 * @result bla
	 *
	 * @throws VerifyError when wrong
	 * @throws ArgumentError never
	 *
	 * @see de.karfau.test.MyClass
	 * */
	public class Main extends Sprite
	{
		public function Main () {
			var ole:String = "olé";
			var test:MyClass = new MyClass(1, 2, ole);
			test.test = "Hello World";
			trace(test.test);
			if (true) {
				trace();
			} else if (false) {
				trace();
			} else {
				trace();
			}
		}
	}
}