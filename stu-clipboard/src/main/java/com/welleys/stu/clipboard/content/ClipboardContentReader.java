package com.welleys.stu.clipboard.content;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardContentReader {
    public static void main(String[] args) throws UnsupportedFlavorException,
            IOException {
        Transferable trans = Toolkit.getDefaultToolkit().getSystemClipboard()
                .getContents(null);

        if (null != trans) {

            if (trans.isDataFlavorSupported(DataFlavor.imageFlavor)) {// trans代表图片时
                System.out.println(trans
                        .getTransferData(DataFlavor.imageFlavor));
            } else if (trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {// trans代表文本是
                System.out.println(trans
                        .getTransferData(DataFlavor.stringFlavor));
            }
        }
    }
}
