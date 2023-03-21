package com.semihbiygit.qrcodedemo.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.spring.boot.client.MatrixToImageWriter;
import com.semihbiygit.qrcodedemo.user.User;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    public static void generateQRCode(User user) throws WriterException, IOException {
        String qrCodePath = "C:\\Users\\semih\\Desktop\\IdeaProjects\\qrcode-demo\\QRCodes\\";
        String qrCodeName = qrCodePath + user.getFirstName() + user.getId() + "-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "ID: " + user.getId() +
                        "\nName: " + user.getFirstName() + " " + user.getLastName() +
                        "\nEmail: " + user.getEmail() +
                        "\nPhone: " + user.getMobile() +
                        "\n", BarcodeFormat.QR_CODE, 350, 350);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToFile(bitMatrix, "PNG", path.toFile());

    }
}
