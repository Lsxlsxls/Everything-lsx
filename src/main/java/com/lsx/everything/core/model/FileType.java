package com.lsx.everything.core.model;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 文件类型
 *
 */
public enum FileType {
    IMG("png","jpg","jpeg","gif"),
    DOC("ppt","pptx","doc","docx","pdf"),
    BIN("exe","sh","jar","msi"),
    ARCHIVE("zip","rar"),
    OTHER("*");

    /**
     * 对应的文件类的扩展名的集合
     */
    private Set<String> extend = new HashSet<>();

    FileType(String ...extend) {
        this.extend.addAll(Arrays.asList(extend));
    }

    /**
     * 根据文件扩展名获取文件类型
     */
    public static FileType lookup(String extend){
        for (FileType fileType : FileType.values()){
            if(fileType.extend.contains(extend)){
                return fileType;
            }
        }
        return FileType.OTHER;
    }

    public static void main(String[] args) {
        System.out.println(FileType.lookup("png"));//img
        System.out.println(FileType.lookup("ppt"));//doc
        System.out.println(FileType.lookup("java"));//other

    }


}

