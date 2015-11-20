package com.iss.expense.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import com.iss.expense.constant.ConstValues;


/**
 * FTP文件上传
 * @author zhucx
 * @date 2013-12-28 上午9:31:34
 * @version 1.0
 */
public class FtpFileUtils {

	private String host = "124.127.212.27";
	private int port = 21;
	private String username = "ftpuser";
	private String password = "123456";
	private static String path = "/";
	private String encoding = "UTF-8";
	private FTPClient client;
	
	private static FtpFileUtils util = new FtpFileUtils();
	
	private Logger log = Logger.getLogger(this.getClass());

	public static void main(String[] args){
		//FtpFileUtils.uploadFile("d:/beauty.jpg", path);
		FtpFileUtils.uploadFile(new String[]{"d:/tv.jpg", "d:/washer.jpg", "d:/bean.jpg", "d:/conditioner.jpg"}, path);
	}
	private FtpFileUtils(){
		init();
	}
	
	private void init(){
		
//	    host = ParameterPool.getSysParameterVal("ftp.host");
//		port = Integer.valueOf(ParameterPool.getSysParameterVal("ftp.port"));
//		username = ParameterPool.getSysParameterVal("ftp.username");
//		password =ParameterPool.getSysParameterVal("ftp.password");
//		path = ParameterPool.getSysParameterVal("ftp.remote.path");
//		encoding = ParameterPool.getSysParameterVal("ftp.encoding");
//		
		log.info("<---- 连接FTP服务器初始化数据  ---->");
		log.info("<--- host :" + host + "  --->");
		log.info("<--- port :" + port + "  --->");
		log.info("<--- username :" + username + "  --->");
		log.info("<--- path :" + path + "  --->");
		log.info("<--- encoding :" + encoding + "  --->");
	}
	
	/**
	 * <p>上传文件到FTP服务器 多文件</p>
	 * @param localFile
	 */
	public static boolean uploadFile(String[] localFiles, String remotePath) {
		return util.upload(localFiles, remotePath);
	}
	
	/**
	 * 文件上传
	 * 
	 * @param localFile 本地文件 
	 * @param remotePath 远程路径
	 */
	public static boolean uploadFile(String localFile,String remotePath) {
		return util.upload(localFile, remotePath);
	}
	
	/**
	 * 从FTP服务器下载文件[多个文件]
	 * 
	 * @param remoteFiles
	 * @param remotePath
	 * @param localPath
	 * @return
	 * @throws Exception
	 */
	public static boolean downloadFile(String[] remoteFiles, 
			String remotePath, String localPath) {
		return util.download(remoteFiles, remotePath, localPath);
	}
	
	/**
	 * <p>从FTP服务器下载文件</p>
	 * @param remoteFile
	 * @param localPath
	 * @throws Exception 
	 */
	public static  void downloadFile(String remoteFile, String localPath) throws Exception {
		util.download(remoteFile, localPath, path);
	}
	
	/**
	 * <p>从FTP服务器下载文件</p>
	 * @param remoteFile
	 * @param localPath
	 * @throws Exception 
	 */
	public static void downloadFile(String remoteFile, String localPath, String path) throws Exception {
		util.download(remoteFile, localPath, path);
	}
	
	
	/**
	 * 验证文件是否存在
	 * 
	 * @param remoteFile
	 * @param remotePath
	 * @return
	 */
	public static boolean existsFile(String remoteFile, String remotePath){
		return util.exists(remoteFile, remotePath);
	}
	
	/**
	 * 
	 * 
	 * @param remoteFile
	 * @param remotePath
	 * @return
	 */
	private boolean exists(String remoteFile, String remotePath){
		try {
			//连接服务
			connectServer(host, port, username, password, remotePath);
			FTPFile[] files = client.listFiles(new String(remoteFile.getBytes(encoding), 
					ConstValues.ENCODING_ISO8859_1));
			if (files != null && files.length != 1) {
				log.info("远程文件不存在");
                return false;
			}
			
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			closeServer();
		}
	}

	/**
	 * <p>上传文件到FTP服务器  多文件</p>
	 * @param localFile
	 * @param path
	 */
	private boolean upload(String[] localFiles, String remotePath) {
		try {
			//连接服务
			connectServer(host, port, username, password, remotePath);
			for (String localFile : localFiles) {
				String fileName = new File(localFile).getName();
				writer(localFile, fileName);
			}
			
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			closeServer();
		}
	}
	
	
	/**
	 * <p>上传文件到FTP服务器</p>
	 * @param localFile
	 * @param path
	 */
	private boolean upload(String localFile, String remotePath) {
		try {
			//连接服务
			connectServer(host, port, username, password, remotePath);
//			String fileName = localFile.substring(localFile.lastIndexOf(File.separator) + 1);
			String fileName = new File(localFile).getName();
			return writer(localFile, fileName);
		} catch (Exception e) {
			return false;
		} finally {
			closeServer();
		}
	}

