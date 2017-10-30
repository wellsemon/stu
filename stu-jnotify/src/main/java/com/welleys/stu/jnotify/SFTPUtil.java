package com.welleys.stu.jnotify;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * sftp����ʼ�����ӵ����ݻ�
 * 
 */
public class SFTPUtil {
	private static ChannelExec channelExec;
	private static Session session;
	private static Channel channel;
	private static ChannelSftp sftp;// sftp������

	// public SFTPUtil(String host, int port, String username, String password)
	// throws Exception {
	// getConnect(host, port, username, password);
	// }

	/**
	 * @param host
	 * @param port
	 * @param username
	 * @param password
	 *            ͨ�������û����ӵ�zjyy
	 * @throws Exception
	 */
	public static ChannelSftp getConnect(String host, int port,
			String userName, String password) throws Exception {
		/** ����jsch���� */
		JSch jsch = new JSch();
		session = jsch.getSession(userName, host, port);
		// session = jsch.getSession(userName, host);
		LogUtil.log("Session created", SFTPUtil.class);
		if (password != null) {
			session.setPassword(password);// ��������
		}
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		// session.setConfig("StrictHostKeyChecking", "no");// ����֤ HostKey
		// session.setConfig("userauth.gssapi-with-mic", "no");

		session.setTimeout(10000);
		try {
			session.connect();// ͨ��session��������
			LogUtil.log("Login success", SFTPUtil.class);
			// System.out.println("�û�["+userName+"]"+"=====���ӵ�linux�����=====");
			LogUtil.log("�û�[" + userName + "]" + "=====���ӵ�linux�����=====",
					SFTPUtil.class);

		} catch (Exception e) {
			if (!session.isConnected()) {
				session.disconnect();
				LogUtil.error("======���ӷ�����ʧ��," + "��������[" + host + "],"
						+ "�û���[" + userName + "]," + "�˿�[" + port + "]�Ƿ���ȷ,"
						+ "������Ϣ��ȷ��������������������Ƿ������������󱻷���ǽ�ܾ�=======", e,
						SFTPUtil.class);
			}
		}

		channel = session.openChannel("sftp");// ��sftpͨ��
		try {
			channel.connect();
			LogUtil.log(
					("Connected successfully to ftpHost = " + host
							+ ",as ftpUserName = " + userName + ", returning: " + channel),
					SFTPUtil.class);
			// System.out.println("�û�["+userName+"]"+"=====�ɹ���sftpͨ��=====");
			LogUtil.log("�û�[" + userName + "]" + "=====�ɹ���sftpͨ��=====",
					SFTPUtil.class);
		} catch (Exception e) {
			if (channel.isConnected()) {
				channel.disconnect();
				LogUtil.error("======���ӷ�����ʧ��," + "��������[" + host + "],"
						+ "�û���[" + userName + "]," + "�˿�[" + port + "]�Ƿ���ȷ,"
						+ "������Ϣ��ȷ��������������������Ƿ������������󱻷���ǽ�ܾ�=======", e,
						SFTPUtil.class);
			}
		}
		sftp = (ChannelSftp) channel;

		return sftp;
	}

	/**
	 * Զ�̵���linux����
	 * 
	 * @param cmd
	 * @param charset
	 * @throws Exception
	 */
	public static void runCmd(String cmd, String charset) throws Exception {
		channelExec = (ChannelExec) session.openChannel("exec");
		channelExec.setCommand(cmd);
		channelExec.setInputStream(null);
		channelExec.setErrStream(System.err);
		channelExec.connect();
		InputStream in = channelExec.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,
				Charset.forName(charset)));
		String buf = null;
		while ((buf = reader.readLine()) != null) {
			System.out.println(buf);
		}
		reader.close();
		channelExec.disconnect();
	}

	/**
	 * �г�ָ��Ŀ¼������Ŀ¼���жϸ�Ŀ¼���Ƿ���ڵ������Ҫ��Ŀ¼
	 */
	public static boolean dirIsExist(String dirPath, String date,
			ChannelSftp sftp) {
		boolean flag = false;
		try {
			@SuppressWarnings("unchecked")
			Vector<Object> vt = sftp.ls(dirPath);
			for (Object v : vt) {
				if (v.toString().contains(date))
					flag = true;
			}
		} catch (SftpException e) {
			LogUtil.error("[" + dirPath + "]ָ��Ŀ¼�����ڻ����粻�����Ժ�", e, SFTPUtil.class);
		}
		return flag;
	}

	/**
	 * ���ļ�ͨ��sftp�����ƶ�����һ��Ŀ¼
	 */
	public static boolean move2Dir(String srcFile, String desFile,
			ChannelSftp sftp) {
		boolean flag = false;
		try {
			sftp.rename(srcFile, desFile);
			flag = true;
			return flag;
		} catch (SftpException e) {
			LogUtil.error("=====" + srcFile + "�ļ��ƶ�ʧ��=====", e, SFTPUtil.class);
			return flag;
		}
	}
}
