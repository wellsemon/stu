package com.welleys.stu.jnotify;

import java.io.BufferedInputStream;

import com.jcraft.jsch.ChannelSftp;

public class SFTPUtilTest {
	public static void synchToAnthor(BufferedInputStream br, String newTmpName) {
		try {
			ChannelSftp c = SFTPUtil.getConnect("172.29.33.119", 22, "blcuz",
					"blcuz");
			c.put(br, "/home/blcuz/" + newTmpName);
			c.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
