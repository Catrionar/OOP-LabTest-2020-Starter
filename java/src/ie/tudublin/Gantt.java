package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	ArrayList<Task> task = new ArrayList<Task>();
	
	int startPoint = -1;
    int endPoint = -1;

	void drawGrid()
    {
        float border = 0.1f * width;
        textAlign(CENTER, CENTER);
        for(int i = 1 ; i <=30 ; i ++)
        {
			//Task t = task[i];
            float x = map(i, 1, 30, border, width - border);
			float y = map(i, 1, 30, border, height - border);
            stroke(255);
            line(x, border,x, height - border);
            fill(255);
            text(i, x, border / 2);
			//text(t, border / 2, y);
        }
    }

	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");
        for(TableRow row:table.rows())
        {
            Task t = new Task(row);
            task.add(t);
        }
	}

	public void printTasks()
	{
		for(Task t: task)
        {
            println(t);
        }
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		colorMode(RGB);
		loadTasks();
		printTasks();
	}

	public void drawTask()
    {
        for(Task t: task)
        {
            t.render(this);
        }
    }
	
	public void draw()
	{			
		background(0);
		drawGrid();
		drawTask();
	}
}
