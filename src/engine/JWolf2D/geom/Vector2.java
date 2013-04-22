package engine.JWolf2D.geom;


public class Vector2
{
	public float x;
	public float y;

	Vector2()
	{
		x = 0;
		y = 0;
	}
	
	public Vector2(float vx, float vy)
	{
		x = vx;
		y = vy;
	}
	
	Vector2(int vx, int vy)
	{
		x = (float) vx;
		y = (float) vy;
	}
	
	public Vector2(double vx, double vy)
	{
		x = (float) vx;
		y = (float) vy;
	}
	
	Vector2(Vector2 v)
	{
		x = v.x;
		y = v.y;
	}
	
	public float magnitude()
	{
		return (float) Math.sqrt(x*x + y*y);
	}

	public void normalize()
	{
		float m = magnitude();

		x /= m;
		y /= m;
	}

	public void scale(float s)
	{
		x *= s;
		y *= s;
	}

	public String toString()
	{
		return "vector " + x + ", " + y;
	}
}
