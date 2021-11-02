package Presentation.AsciiVid;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;
public class AsciiPic
{
    private static class PixelInfo {
        PixelInfo() { }
        PixelInfo(char ch){
            r = g = b = 0;
            this.ch = ch;
        }
        int r, g, b;
        char ch;
    }

    private static ArrayList<PixelInfo> createColorfulAsciiPic(BufferedImage image) {
        final String base = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'.  ";
        final int vCharNum = 100, hCharNum = image.getWidth() * vCharNum * 2 / image.getHeight();
        final int pixelHeight = image.getHeight() / vCharNum, pixelWidth = image.getWidth() / hCharNum;
        ArrayList<PixelInfo> result = new ArrayList<>();
        for (int y = 0; y < image.getHeight(); y += pixelHeight) {
            for (int x = 0; x < image.getWidth(); x += pixelWidth) {
                final int pixel = image.getRGB(x, y);
                PixelInfo pixelInfo = new PixelInfo();
                pixelInfo.r = (pixel & 0xff0000) >> 16;
                pixelInfo.g = (pixel & 0xff00) >> 8;
                pixelInfo.b = pixel & 0xff;
                final float gray = 0.299f * pixelInfo.r + 0.578f * pixelInfo.g + 0.114f * pixelInfo.b;
                pixelInfo.ch = base.charAt(Math.round(gray * (base.length() - 1) / 255));
                result.add(pixelInfo);
            }
            result.add(new PixelInfo('\n'));
        }
        return result;
    }
    private static void printColorfulAsciiPic(BufferedImage image) throws InterruptedException{
        ArrayList<PixelInfo> picInfo = createColorfulAsciiPic(image);
        WindowsLibrary.Console.changeBackground();
        WindowsLibrary.Console.fullScreen();
        WindowsLibrary.Console.cls();
        for (var pixelInfo : picInfo)
            WindowsLibrary.Console.printColorfulChar(pixelInfo.r, pixelInfo.g, pixelInfo.b, pixelInfo.ch);
        sleep(3000);
        WindowsLibrary.Console.recoveryBackground();
    }

    private static void printAsciiPic(BufferedImage image) {
        final String base = "@$%*o!;. ";
        final int vCharNum = 30, hCharNum = image.getWidth() * vCharNum * 2 / image.getHeight();
        final int pixelHeight = image.getHeight() / vCharNum, pixelWidth = image.getWidth() / hCharNum;
        StringBuilder result = new StringBuilder();
        for (int y = 0; y < image.getHeight(); y += pixelHeight) {
            for (int x = 0; x < image.getWidth(); x += pixelWidth) {
                final int pixel = image.getRGB(x, y);
                final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                final int index = Math.round(gray * (base.length() - 1) / 255);
                result.append(base.charAt(index));
            }
            result.append('\n');
        }
        System.out.print(result);
    }

    public static void macHelloPic()
    {
        try {
            AsciiPic.printAsciiPic(ImageIO.read(new File("test.png")));
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public static void winHelloPic()
    {
        try {
            AsciiPic.printColorfulAsciiPic(ImageIO.read(new File("test.png")));
        } catch (InterruptedException | IOException e) {
            //e.printStackTrace();
        }
    }
}
