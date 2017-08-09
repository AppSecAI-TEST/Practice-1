package head.first.intro;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("MUTE !! (no quack or squeak)");

	}

}
