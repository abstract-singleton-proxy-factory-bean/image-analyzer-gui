/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aps.utils.image;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.ColorModel;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class ImageAnalyzer {

    private final int colorSensitivity;
    private final Color imageBaseColor;
    private final Color highlightColor;

    public static BufferedImage run(BufferedImage image, int imageSensitivity, Color imageBaseColor,
            Color highlightColor) {
        ImageAnalyzer imageAnalyzer = new ImageAnalyzer(imageSensitivity, imageBaseColor, highlightColor);
        BufferedImage highlightedImage = imageAnalyzer.highlightBaseColor(image);

        return highlightedImage;
    }

    public static void saveImage(BufferedImage image, String filename) throws Exception {
        File outputFile = new File(filename);
        ImageIO.write(image, "jpg", outputFile);
    }
    
    public static Color getBaseColor(BufferedImage sourceImage) {
        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        int counter = 0;
        
        Color[] colors = new Color[width * height];
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                int pixel = sourceImage.getRGB(x, y);
                colors[counter++] = new Color(pixel, true);
            }
        }
        
        Color color = Arrays.asList(colors)
            .stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .get()
            .getKey();
        
        System.out.println(color);
        
        return color;
    }

    public ImageAnalyzer(int colorSensitivity, Color imageBaseColor, Color highlightColor) {
        this.colorSensitivity = colorSensitivity;
        this.imageBaseColor = imageBaseColor;
        this.highlightColor = highlightColor;
    }

    public BufferedImage highlightBaseColor(BufferedImage sourceImage) {
        BufferedImage image = cloneBufferedImage(sourceImage);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = image.getRGB(x, y);
                Color color = new Color(pixel, true);

                if (ColorCompare.compareRange(color, this.imageBaseColor, this.colorSensitivity)) {
                    image.setRGB(x, y, this.highlightColor.getRGB());
                }
            }
        }

        return image;
    }

    public double getPercentageOfBaseColor(BufferedImage sourceImage) {
        int totalBaseColorPixels = 0;

        for (int y = 0; y < sourceImage.getHeight(); y++) {
            for (int x = 0; x < sourceImage.getWidth(); x++) {
                int pixel = sourceImage.getRGB(x, y);
                Color color = new Color(pixel, true);

                if (ColorCompare.compareRange(color, this.imageBaseColor, this.colorSensitivity)) {
                    totalBaseColorPixels++;
                }
            }
        }

        long totalImagePixels = sourceImage.getHeight() * sourceImage.getWidth();
        double percentage = ((double) totalBaseColorPixels / totalImagePixels) * 100;

        return percentage;
    }

    private static BufferedImage cloneBufferedImage(BufferedImage image) {
        ColorModel colorModel = image.getColorModel();
        boolean isAlphaPremultiplied = colorModel.isAlphaPremultiplied();
        WritableRaster raster = image.copyData(image.getRaster().createCompatibleWritableRaster());
        return new BufferedImage(colorModel, raster, isAlphaPremultiplied, null);
    }

    public static BufferedImage readImageFile(String imageFilePath) throws IOException {
        File imageFile = new File(imageFilePath);
        BufferedImage image = ImageIO.read(imageFile);

        return image;
    }
}
