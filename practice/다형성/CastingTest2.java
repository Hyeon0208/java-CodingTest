class CastingTest2 {
	public static void main(String args[]) {
		//Car car = new Car(); 컴파일 에러 해결을 위해 아래로 인스턴스 변경.
		Car car = new FireEngine();
		Car car2 = null;
		FireEngine fe = null;
  
		car.drive();
		fe = (FireEngine)car; // 조상 타입의 인스턴스를 자손 타입의 참조 변수로 참조하는 것은 허용 x
		fe.drive();
		car2 = fe;
		car2.drive();
	}
}

class Car {
	String color;
	int door;

	void drive() { 		// 운전하는 기능
		System.out.println("drive, Brrrr~");
	}

	void stop() {		// 멈추는 기능	
		System.out.println("stop!!!");	
	}
}

class FireEngine extends Car {	// 소방차
	void water() {		// 물을 뿌리는 기능
		System.out.println("water!!!");
	}
}