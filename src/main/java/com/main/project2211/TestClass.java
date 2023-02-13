package com.main.project2211;
import com.github.sarxos.webcam.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class TestClass {

    public static void main(String[] args) {
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        for (int i = 0; i <= 100; i++) {
            takePic(""+i,webcam);
        }
        webcam.close();
    }

    public static void takePic(String name, Webcam webcam){
        BufferedImage image = webcam.getImage();
        try {
            ImageIO.write(image, "JPEG", new File("C:\\Users\\Oistín\\Documents\\Github\\Project2-2-11\\src\\Pictures"+name+".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
