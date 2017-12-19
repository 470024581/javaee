package com.weixin.controller;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.mapred.JobConf;

public class HdfsDao {

    private static final String HDFS = "hdfs://192.168.61.128:9000/";
    
    String input = "hdfs://192.168.61.128:9000/user/hdfs/input/";
	
	String output = "hdfs://192.168.61.128:9000/user/hdfs/output";

    private static Configuration conf = config();
    
    public static JobConf config(){
        JobConf conf = new JobConf();
//        conf.setJobName("HdfsDAO");
//        conf.addResource("classpath:/hadoop/core-site.xml");
//        conf.addResource("classpath:/hadoop/hdfs-site.xml");
//        conf.addResource("classpath:/hadoop/mapred-site.xml");
        return conf;
    }
    
    public static void main(String[] args) throws IOException {
    	uploadFile("C:\\Users\\Administrator\\Desktop\\试用期转正申请表&试用期表现评定表 - 梁龙.docx");
//        HdfsDao.ls("/tmp");
//        hdfs.copyFile("datafile/item.csv", "/new");
    }        
    
    public static void uploadFile(String filePath) throws IOException{
    	FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
    	Path src = new Path(filePath);
    	Path dst = new Path("/user/hdfs/output");
    	fs.copyFromLocalFile(src, dst);
    	System.out.println("Upload to"+conf.get("fs.defaultFS"));
        
        FileStatus files[]=fs.listStatus(dst);
        for(FileStatus file:files){
            System.out.println(file.getPath());
        }
    }
    
    public void mkdirs(String folder) throws IOException {
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        if (!fs.exists(path)) {
            fs.mkdirs(path);
            System.out.println("Create: " + folder);
        }
        fs.close();
    }

    public void rmr(String folder) throws IOException {
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        fs.deleteOnExit(path);
        System.out.println("Delete: " + folder);
        fs.close();
    }

    public static void ls(String folder) throws IOException {
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        FileStatus[] list = fs.listStatus(path);
        System.out.println("ls: " + folder);
        System.out.println("==========================================================");
        for (FileStatus f : list) {
            System.out.printf("name: %s, folder: %s, size: %d\n", f.getPath(), f.isDir(), f.getLen());
        }
        System.out.println("==========================================================");
        fs.close();
    }

    public void createFile(String file, String content) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        byte[] buff = content.getBytes();
        FSDataOutputStream os = null;
        try {
            os = fs.create(new Path(file));
            os.write(buff, 0, buff.length);
            System.out.println("Create: " + file);
        } finally {
            if (os != null)
                os.close();
        }
        fs.close();
    }

    public void copyFile(String local, String remote) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        fs.copyFromLocalFile(new Path(local), new Path(remote));
        System.out.println("copy from: " + local + " to " + remote);
        fs.close();
    }

    public void download(String remote, String local) throws IOException {
        Path path = new Path(remote);
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        fs.copyToLocalFile(path, new Path(local));
        System.out.println("download: from" + remote + " to " + local);
        fs.close();
    }
    
    public void cat(String remoteFile) throws IOException {
        Path path = new Path(remoteFile);
        FileSystem fs = FileSystem.get(URI.create(HDFS), conf);
        FSDataInputStream fsdis = null;
        System.out.println("cat: " + remoteFile);
        try {  
            fsdis =fs.open(path);
            IOUtils.copyBytes(fsdis, System.out, 4096, false);  
          } finally {  
            IOUtils.closeStream(fsdis);
            fs.close();
          }
    }

    public void location() throws IOException {
        // String folder = HDFS + "create/";
        // String file = "t2.txt";
        // FileSystem fs = FileSystem.get(URI.create(HDFS), new
        // Configuration());
        // FileStatus f = fs.getFileStatus(new Path(folder + file));
        // BlockLocation[] list = fs.getFileBlockLocations(f, 0, f.getLen());
        //
        // System.out.println("File Location: " + folder + file);
        // for (BlockLocation bl : list) {
        // String[] hosts = bl.getHosts();
        // for (String host : hosts) {
        // System.out.println("host:" + host);
        // }
        // }
        // fs.close();
    }

}