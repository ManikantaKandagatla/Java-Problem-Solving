package com.mywork.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author ManiKanta Kandagatla
 */
public class OverlappingRectangles
{

    /**
     * 
     */
    public OverlappingRectangles()
    {
        // TODO Auto-generated constructor stub
    }

    public int calculateArea(List<Dimension> dimensions)
    {
        int area = 0;
        if (dimensions.size() == 1)
        {
            area = dimensions.get(0).height * dimensions.get(0).width;
        }
        else
        {
            area = dimensions.get(0).height * dimensions.get(0).width;
            Dimension previousDimension, currentDimension;
            for (int index = 1; index < dimensions.size(); index++)
            {
                previousDimension = dimensions.get(index - 1);
                currentDimension = dimensions.get(index);
                int currentEndXcord = currentDimension.x_cord + currentDimension.width;
                int prevEndXCord = previousDimension.x_cord + previousDimension.width;

                area = area + currentDimension.width * currentDimension.height;
                if (currentDimension.x_cord < previousDimension.x_cord + previousDimension.width
                        && currentEndXcord <= prevEndXCord)
                {
                    if (currentDimension.height > previousDimension.height)
                    {
                        area = area - previousDimension.height * currentDimension.width;
                    }
                    else
                    {
                        area = area - currentDimension.height * currentDimension.width;
                    }
                }
                else if (currentDimension.x_cord < previousDimension.x_cord
                        + previousDimension.width && currentEndXcord > prevEndXCord)
                {
                    if (currentDimension.height > previousDimension.height)
                    {
                        area = area - previousDimension.height
                                * (prevEndXCord - currentDimension.x_cord);
                    }
                    else
                    {
                        area = area - currentDimension.height
                                * (prevEndXCord - currentDimension.x_cord);
                    }

                }
            }
        }
        return area;
    }

    public void runTestCases()
    {
        int[][][] testCases = { { { 0, 4, 3 }, { 1, 6, 9 }, { 4, 5, 6 }, { 3, 5, 11 } },
                { { 1, 4, 5 }, { 6, 3, 4 }, { 6, 5, 5 } },
                { { 1, 4, 5 }, { 6, 3, 4 }, { 6, 3, 7 } },
                { { 1, 4, 5 }, { 6, 4, 5 }, { 6, 4, 8 } }, { { 0, 4, 5 }, { 2, 4, 7 } } };
        List<Dimension> dimensions;
        Comparator<Dimension> dimensionComparator = new Comparator<Dimension>()
        {

            @Override
            public int compare(Dimension d1, Dimension d2)
            {
                return d1.x_cord > d2.x_cord ? 1 : -1;
            }
        };

        for (int i = 0; i < testCases.length; i++)
        {
            dimensions = new ArrayList<Dimension>();
            for (int j = 0; j < testCases[i].length; j++)
            {
                dimensions.add(
                        new Dimension(testCases[i][j][0], testCases[i][j][1], testCases[i][j][2]));
                dimensions.sort(dimensionComparator);
            }
            System.out.println("Polygon area : " + calculateArea(dimensions));
            dimensions.clear();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        OverlappingRectangles testObj = new OverlappingRectangles();
        testObj.runTestCases();
    }

}

class Dimension
{
    int width;

    int height;

    int x_cord;

    public Dimension(int x_cord, int width, int height)
    {
        setX_cord(x_cord);
        setWidth(width);
        setHeight(height);
    }

    public int getwidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getX_cord()
    {
        return x_cord;
    }

    public void setX_cord(int x_cord)
    {
        this.x_cord = x_cord;
    }

}
