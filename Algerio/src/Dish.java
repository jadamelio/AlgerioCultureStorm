import java.util.ArrayList;

public class Dish
{

  public static void main(String[] args)
  {
    int width = 2000;
    int height = 200;

    ArrayList<Cell> cells = new ArrayList<Cell>();
    cells.add(new jackCellv1());
    cells.get(0).setxVel(1);
    cells.get(0).setType("Cell");
    
    while (true)
    {
      Agar(cells, width, height);
    }
  }

  public static void Agar(ArrayList<Cell> cells, int width, int height)
  {
    for (int i = 0; i < cells.size(); i++)
    {
      // trace("Loop");

      if (cells.get(i).getType().equals("Cell"))
      {
        cells.get(i).main();
        trace(cells.get(i).isDiv());
      }
      wallDetect(cells.get(i), width, height);
      cells = hitDetect(cells);

    }

  }

  public static ArrayList<Cell> hitDetect(ArrayList<Cell> cells)
  {
    if (cells.size() > 1)
    {

      for (int i = 0; i < cells.size(); i++)
      {
        if (cells.get(i).getType().equals("Cell"))
        {
          for (int j = i + 1; j < cells.size(); j++)
          {
            int xDis = cells.get(i).getxCoord() - cells.get(j).getxCoord();
            int yDis = cells.get(i).getyCoord() - cells.get(j).getyCoord();
            double distance = Math.abs((xDis ^ 2 + yDis ^ 2) ^ (1 / 2));
           
            if (distance < cells.get(i).getMass() / 2 + cells.get(j).getMass() / 2)
            {
             
              cells = eat(cells, i, j);

            }
          }
        }
      }
    }
    return cells;
  }

  public static ArrayList<Cell> eat(ArrayList<Cell> cells, int i, int j)
  {

    if (cells.get(i).getMass() / cells.get(j).getMass() > 2)
    {
      cells.get(i).eat(cells.get(j));
      cells.remove(j);
    }
    else if (cells.get(j).getMass() / cells.get(i).getMass() > 2)
    {
      cells.get(j).eat(cells.get(i));
      cells.remove(i);
    }

    return cells;
  }

  public static void wallDetect(Cell cCell, int width, int height)
  {
    if (cCell.getType().equals("Cell"))
    {
      if (cCell.getxCoord() + cCell.getMass() / 2 > width)
      {
        cCell.setxCoord(width - cCell.getMass() / 2);
        cCell.setxVel(0);
        cCell.setxA(0);
      }
      if (cCell.getyCoord() + cCell.getMass() / 2 > height)
      {
        cCell.setyCoord(height - cCell.getMass() / 2);
        cCell.setyVel(0);
        cCell.setyA(0);
      }
      if (cCell.getxCoord() + cCell.getMass() / 2 < 0)
      {
        cCell.setxCoord(0 + cCell.getMass() / 2);
        cCell.setxVel(0); 
        cCell.setxA(0);
      }
      if (cCell.getyCoord() + cCell.getMass() / 2 < 0)
      {
        cCell.setyCoord(0 + cCell.getMass() / 2);
        cCell.setyVel(0);
        cCell.setyA(0);
      }
    }
  }

  public static void trace(String a)
  {
    System.out.println(a);
  }

  public static void trace(int a)
  {
    System.out.println(a);
  }

  public static void trace(double a)
  {
    System.out.println(a);
  }
  public static void trace(boolean a)
  {
    System.out.println(a);
  }
}
