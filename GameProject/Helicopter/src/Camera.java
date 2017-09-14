
public class Camera extends Sprite {

	int camSpeed = GameConstants.CameraSpeed;

	public void moveCamera() {
		x = x + camSpeed;
	}

	public void left() {
		camSpeed = -GameConstants.CameraSpeed;
		moveCamera();
	}

	public void right() {
		camSpeed = GameConstants.CameraSpeed;
		moveCamera();
		// System.out.println("right");;
	}
}
// public void moveBackground(){
//
// right();
//
// }
