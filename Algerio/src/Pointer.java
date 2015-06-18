import java.util.ArrayList;

public class Pointer implements MainInterface {

	private int xCoord;

	private int yCoord;
	private int xVel;
	private int yVel;
	private int xA;
	private int yA;
	private int mass;
	private boolean div;
	private String type;
	private ArrayList<Cell> sense;
	private ArrayList<Cell> subCells;

	public Pointer(int xCoord, int yCoord, int xVel, int yVel, int xA, int yA,
			int mass, boolean div, String type, ArrayList<Cell> sense,
			ArrayList<Cell> subCells) {
		super();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.xVel = xVel;
		this.yVel = yVel;
		this.xA = xA;
		this.yA = yA;
		this.mass = mass;
		this.div = div;
		this.type = type;
		this.sense = sense;
		this.subCells = subCells;
	}

	@Override
	public void main() {
		update();

	}

	public void update() {
		for (Cell cell : subCells) {
			cell.setxVel(xVel);
			cell.setyVel(yVel);
			cell.setxA(cell.getxA() + xA);
			cell.setyA(cell.getyA() + yA);
			cell.update();

		}
	}

	public void divide() {
		ArrayList<Cell> temp = new ArrayList<Cell>();
		for (Cell cell : subCells) {
			if (cell.getMass() > 59) {
				temp.add(new Cell(cell.getxCoord() + cell.getMass(), cell
						.getyCoord() + cell.getMass(), cell.getxVel(), cell
						.getyVel(), cell.getyA(), cell.getxA(),
						cell.getMass() / 2));
				cell.setMass(cell.getMass() / 2);
			}
		}
		for (Cell cell : temp) {
			subCells.add(cell);
		}
	}

	public int removeCell(Cell cell) {
		mass = cell.getMass();
		subCells.remove(cell);
		return mass;
	}

	// Not sure about this
	private void cDxV(Cell cell, int value) {
		cell.setxVel(value);
	}

	private void cDyV(Cell cell, int value) {
		cell.setyVel(value);
	}

	private void cDyAc(Cell cell, int value) {
		cell.setyA(value);
	}

	private void cDxAc(Cell cell, int value) {
		cell.setxA(value);
	}

	private void cDxCoord(Cell cell, int value) {
		cell.setxCoord(value);
	}

	private void cDyCoord(Cell cell, int value) {
		cell.setyCoord(value);
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int getxVel() {
		return xVel;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	public int getxA() {
		return xA;
	}

	public void setxA(int xA) {
		this.xA = xA;
	}

	public int getyA() {
		return yA;
	}

	public void setyA(int yA) {
		this.yA = yA;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public boolean isDiv() {
		return div;
	}

	public void setDiv(boolean div) {
		this.div = div;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Cell> getSense() {
		return sense;
	}

	public void setSense(ArrayList<Cell> sense) {
		this.sense = sense;
	}

	public ArrayList<Cell> getSubCells() {
		return subCells;
	}

	public void setSubCells(ArrayList<Cell> subCells) {
		this.subCells = subCells;
	}

}
