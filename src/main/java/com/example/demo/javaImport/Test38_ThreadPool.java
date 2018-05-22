package com.example.demo.javaImport;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Test38_ThreadPool {

    public static void main(String[] args) {
        try(Scanner in =new Scanner(System.in)){
            System.out.print("enter base directory(eg:/usr/local/jdk5.0/src):");
            String directory=in.nextLine();
            System.out.print("enter keyword(eg:volatile):");
            String keyword=in.nextLine();

            ExecutorService pool= Executors.newCachedThreadPool();
            MatchCounter counter=new MatchCounter(new File(directory),keyword,pool);
            Future<Integer> result=pool.submit(counter);
            try{
                System.out.println(result.get()+" matching files.");
            }
            catch (ExecutionException e){
                e.printStackTrace();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            pool.shutdown();

            int largestPoolSize=((ThreadPoolExecutor)pool).getLargestPoolSize();
            System.out.println("largest pool size= "+largestPoolSize);

        }
    }
}

class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounter(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }
    @Override
    public Integer call() throws Exception {
        count = 0;
        try {
            File[] files = directory.listFiles();
            List<Future<Integer>> results = new ArrayList<>();

            for (File f : files
                    ) {
                if (f.isDirectory()) {
                    MatchCounter counter = new MatchCounter(f, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                } else {
                    if (search(f)) count++;
                }

            }
            for (Future<Integer> result : results
                    ) {
                try {
                    count += result.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }


        } catch (InterruptedException e) {
        }
        return count;
    }
    public boolean search(File file){
        try{
            try(Scanner in=new Scanner(file,"UTF-8")){
                boolean found=false;
                while (!found&&in.hasNextLine()){
                    String line=in.nextLine();
                    if (line.contains(keyword)) found=true;
                }
                return found;
            }
        }
        catch (IOException e){
            return false;
        }
    }
}
