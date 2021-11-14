/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aps.utils.image;

import java.awt.Color;

public class ColorCompare {
  private static int[] getRGB(Color color) {
    return new int[] { color.getRed(), color.getGreen(), color.getBlue() };
  }

  private static int getDifference(int source, int target) {
    return Math.abs(target - source);
  }

  public static boolean compareRange(Color source, Color target, int sensitivity) {
    int[] sourceColors = getRGB(source);
    int[] targetColors = getRGB(target);

    int redDifference = getDifference(sourceColors[0], targetColors[0]);
    int greenDifference = getDifference(sourceColors[1], targetColors[1]);
    int blueDifference = getDifference(sourceColors[2], targetColors[2]);

    return redDifference <= sensitivity && greenDifference <= sensitivity && blueDifference <= sensitivity;
  }
}