package com.jdbc.springdemo.datademo.sftpdemo;

public class SftpDemo {

    /**
     * 密钥文件连接
     *
     * @param port         端口号 如: "22"
     * @param priKeyFile   密钥文件地址（注意是地址）
     * @param downloadFile 下载地址
     * @param saveFile     保存的地址
     * @param fileName     下载的文件名
     * @return
     */

//    public boolean priKeyConnect(Integer port,
//                                 String priKeyFile,
//                                 String downloadFile,
//                                 String saveFile,
//                                 String fileName,
//                                 String userName,
//                                 String hostName) {
//        boolean result = true;
//        ChannelSftp sftp = null;
//        Session session = null;
//        Channel channel = null;
//        JSch jsch = new JSch();
//        try {
//            jsch.addIdentity(priKeyFile);
//            session = jsch.getSession(userName,
//                    hostName, port);
//            Properties config = new Properties();
//            config.put("StrictHostKeyChecking", "no");
//            session.setConfig(config);
//            session.setTimeout(100000);
//            session.connect();
//            channel = session.openChannel("sftp");
//            channel.connect();
//            sftp = (ChannelSftp) channel;
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.info("SFTP连接失败");
//            result = false;
//        }
//
//        if (result) {
//            try {
//                File srcFile = new File(saveFile + File.separator + fileName);
//                if (!srcFile.exists()) {
//                    (new File(srcFile.getParent())).mkdirs();
//                }
//                sftp.cd(downloadFile);//进入下载地址
//                sftp.get(fileName, saveFile);//目标文件和保存地址
//
//                log.info("fileName:{},filaPath:{}", fileName, srcFile.getPath());
//            } catch (Exception e) {
//                log.info("SFTP下载失败,exception",e);
//                result = false;
//            } finally {
//                session.disconnect();
//                channel.disconnect();
//                sftp.disconnect();
//            }
//        }
//        return result;
//    }
}
