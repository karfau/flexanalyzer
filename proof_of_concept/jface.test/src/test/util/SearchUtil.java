package test.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.widgets.Display;

public class SearchUtil 
{
	public static int[] getSearchTermOccurrences(String searchTerm, String content)
	{
		List<StyleRange> styleRange;
		List<Integer> ranges;
		Display disp = Display.getCurrent();
		StyleRange myStyleRange = new StyleRange(0, 0, null, disp.getSystemColor(SWT.COLOR_YELLOW));
		
		styleRange = new ArrayList<StyleRange>();
		ranges = new ArrayList<Integer>();
		
		if (searchTerm.equals(""))
		{
			return new int[] {};
		}
		
		for (int i = 0; i < content.length(); i++)
		{
			if (i + searchTerm.length() <= content.length() 
					&& content.substring(i, i + searchTerm.length()).equalsIgnoreCase(searchTerm))
			{
				ranges.add(i);
				ranges.add(searchTerm.length());
			}
		}
		
		int[] intRanges = new int[ranges.size()];
		int arrayIndexCounter = 0;
		for (int listIndexCounter = 0; listIndexCounter < ranges.size(); listIndexCounter++)
		{
			if (listIndexCounter % 2 == 0)
			{
				if (searchTerm.length() > 1
						&& listIndexCounter != 0
						&& ranges.get(listIndexCounter - 2) 
										+ ranges.get(listIndexCounter - 1) >= ranges.get(listIndexCounter))
				{
					intRanges[arrayIndexCounter - 1] = 0
									- ranges.get(listIndexCounter - 2)
									+ ranges.get(listIndexCounter)
									+ ranges.get(++listIndexCounter);
				}
				else
				{
					intRanges[arrayIndexCounter++] = ranges.get(listIndexCounter);
				}
			}
			else
			{
				intRanges[arrayIndexCounter++] = ranges.get(listIndexCounter);
				styleRange.add(myStyleRange);
			}
		}
		
		int[] intRangesCorrectSize = new int[arrayIndexCounter];
		System.arraycopy(intRanges, 0, intRangesCorrectSize, 0, arrayIndexCounter);
		
		return intRangesCorrectSize;
	}
}
