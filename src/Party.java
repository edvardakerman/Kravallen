import java.util.ArrayList;
import java.util.Random;

public class Party extends Location {
	private ArrayList<String> music = new ArrayList<String>();

	public Party(String name, String description) {
		super(name, description);
	}

	public void dance() {
		System.out.println("CHACHACHA");
	}

	public void setMusic(String newMusic) {
		music.add(newMusic);
	}

	public ArrayList<String> getMusic() {
		return this.music;
	}

	public String shuffleMusic() {
		Random rnd = new Random();
		return music.get(rnd.nextInt(music.size()));
	}

	@Override
	public void describeYourself() {
		super.describeYourself();
		System.out.println(shuffleMusic() + " Spelas högt!!!!");
	}
}
