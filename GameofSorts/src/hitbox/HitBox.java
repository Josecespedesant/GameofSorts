package hitbox;

/**
 * Declaration of the class HitBox..
 * @author Jose Antonio Cespedes Downing
 */
public class HitBox {
	/**
	 * Attributes of the class HitBox, including position x and y of the hit box and the width and height of the entity.
	 */
	private float x, y;
	private int width, height;
	
	/**
	 * Constructor of the class HitBox.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public HitBox (float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Allows the hit box to be moved.
	 * @param x
	 * @param y
	 */
	public void move (float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Allows the hit box to be moved only on the x axis.
	 * @param x
	 */
	public void move (float x) {
		this.x = x;
		this.y = 50f;
	}
	
	/**
	 * Method that verify if two hit boxes collided.
	 * @param rect
	 * @return true if two hit boxes collided false if not.
	 */
	public boolean collidesWith (HitBox rect) {
		return x < rect.x + rect.width && y < rect.y + rect.height && x + width > rect.x && y + height > rect.y;
	}
	
	/**
	 * Return the X position of the hit box.
	 * @return x
	 */
	public float getX() {
		return x;
	}

	/**
	 * Sets the X position of the hit box.
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Return the Y position of the hit box.
	 * @return y
	 */
	public float getY() {
		return y;
	}

	/**
	 * Sets the Y position of the hit box.
	 * @param y
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * Returns the width of the hit box
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width of the hit box.
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Returns the height of the hit box
	 * @return width
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the width of the hit box.
	 * @param width
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	
	

}
