package vectorizer;

public class Math {
	public static Integer IntPow(Integer x, Integer pow)
	{
	    Integer ret = 1;
	    while (pow != 0)
	    {
	        if ((pow & 1) == 1)
	            ret *= x;
	        x *= x;
	        pow >>= 1;
	    }
	    return ret;
	}
	
	public static Integer IntSqrt(Integer x) {
		Integer y = 0;
		
		while (x >= 0) {
			x = x - y;
			y = y + 1;
			x = x - y;
		}
		
		return y - 1;
	}
}
