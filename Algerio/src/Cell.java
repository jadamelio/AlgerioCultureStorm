import java.util.Random;

public class Cell {

	
	//Properties
	private double xCoord;
	private double yCoord;
	private double xVel;
	private double yVel;
	private double xA;
	private double yA;
	private double mass;
	private double maxSpeed;

	

	// Constructors
	public Cell() {
		xVel = 0;
		yVel = 0;
		xA = 0;
		yA = 0;
		mass = 10;
		xCoord = 0;
		yCoord = 0;
	}

	public Cell(double xC, double yC, double xV, double yV, double xAc, double yAc, double ma) {
		xCoord = xC;
		yCoord = yC;
		xVel = xV;
		yVel = yV;
		xA = xAc;
		yA = yAc;
		mass = ma;
	
	}

	public Cell(double width, double height) {
		xVel = 0;
		yVel = 0;
		xA = 0;
		yA = 0;
		mass = 10;
		Random gen = new Random((int)width);
		xCoord = gen.nextInt();
		gen = new Random((int)height);
		yCoord = gen.nextInt();

	}

	// Methods
//Moves the Cell
	public void update() {
		xVel += xA;
		yVel += yA;
		xCoord += xVel;
		yCoord += yVel;

	}
	//Sets vectors to a coordinate, not exceeding max speed
	public double move(double x, double y, double speed){
		double xVec = this.xCoord - x;
		double yVec = this.yCoord - y;
		double ratio = yVec / xVec;
		for(double i = speed; i >= 0; i -= .1){
			for(double j = speed; j >= 0; j -= .1){
				if(j/i < ratio + .2 && j/i > ratio - .2 && Math.sqrt((j*j)+(i*i)) <= speed){
					this.setyVel(i);
					this.setxVel(j);
					return j/i;
				}
			}
		}
		
		return -1;
		
	}

	public void eat(Cell cell) {

	}

	
	//Setters and getters
	public double getxCoord() {
		return xCoord;
	}
	
	public double getMomentum(){
		return this.getMass() * Math.sqrt(this.getxVel()*this.getxVel()+this.getyVel()*this.getyVel());
	}

	public void setxCoord(double xCord) {
		this.xCoord = xCord;
	}

	public double getyCoord() {
		return yCoord;
	}

	public void setyCoord(double yCord) {
		this.yCoord = yCord;
	}

	public double getxVel() {
		return xVel;
	}

	public void setxVel(double xVel) {
		this.xVel = xVel;
	}

	public double getyVel() {
		return yVel;
	}

	public void setyVel(double yVel) {
		this.yVel = yVel;
	}

	public double getxA() {
		return xA;
	}

	public void setxA(double xA) {
		this.xA = xA;
	}

	public double getyA() {
		return yA;
	}

	public void setyA(double yA) {
		this.yA = yA;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}
	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

}
