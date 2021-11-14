package com.aps.utils.image;

import java.awt.Dimension;
import java.awt.Image;

public class ImageResizer {
    public static Dimension getScaledDimension(Dimension imageSize, Dimension boundary) {
        int originalWidth = imageSize.width;
        int originalHeight = imageSize.height;
        int boundWidth = boundary.width;
        int boundHeight = boundary.height;
        int newWidth = originalWidth;
        int newHeight = originalHeight;

        if (originalWidth > boundWidth) {
            newWidth = boundWidth;
            newHeight = (newWidth * originalHeight) / originalWidth;
        }

        if (newHeight > boundHeight) {
            newHeight = boundHeight;
            newWidth = (newHeight * originalWidth) / originalHeight;
        }

        return new Dimension(newWidth, newHeight);
    }
}
