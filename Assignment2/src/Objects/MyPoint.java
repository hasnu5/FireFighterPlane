/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

public class MyPoint 
{
	public int x;
	public int y;
	
	MyPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	MyPoint(MyPoint p)
	{
		x = p.x;
		y = p.y;
	}
}

