package head.first.intro;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.display();
		mallard.performFly();
		mallard.quack();
		System.out.println(" ====== ");
		
		FlyBehavior fb = new FlyNoWay();
		QuackBehavior qb = new Squeak();
		// set new behaviors for Mallard duck
		mallard.setFlyBehavior(fb);
		mallard.setQuackBehavior(qb);

		mallard.performFly();
		mallard.quack();
		
		System.out.println(" ==== now Model Duck ==");
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}
}
