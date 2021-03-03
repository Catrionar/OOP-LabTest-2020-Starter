package ie.tudublin;

import processing.core.PApplet;
//import processing.core.PApplet;
import processing.data.TableRow;

public class Task {
    private String task;
	private int start;
	private int end;

	public Task()
	{

	}

    public void render(PApplet pa)
    {
        float border = pa.width * 0.1f;
        float x = PApplet.map(start, 1, 30, border, pa.width - border);
        float h = PApplet.map(end, 0, 30, border, pa.height - (border *2));
        //float y1 = PApplet.map(start, 1, 30, border, pa.height - (border*2));
        //float x2 = PApplet.map(end, 1, 30, border, pa.width - border);
        //float y2 = PApplet.map(end, 1, 30, border, pa.height -(border*2));
        pa.stroke(255, 255, 0);
        pa.rect(pa.height - border, x, -h, 10);
        
    }


	public Task(TableRow row)
	{
		this(
			row.getString("Task"),
			row.getInt("Start"),
			row.getInt("End")
		);
	}

	public Task(String task, int start, int end)
	{
		this.task = task;
		this.start = start;
		this.end = end;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		end = end;
	}

	@Override
	public String toString() {
		return "Task [End=" + end + ", Start=" + start + ", task=" + task + "]";
	}
}
