/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author admin
 */
public class createQR {
    public static void createQRNew(String data, String filePath){
        try {
            int size = 300;
            // Tạo đối tượng QRCodeWriter
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            // Tạo bản đồ thông tin để định cấu hình mã QR
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); // Đặt mức độ sửa lỗi

            // Tạo mã QR
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, size, size, hints);

            // Tạo đối tượng BufferedImage
            BufferedImage qrImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);

            // Đổ bitMatrix vào BufferedImage
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    qrImage.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
                }
            }

            // Lưu ảnh QR vào file
            ImageIO.write(qrImage, "png", new File(filePath));
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
}
}
