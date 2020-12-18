//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.welleys.network;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PictureDownload {
    private static final Logger LOG = Logger.getLogger(PictureDownload.class.getName());

    public PictureDownload() {
    }

    public static void downloadPicture(List<String> urlList, String dirPath) {
        Iterator var3 = urlList.iterator();

        while(var3.hasNext()) {
            String urlString = (String)var3.next();

            try {
                URL url = new URL(urlString);
                String imageName = urlString.substring(urlString.lastIndexOf("/") + 1);
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(new File(dirPath + File.separator + imageName));
                byte[] buffer = new byte[1024];

                int length;
                while((length = dataInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }

                dataInputStream.close();
                fileOutputStream.close();
            } catch (Exception var10) {
                LOG.log(Level.SEVERE, var10.getMessage(), var10);
            }
        }

    }
}
