package com.bit.basic.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName HotswapCL.java
 * @Description TODO
 * @createTime 2019年11月05日 14:16:00
 */
class HotswapCL extends ClassLoader {

    private String basedir; // 需要该类加载器直接加载的类文件的基目录
    private HashSet dynaclazns; // 需要由该类加载器直接加载的类名

    public HotswapCL(String basedir, String[] clazns) {
        super(null); // 指定父类加载器为 null
        this.basedir = basedir;
        dynaclazns = new HashSet();
        loadClassByMe(clazns);
    }

    private void loadClassByMe(String[] clazns) {
        for (int i = 0; i < clazns.length; i++) {
            Class clazz = loadDirectly(clazns[i]);
            if (clazz != null) {
                dynaclazns.add(clazns[i]);
            }
        }
    }

    private Class loadDirectly(String name) {
        Class cls = null;
        StringBuffer sb = new StringBuffer(basedir);
        String classname = name.replace('.', File.separatorChar) + ".class";
        sb.append(File.separator + classname);
        File classF = new File(sb.toString());
        try {
            if (classF.exists()) {
                cls = instantiateClass(name, new FileInputStream(classF), classF.length());
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return cls;
    }

    private Class instantiateClass(String name, InputStream fin, long len) {
        byte[] raw = new byte[(int) len];
        try {
            fin.read(raw);
            fin.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return defineClass(name, raw, 0, raw.length);
    }

    @Override
    protected Class loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        Class cls = findLoadedClass(name);
        if (!this.dynaclazns.contains(name) && cls == null) {
            cls = getSystemClassLoader().loadClass(name);
        }
        if (cls == null) {
            throw new ClassNotFoundException(name);
        }
        if (resolve) {
            resolveClass(cls);
        }
        return cls;
    }
}