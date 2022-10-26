package business;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import static jdk.nashorn.internal.objects.Global.undefined;

public class RGBController {

    public static BufferedImage selectRGB(URL imagem, String RGB) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(imagem);
        Color cor;
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                cor = new Color(bufferedImage.getRGB(i, j));
                int pixelR = 0;
                int pixelG = 0;
                int pixelB = 0;

                if(Objects.equals(RGB, "R")) {
                    pixelR = cor.getRed();
                    pixelG = cor.getGreen() - 255;
                    pixelB = cor.getBlue() - 255;
                }
                if(Objects.equals(RGB, "G")) {
                    pixelR = cor.getRed() - 255;
                    pixelG = cor.getGreen();
                    pixelB = cor.getBlue() - 255;
                }
                if(Objects.equals(RGB, "B")) {
                    pixelR = cor.getRed() - 255;
                    pixelG = cor.getGreen() - 255;
                    pixelB = cor.getBlue();
                }

                pixelR = Math.max(pixelR, 0);
                pixelR = Math.min(255, pixelR);

                pixelG = Math.max(pixelG, 0);
                pixelG = Math.min(255, pixelG);

                pixelB = Math.max(pixelB, 0);
                pixelB = Math.min(255, pixelB);


                bufferedImage.setRGB(i, j, new Color(pixelR, pixelG, pixelB).getRGB());
            }
        }
        return bufferedImage;
    }

    public static BufferedImage grid(URL imagem) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(imagem);
        Color cor;
        for (int i = 0; i < bufferedImage.getWidth(); i += 4) {
            for (int j = 0; j < bufferedImage.getHeight(); j += 4) {
                bufferedImage.setRGB(i, j, new Color(0, 0, 0).getRGB());
            }
        }
        return bufferedImage;
    }

    public static BufferedImage chess(URL imagem) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(imagem);
        Color cor;
        for (int i = 0; i < bufferedImage.getWidth(); i += 8) {
            for (int j = 0; j < bufferedImage.getHeight(); j += 8) {
                for (int blackV = i; blackV < i+4; blackV++) {
                    for (int blackH = j; blackH < j+4; blackH++) {
                        bufferedImage.setRGB(blackV, blackH, new Color(0, 0, 0).getRGB());
                    }
                }
            }
        }
        for (int i = 4; i < bufferedImage.getWidth(); i += 8) {
            for (int j = 4; j < bufferedImage.getHeight(); j += 8) {
                for (int blackV = i; blackV < i+4; blackV++) {
                    for (int blackH = j; blackH < j+4; blackH++) {
                        bufferedImage.setRGB(blackV, blackH, new Color(0, 0, 0).getRGB());
                    }
                }
            }
        }
        return bufferedImage;
    }

    public static BufferedImage blackWhite(URL imagem) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(imagem);
        Color cor;
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {

                cor = new Color(bufferedImage.getRGB(i, j));
                int med = (cor.getRed() + cor.getBlue() + cor.getGreen()) / 3;
                int pixelR = med;
                int pixelG = med;
                int pixelB = med;

                bufferedImage.setRGB(i, j, new Color(pixelR, pixelG, pixelB).getRGB());
            }
        }
        return bufferedImage;
    }

    public static BufferedImage bblackWhite(URL imagem, String layers) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(imagem);
        Color cor;
        if(layers.equals("")) {
            layers = "2";
        }
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {

                cor = new Color(bufferedImage.getRGB(i, j));
                int med = (cor.getRed() + cor.getBlue() + cor.getGreen()) / 3;
                int pixelR = med;
                int pixelG = med;
                int pixelB = med;
                int X = 0;
                switch (Integer.parseInt(layers)) {
                    case 2:
                        if (med < 173) {
                            X = 0;
                        } else {
                            X = 255;
                        }
                        break;
                    case 3:
                        if (med < 85) {
                            X = 0;
                        } else if (med < 165) {
                            X = 173;
                        } else {
                            X = 255;
                        }
                        break;
                    case 4:
                        if (med < 63) {
                            X = 0;
                        } else if (med < 127) {
                            X = 127;
                        } else if (med < 190) {
                            X = 190;
                        } else {
                            X = 255;
                        }
                        break;
                    case 5:
                        if (med < 51) {
                            X = 0;
                        } else if (med < 102) {
                            X = 102;
                        } else if (med < 153) {
                            X = 153;
                        } else if (med < 204) {
                            X = 204;
                        } else {
                            X = 255;
                        }
                        break;
                }
                pixelR = X;
                pixelG = X;
                pixelB = X;

                bufferedImage.setRGB(i, j, new Color(pixelR, pixelG, pixelB).getRGB());
            }
        }
        return bufferedImage;
    }

    public static BufferedImage focus(URL imagem, int focus) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(imagem);
        Color cor;

        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {

                cor = new Color(bufferedImage.getRGB(i, j));
                int med = (cor.getRed() + cor.getBlue() + cor.getGreen()) / 3;
                if(med <= focus) {
                    int pixelR = med;
                    int pixelG = med;
                    int pixelB = med;

                    bufferedImage.setRGB(i, j, new Color(pixelR, pixelG, pixelB).getRGB());
                }

            }
        }
        return bufferedImage;
    }
}
