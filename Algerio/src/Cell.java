import java.util.ArrayList;
import java.util.Random;

public class Cell implements MainInterface
{
  

private int xCoord;
  private int yCoord;
  private int xVel;
  private int yVel;
  private int xA;
  private int yA;
  private int mass;
  private ArrayList<Cell> subCells = new ArrayList<Cell>();
  private boolean div;
  private String type;
  private ArrayList<Cell> sense;

  // Constructors
  public Cell()
  {
    xVel = 0;
    yVel = 0;
    xA = 0;
    yA = 0;
    mass = 10;
    xCoord = 0;
    yCoord = 0;
    type = "Food";
  }

  public Cell(int xC, int yC, int xV, int yV, int xAc, int yAc, int ma,
      String a, ArrayList<Cell> b)
  {
    xCoord = xC;
    yCoord = yC;
    xVel = xV;
    yVel = yV;
    xA = xAc;
    yA = yAc;
    mass = ma;
    type = a;
    sense = b;
  }

  public Cell(int width, int height, String a)
  {
    xVel = 0;
    yVel = 0;
    xA = 0;
    yA = 0;
    mass = 10;
    type = a;
    Random gen = new Random(width);
    xCoord = gen.nextInt();
    gen = new Random(height);
    yCoord = gen.nextInt();

  }

  // Methods

  public void update()
  {
    xVel += xA;
    yVel += yA;
    xCoord += xVel;
    yCoord += yVel;
    if (div)
    {
      for (Cell a : subCells)
      {
        a.xVel = this.xVel;
        a.yVel = this.yVel;
        a.xCoord += a.xVel;
        a.yCoord += a.yVel;
      }
    }
  }

  public void eat(Cell cell)
  {

    if (div)
    {
      for (Cell a : subCells)
      {
        a.mass += cell.mass / (subCells.size() + 1);
      }
      this.mass += cell.mass / (subCells.size() + 1);
    }
    else
    {
      mass += cell.mass;
    }
  }

  public void divide()
  {
    if (mass > 60)
    {
      if (div)
      {
        for (Cell a : subCells)
        {
          if (mass > 60)
          {
            if (xVel != 0 && yVel != 0)
            {
              subCells.add(new Cell((xVel / xVel) * a.mass, (yVel / yVel)
                  * a.mass, xVel, yVel, 0, 0, a.mass / 2, "Cell", null));
              a.mass = a.mass / 2;
              div = true;
            }
            else
            {
              subCells.add(new Cell((1) * a.mass, (1) * a.mass, xVel, yVel, 0,
                  0, a.mass / 2, "Cell", null));
              a.mass = a.mass / 2;
              div = true;
            }
          }
        }

      }
      else
      {
        if (xVel != 0 && yVel != 0)
        {
          subCells.add(new Cell((xVel / xVel) * mass, (yVel / yVel) * mass,
              xVel, yVel, 0, 0, mass / 2, "Cell", null));
          mass = mass / 2;
          div = true;

        }
        else
        {
          subCells.add(new Cell((1) * mass, (1) * mass, xVel, yVel, 0, 0,
              mass / 2, "Cell", null));
          mass = mass / 2;
          div = true;
        }
      }
    }

  }

  public void main()
  {

  }



public int getxCoord() {
	return xCoord;
}

public void setxCoord(int xCord) {
	this.xCoord = xCord;
}

public int getyCoord() {
	return yCoord;
}

public void setyCoord(int yCord) {
	this.yCoord = yCord;
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

public ArrayList<Cell> getSubCells() {
	return subCells;
}

public void setSubCells(ArrayList<Cell> subCells) {
	this.subCells = subCells;
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

}
