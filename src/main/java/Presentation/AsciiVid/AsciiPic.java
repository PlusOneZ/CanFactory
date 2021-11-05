package Presentation.AsciiVid;
import Main.Main;
import Presentation.WindowsLibrary;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static java.lang.Thread.sleep;
//处理字符图片的类
public class AsciiPic
{
    //彩色图片信息
    private static class PixelInfo {
        PixelInfo() { }
        PixelInfo(char ch){
            r = g = b = 0;
            this.ch = ch;
        }
        int r, g, b;
        char ch;
    }
    //生产彩色图片
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
    //打印彩色图片
    private static void printColorfulAsciiPic(BufferedImage image) throws InterruptedException{
        ArrayList<PixelInfo> picInfo = createColorfulAsciiPic(image);
        WindowsLibrary.Console.changeBackground();
        WindowsLibrary.Console.fullScreen();
        WindowsLibrary.Console.cls();
        for (var pixelInfo : picInfo)
            WindowsLibrary.Console.printColorfulChar(pixelInfo.r, pixelInfo.g, pixelInfo.b, pixelInfo.ch);
        sleep(3000);
        WindowsLibrary.Console.recoveryBackground();
        WindowsLibrary.Console.recoveryScreen();
    }
    //打印黑白图片
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
    //打印mac下的欢迎图片
    public static void macHelloPic()
    {
        String fileName = "src/main/java/macHello.png";
//        String fileName;
//        fileName = URLDecoder.decode(Main.class.getProtectionDomain().getCodeSource().getLocation().getFile(),
//                StandardCharsets.UTF_8);
//        fileName = fileName.substring(0,fileName.lastIndexOf('/')) + "/macHello.png";
        try {
            AsciiPic.printAsciiPic(ImageIO.read(new File(fileName)));
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
    //打印win下的欢迎图片
    public static void winHelloPic()
    {
        String fileName = "src/main/java/winHello.jpg";
//        String fileName;
//        fileName = URLDecoder.decode(Main.class.getProtectionDomain().getCodeSource().getLocation().getFile(),
//                StandardCharsets.UTF_8);
//        fileName = fileName.substring(0,fileName.lastIndexOf('/')) + "/winHello.jpg";
        try {
            AsciiPic.printColorfulAsciiPic(ImageIO.read(new File(fileName)));
        } catch (InterruptedException | IOException e) {
            //e.printStackTrace();
        }
    }
}
