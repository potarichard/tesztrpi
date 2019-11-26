package mypackage;


//                   |
//       ________|   |
//       |       |   |
//   |   |   |   |   |
// | | | | | | | | | |

// 1 2 1 3 1 2 1 4 1 5

public class MaxAreaWater 
{
	public int maxArea(int[] height)
	{		
		int		area = 0,
				max_h = 0,
				length = 1;
		
		for(int i=1; i<height.length; i++)
		{			
			if(height[i-1] > max_h)
			{
				length = 1;
				max_h = height[i-1];
			}
			else
				length++;
			
			area = Math.max(area, (max_h*length));			
		}
		
		return area;
	}

	
	public int maxAreaStandard(int[] height)
	{
		int		left = 0,
				right = height.length -1,
				maxArea = 0;
		
		while(left < right)
		{
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]*(right-left)));
			
			if(height[left] < height[right])
				left++;
			else
				right--;			
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) 
	{
		int[] arr = new int[] {1, 2, 1, 3, 1, 2, 1, 4, 1, 5};		// should give 12 (4x3)		
		
		MaxAreaWater mw = new MaxAreaWater();
		
		System.out.println(mw.maxArea(arr));
		System.out.println(mw.maxAreaStandard(arr));

	}

}
