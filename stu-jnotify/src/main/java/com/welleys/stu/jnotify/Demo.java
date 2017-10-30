//package com.welleys.stu.jnotify;
//
//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//import net.contentobjects.jnotify.JNotify;
//import net.contentobjects.jnotify.JNotifyException;
//import net.contentobjects.jnotify.JNotifyListener;
//
//public class Demo {
//	public static void main(String[] args) throws JNotifyException,
//			InterruptedException {
//		// to add a watch :
//		String path = "D:/User";
//		int mask = JNotify.FILE_CREATED | JNotify.FILE_DELETED
//				| JNotify.FILE_MODIFIED | JNotify.FILE_RENAMED;
//		boolean watchSubtree = true;
//		int watchID = JNotify.addWatch(path, mask, watchSubtree,
//				new JNotifyListener() {
//					public void fileRenamed(int wd, String rootPath,
//							String oldName, String newName) {
//						System.out.println("JNotifyTest.fileRenamed() : wd #"
//								+ wd + " root = " + rootPath + ", " + oldName
//								+ " -> " + newName);
//					}
//
//					public void fileModified(int wd, String rootPath,
//							String name) {
//						System.out.println("JNotifyTest.fileModified() : wd #"
//								+ wd + " root = " + rootPath + ", " + name);
//					}
//
//					public void fileDeleted(int wd, String rootPath, String name) {
//						System.out.println("JNotifyTest.fileDeleted() : wd #"
//								+ wd + " root = " + rootPath + ", " + name);
//					}
//
//					public void fileCreated(int wd, String rootPath, String name) {
//						System.out.println("JNotifyTest.fileCreated() : wd #"
//								+ wd + " root = " + rootPath + ", " + name);
//						if (name.endsWith(".SYN")) {
//							// ����ͬ�����ļ�������
//							System.out.println("������һ̨������ͬ���ļ�");
//							new File(rootPath + "/" + name).renameTo(new File(
//									rootPath + "/" + name.replace(".SYN", "")));
//						} else {
//							String newTmpName = name + ".SYN";
//							// �����ϴ����ļ�ͬ������һ����
//							new File(rootPath + "/" + name).renameTo(new File(
//									rootPath + "/" + newTmpName));
//
//							FileInputStream fis = null;
//							try {
//								fis = new FileInputStream(rootPath + "/"
//										+ newTmpName);
//								SFTPUtilTest.synchToAnthor(
//										new BufferedInputStream(fis),
//										newTmpName);
//							} catch (FileNotFoundException e) {
//								e.printStackTrace();
//							} finally {
//								try {
//									fis.close();
//								} catch (IOException e) {
//									e.printStackTrace();
//								}
//							}
//							new File(rootPath + "/" + newTmpName)
//									.renameTo(new File(rootPath + "/"
//											+ name.replace(".SYN", "")));
//						}
//
//					}
//				});
//		System.out.println(watchID);
//
//		while (true) {
//			Thread.sleep(24 * 60 * 60 * 1000);
//		}
//		// to remove watch:
//		// boolean res = JNotify.removeWatch(watchID);
//		// if (!res) {
//		// invalid watch ID specified.
//		// }
//
//	}
//}
