public final class Algorithm 
{
    public static <T> T max(T x, T y) 
   {
        return ( (x > y) ? x : y);
    }
    public static <T> void swap(T[] x, int a, int b) 
	{
   		Object temp = x[b];
   		x[b] = x[a];
   		x[a] = (T) temp;
        return;
    }
}