	//下载多个文件
	private synchronized boolean download(String[] remoteFiles, 
			String remotePath, String localPath) {
		try {
			//连接服务
			connectServer(host, port, username, password, remotePath);
			log.info("本地保存路径 --> " + localPath);
			
			File file = new File(localPath);
			if (!file.exists()){
				file.mkdirs();
			}
			
			for (String remoteFile : remoteFiles) {
				String fileName = remoteFile.substring(remoteFile.lastIndexOf("/") + 1);
				writerLocal(remoteFile, localPath + File.separator + fileName);
			}
			
			return true;
		} catch (Exception e) {
			log.info("文件下载出错: ",e );
			return false;
		} finally {
			closeServer();
		}
	}
	
	//下载单个文件
	private synchronized void download(String remoteFile, String localPath, String path) throws Exception {
		try {
			//连接服务
			connectServer(host, port, username, password, path);
			log.info("远程文件路径 --> " + remoteFile);
			log.info("本地保存路径 --> " + localPath);
			
			FTPFile[] files = client.listFiles(new String(remoteFile.getBytes(encoding), 
					ConstValues.ENCODING_ISO8859_1));
			
			if (files!=null && files.length != 1) {
				log.info("远程文件不存在");
                throw new RuntimeException("远程文件不存在");
			}
			writerLocal(remoteFile, localPath);
			log.info("文件下载成功！");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			closeServer();
		}
	}

	/*
	 * 打开连接 
	 */
	private synchronized void connectServer(String ip, int port, String username, String password, String path)
			throws Exception {
		
		client = new FTPClient();
		client.connect(ip, port);
		boolean loginFlag = client.login(username, password);
		
		log.info("登录FTP服务器 --> " + loginFlag);
		
		// 检验是否连接成功  
		int reply = client.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			client.disconnect();
			log.info("FTP服务器连接断开");
			return;
		}
		
		client.setFileType(FTP.BINARY_FILE_TYPE);
		if (null != path && path.length() != 0) {

			boolean changeFlag = client.changeWorkingDirectory(path);
			log.info("改变FTP文件目录 --> " + path + " : " + changeFlag);
			
			if (!changeFlag){
				boolean makeDirFlag = client.makeDirectory(path);
				log.info("新建目录  : " + path + " -->" + makeDirFlag);
				client.changeWorkingDirectory(path);
			}
			
		}
		client.setControlEncoding(encoding);
		log.info("设置编码--> " + encoding);
		
		log.info("FTP服务器地址: " + client.getLocalAddress());
	}

	/*
	 * 关闭连接 
	 */
	private void closeServer() {
		if (null != client && client.isConnected()) {
			try {
				boolean logoutFlag = client.logout();
				log.info("退出FTP服务器 --> " + logoutFlag);
			} catch (IOException e) {
				log.error("退出FTP服务器出错：", e);
			}
		}
	}

	/*
	 * 上传文件
	 */
	private boolean writer(String localFile, String remoteFile) {
		InputStream in = null;
		try {
			in = new FileInputStream(localFile);
			boolean iFlag = client.storeFile(new String(remoteFile.getBytes(encoding), 
					ConstValues.ENCODING_ISO8859_1), in);
			log.info("文件上传 " + localFile + "--> " + iFlag);
			return iFlag;
		} catch (Exception e) {
			log.error("文件上传出错: ", e);
			return false;
		} finally {
			free(in, null);
		}
		
	}

	/*
	 * 下载文件
	 */
	private boolean writerLocal(String remoteFile, String localFile) throws Exception {
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new FileOutputStream(localFile);
			boolean iFlag = client.retrieveFile(new String(remoteFile.getBytes(encoding), 
					ConstValues.ENCODING_ISO8859_1), out);
			log.info("文件下载 " + remoteFile + " --> " + iFlag);
			return iFlag;
		} catch (Exception e) {
			log.info("文件下载出错  ", e);
			return false;
		} finally {
			free(in, out);
		}
	}

	/*
	 * 关闭流
	 */
	private void free(InputStream in, OutputStream out) {
		if (null != in) {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (null != out) {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
