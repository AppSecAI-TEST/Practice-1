package head.first.intro;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public Duck() {
		// wanna do something for each type of duck
	}

	public abstract void display();

	public void performFly() {
		flyBehavior.fly();
	}

	public void quack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float, even decoys! (EVERY DUCK FLOATS)");
	}

	// setting behavior of a duck dynamically @ runtime
	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
}

class MallardDuck extends Duck {

	public MallardDuck() {
		super();
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	@Override
	public void display() {
		System.out.println("Mallard Duck");
	}

}

class ModelDuck extends Duck {

	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	@Override
	public void display() {
		System.out.println("I’m a model duck");
	}

}
