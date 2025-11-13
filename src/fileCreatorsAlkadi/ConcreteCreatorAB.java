package fileCreatorsAlkadi;

import java.io.IOException;

public class ConcreteCreatorAB extends Creator {

	@Override
	public Product factoryMethod(String typ) throws IOException {
		// TODO Auto-generated method stub
		if (typ.equals("csv")) {
			return new ConcreteProductA();
		}
		else {
			return new ConcreteProductB();
		}
	}

}
